package Stage03.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import Stage03.dictionary.ErrorMessages;
import Stage03.model.Cinema;
import Stage03.model.Order;
import Stage03.model.Seat;

@Service
public class BookingService {

	@Autowired
	private Cinema cinema;

	public Cinema getCinemaInfo() {
		return cinema;
	}

	public UUID generatedToken;

	public ResponseEntity<String> purchaseTicket(Seat seat) {
		ResponseEntity response = getSeatAvailability(seat.getRow(), seat.getColumn());
		if (response.getStatusCode().is2xxSuccessful()) {
			changeSeatAvailability(seat, false);
			changeSeatToken(seat, generatedToken);
		}
		return response;
	}

	private ResponseEntity<String> getSeatAvailability(int row, int column) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity seatInfo;
		Optional<Seat> seatOpt = Arrays.stream(cinema.getSeats())
				.filter(s -> s.getRow() == row && s.getColumn() == column).findFirst();
		if (seatOpt.isEmpty()) {
			seatInfo = new ResponseEntity(Map.of("error", ErrorMessages.OUT_OF_BOUNDS.toString()),
					HttpStatus.BAD_REQUEST);
		} else if (!seatOpt.get().isAvaliable()) {
			seatInfo = new ResponseEntity(Map.of("error", ErrorMessages.ALREADY_PURCHASED.toString()),
					HttpStatus.BAD_REQUEST);
		} else {
			Map<String, Object> map = new LinkedHashMap<>();
			String firstKey = "token";
			Object firstValue = UUID.randomUUID();
			String secondKey = "ticket";
			Object secondValue = seatOpt.get();
			generatedToken = (UUID) firstValue;
			map.put(firstKey, firstValue);
			map.put(secondKey, secondValue);
			seatInfo = new ResponseEntity(map, HttpStatus.OK);
		}
		return seatInfo;
	}
	
	public ResponseEntity<String> returnTicket(Order order) {
		ResponseEntity seatInfo = null;
		Optional<Seat> seatOpt = Arrays.stream(cinema.getSeats()).filter(s -> s.getToken() != null).filter(s -> s.getToken().equals(order.getToken())).findFirst();
		if(seatOpt.isEmpty()) {
			seatInfo = new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
		} else {
			Seat seat = seatOpt.get();
			seat.setToken(null);
			seat.setAvaliable(true);
			seatInfo = new ResponseEntity<>(Map.of("returned_ticket", seat), HttpStatus.OK);
		}
		return seatInfo;
	}

	private synchronized void changeSeatAvailability(Seat seat, boolean availability) {
		Arrays.stream(cinema.getSeats()).filter(s -> s.equals(seat)).forEach(s -> s.setAvaliable(availability));
	}
	
	private synchronized void changeSeatToken(Seat seat, UUID generatedToken) {
		Arrays.stream(cinema.getSeats()).filter(s -> s.equals(seat)).forEach(s -> s.setToken(generatedToken));
	}

}

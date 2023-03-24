package Stage04.service;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import Stage04.dictionary.ErrorMessages;
import Stage04.exceptions.AlreadyPurchasedException;
import Stage04.exceptions.OutOfBoundsException;
import Stage04.exceptions.WrongPasswordException;
import Stage04.exceptions.WrongTokenExceptions;
import Stage04.model.Cinema;
import Stage04.model.Seat;
import Stage04.model.Stats;
import Stage04.model.Ticket;

@Service
public class BookingService {

	@Autowired
	private Cinema cinema;

	public Cinema getCinemaInfo() {
		return cinema;
	}

	public ResponseEntity<?> purchaseTicket(Seat seat) {
		int row = seat.getRow();
		int column = seat.getColumn();
		ResponseEntity<?> seatInfo;
		Optional<Seat> seatOpt = Arrays.stream(cinema.getSeats())
				.filter(s -> s.getRow() == row && s.getColumn() == column).findFirst();
		if (seatOpt.isEmpty()) {
			throw new OutOfBoundsException(ErrorMessages.OUT_OF_BOUNDS.toString());
		} else if (!seatOpt.get().isAvaliable()) {
			throw new AlreadyPurchasedException(ErrorMessages.ALREADY_PURCHASED.toString());
		} else {
			String token = UUID.randomUUID().toString();
			Seat seats = seatOpt.get();
			Ticket ticket = new Ticket(token, seats);
			cinema.incrementCurrentIncome(seats.getPrice());
			cinema.putToMap(token, seats);
			changeSeatAvailability(seats, false);
			seatInfo = new ResponseEntity<>(ticket, HttpStatus.OK);
		}
		return seatInfo;
	}

	public ResponseEntity<?> returnTicket(String token) {
		ResponseEntity<?> seatInfo = null;
		Seat seat = cinema.getPurchasedTicket().get(token);
		if (seat == null) {
			throw new WrongTokenExceptions(ErrorMessages.WRONG_TOKEN.toString());
		} else {
			changeSeatAvailability(seat, true);
			cinema.removeFromMap(token);
			cinema.decrementCurrentIncome(seat.getPrice());
			seatInfo = new ResponseEntity<>(Map.of("returned_ticket", seat), HttpStatus.OK);
		}
		return seatInfo;
	}

	public ResponseEntity<?> cinemaStatistics(String password) {
		if (password == null || !password.equals("super_secret")) {
			throw new WrongPasswordException(ErrorMessages.WRONG_PASSWORD.toString());
		}
		int income = cinema.getCurrentIncome();
		int numberOfFreeSeats = cinema.getAvailableSeats().length;
		int numberOfPurchasedSeats = cinema.getPurchasedTicket().size();
		return new ResponseEntity<>(new Stats(income, numberOfFreeSeats, numberOfPurchasedSeats), HttpStatus.OK);
	}

	private synchronized void changeSeatAvailability(Seat seat, boolean availability) {
		Arrays.stream(cinema.getSeats()).filter(s -> s.equals(seat)).forEach(s -> s.setAvaliable(availability));
	}

}

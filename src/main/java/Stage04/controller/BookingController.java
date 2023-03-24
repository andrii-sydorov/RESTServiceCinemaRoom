package Stage04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Stage04.model.Cinema;
import Stage04.model.Seat;
import Stage04.model.Token;
import Stage04.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/seats")
	public Cinema getAvaliableSeatsInfo() {
		return bookingService.getCinemaInfo();
	}

	@PostMapping("/purchase")
	public ResponseEntity<?> purchaseTicket(@RequestBody Seat seat) {
		return bookingService.purchaseTicket(seat);
	}

	@PostMapping("/return")
	public ResponseEntity<?> returnTicket(@RequestBody Token token) {
		return bookingService.returnTicket(token.token());
	}

	@PostMapping("/stats")
	public ResponseEntity<?> cinemaStatistics(String password) {
		return bookingService.cinemaStatistics(password);
	}
}

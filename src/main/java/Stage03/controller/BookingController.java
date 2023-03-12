package Stage03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Stage03.model.Cinema;
import Stage03.model.Order;
import Stage03.model.Seat;
import Stage03.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/seats")
	public Cinema getAvaliableSeatsInfo() {
		return bookingService.getCinemaInfo();
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<String> purchaseTicket(@RequestBody Seat seat) {
		return bookingService.purchaseTicket(seat);
	}
	
	@PostMapping("/return")
	public ResponseEntity<String> returnTicket(@RequestBody Order order) {
		return bookingService.returnTicket(order);
	}
}

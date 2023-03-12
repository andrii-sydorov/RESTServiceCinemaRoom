package Stage02.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Stage02.Exception.ResponseException;
import Stage02.Pojo.ExceptionResponse;
import Stage02.Pojo.Seat;
import Stage02.Pojo.Theatre;

@RestController
public class Controller {

	Theatre t = new Theatre();

	@GetMapping("/seats")
	public Theatre getSeat() {
		return t;
	}

	@PostMapping("/purchaseException")
	public Seat getSeatException(@RequestBody Seat seat) {
		List<Seat> ls = t.getAvailiableSeat();
		int row = seat.getRow();
		int column = seat.getColumn();
		for (Seat s : ls) {
			if (s.getColumn() == column && s.getRow() == row) {
				if (s.isFree()) {
					s.setFree(false);
					return s;
				} else {
					throw new ResponseException("The ticket has been already purchased!");
				}
			} else if (row <= 0 || row > t.getTotalRows() || column <= 0 || column > t.getTotalColumns()) {
				throw new ResponseException("The number of a row or a column is out of bounds!");
			}
		}
		return null;
	}

	@PostMapping("/purchase")
	public ResponseEntity<?> getSeat(@RequestBody Seat seat) {
		List<Seat> ls = t.getAvailiableSeat();
		int row = seat.getRow();
		int column = seat.getColumn();
		for (Seat s : ls) {
			if (s.getColumn() == column && s.getRow() == row) {
				if (s.isFree()) {
					s.setFree(false);
					return new ResponseEntity<>(s, HttpStatus.OK);
				} else {
					// throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has
					// been already purchased!");
					return new ResponseEntity<>(new ExceptionResponse("The ticket has been already purchased!"),
							HttpStatus.BAD_REQUEST);
				}
			} else if (row <= 0 || row > t.getTotalRows() || column <= 0 || column > t.getTotalColumns()) {
				// throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
				// "The number of a row or a column is out of bounds!");
				return new ResponseEntity<>(new ExceptionResponse("The number of a row or a column is out of bounds!"),
						HttpStatus.BAD_REQUEST);
			}
		}
		return null;
	}
}

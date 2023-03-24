package Stage04.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongTokenExceptions extends RuntimeException {

	public WrongTokenExceptions(String message) {
		super(message);
	}
}

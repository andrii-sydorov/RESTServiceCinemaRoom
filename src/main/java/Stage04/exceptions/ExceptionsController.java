package Stage04.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler({ AlreadyPurchasedException.class })
	public ResponseEntity<CustomErrorResponse> exceptionsHandlerAlreadyPurchasedException(
			AlreadyPurchasedException ape) {
		CustomErrorResponse cer = new CustomErrorResponse(ape.getMessage());
		return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ OutOfBoundsException.class })
	public ResponseEntity<CustomErrorResponse> exceptionsHandlerOutOfBoundsException(OutOfBoundsException oobe) {
		CustomErrorResponse cer = new CustomErrorResponse(oobe.getMessage());
		return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ WrongTokenExceptions.class })
	public ResponseEntity<CustomErrorResponse> exceptionsHandlerWrongTokenExceptions(WrongTokenExceptions wte) {
		CustomErrorResponse cer = new CustomErrorResponse(wte.getMessage());
		return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ WrongPasswordException.class })
	public ResponseEntity<CustomErrorResponse> exceptionsHandlerWrongPasswordException(WrongPasswordException wpe) {
		CustomErrorResponse cer = new CustomErrorResponse(wpe.getMessage());
		return new ResponseEntity<>(cer, HttpStatus.NOT_FOUND);
	}
}

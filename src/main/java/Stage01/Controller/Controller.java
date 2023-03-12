package Stage01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Stage01.Pojo.Theatre;

@RestController
public class Controller {

	Theatre t = new Theatre();
	
	@GetMapping("/seats")
	public Theatre getTheatre() {
		return t;
	}
}

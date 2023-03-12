package Stage03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * We live in a fast world, and our plans may change very quickly. Let's add the
 * ability to refund a ticket if a customer can't come and watch a movie. We
 * will use tokens to secure the ticket refund process.
 * 
 * Objectives Change the JSON response when a customer purchases a ticket by
 * making a POST request to the /purchase endpoint. Turn it into the following
 * format:
 * 
 * { 
 * 		"token": "00ae15f2-1ab6-4a02-a01f-07810b42c0ee", 
 * 		"ticket": { 
 * 			"row": 1,
 * 			"column": 1, 
 * 			"price": 10 
 * 		} 
 * } 
 * 
 * We recommend using the randomUUID() method of
 * the UUID class to generate tokens. Take a look at this UUID Guide by Baeldung
 * if you're interested in more detail.
 * 
 * Implement the /return endpoint, which will handle POST requests and allow
 * customers to refund their tickets.
 * 
 * The request should have the token feature that identifies the ticket in the
 * request body. Once you have the token, you need to identify the ticket it
 * relates to and mark it as available. The response body should be as follows:
 * 
 * { 
 * 		"returned_ticket": { 
 * 			"row": 1, 
 * 			"column": 1, 
 * 			"price": 10 
 * 		} 
 * } 
 * 
 * The returned_ticket should contain the information about the returned ticket.
 * 
 * If you cannot identify the ticket by the token, make your program respond
 * with a 400 status code and the following response body:
 * 
 * { 
 * 		"error": "Wrong token!" 
 * } 
 * 
 * Examples Example 1: a correct POST /purchase request
 * 
 * Request body:
 * 
 * { 
 * 		"row": 3, 
 * 		"column": 4 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 		"token": "e739267a-7031-4eed-a49c-65d8ac11f556", 
 * 		"ticket": { 
 * 			"row": 3,
 * 			"column": 4, 
 * 			"price": 10 
 * 		} 
 * } 
 * 
 * Example 2: POST /return with the correct token
 * 
 * Request body:
 * 
 * { 
 * 		"token": "e739267a-7031-4eed-a49c-65d8ac11f556" 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 		"returned_ticket": { 
 * 			"row": 1, 
 * 			"column": 2, 
 * 			"price": 10 
 * 		} 
 * } 
 * 
 * Example 3: POST/return with an expired token
 * 
 * Request body:
 * 
 * { 
 * 		"token": "e739267a-7031-4eed-a49c-65d8ac11f556" 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 		"error": "Wrong token!" 
 * }
 * 
 * @author SMD_ASY
 *
 */

@SpringBootApplication
public class ChangePlans {
	public static void main(String[] args) {
		SpringApplication.run(ChangePlans.class, args);
	}
}

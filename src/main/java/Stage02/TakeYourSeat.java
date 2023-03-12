package Stage02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Stage 2/4: 
 * 
 * Take your seat Description Movie-goers should be able to check the
 * availability of seats before purchasing a ticket. In this stage, you need to
 * add an endpoint to check and purchase an available ticket. If the ticket has
 * been purchased or the request contains wrong information about the ticket,
 * return an error message.
 * 
 * Objectives Implement the /purchase endpoint that handles POST requests and
 * marks a booked ticket as purchased.
 * 
 * A request should contain the following data:
 * 
 *   row — the row number; 
 *   column — the column number. 
 * 
 * Take these variables and check if the specified ticket is available. 
 * If the ticket is booked, mark the seat as purchased and don't show it in the list.
 * 
 * If the purchase is successful, the response body should be as follows:
 * 
 * { 
 * 	"row": 5, 
 * 	"column": 7, 
 * 	"price": 8 
 * } 
 * 
 * The ticket price is determined by a row number. If the row number is less or equal to 4, 
 * set the price at 10. All other rows cost 8 per seat.
 * 
 * If the seat is taken, respond with a 400 (Bad Request) status code. The
 * response body should contain the following:
 * 
 * { 
 * 	"error": "The ticket has been already purchased!" 
 * } 
 * 
 * If users pass a wrong row/column number, respond with a 400 status code and the following line:
 * 
 * { 
 * "error": "The number of a row or a column is out of bounds!" 
 * } 
 * 
 * Show the ticket price when the /seats endpoint is accessed. See the first example for
 * more details.
 * 
 * Examples 
 * 
 * Example 1: a GET /seats request
 * 
 * Response body:
 * 
 * { 
 * 	"total_rows":9,
 *  "total_columns":9,
 *   "available_seats":[ 
 *   { "row":1,
 * 	   "column":1, 
 * 	   "price":10 
 *   }, 
 *   { "row":1,
 *     "column":2,
 *     "price":10 
 *   },
 *   { 
 *     "row":1,
 *     "column":3, 
 *     "price":10 
 *   },
 * 
 * ........
 * 
 *   { 
 *     "row":9, 
 *     "column":8, 
 *     "price":8 
 *   }, 
 *   { 
 *     "row":9, 
 *     "column":9, 
 *     "price":8 
 *   } 
 *  ] 
 * }
 * 
 * 
 * Example 2: a POST /purchase correct request
 * 
 * Request body:
 * 
 * { 
 * 	"row": 3, 
 * 	"column": 4 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 	"row": 3,
 *  "column": 4,
 *  "price": 10 
 * } 
 * 
 * Example 3: a POST /purchase request, the ticket is already booked
 * 
 * Request body:
 * 
 * { 
 * 	"row": 3, 
 * 	"column": 4 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 	"error": "The ticket has been already purchased!" 
 * } 
 * 
 * Example 4: a POST
 * /purchase request, a wrong row number
 * 
 * Request body:
 * 
 * { 
 * 	"row": 15,
 *  "column": 4 
 * } 
 * 
 * Response body:
 * 
 * { 
 * 	"error": "The number of a row or a column is out of bounds!" 
 * }
 * 
 * @author SMD_ASY
 *
 */

@SpringBootApplication
public class TakeYourSeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TakeYourSeat.class, args);
		System.out.println("My application was running");
	}

}

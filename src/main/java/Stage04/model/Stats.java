package Stage04.model;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Stage 4/4: 
 * 
 * The statistics Description Your REST service knows how to show
 * available tickets, sell them, and make a refund. Let's add statistics
 * available only to the theatre managers.
 * 
 * Objectives Implement the /stats endpoint that will handle POST requests with
 * URL parameters. If the URL parameters contain a password key with a
 * super_secret value, return the movie theatre statistics in the following
 * format:
 * 
 * { 
 * 		"current_income": 0, 
 * 		"number_of_available_seats": 81,
 * 		"number_of_purchased_tickets": 0 
 * } 
 * 
 * Take a look at the description of keys:
 * 
 * current_income — shows the total income of sold tickets.
 * number_of_available_seats — shows how many seats are available.
 * number_of_purchased_tickets — shows how many tickets were purchased. 
 * 
 * If the parameters don't contain a password key or a wrong value has been passed,
 * respond with a 401 status code. The response body should contain the
 * following:
 * 
 * { 
 * 		"error": "The password is wrong!" 
 * } 
 * 
 * Examples 
 * 
 * Example 1: a POST /stats request with no parameters
 * 
 * Response body:
 * 
 * { 
 * 		"error": "The password is wrong!" 
 * } 
 * 
 * Example 2: a POST /stats request with the correct password
 * 
 * Response body:
 * 
 * { 
 * 		"current_income": 30, 
 * 		"number_of_available_seats": 78,
 * 		"number_of_purchased_tickets": 3 
 * }
 * 
 * @author SMD_ASY
 *
 */

public class Stats {

	private int currentIncome;
	private int numberOfAvailableSeats;
	private int numberOfPurchasedTickets;

	public Stats(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
		this.currentIncome = currentIncome;
		this.numberOfAvailableSeats = numberOfAvailableSeats;
		this.numberOfPurchasedTickets = numberOfPurchasedTickets;
	}

	@JsonGetter("current_income")
	public int getCurrentIncome() {
		return currentIncome;
	}

	@JsonGetter("number_of_available_seats")
	public int getNumberOfAvailableSeats() {
		return numberOfAvailableSeats;
	}

	@JsonGetter("number_of_purchased_tickets")
	public int getNumberOfPurchasedTickets() {
		return numberOfPurchasedTickets;
	}

}

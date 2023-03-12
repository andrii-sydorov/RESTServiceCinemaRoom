package Stage03.model;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder({"total_rows", "total_columns", "avaliable_seats"})
	

public class Cinema {

	private int totalRows = 9;
	private int totalColumns = 9;
	private Seat[] seats = new Seat[totalRows * totalColumns];

	public Cinema() {
		if (seats[0] == null) {
			createSeats();
		}
	}

	@JsonGetter("total_rows")
	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	@JsonGetter("total_columns")
	public int getTotalColumns() {
		return totalColumns;
	}

	public void setTotalColumn(int totalColumns) {
		this.totalColumns = totalColumns;
	}

	@JsonIgnore
	public Seat[] getSeats() {
		return seats;
	}

	public void setAvailableSeats(Seat[] availableSeats) {
		this.seats = availableSeats;
	}
	
	@JsonGetter("avaliable_seats")
	public Seat[] getAvailableSeats() {
		return Arrays.stream(seats).filter(Seat::isAvaliable).toArray(Seat[]::new);
	}

	public void createSeats() {
		int index = 0;
		for (int r = 1; r <= totalRows; r++) {
			for (int c = 1; c <= totalColumns; c++) {
				seats[index] = new Seat(r, c, true);
				index++;
			}
		}
	}
}

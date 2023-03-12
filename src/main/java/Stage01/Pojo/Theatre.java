package Stage01.Pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "total_rows",
    "total_columns",
    "available_seats"
})
public class Theatre {

	@JsonProperty("total_rows")
	private int totalRows = 9;
	@JsonProperty("total_columns")
	private int totalColumns = 9;
	@JsonProperty("available_seats")
	private List<Seat> availiableSeats = makeListOfSeat(totalRows, totalColumns);

	private List<Seat> makeListOfSeat(int totalRows, int totalColumns) {
		List<Seat> ls = new ArrayList<>();
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 1; j <= totalColumns; j++) {
				ls.add(new Seat(i, j));
			}
		}
		return ls;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalColumns() {
		return totalColumns;
	}

	public void setTotalColumns(int totalColumns) {
		this.totalColumns = totalColumns;
	}

	public List<Seat> getAvaliableSeat() {
		return availiableSeats;
	}

	public void setAvaliableSeat(List<Seat> avaliableSeat) {
		this.availiableSeats = avaliableSeat;
	}

}

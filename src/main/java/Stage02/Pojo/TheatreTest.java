package Stage02.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TheatreTest {
	@JsonProperty("total_rows")
	private int totalRows = 9;
	@JsonProperty("total_columns")
	private int totalColumns = 9;
	@JsonProperty("available_seats")
	private Seat[][] availiableSeat = makeArray(totalRows, totalColumns);

	private static Seat[][] makeArray(int totalRows, int totalColumns) {
		Seat[][] s = new Seat[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				int price = (i + 1) <= 4 ? 10 : 8;
				s[i][j] = new Seat(i + 1, j + 1, price);
			}
		}
		return s;
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

	public Seat[][] getAvailiableSeat() {
		return availiableSeat;
	}

	public void setAvailiableSeat(Seat[][] availiableSeat) {
		this.availiableSeat = availiableSeat;
	}
}

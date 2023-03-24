package Stage04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {

	private int row;
	private int column;
	private int price;
	private boolean isAvaliable;

	public Seat(int row, int column, boolean isAvaliable) {
		this.row = row;
		this.column = column;
		this.price = row <= 4 ? 10 : 8;
		this.isAvaliable = isAvaliable;
	}

	public Seat(@JsonProperty("row") int row, @JsonProperty("column") int column) {
		this.row = row;
		this.column = column;
		this.price = row <= 4 ? 10 : 8;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Seat [row=" + row + ", column=" + column + ", price=" + price + "]";
	}

	@JsonIgnore
	public boolean isAvaliable() {
		return isAvaliable;
	}

	public void setAvaliable(boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		Seat s = (Seat) object;
		return row == s.getRow() && column == s.getColumn();
	}

	@Override
	public int hashCode() {
		return row * 31 + column;
	}
}

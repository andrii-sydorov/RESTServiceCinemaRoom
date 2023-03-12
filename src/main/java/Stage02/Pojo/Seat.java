package Stage02.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

	private int row;
	private int column;
	private int price;
	@JsonIgnore
	private boolean isFree = true;

	@JsonIgnore
	public boolean isFree() {
		return isFree;
	}

	@JsonIgnore
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Seat() {
	}

	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Seat(int row, int column, int price) {
		this.row = row;
		this.column = column;
		this.price = price;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

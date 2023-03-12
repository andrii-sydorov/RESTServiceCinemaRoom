package Stage03.dictionary;

public enum ErrorMessages {
	OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
	ALREADY_PURCHASED("The ticket has been already purchased!");

	private final String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return this.errorMessage;
	}
}

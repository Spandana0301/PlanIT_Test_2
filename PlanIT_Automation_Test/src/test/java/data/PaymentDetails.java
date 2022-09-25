package data;

public class PaymentDetails {

	String cardSelect;
	String cardNumber;

	public PaymentDetails(String cardSelect, String cardNumber) {

		this.cardSelect = cardSelect;
		this.cardNumber = cardNumber;
	}

	public void setCardSelect(String cardSelect) {
		this.cardSelect = cardSelect;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardSelect() {
		return cardSelect;
	}

	public String getCardNumber() {
		return cardNumber;
	}

}

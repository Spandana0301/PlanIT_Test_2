package data;

public class DeliveryDetails {

	String forename;
	String surname;
	String email;
	String telephonenumber;
	String address;

	public DeliveryDetails(String forename, String surname, String email, String telephonenumber, String address) {

		this.forename = forename;
		this.surname = surname;
		this.email = email;
		this.telephonenumber = telephonenumber;
		this.address = address;

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setForeName(String forename) {
		this.forename = forename;
	}

	public void setSurName(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephoneNumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	public String getAddress() {
		return address;
	}

	public String getForeName() {
		return forename;
	}

	public String getSurName() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephoneNumber() {
		return telephonenumber;
	}

}

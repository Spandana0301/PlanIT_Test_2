package data;

public class ContactDetails {

	String forename;
	String surname;
	String email;
	String telephoneNumber;
	String message;

	public ContactDetails(String forename, String surname, String email, String telephoneNumber, String message) {

		this.forename = forename;
		this.surname = surname;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.message = message;

	}
	public ContactDetails(String forename) {
		this.forename = forename;

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

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return telephoneNumber;
	}

	public String getMessage() {
		return message;
	}

}

package data;

public class LogInDetails {
	String UserName;
	String Password;
	
	public LogInDetails(String UserName,String Password) {
		this.UserName=UserName;
		this.Password=Password;
	}

	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public String getPassword() {
		return Password;
	}
}

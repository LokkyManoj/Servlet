package model;

public class RegistrationPojo {
String userName;
String mobileNo;
String date;
String email;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

public RegistrationPojo(String userName, String mobileNo, String date, String email) {
	super();
	this.userName = userName;
	this.mobileNo = mobileNo;
	this.date = date;
	this.email = email;
}
public RegistrationPojo() {
	
}

public String toString() {
	return "RegistrationPojo [userName=" + userName + ", mobileNo=" + mobileNo + ", date=" + date + ", email=" + email
			+ "]";
}

}

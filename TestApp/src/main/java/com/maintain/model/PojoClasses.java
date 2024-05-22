package com.maintain.model;

public class PojoClasses {
int id;	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

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

public PojoClasses(String userName, String mobileNo, String date, String email) {
	super();
	this.userName = userName;
	this.mobileNo = mobileNo;
	this.date = date;
	this.email = email;
}
public PojoClasses() {
	
}

@Override
public String toString() {
	return "PojoClasses [id=" + id + ", userName=" + userName + ", mobileNo=" + mobileNo + ", date=" + date + ", email="
			+ email + "]";
}

}

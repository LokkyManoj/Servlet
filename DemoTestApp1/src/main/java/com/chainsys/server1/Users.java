package com.chainsys.server1;

import java.util.ArrayList;

import model.RegistrationPojo;

public class Users {
ArrayList<RegistrationPojo> user=new ArrayList<>();
public void addUser(String name,String mobileNo,String date,String email) {
	RegistrationPojo user1=new RegistrationPojo(name,mobileNo,date,email);
	user.add(user1);
	System.out.println(user);
}
public ArrayList<RegistrationPojo> getUser(){
	return user;
	
}

	}


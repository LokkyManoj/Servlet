package com.maintain.server;

import java.util.ArrayList;

import com.maintain.model.PojoClasses;


public class Users {
ArrayList<PojoClasses> user=new ArrayList<>();
public void addUser(String name,String mobileNo,String date,String email) {
	PojoClasses user1=new PojoClasses(name,mobileNo,date,email);
	user.add(user1);
	System.out.println(user);
}
public ArrayList<PojoClasses> getUser(){
	return user;
	
}

	}


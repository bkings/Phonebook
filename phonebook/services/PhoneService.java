package com.phonebook.services;

import java.util.List;

import com.phonebook.models.Contact;

public interface PhoneService {

	public boolean addContact(Contact c);
	public boolean searchContact(Contact c,String fname);
	public Contact getById(int id);
	public List<Contact> getContact(); 
}

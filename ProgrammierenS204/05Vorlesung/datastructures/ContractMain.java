package datastructures;

import java.util.Collections;
import java.util.LinkedList;

public class ContractMain {

	public static void main(String[] args) {
		LinkedList<Contact> contacts = new LinkedList<>();
		contacts.add(new Contact(123456, "Bob Ross"));
		contacts.add(new Contact(234567, "Bruce Lee"));
		contacts.add(new Contact(345567, "Daniel"));
		contacts.add(new Contact(456788, "Kirsten"));
		contacts.add(new Contact(678990, "Zorro"));
		contacts.add(new Contact(0, "Chuck Norris"));
		contacts.add(new Contact(2314353, "Uwe Boll"));
		
		Collections.sort(contacts);
		
		for(Contact contact : contacts) {
			System.out.println(contact.getName() + " : " + contact.getNumber());
		}
	}

}

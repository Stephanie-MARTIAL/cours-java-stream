package org.eclipse.classes;

public class Letter {

	private String street;
	private String city;

	public Letter() {
		super();
	}

	public Letter(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return "Letter [street=" + street + ", city=" + city + "]";
	}



}

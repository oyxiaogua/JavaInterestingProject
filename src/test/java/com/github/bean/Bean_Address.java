package com.github.bean;

public class Bean_Address {
	private Bean_Street street;
	private String zipCode;
	private String city;
	private String country;

	public Bean_Street getStreet() {
		return street;
	}

	public void setStreet(Bean_Street street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "Bean_Address [street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country
				+ "]";
	}

}
package com.github.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Bean_Person extends Bean_Human {
	private String email;
	private Enum_Gender gender;
	private Bean_Address address;
	private Date birthDate;
	private String phoneNumber;
	private List<String> nicknames;
	private String[] strArr;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Enum_Gender getGender() {
		return gender;
	}

	public void setGender(Enum_Gender gender) {
		this.gender = gender;
	}

	public Bean_Address getAddress() {
		return address;
	}

	public void setAddress(Bean_Address address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getNicknames() {
		return nicknames;
	}

	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}

	public String[] getStrArr() {
		return strArr;
	}

	public void setStrArr(String[] strArr) {
		this.strArr = strArr;
	}

	public String toString() {
		return "Bean_Person [email=" + email + ", gender=" + gender + ", address=" + address + ", birthDate="
				+ birthDate + ", phoneNumber=" + phoneNumber + ", nicknames=" + nicknames + ", strArr="
				+ Arrays.toString(strArr) + "]";
	}

}
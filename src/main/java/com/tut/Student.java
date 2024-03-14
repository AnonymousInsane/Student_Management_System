package com.tut;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column(name = "Student_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Student_Name")
	private String nameString;
	@Column(name = "Student_Address")
	private String addressString;
	@Column(name = "Mobile_Number")
	private long mobile;
	@Column(name = "Student_Gender")
	private String genderString;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGenderString() {
		return genderString;
	}
	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}
	public Student(int id, String nameString, String addressString, long mobile, String genderString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.addressString = addressString;
		this.mobile = mobile;
		this.genderString = genderString;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student id :" + id + "\nName :" + nameString + "\nAddress=" + addressString + "\nMobile :"
				+ mobile + "\nGender :" + genderString ;
	}
	
}

package com.sbs.persistence;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
    @Id // this sets up the Spring Data for MongoDB automatic ID conversion
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String emailAddress;
    private String phoneNumber;
    private EmpPosCatType positionCategory;
    private Date dateHired;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private Boolean active;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public EmpPosCatType getPositionCategory() {
		return positionCategory;
	}
	public void setPositionCategory(EmpPosCatType positionCategory) {
		this.positionCategory = positionCategory;
	}
	public Date getDateHired() {
		return dateHired;
	}
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", middleName=" + middleName
				+ ", emailAddress=" + emailAddress + ", phoneNumber="
				+ phoneNumber + ", positionCategory=" + positionCategory
				+ ", dateHired=" + dateHired + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", active=" + active + "]";
	}
    

}

package com.bridgeLabz.loginRegistraionProject;

public class Employee {
private String firstName;
private String lastName;
private String email;
private String address;
@Override
public String toString() {
	return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address
			+ ", comp_name=" + comp_name + ", age=" + age + ", sal=" + sal + ", gender=" + gender + ", specialize="
			+ specialize + ", lang_known=" + lang_known + ", pass=" + pass + ", contact=" + contact + ", userid="
			+ userid + "]";
}
private String comp_name;
private int age;
private double sal;
private String gender;
private String specialize;
private String lang_known;
private String pass;
private long contact;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getComp_name() {
	return comp_name;
}
public void setComp_name(String comp_name) {
	this.comp_name = comp_name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getSpecialize() {
	return specialize;
}
public void setSpecialize(String specialize) {
	this.specialize = specialize;
}
public String getLang_known() {
	return lang_known;
}
public void setLang_known(String lang_known) {
	this.lang_known = lang_known;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
private int userid;

}

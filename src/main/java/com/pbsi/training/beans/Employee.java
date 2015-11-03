package com.pbsi.training.beans;


public class Employee {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String currentOccupation;
	private String email;
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the currentOccupation
	 */
	public String getCurrentOccupation() {
		return currentOccupation;
	}



	/**
	 * @param currentOccupation the currentOccupation to set
	 */
	public void setCurrentOccupation(String currentOccupation) {
		this.currentOccupation = currentOccupation;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getFirstName()+" "+ getLastName();
	}
}

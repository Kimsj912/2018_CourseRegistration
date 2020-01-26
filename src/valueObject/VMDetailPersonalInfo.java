package valueObject;

import java.util.Scanner;

public class VMDetailPersonalInfo {
	private String userID;
	private String userName;
	private String userCollegeNum;
	private String userPersonNum;
	private String userEMail;
	private String userPhone1;
	private String userPhone2;
	private String userCampus;
	private String userCollege;
	private String userDepartment;
	

	public void readFromFile(Scanner scanner) {
		this.setUserID(scanner.next());
		this.setUserName(scanner.next());
		this.setUserCollegeNum(scanner.next());
		this.setUserPersonNum(scanner.next());
		this.setUserEMail(scanner.next());
		this.setUserPhone1(scanner.next());
		this.setUserPhone2(scanner.next());
		this.setUserCampus(scanner.next());
		this.setUserCollege(scanner.next());
		this.setUserDepartment(scanner.next());
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCollegeNum() {
		return userCollegeNum;
	}

	public void setUserCollegeNum(String userCollegeNum) {
		this.userCollegeNum = userCollegeNum;
	}

	public String getUserPersonNum() {
		return userPersonNum;
	}

	public void setUserPersonNum(String userPersonNum) {
		this.userPersonNum = userPersonNum;
	}

	public String getUserEMail() {
		return userEMail;
	}

	public void setUserEMail(String userEMail) {
		this.userEMail = userEMail;
	}

	public String getUserPhone1() {
		return userPhone1;
	}

	public void setUserPhone1(String userPhone1) {
		this.userPhone1 = userPhone1;
	}

	public String getUserPhone2() {
		return userPhone2;
	}

	public void setUserPhone2(String userPhone2) {
		this.userPhone2 = userPhone2;
	}

	public String getUserCampus() {
		return userCampus;
	}

	public void setUserCampus(String userCampus) {
		this.userCampus = userCampus;
	}

	
	public String getUserCollege() {
		return userCollege;
	}

	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}

	
	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

}

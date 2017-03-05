package pojo;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private int userType;
	private String userEmail;
	private Timestamp registerTime;
	private Timestamp signTime;
	private String signIp;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public Timestamp getSignTime() {
		return signTime;
	}
	public void setSignTime(Timestamp signTime) {
		this.signTime = signTime;
	}
	public String getSignIp() {
		return signIp;
	}
	public void setSignIp(String signIp) {
		this.signIp = signIp;
	}
	
}

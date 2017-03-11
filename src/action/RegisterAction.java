package action;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManager;

public class RegisterAction implements Action {
	private String user_name;
	private String user_password;
	private String user_email;
	private UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	
	public String execute() throws Exception {
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setRegister_time(new Timestamp(new Date().getTime()));
		user.setUser_email(user_email);
		user.setUser_type(1);
		if(userManager.register(user))
			return SUCCESS;
		else
			return ERROR;
	}

}
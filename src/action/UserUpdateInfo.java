package action;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

/** 
 * @author Lucifer 
 * @date 2017年3月24日 上午9:18:31 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class UserUpdateInfo implements Action {
	private String user_name;
	private String user_password;
	private String user_email;
	private User user;
	private UserManagerImpl userManager;
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public UserManagerImpl getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(user_name==null&&user_email==null)
			return NONE;
		user = new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setUser_email(user_email);
		if(userManager.updateUserInfo(user))
			return SUCCESS;
		return ERROR;
	}

}

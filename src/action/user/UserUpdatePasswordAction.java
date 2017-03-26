package action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

/** 
 * @author Lucifer 
 * @date 2017��3��20�� ����9:39:22 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
public class UserUpdatePasswordAction implements Action,SessionAware {
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	private User user;
	private Map<String, Object> session;
	private UserManagerImpl userManager;
	
	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserManagerImpl getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		int user_id = (int) session.get("USER_ID");
//		if(user_id==0){
//			return ERROR;
//		}
		user = new User();
		System.out.println(session.get("USER_NAME"));
		if(newPassword.equals(confirmPassword)&&!oldPassword.equals(newPassword)){
//			user.setUser_id(user_id);
			user.setUser_password(newPassword);
			user.setUser_name(session.get("USER_NAME").toString());
			if(userManager.updateUserPW(user)){
				return SUCCESS;
			}
			else{
				return ERROR;
			}
		}
		return ERROR;
	}


}

package action;

import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import pojo.User;
import service.UserManager;


public class LoginAction implements Action{
	
	private String contentType = "text/html;charset=utf-8";
	private UserManager userManager;
	private String user_name;
	private String user_password;
	private User user;
	
	
	
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


	public UserManager getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public String execute() throws Exception
    {
		user = new User();
        ServletActionContext.getResponse().setContentType(contentType);
        user.setUser_name(getUser_name());
        user.setUser_password(getUser_password());
        if(userManager.login(user).equals("success")){
        	System.out.println("用户"+getUser_name()+"登陆成功");
        	String remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
        	return SUCCESS;
        }
        else if(userManager.login(user).equals("error"))
        	return ERROR;
        else
        	return NONE;
    }
}

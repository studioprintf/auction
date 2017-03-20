package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

@Controller
public class UserLoginAction implements Action,SessionAware{
	
	private String contentType = "text/html;charset=utf-8";
	private UserManagerImpl userManager;
	private String user_name;
	private String user_password;
	private User user;
	private Map<String, Object> session; 
	
	
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
	
	public String execute() throws Exception
    {
		if(session.get("USER_NAME")!=null)
			return "exist";
		user = new User();
        ServletActionContext.getResponse().setContentType(contentType);
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        user.setSign_ip(ServletActionContext.getRequest().getRemoteAddr());
        user.setSign_time(new Timestamp(new Date().getTime()));
        if(userManager.login(user).equals("success")){
        	session.put("USER_NAME", user_name);
        	session.put("USER_ID", user.getUser_id());
        	return SUCCESS;
        }
        else if(userManager.login(user).equals("error"))
        	return ERROR;
        else
        	return NONE;
    }


	
}

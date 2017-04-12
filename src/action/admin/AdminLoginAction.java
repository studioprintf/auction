package action.admin;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import pojo.User;
import service.UserManagerImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/** 
 * @author Lucifer 
 * @date 2017��3��29�� ����11:46:41 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class AdminLoginAction implements Action, SessionAware, RequestAware {
	private String user_name;
	private String user_password;
    private String checkImage;
    private User user;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	private UserManagerImpl userManager;
	
	
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

	public String getCheckImage() {
		return checkImage;
	}

	public void setCheckImage(String checkImage) {
		this.checkImage = checkImage;
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
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg1) {
		this.request = arg1;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		checkImage.toLowerCase();
        if (!checkImage.equals(session.get("checkCode"))) {
            session.remove("checkCode");
			request.put("msg","验证码错误，请重新输入");
			request.put("url","login");
            return "fail";
        }
        session.remove("checkCode");
		user = new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
        user.setSign_ip(ServletActionContext.getRequest().getRemoteAddr());
        user.setSign_time(new Timestamp(new Date().getTime()));
        String result = userManager.login(user);
        if (result.equals("success")) {
            session.put("USER_NAME", user_name);
            session.put("USER_ID", user.getUser_id());
            session.put("AMDIN", "TRUE");

			return SUCCESS;
		} else if (result.equals("error")) {
			request.put("msg", "密码错误，请重新输入");
			request.put("url", "login");
			return ERROR;
		} else {

			return NONE;
		}
	}


}

package action.user;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

/** 
 * @author Lucifer 
 * @date 2017年3月29日 上午10:14:49 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class UserInfoAuction implements SessionAware, RequestAware, Action {
	private Map<String,Object> session;
	private Map<String,Object> request;
	private UserManagerImpl userManager;
	
	
	public UserManagerImpl getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUser_name(session.get("USER_NAME").toString());
		user = userManager.findUserInfo(user);
		request.put("USER", user);
		return SUCCESS;
	}

}

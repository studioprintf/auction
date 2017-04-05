package action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.Action;

import service.UserManagerImpl;

/** 
 * 管理员获取所有用户Action
 * @author Lucifer 
 * @date 2017年3月29日 下午4:14:30 
 * @version 1.0 
 * @parameter  request userManager
 * @since  
 * @return  List<User>
 */
public class AdminGetUser implements Action, RequestAware {
	private Map<String, Object> request;
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
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request.put("userList", userManager.getUsers());
		return SUCCESS;
	}

}

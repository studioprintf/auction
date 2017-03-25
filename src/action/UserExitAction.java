package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

/** 
 * @author Lucifer 
 * @date 2017年3月15日 下午4:29:05 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Controller
public class UserExitAction implements Action,SessionAware{
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		session.remove("USER_NAME");
		session.remove("USER_ID");
		return SUCCESS;
	}



}

package action.admin;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/** 
 * @author Lucifer 
 * @date 2017年3月29日 下午12:27:29 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class AdminAuthority implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session.get("USER_NAME") == null || session.get("USER_ID") == null) {
            return Action.INPUT;
        }
        if (session.get("ADMIN").equals("TRUE"))
        	return Action.ERROR;
        return invocation.invoke();
    }
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.User;
import service.UserManager;
import service.UserManagerImpl;

import java.util.Map;

/**
 * Created by Dymond on 2017/3/29.
 */

@Controller
public class UserInfoAction implements Action,SessionAware,RequestAware {
    private User user;
    private UserManagerImpl userManager;
    private Map<String, Object> session;
    private Map<String,Object> request;

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


    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public String execute() throws Exception {
        String user_name = (String) session.get("USER_NAME");
        if(user_name ==null)
            return NONE;
        User userSql = userManager.findUserByName(user_name);
        request.put("user",userSql);
        return SUCCESS;
    }


    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}

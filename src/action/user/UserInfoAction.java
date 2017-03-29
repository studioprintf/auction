package action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
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
public class UserInfoAction extends ActionSupport implements Action,SessionAware {
    private User user;
    private UserManagerImpl userManager;
    private Map<String, Object> session;

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
        ActionContext atx = ActionContext.getContext();
        atx.put("user",userSql);
        return SUCCESS;
    }
}

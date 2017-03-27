package action.user;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

@Controller
public class UserRegisterAction implements Action {
    private String user_name;
    private String user_password;
    private String user_email;
    private UserManagerImpl userManager;

    public UserManagerImpl getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String execute() throws Exception {
        System.out.print("boot");
        User user = new User();
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        user.setRegister_time(new Timestamp(new Date().getTime()));
        user.setUser_email(user_email);
        user.setUser_type(1);
        if (userManager.register(user)) {
            System.out.print("yes");
            return SUCCESS;
        } else {
            System.out.print("no");
            return ERROR;
        }
    }

}

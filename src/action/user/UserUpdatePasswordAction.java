package action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.User;
import service.UserManagerImpl;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:39:22
 * @parameter
 * @return
 */
@Controller
public class UserUpdatePasswordAction implements Action, SessionAware {
    private String oldPassword;
    private String newPassword;
    private User user;
    private Map<String, Object> session;
    private UserManagerImpl userManager;
    private InputStream inputStream;

    public String getOldPassword() {
        return oldPassword;
    }


    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public String getNewPassword() {
        return newPassword;
    }


    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        // TODO Auto-generated method stub
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        if(oldPassword.equals(newPassword))//非法提交
            return NONE;
        user = new User();
        user.setUser_id((int) session.get("USER_ID"));
        user.setUser_password(newPassword);
        user.setUser_name(session.get("USER_NAME").toString());
        if (userManager.updateUserPW(user,oldPassword)) {
            inputStream = new ByteArrayInputStream("1".getBytes());
        } else {
            inputStream = new ByteArrayInputStream("0".getBytes());
        }
        return SUCCESS;
    }



}

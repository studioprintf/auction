package action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pojo.User;
import service.UserManager;
import service.UserManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dymond on 2017/3/28.
 *
 *
 * Ajax 显示用户余额
 */


public class UserGetBalanceAction extends ActionSupport implements ModelDriven<User> {
    private InputStream inputStream;
    private UserManager userManager = new UserManagerImpl();
    private User user = new User();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InputStream getInputStream() {
        return inputStream;
    }


    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }



    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }


    public String checkBalance() throws UnsupportedEncodingException {

        String user_name = user.getUser_name();
        if (userManager.findUserByName(user_name) != null) {
            inputStream = new ByteArrayInputStream("10000".getBytes("UTF-8"));
        }
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {


        return checkBalance();
    }

    @Override
    public User getModel() {
        return user;
    }
}

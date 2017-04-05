package action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pojo.User;
import service.UserManager;
import service.UserManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dymond on 2017/3/25.
 */
public class UserCheckNameAction extends ActionSupport implements ModelDriven<User> {
	
	private static final long serialVersionUID = 1L;
	private User user = new User();
    private UserManager userManager = new UserManagerImpl();
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    //妫�楠岀敤鎴锋樀绉版槸鍚﹀瓨鍦�
    public String checkName() throws UnsupportedEncodingException {
        String user_name = user.getUser_name();
        if (userManager.findUserByName(user_name) == null) {
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        } else {
            inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
        }
        return "ajax_succ";
    }

    @Override
    public User getModel() {
        return user;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public String execute() throws Exception {
        String result = checkName();//return "ajax_succ";
        return result;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

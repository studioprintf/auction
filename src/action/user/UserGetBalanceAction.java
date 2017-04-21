package action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;
import pojo.User;
import service.UserManager;
import service.UserManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dymond on 2017/3/28.
 *
 *
 * Ajax 显示用户余额
 */

@Controller
public class UserGetBalanceAction extends ActionSupport {
    private InputStream inputStream;
    private UserManager userManager = new UserManagerImpl();
    private User user;
    private String userName;
    private Map<String,Object> dataMap;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String json(){
        dataMap = new HashMap<>();
        user = userManager.findUserByName(userName);
        dataMap.put("balance",user.getBalance());
        dataMap.put("frozen_amount",user.getFrozen_amount());


        return SUCCESS;

    }


}

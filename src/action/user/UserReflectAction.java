package action.user;

import action.BaseAction;
import org.springframework.stereotype.Controller;
import service.BalanceManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by lucifer on 17-4-15.
 */

@Controller
public class UserReflectAction extends BaseAction {
    private double amount;
    private InputStream inputStream;

    private BalanceManagerImpl balanceManager;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BalanceManagerImpl getBalanceManager() {
        return balanceManager;
    }

    public void setBalanceManager(BalanceManagerImpl balanceManager) {
        this.balanceManager = balanceManager;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String execute() throws Exception{
        int user_id = Integer.parseInt(session.get("USER_ID").toString());
        if (balanceManager.reflect(user_id, getAmount())) {
            balanceManager.balanceLog(user_id, amount);
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        }else {
            inputStream = new ByteArrayInputStream("充值失败".getBytes("UTF-8"));
        }
        return SUCCESS;
    }


}

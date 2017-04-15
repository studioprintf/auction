package action.user;

import action.BaseAction;
import org.springframework.stereotype.Controller;
import service.BalanceManagerImpl;

/**
 * Created by lucifer on 17-4-15.
 */

@Controller
public class UserReflectAction extends BaseAction{
    private double amount;

    private BalanceManagerImpl balanceManager;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String execute(){
        int user_id = Integer.parseInt(session.get("USER_ID").toString());
        if(balanceManager.reflect(user_id,getAmount()))
            balanceManager.balanceLog(user_id,amount);
        return SUCCESS;
    }
}

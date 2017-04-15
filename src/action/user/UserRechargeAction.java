package action.user;

import action.BaseAction;
import org.springframework.stereotype.Controller;
import service.BalanceManagerImpl;

/**
 * Created by Dymond on 2017/3/28.
 */
@Controller
public class UserRechargeAction extends BaseAction{
    private double amount;

    private BalanceManagerImpl balanceManager;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String execute() throws Exception{
        int user_id = Integer.parseInt(session.get("USER_ID").toString());
        if(balanceManager.recharge(user_id,getAmount())){
            balanceManager.balanceLog(user_id,amount);
            return SUCCESS;
        }
        return ERROR;
    }
}

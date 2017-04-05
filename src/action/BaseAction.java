package action;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by DTLuc on 2017/3/30.
 */
public class BaseAction implements SessionAware, Action {
    protected Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }
}

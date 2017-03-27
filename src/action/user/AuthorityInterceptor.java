package action.user;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * ��½Ȩ��������
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��21�� ����5:11:08
 * @parameter
 * @return
 */
public class AuthorityInterceptor implements Interceptor {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session.get("USER_NAME") == null || session.get("USER_ID") == null) {
            return Action.INPUT;
        }
        return invocation.invoke();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

}

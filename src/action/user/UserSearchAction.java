package action.user;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:31:17
 * @parameter
 * @return
 */
@Controller
public class UserSearchAction implements Action {
    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub

        return null;
    }

}
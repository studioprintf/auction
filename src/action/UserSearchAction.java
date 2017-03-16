package action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

/** 
 * @author Lucifer 
 * @date 2017年3月15日 下午4:31:17 
 * @version 1.0 
 * @parameter  
 * @since  
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

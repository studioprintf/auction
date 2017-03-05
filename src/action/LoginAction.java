package action;

import service.LoginServiceCheck;

public class LoginAction {
	
	public String execute() throws Exception{
		LoginServiceCheck loginServiceCheck = new LoginServiceCheck();
        loginServiceCheck.getUser();
		return "success";
	}
	
}

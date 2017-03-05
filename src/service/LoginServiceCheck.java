package service;

import java.util.List;

import daoImpl.UserDaoImpl;
import pojo.User;

public class LoginServiceCheck implements LoginService {

	@Override
	public List<User> getUser() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		return userDaoImpl.getUser();
	}

	@Override
	public void saveUser(User userBean) {
		// TODO Auto-generated method stub

	}

}

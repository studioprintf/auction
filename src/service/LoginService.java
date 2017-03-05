package service;

import java.util.List;

import pojo.User;

public interface LoginService {

    public List<User> getUser();

    public void saveUser(User userBean);

}

package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return 0;
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}

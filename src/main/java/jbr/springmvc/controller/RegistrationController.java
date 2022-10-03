package jbr.springmvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Department;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;
import jbr.springmvc.service.DepartmentService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  
  @Autowired
  public DepartmentService departmentService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  User user = new User();	 
	  return new ModelAndView("register", "command" ,user);
  }
  
  @ModelAttribute("departmentList")
  public Map<Integer, String> getDepartmentList() {
	  List<Department> departments = departmentService.getDepartments();
	  
     Map<Integer, String> departmentList = new HashMap<Integer, String>();
     for(Department d : departments) {
     	departmentList.put(d.getId(), d.getName());
     }
     return departmentList;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

    userService.register(user);

    return new ModelAndView("welcome", "firstname", user.getFirstname());
  }
}

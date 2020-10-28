package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mycompany.model.User;
import com.mycompany.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView landingPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("addUser", "usr", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("usr") User usr) {

        userService.add(usr);
        List<User> users = userService.getAllUsers();
        ModelAndView model = new ModelAndView("getUsers");
        model.addObject("users", users);
        return model;
    }

    @RequestMapping("/getUsers")
    public ModelAndView listUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView model = new ModelAndView("getUsers");
        model.addObject("users", users);
        return model;
    }

}

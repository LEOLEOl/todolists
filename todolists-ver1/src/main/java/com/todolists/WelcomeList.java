package com.todolists;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * Created by vietha on 8/21/2017.
 */
@RestController
public class WelcomeList {

    @RequestMapping(value = "/welcome")
    public String welcome()
    {
        return "Welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String logon(@RequestBody UserLogin userLogin)
    {
        return userLogin.name;
    }

    static public class UserLogin {
        public String name;
        public String password;
    }
}

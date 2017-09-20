package com.todolists.Controller;

import com.todolists.Entity.User;
import com.todolists.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers() {return this.userService.getAllUsers(); }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable("username") String username) {return this.userService.getUserByUsername(username); }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteUserByUsername(@PathVariable("username") String username) {this.userService.removeUserByUsername(username);}

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {this.userService.updateUser(user);}

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user) {this.userService.insertUser(user);}

}

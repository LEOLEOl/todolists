package com.todolists.spaghetticode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */

@RestController
@RequestMapping("/tempusers")
public class TempUserController {

    @Autowired
    private TempUserService tempUserService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TempUser> getAllUsers() {
        return this.tempUserService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TempUser getUserById(@PathVariable("id") String id) {
        return this.tempUserService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") String id) {
        tempUserService.removeUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody TempUser tempUser) {
        tempUserService.updateUser(tempUser);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody TempUser tempUser) {
        tempUserService.insertUser(tempUser);
    }
}

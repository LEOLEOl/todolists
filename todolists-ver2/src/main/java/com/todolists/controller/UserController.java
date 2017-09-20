package com.todolists.controller;

import com.todolists.entity.User;
import com.todolists.service.MyUserPrincipal;
import com.todolists.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;

/**
 * Created by vietha on 8/23/2017.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/login")
    public String printUser(ModelMap modelMap) {
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        return username;
    }

    // Get all users
    @GetMapping
    public Collection<User> getAllUsers() {return userService.getAllUsers(); }

    // get a specific user
    @GetMapping
    public User getUserByUsername(Principal principal) {return userService.getUserByUsername(principal.getName()); }


    // create a new user
    @PostMapping
    public void insertUser(@RequestBody User user) { userService.insertUser(user);}

    // update a new user
    @PutMapping
    public void updateUser(@RequestBody User user) { userService.updateUser(user);}


    // delete a specific user
    @DeleteMapping
    public void deleteUserByUsername(Principal principal) { userService.removeUserByUsername(principal.getName());}





    @GetMapping("/getjwts")
    @ResponseBody
    public String getJwts()
    {
        try {
            String jwt = Jwts.builder()
                    .setSubject("users/TzMUocMF4p")
                    .setExpiration(new Date(2017-1900, 12, 31))
                    .claim("name", "Robert Token Man")
                    .claim("scope", "self groups/admins")
                    .signWith(
                            SignatureAlgorithm.HS256,
                            "secret".getBytes("UTF-8")
                    )
                    .compact();


//            String jwt2 = "123";
//                    Jws<Claims> claims = Jwts.parser()
//                    .setSigningKey("secret".getBytes("UTF-8"))
//                    .parseClaimsJws(jwt);
//            String scope = (String)claims.getBody().get("scope");
//            assertEquals(scope, "self groups/admins");

            return jwt;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
       }
    }

    @GetMapping("jwtsinfo")
    public String jwtsInfo(@RequestHeader("Token") String token)
    {
        String jwt = token;

        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey("secret".getBytes("UTF-8"))
                    .parseClaimsJws(jwt);

            String name = (String)claims.getBody().getSubject();
            return name;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

}

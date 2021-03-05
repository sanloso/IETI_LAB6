package com.eci.taskplanner.components.controller;

import com.eci.taskplanner.components.exceptions.UserException;
import com.eci.taskplanner.components.models.User;
import com.eci.taskplanner.components.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUsers(){
        try{
            List<User> userList= userService.getAll();
            return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public ResponseEntity<?> findUsersByName(@PathVariable String name){
        try{
            User user= userService.getByName(name);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            userService.create(user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try{
            userService.update(user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove/{name}")
    public ResponseEntity<?> removeUser(@PathVariable String name){
        try{
            userService.remove(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
        }
    }
}

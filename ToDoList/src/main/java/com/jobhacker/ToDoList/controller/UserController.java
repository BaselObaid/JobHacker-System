package com.jobhacker.ToDoList.controller;

import com.jobhacker.ToDoList.Model.User;
import com.jobhacker.ToDoList.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createNewUser(@RequestBody User user){
        userService.insert(user);
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.delete(userId);
    }

}

package com.avinashdeveloper.app.ws.ui.controller;

import com.avinashdeveloper.app.ws.ui.model.request.UserDetailsRequestModel;
import com.avinashdeveloper.app.ws.ui.model.response.UserResponseModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
        return null;
    }

    @PutMapping
    public String updateUser() {
        return "updateUser  was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }
}

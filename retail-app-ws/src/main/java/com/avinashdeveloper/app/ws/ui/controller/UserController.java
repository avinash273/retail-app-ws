package com.avinashdeveloper.app.ws.ui.controller;

import com.avinashdeveloper.app.ws.service.UserService;
import com.avinashdeveloper.app.ws.shared.dto.UserDto;
import com.avinashdeveloper.app.ws.ui.model.request.UserDetailsRequestModel;
import com.avinashdeveloper.app.ws.ui.model.response.UserResponseModel;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserResponseModel returnValue = new UserResponseModel();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);//copyProperties(src, target)
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
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

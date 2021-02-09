package com.avinashdeveloper.app.ws.service;

import com.avinashdeveloper.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}

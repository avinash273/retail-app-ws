package com.avinashdeveloper.app.ws.service.impl;

import com.avinashdeveloper.app.ws.UserRepository;
import com.avinashdeveloper.app.ws.io.entity.UserEntity;
import com.avinashdeveloper.app.ws.service.UserService;
import com.avinashdeveloper.app.ws.shared.dto.UserDto;
import com.avinashdeveloper.app.ws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity storedEmailDetails = userRepository.findByEmail(user.getEmail());

        if(storedEmailDetails != null) throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setEncryptedPassword("test");

        String publicUserId = utils.generateUserId(20);
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }
}

package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    List<UserDto> getUserByAll();
}

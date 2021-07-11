package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    List<UserDto> getUserByAll();

    UserDto getUserDetailsByEmail(String username);
    
}

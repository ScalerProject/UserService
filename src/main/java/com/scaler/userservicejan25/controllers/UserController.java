package com.scaler.userservicejan25.controllers;

import com.scaler.userservicejan25.dtos.LoginRequestDto;
import com.scaler.userservicejan25.dtos.LogoutRequestDto;
import com.scaler.userservicejan25.dtos.SignupRequestDto;
import com.scaler.userservicejan25.dtos.UserDto;
import com.scaler.userservicejan25.models.Token;
import com.scaler.userservicejan25.models.User;
import com.scaler.userservicejan25.services.UserService;
import com.scaler.userservicejan25.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("UserServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto requestDto){
        User user = userService.signup(requestDto.getEmail(), requestDto.getPassword(), requestDto.getName());

        return UserDto.from(user);
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto) {
        return userService.login(requestDto.getEmail(), requestDto.getPassword());
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto){
        userService.logout(requestDto.getTokenValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/validate")
    public UserDto validateToken(@PathVariable String tokenValue){
        return null;
    }
}

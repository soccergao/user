package com.soccergao.user.controller;

import com.soccergao.user.dto.UserDto;
import com.soccergao.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gqw
 * @version 1.0.0
 * @Description
 * @createTime 2021/09/14
 */
@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return userDto;
    }
}

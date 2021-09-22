package com.soccergao.user.service;

import com.soccergao.user.annotations.NullProcessingAnnotation;
import com.soccergao.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gqw
 * @version 1.0.0
 * @Description
 * @createTime 2021/09/14
 */
@Slf4j
@Service
public class UserService {

    public UserDto findById(Long id) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName("张三");
        userDto.setPhone("12345678901");
        userDto.setSex(1);
        return userDto;
    }
}

package com.soccergao.user.dto;

import lombok.Data;

/**
 * @author gqw
 * @version 1.0.0
 * @Description
 * @createTime 2021/09/14
 */
@Data
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private Integer sex;
}

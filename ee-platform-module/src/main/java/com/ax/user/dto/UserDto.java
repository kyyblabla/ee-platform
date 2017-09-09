package com.ax.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


/**
 * Created by kyy on 2017/9/8.
 */
@Data
public class UserDto {

    private String name;
    private String password;
    private Integer age;
    private String roles;

}

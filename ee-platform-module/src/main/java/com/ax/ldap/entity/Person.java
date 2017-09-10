package com.ax.ldap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * Created by kyy on 2017/9/10.
 */
@Data
@Entry(objectClasses = {"person", "top"})
public class Person {

    @Id
    @JsonIgnore
    private Name dn;

    @Attribute(name = "telephoneNumber")
    private String phone;

    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "userPassword")
    private String password;

    @Attribute(name = "cn")
    private String cnName;

    @Attribute(name = "sn")
    private String enName;

    @Attribute(name = "description")
    private String description;


}

package com.ax.ldap.controller;

import com.ax.ldap.dao.PersonRepository;
import com.ax.ldap.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/10.
 */
@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/search")
    public Person findAll(@RequestParam("phone") String phone) {
        return personRepository.findByPhone(phone);
    }

}

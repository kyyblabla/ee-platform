package com.ax.ldap.dao;

import com.ax.ldap.entity.Person;
import org.springframework.data.ldap.repository.LdapRepository;

/**
 * Created by kyy on 2017/9/10.
 */
public interface PersonRepository extends LdapRepository<Person> {

    Person findByPhone(String phone);

}

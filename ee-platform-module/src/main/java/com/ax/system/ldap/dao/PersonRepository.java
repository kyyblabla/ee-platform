package com.ax.system.ldap.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.system.ldap.entity.Person;
import org.springframework.data.ldap.repository.LdapRepository;

/**
 * Created by kyy on 2017/9/10.
 */
@JpaDao
public interface PersonRepository extends LdapRepository<Person> {

    Person findByPhone(String phone);

}

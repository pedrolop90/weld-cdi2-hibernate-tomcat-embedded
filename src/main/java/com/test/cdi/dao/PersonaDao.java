package com.test.cdi.dao;

import com.test.cdi.entity.PersonaEntity;
import com.test.cdi.repository.MysqlCrudRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author pedro
 */
@ApplicationScoped
public class PersonaDao extends MysqlCrudRepository<PersonaEntity, Long> {

}

package com.test.cdi.service.impl;

import com.test.cdi.dao.PersonaDao;
import com.test.cdi.entity.PersonaEntity;
import com.test.cdi.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author pedro
 */
@ApplicationScoped
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Inject
    private PersonaDao personaDao;

    @PostConstruct
    public void init() {
        logger.debug("se creo el bean test com.test.cdi.service.");
    }

    @Override
    public String getTest(Long idPersona) {
        Collection<PersonaEntity> personaEntities = personaDao.findAll();
        String agrupados = personaEntities
                .stream()
                .map(p -> p.getNombre())
                .collect(Collectors.joining(", "));
        logger.info(agrupados);
        return agrupados;
    }
}

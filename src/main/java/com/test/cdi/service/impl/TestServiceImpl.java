package com.test.cdi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.cdi.service.TestService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author pedro
 */
@ApplicationScoped
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @PostConstruct
    public void init() {
        logger.debug("se creo el bean test com.test.cdi.service.");
    }

    @Override

    public String getTest() {
        return "hola";
    }
}

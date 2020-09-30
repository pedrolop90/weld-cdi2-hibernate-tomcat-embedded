package com.test.cdi.controller;

import com.test.cdi.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author pedro
 */
@ApplicationScoped
@Path("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Inject
    private TestService testService;

    @GET
    public String getTest() {
        logger.info("hello!!");
        return testService.getTest(null);
    }

}

package com.yambay.job.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by chrisp on 6/10/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobControllerExceptionTests {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getJobNotFound() {
        ResponseEntity<String> forEntity = template.getForEntity("/job/UKPN_OMS/98787", String.class);
        HttpStatus httpStatus = forEntity.getStatusCode();
        assertEquals(404, httpStatus.value());
        assertThat(forEntity.getBody(), containsString("Job with jobSource:UKPN_OMS and jobCode:98787 does not exist"));
    }
}
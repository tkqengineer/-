package com.alex.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-quartz.xml")
public class TestJob {

    @Test
    public void testJob() throws InterruptedException {

        Thread.sleep(100000000);

    }

}

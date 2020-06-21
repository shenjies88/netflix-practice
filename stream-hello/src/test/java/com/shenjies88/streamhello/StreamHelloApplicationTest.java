package com.shenjies88.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shenjies88
 * @since 2020/6/21-3:28 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }
}

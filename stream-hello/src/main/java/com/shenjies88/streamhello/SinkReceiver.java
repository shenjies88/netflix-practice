package com.shenjies88.streamhello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author shenjies88
 * @since 2020/6/21-11:10 AM
 */
@Slf4j
@EnableBinding({Sink.class, SinkSender.class})
public class SinkReceiver {
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        log.info("Received: " + payload);
    }
}

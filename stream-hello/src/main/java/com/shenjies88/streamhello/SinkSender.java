package com.shenjies88.streamhello;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author shenjies88
 * @since 2020/6/21-3:26 PM
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}

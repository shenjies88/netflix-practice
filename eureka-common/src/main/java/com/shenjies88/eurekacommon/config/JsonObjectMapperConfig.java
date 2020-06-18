package com.shenjies88.eurekacommon.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenjies88
 */
@Slf4j
@Configuration
public class JsonObjectMapperConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        log.info(">> 配置消息json转换属性,日期输出为long,忽略未知的属性");
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_DEFAULT);
            jacksonObjectMapperBuilder.failOnUnknownProperties(false);
            jacksonObjectMapperBuilder.featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        };
    }

}

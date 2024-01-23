package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;


@Configuration
@EnableIntegration
@IntegrationComponentScan
public class MqttIntegrationConfig {

    @Bean
    public DirectChannel mqttInputChannel() {
        return new DirectChannel();
    }

//    @Bean
//    public IntegrationFlow mqttInbound() {
//        return IntegrationFlows.from(
//                        Mqtt.inboundAdapter("mqttInputChannel", "tcp://localhost:1883")
//                                .clientId("clientId")
//                                .credentials("myUsername", "myPassword")
//                                .topics("your/topic"))
//                .handle("mqttMessageHandler", "handleMessage")
//                .get();
//    }
}

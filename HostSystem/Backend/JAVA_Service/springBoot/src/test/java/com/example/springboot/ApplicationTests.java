package com.example.springboot;

import com.example.springboot.service.MqttService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class ApplicationTests {
    @Resource
    private MqttService mqttService;

    @Resource
    private List<String> receivedMessages;

    @Test
    public void testMqttIntegration() throws InterruptedException {
        // 发送消息
        mqttService.sendToMqtt("Hello MQTT!");

        // 等待一段时间以确保消息被接收
       while (true){}

        // 断言或验证逻辑，确保消息已经被正确接收
        //assert receivedMessages.contains("Hello MQTT!");
    }

}

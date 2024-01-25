package com.example.springboot.controller;

import com.example.springboot.service.MqttService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mqtt")
public class MqttController {
    @Resource
    private  MqttService mqttService;
    @Resource
    private List<String> receivedMessages;

    @PostMapping("/publish")
    public void publishMessage(@RequestBody String message) {

        mqttService.sendToMqtt(message);
    }
    @GetMapping("/costumer")
    public List<String> getMessage() {
        return receivedMessages;
    }
}

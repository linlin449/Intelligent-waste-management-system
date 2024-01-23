package com.example.springboot.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wasteBins")
@Data
public class WasteBin {

    @Id
    private String _id;
    private String binId;
    private double weight;
    private boolean isFull;
    private STM32 stm32;
    private ESP32 esp32;
}
@Data
class STM32 {
    private String status;
    private PressureSensor pressureSensor;
    private InfraredSensor infraredSensor;
    private String motorStatus;
    private String displayStatus;
}
@Data
class PressureSensor {
    private double bottomPressure;
    private String status;
}
@Data
class InfraredSensor {
    private boolean isTopFull;
    private String status;
}
@Data
class ESP32 {
    private String status;
    private String cameraStatus;
}




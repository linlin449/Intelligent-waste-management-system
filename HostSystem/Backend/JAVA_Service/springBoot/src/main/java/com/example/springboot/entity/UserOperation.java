package com.example.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "userOperations")
@Data
public class UserOperation {

    @Id
    private String _id;

    private String userId;
    private String binId;
    private Double storageWeight;
    private String action;
    private Date timestamp;
}

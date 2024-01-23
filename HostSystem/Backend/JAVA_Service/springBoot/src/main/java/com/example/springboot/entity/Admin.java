package com.example.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
@Data
public class Admin {

    @Id
    private String _id;

    private String adminId;
    private String username;
    private String password; // Note: Password should be hashed and stored securely in a real-world scenario
}


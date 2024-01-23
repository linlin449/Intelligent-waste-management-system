package com.example.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "faces")
@Data
public class Face {

    @Id
    private String _id;

    private String userId;
    private String userName;
    private String faceData;
    //private List<BinPermission> permissions;

}
@Data
class BinPermission {

    private String binId;
    private List<String> actions;

}


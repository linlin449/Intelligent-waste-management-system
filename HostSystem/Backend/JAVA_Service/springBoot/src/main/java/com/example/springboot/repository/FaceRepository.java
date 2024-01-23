package com.example.springboot.repository;

import com.example.springboot.entity.Face;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaceRepository extends MongoRepository<Face, String> {
    Face findByUserId(String userId);
    // Add more custom query methods if needed
}


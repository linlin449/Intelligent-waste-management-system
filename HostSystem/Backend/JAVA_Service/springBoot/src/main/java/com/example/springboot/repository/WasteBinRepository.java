package com.example.springboot.repository;

import com.example.springboot.entity.WasteBin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WasteBinRepository extends MongoRepository<WasteBin, String> {
    WasteBin findByBinId(String binId);
}

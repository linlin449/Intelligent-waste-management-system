package com.example.springboot.repository;

import com.example.springboot.entity.UserOperation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserOperationRepository extends MongoRepository<UserOperation, String> {
    List<UserOperation> findByBinIdOrderByTimestampDesc(String binId);
    List<UserOperation> findByBinIdAndActionOrderByTimestampDesc(String binId, String action);
    // Add more custom query methods if needed
}

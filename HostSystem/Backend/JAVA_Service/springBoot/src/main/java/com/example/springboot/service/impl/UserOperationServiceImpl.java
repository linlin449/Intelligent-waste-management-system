package com.example.springboot.service.impl;

import com.example.springboot.entity.UserOperation;
import com.example.springboot.repository.UserOperationRepository;
import com.example.springboot.service.UserOperationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOperationServiceImpl implements UserOperationService {
    @Resource
    private UserOperationRepository userOperationRepository;

    @Override
    public List<UserOperation> getAllUserOperations() {
        return userOperationRepository.findAll();
    }

    @Override
    public UserOperation getUserOperationById(String id) {
        return userOperationRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserOperation> getUserOperationsByBinId(String binId) {
        return userOperationRepository.findByBinIdOrderByTimestampDesc(binId);
    }

    @Override
    public List<UserOperation> getUserOperationsByBinIdAndAction(String binId, String action) {
        return userOperationRepository.findByBinIdAndActionOrderByTimestampDesc(binId, action);
    }

    @Override
    public UserOperation createUserOperation(UserOperation userOperation) {
        return userOperationRepository.save(userOperation);
    }

    @Override
    public UserOperation updateUserOperation(String id, UserOperation updatedUserOperation) {
        UserOperation existingUserOperation = userOperationRepository.findById(id).orElse(null);
        if (existingUserOperation != null) {
            // Update fields as needed
            existingUserOperation.setUserId(updatedUserOperation.getUserId());
            existingUserOperation.setBinId(updatedUserOperation.getBinId());
            existingUserOperation.setAction(updatedUserOperation.getAction());
            existingUserOperation.setStorageWeight(updatedUserOperation.getStorageWeight());
            existingUserOperation.setTimestamp(updatedUserOperation.getTimestamp());
            // Update other fields...

            return userOperationRepository.save(existingUserOperation);
        }
        return null;
    }

    @Override
    public void deleteUserOperation(String id) {
        userOperationRepository.deleteById(id);
    }
}

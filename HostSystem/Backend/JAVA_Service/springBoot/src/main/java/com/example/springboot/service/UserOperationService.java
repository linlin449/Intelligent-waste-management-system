package com.example.springboot.service;

import com.example.springboot.entity.UserOperation;

import java.util.List;

public interface UserOperationService {
    List<UserOperation> getAllUserOperations();
    UserOperation getUserOperationById(String id);
    List<UserOperation> getUserOperationsByBinId(String binId);
    List<UserOperation> getUserOperationsByBinIdAndAction(String binId, String action);
    UserOperation createUserOperation(UserOperation userOperation);
    UserOperation updateUserOperation(String id, UserOperation updatedUserOperation);
    void deleteUserOperation(String id);
}

package com.example.springboot.controller;

import com.example.springboot.entity.UserOperation;
import com.example.springboot.service.UserOperationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userOperations")
public class UserOperationController {
    @Resource
    private UserOperationService userOperationService;

    @GetMapping
    public List<UserOperation> getAllUserOperations() {
        return userOperationService.getAllUserOperations();
    }

    @GetMapping("/{id}")
    public UserOperation getUserOperationById(@PathVariable String id) {
        return userOperationService.getUserOperationById(id);
    }

    @GetMapping("/bin/{binId}")
    public List<UserOperation> getUserOperationsByBinId(@PathVariable String binId) {
        return userOperationService.getUserOperationsByBinId(binId);
    }

    @GetMapping("/bin/{binId}/{action}")
    public List<UserOperation> getUserOperationsByBinIdAndAction(@PathVariable String binId, @PathVariable String action) {
        return userOperationService.getUserOperationsByBinIdAndAction(binId, action);
    }

    @PostMapping
    public UserOperation createUserOperation(@RequestBody UserOperation userOperation) {
        return userOperationService.createUserOperation(userOperation);
    }

    @PutMapping("/{id}")
    public UserOperation updateUserOperation(@PathVariable String id, @RequestBody UserOperation updatedUserOperation) {
        return userOperationService.updateUserOperation(id, updatedUserOperation);
    }

    @DeleteMapping("/{id}")
    public void deleteUserOperation(@PathVariable String id) {
        userOperationService.deleteUserOperation(id);
    }
}

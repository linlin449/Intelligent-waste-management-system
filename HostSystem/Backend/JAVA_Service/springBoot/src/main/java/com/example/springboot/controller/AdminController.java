package com.example.springboot.controller;

import com.example.springboot.entity.Admin;
import com.example.springboot.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Resource
    private AdminService adminService;

//    @PostMapping("/login")
//    public boolean login(@RequestBody AdminCredentials adminCredentials) {
//        // Assuming AdminCredentials is a DTO with adminId and password fields
//        return adminService.authenticateAdmin(adminCredentials.getAdminId(), adminCredentials.getPassword());
//    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

//    @PostMapping("/grantPermissions")
//    public void grantPermissions(@RequestBody GrantPermissionRequest request) {
//        // Assuming GrantPermissionRequest is a DTO with adminId, userId, binId, and action fields
//        adminService.grantPermissions(request.getAdminId(), request.getUserId(), request.getBinId(), request.getAction());
//    }

}

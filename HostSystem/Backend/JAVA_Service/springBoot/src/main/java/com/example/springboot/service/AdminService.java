package com.example.springboot.service;

import com.example.springboot.entity.Admin;

public interface AdminService {
    Admin getAdminByAdminId(String adminId);
    boolean authenticateAdmin(String adminId, String password);
    Admin createAdmin(Admin admin);
    void grantPermissions(String adminId, String userId, String binId, String action);
}

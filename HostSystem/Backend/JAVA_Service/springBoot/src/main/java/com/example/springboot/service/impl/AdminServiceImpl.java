package com.example.springboot.service.impl;

import com.example.springboot.entity.Admin;
import com.example.springboot.repository.AdminRepository;
import com.example.springboot.service.AdminService;
import com.example.springboot.service.FaceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
//TODO 密码加密操作，权限管理还没有定好
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Resource
    private FaceService faceService;

    @Override
    public Admin getAdminByAdminId(String adminId) {
        return adminRepository.findByAdminId(adminId);
    }

    @Override
    public boolean authenticateAdmin(String adminId, String password) {
        Admin admin = adminRepository.findByAdminId(adminId);
//        if (admin != null) {
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            return passwordEncoder.matches(password, admin.getPassword());
//        }
        return false;
    }

    @Override
    public Admin createAdmin(Admin admin) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        return adminRepository.save(admin);
        return null;
    }

    @Override
    public void grantPermissions(String adminId, String userId, String binId, String action) {
        // Assuming you have a method in the UserService to handle permissions
        faceService.grantUserPermission(userId, binId, action);
    }

}

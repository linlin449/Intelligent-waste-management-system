package com.example.springboot.repository;

import com.example.springboot.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByAdminId(String adminId);
}

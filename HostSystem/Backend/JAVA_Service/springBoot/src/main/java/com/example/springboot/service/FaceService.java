package com.example.springboot.service;

import com.example.springboot.entity.Face;

import java.util.List;

public interface FaceService {
    List<Face> getAllFaces();
    Face getFaceById(String id);
    Face getFaceByUserId(String userId);
    Face createFace(Face face);
    Face updateFace(String userId, Face updatedFace);
    void deleteFace(String userId);

    void grantUserPermission(String userId, String binId, String action);
}

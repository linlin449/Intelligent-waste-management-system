package com.example.springboot.service.impl;

import com.example.springboot.entity.Face;
import com.example.springboot.repository.FaceRepository;
import com.example.springboot.service.FaceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceServiceImpl implements FaceService {
    @Resource
    private FaceRepository faceRepository;

    @Override
    public List<Face> getAllFaces() {
        return faceRepository.findAll();
    }

    @Override
    public Face getFaceById(String id) {
        return faceRepository.findById(id).orElse(null);
    }

    @Override
    public Face getFaceByUserId(String userId) {
        return faceRepository.findByUserId(userId);
    }

    @Override
    public Face createFace(Face face) {
        return faceRepository.save(face);
    }

    @Override
    public Face updateFace(String userId, Face updatedFace) {
        Face existingFace = faceRepository.findByUserId(userId);
        if (existingFace != null) {
            // Update fields as needed
            existingFace.setUserName(updatedFace.getUserName());
            existingFace.setFaceData(updatedFace.getFaceData());
            existingFace.setPermissions(updatedFace.getPermissions());
            // Update other fields...

            return faceRepository.save(existingFace);
        }
        return null;
    }

    @Override
    public void deleteFace(String userId) {
        Face existingFace = faceRepository.findByUserId(userId);
        if (existingFace != null) {
            faceRepository.deleteById(existingFace.get_id());
        }
    }

    @Override
    public void grantUserPermission(String userId, String binId, String action) {

    }
}

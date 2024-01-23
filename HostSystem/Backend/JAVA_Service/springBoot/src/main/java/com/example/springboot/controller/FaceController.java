package com.example.springboot.controller;

import com.example.springboot.entity.Face;
import com.example.springboot.service.FaceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faces")
public class FaceController {
    @Resource
    private FaceService faceService;

    @GetMapping
    public List<Face> getAllFaces() {
        return faceService.getAllFaces();
    }

    @GetMapping("/{id}")
    public Face getFaceById(@PathVariable String id) {
        return faceService.getFaceById(id);
    }

    @GetMapping("/user/{userId}")
    public Face getFaceByUserId(@PathVariable String userId) {
        return faceService.getFaceByUserId(userId);
    }

    @PostMapping
    public Face createFace(@RequestBody Face face) {
        return faceService.createFace(face);
    }

    @PutMapping("/user/{userId}")
    public Face updateFace(@PathVariable String userId, @RequestBody Face updatedFace) {
        return faceService.updateFace(userId, updatedFace);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteFace(@PathVariable String userId) {
        faceService.deleteFace(userId);
    }
}


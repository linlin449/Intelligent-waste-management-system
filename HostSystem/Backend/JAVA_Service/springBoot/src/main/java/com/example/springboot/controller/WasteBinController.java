package com.example.springboot.controller;

import com.example.springboot.entity.WasteBin;
import com.example.springboot.service.WasteBinService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wasteBins")
public class WasteBinController {
    @Resource
    private WasteBinService wasteBinService;

    @GetMapping
    public List<WasteBin> getAllWasteBins() {
        return wasteBinService.getAllWasteBins();
    }

    @GetMapping("/{id}")
    public WasteBin getWasteBinById(@PathVariable String id) {
        return wasteBinService.getWasteBinById(id);
    }

    @PostMapping
    public WasteBin createWasteBin(@RequestBody WasteBin wasteBin) {
        return wasteBinService.createWasteBin(wasteBin);
    }

    @PutMapping("/{id}")
    public WasteBin updateWasteBin(@PathVariable String id, @RequestBody WasteBin updatedWasteBin) {
        return wasteBinService.updateWasteBin(id, updatedWasteBin);
    }

    @DeleteMapping("/{id}")
    public void deleteWasteBin(@PathVariable String id) {
        wasteBinService.deleteWasteBin(id);
    }
}

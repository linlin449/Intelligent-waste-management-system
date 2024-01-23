package com.example.springboot.service.impl;

import com.example.springboot.entity.WasteBin;
import com.example.springboot.repository.WasteBinRepository;
import com.example.springboot.service.WasteBinService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteBinServiceImpl implements WasteBinService {
    @Resource
    private WasteBinRepository wasteBinRepository;

    @Override
    public List<WasteBin> getAllWasteBins() {
        return wasteBinRepository.findAll();
    }

    @Override
    public WasteBin getWasteBinById(String id) {
        return wasteBinRepository.findById(id).orElse(null);
    }

    @Override
    public WasteBin getWasteBinByBinId(String binId) {
        return wasteBinRepository.findByBinId(binId);
    }

    @Override
    public WasteBin createWasteBin(WasteBin wasteBin) {
        return wasteBinRepository.save(wasteBin);
    }

    @Override
    public WasteBin updateWasteBin(String binId, WasteBin updatedWasteBin) {
        WasteBin existingWasteBin = wasteBinRepository.findByBinId(binId);
        if (existingWasteBin != null) {
            // Update fields as needed
            existingWasteBin.setWeight(updatedWasteBin.getWeight());
            existingWasteBin.setFull(updatedWasteBin.isFull());
            // Update other fields...

            return wasteBinRepository.save(existingWasteBin);
        }
        return null;
    }

    @Override
    public void deleteWasteBin(String binId) {
        WasteBin existingWasteBin = wasteBinRepository.findByBinId(binId);
        if (existingWasteBin != null) {
            wasteBinRepository.deleteById(existingWasteBin.get_id());
        }
    }
}

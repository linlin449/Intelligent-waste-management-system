package com.example.springboot.service;

import com.example.springboot.entity.WasteBin;

import java.util.List;

public interface WasteBinService {
    List<WasteBin> getAllWasteBins();
    WasteBin getWasteBinById(String id);
    WasteBin getWasteBinByBinId(String binId);
    WasteBin createWasteBin(WasteBin wasteBin);
    WasteBin updateWasteBin(String binId, WasteBin updatedWasteBin);
    void deleteWasteBin(String binId);
}
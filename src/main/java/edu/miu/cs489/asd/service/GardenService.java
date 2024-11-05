package edu.miu.cs489.asd.service;

import edu.miu.cs489.asd.entity.Garden;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    public Optional<Garden> addGarden(Garden garden);
    public Optional<Garden> getGarden(Long id);
    public List<Garden> getAllGardens();
    public Optional<Garden> updateGarden(Garden garden);
    public void deleteGarden(Long id);
    public Optional<Garden> findGardenByName(String name);
}

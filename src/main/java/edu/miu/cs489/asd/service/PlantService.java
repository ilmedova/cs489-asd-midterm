package edu.miu.cs489.asd.service;

import edu.miu.cs489.asd.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    public Optional<Plant> getPlant(Long id);
    public List<Plant> getAllPlants();
    public Optional<Plant> addPlant(Plant plant);
    public Optional<Plant> updatePlant(Plant plant);
    public void deletePlant(Long id);
    public List<Plant> getPlantsSortedByDate();
}

package edu.miu.cs489.asd.service.impl;

import edu.miu.cs489.asd.entity.Plant;
import edu.miu.cs489.asd.repository.PlantRepository;
import edu.miu.cs489.asd.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public Optional<Plant> getPlant(Long id) {
        return plantRepository.findById(id);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll(Sort.by("name"));
    }

    @Override
    public Optional<Plant> addPlant(Plant plant) {
        CompletableFuture.runAsync(
                () -> plantRepository.save(plant)
        );
        return Optional.of(plant);
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        CompletableFuture.runAsync(
                () -> plantRepository.save(plant)
        );
        return Optional.of(plant);
    }

    @Override
    public void deletePlant(Long id) {
        CompletableFuture.runAsync(
                () -> plantRepository.deleteById(id)
        );
    }

    @Override
    public List<Plant> getPlantsSortedByDate() {
        return plantRepository.findAll(Sort.by("plantDate"));
    }
}

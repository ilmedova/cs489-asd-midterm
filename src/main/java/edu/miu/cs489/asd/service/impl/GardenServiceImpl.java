package edu.miu.cs489.asd.service.impl;

import edu.miu.cs489.asd.entity.Garden;
import edu.miu.cs489.asd.repository.GardenRepository;
import edu.miu.cs489.asd.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    @Override
    public Optional<Garden> addGarden(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }



    @Override
    public Optional<Garden> getGarden(Long id) {
        return gardenRepository.findById(id);
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        CompletableFuture.runAsync(() -> {
            gardenRepository.save(garden);
        });
        return Optional.of(garden);
    }

    @Override
    public void deleteGarden(Long id) {
        CompletableFuture.runAsync(() -> {
            gardenRepository.deleteById(id);
        });
    }

    @Override
    public Optional<Garden> findGardenByName(String name) {
        return Optional.of(gardenRepository.findByName(name));
    }
}

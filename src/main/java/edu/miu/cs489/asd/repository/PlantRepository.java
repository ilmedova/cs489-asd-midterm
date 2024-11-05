package edu.miu.cs489.asd.repository;

import edu.miu.cs489.asd.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    public List<Plant> findAllByGarden_Id(Long gardenId);
}

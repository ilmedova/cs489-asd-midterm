package edu.miu.cs489.asd.repository;

import edu.miu.cs489.asd.entity.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepository extends JpaRepository<Garden, Long> {
    public Garden findByName(String name);
}

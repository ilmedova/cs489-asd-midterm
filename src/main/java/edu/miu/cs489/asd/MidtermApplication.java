package edu.miu.cs489.asd;

import edu.miu.cs489.asd.entity.Garden;
import edu.miu.cs489.asd.entity.Plant;
import edu.miu.cs489.asd.service.GardenService;
import edu.miu.cs489.asd.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class MidtermApplication {

    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(MidtermApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Garden veg = gardenService.addGarden(new Garden("Vegetable Patch", 50.0)).get();
            Garden herb = gardenService.addGarden(new Garden("Herb Garden", 20.0)).get();

            plantService.addPlant(new Plant("Tomato", "Vegetable", "2024-03-10", veg));
            plantService.addPlant(new Plant("Carrot", "Vegetable", "2024-02-20", veg));
            plantService.addPlant(new Plant("basil", "Herb", "2024-04-05", herb));

            gardenService.getAllGardens().forEach(
                    g -> {
                        System.out.println("ID: " + g.getId() + ", Name: " + g.getName() + ", Size: " + g.getSize());
                    }
            );

            plantService.getAllPlants().forEach(
                    p -> {
                        System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Type: " + p.getType() + ", Plant Date: " + p.getPlantDate() + ", Garden: " + p.getGarden().getName());
                    }
            );

            plantService.getPlantsSortedByDate().forEach(
                    p -> {
                        System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Type: " + p.getType() + ", Plant Date: " + p.getPlantDate() + ", Garden: " + p.getGarden().getName());
                    }
            );

        };
    };
}

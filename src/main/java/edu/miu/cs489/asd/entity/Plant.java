package edu.miu.cs489.asd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "plants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String type;

    private String plantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "garden_id")
    private Garden garden;

    public Plant(String name, String type, String plantDate, Garden garden) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
        this.garden = garden;
    }
}

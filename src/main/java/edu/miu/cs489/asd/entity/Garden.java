package edu.miu.cs489.asd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gardens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private Double size;

    @OneToMany(mappedBy = "garden")
    private List<Plant> plants;

    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }
}

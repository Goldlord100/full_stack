package fr.polytech.fsback.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Restaurant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {

    @Id
    @Generated
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> listEvaluation;
}

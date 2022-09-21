package fr.polytech.fsback.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "Evaluation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationEntity {

    @Id
    @Generated
    private int id;

    @Column(name = "nom_eval")
    private String nom_eval;

    @Column(name = "commentary")
    private String commentary;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;

}

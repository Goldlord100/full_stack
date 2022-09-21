package fr.polytech.fsback.repository;

import fr.polytech.fsback.entity.EvaluationEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {

}

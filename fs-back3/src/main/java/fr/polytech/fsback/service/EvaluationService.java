package fr.polytech.fsback.service;

import fr.polytech.fsback.entity.EvaluationEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int restaurantId, String nom_eval, String message){
        final RestaurantEntity restaurantEntity = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity evaluationEntity = EvaluationEntity.builder().commentary(message).nom_eval(nom_eval).restaurant(restaurantEntity).build();

        return this.evaluationRepository.save(evaluationEntity);
    }


}

package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.RestaurantEntity;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("address")
    @Size(max = 255)
    private String address;

    @JsonProperty("listEval")
    private List<EvaluationDto> listEval;

    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity){
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .address(restaurantEntity.getAddress())
                .listEval(restaurantEntity.getListEvaluation().stream().map(evaluation -> EvaluationDto.fromEntity(evaluation)).collect(Collectors.toList()))
                .build();
    }
}

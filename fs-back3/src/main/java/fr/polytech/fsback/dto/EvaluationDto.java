package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom_eval")
    @Size(max = 50)
    private String nom_eval;

    @JsonProperty("commentary")
    @Size(max = 255)
    private String commentary;

    @JsonProperty("note")
    private int note;

    public static EvaluationDto fromEntity(EvaluationEntity evaluationEntity){
         return EvaluationDto.builder()
                 .id(evaluationEntity.getId())
                 .nom_eval(evaluationEntity.getNom_eval())
                 .commentary(evaluationEntity.getNom_eval())
                 .build();
    }
}

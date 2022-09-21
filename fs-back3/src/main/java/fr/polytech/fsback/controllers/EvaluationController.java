package fr.polytech.fsback.controllers;

import fr.polytech.fsback.dto.EvaluationDto;
import fr.polytech.fsback.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("restaurants/{id}/evaluations")
    public @ResponseBody EvaluationDto addEvaluation(@Valid @RequestBody EvaluationDto evaluationDto, @PathVariable int id){
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluation(evaluationDto.getId(), evaluationDto.getNom_eval(), evaluationDto.getCommentary()));
    }

}

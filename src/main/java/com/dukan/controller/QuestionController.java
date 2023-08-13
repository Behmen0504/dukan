package com.dukan.controller;

import com.dukan.model.QuestionDTO;
import com.dukan.model.requests.QuestionRequestDTO;
import com.dukan.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionDTO> getQuestions(){
        return questionService.getQuestions();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuestionDTO getQuestion(@PathVariable Long id){
        return questionService.getQuestion(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addQuestion(@RequestBody QuestionRequestDTO requestDTO){
        questionService.addQuestion(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateQuestion(@PathVariable Long id,@RequestBody QuestionRequestDTO requestDTO){
        questionService.updateQuestion(id,requestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
    }

}

package com.dukan.service;

import com.dukan.dao.entity.QuestionEntity;
import com.dukan.dao.repository.QuestionRepository;
import com.dukan.mapper.QuestionMapper;
import com.dukan.model.QuestionDTO;
import com.dukan.model.requests.QuestionRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<QuestionDTO> getQuestions() {
        log.info("ActionLog.getQuestions start");
        List<QuestionDTO> questionDTOS = QuestionMapper.INSTANCE.mapEntitiesToDtos(questionRepository.findAll());
        log.info("ActionLog.getQuestions end");
        return questionDTOS;
    }

    public QuestionDTO getQuestion(Long id) {
        log.info("ActionLog.getQuestion start");
        QuestionDTO questionDTO = QuestionMapper.INSTANCE.mapEntityToDto(questionRepository.findById(id).get());
        log.info("ActionLog.getQuestion end");
        return questionDTO;
    }
    public void addQuestion(QuestionRequestDTO requestDTO) {
        log.info("ActionLog.addQuestion start");
        QuestionEntity questionEntity = QuestionMapper.INSTANCE.mapQuestionRequestDtoToEntity(requestDTO);
        questionRepository.save(questionEntity);
        log.info("ActionLog.addQuestion end");
    }

    public void updateQuestion(Long id, QuestionRequestDTO questionRequestDTO) {
        log.info("ActionLog.updateQuestion start");
        QuestionEntity questionEntity = questionRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateQuestion end");
    }
}
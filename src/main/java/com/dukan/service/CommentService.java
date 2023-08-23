package com.dukan.service;

import com.dukan.dao.entity.CommentEntity;
import com.dukan.dao.repository.CommentRepository;
import com.dukan.mapper.CommentMapper;
import com.dukan.model.CommentDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.CommentRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentDTO> getComments() {
        log.info("ActionLog.getComments start");
        List<CommentDTO> commentDTOS = CommentMapper.INSTANCE.mapEntitiesToDtos(commentRepository.findAll());
        log.info("ActionLog.getComments end");
        return commentDTOS;
    }

    public CommentDTO getComment(Long id) {
        log.info("ActionLog.getComment start");
        CommentDTO commentDTO = CommentMapper.INSTANCE.mapEntityToDto(
                commentRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("ActionLog.getComment.error comment not found with id: {}", id);
                                    throw new NotFoundException("COMMENT_NOT_FOUND");
                                }
                        ));
        log.info("ActionLog.getComment end");
        return commentDTO;
    }

    public void addComment(CommentRequestDTO requestDTO) {
        log.info("ActionLog.addComment start");
        CommentEntity commentEntity = CommentMapper.INSTANCE.mapCommentRequestDtoToEntity(requestDTO);
        commentRepository.save(commentEntity);
        log.info("ActionLog.addComment end");
    }

    public void updateComment(Long id, CommentDTO commentDTO) {
        log.info("ActionLog.updateComment start");
        CommentEntity commentEntity = commentRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateComment end");
    }

    public void deleteComment(Long id) {
        log.info("ActionLog.deleteComment start");
        commentRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteComment.error comment not found with id: {}", id);
                    throw new NotFoundException("COMMENT_NOT_FOUND");
                }
        );
        commentRepository.deleteById(id);
        log.info("ActionLog.deleteComment end");
    }
}

package com.dukan.controller;


import com.dukan.model.CommentDTO;
import com.dukan.model.requests.CommentRequestDTO;
import com.dukan.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody CommentRequestDTO requestDTO) {
        commentService.addComment(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
    }
}

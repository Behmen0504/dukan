package com.dukan.service;

import com.dukan.dao.entity.BlogEntity;
import com.dukan.dao.repository.BlogRepository;
import com.dukan.mapper.BlogMapper;
import com.dukan.model.dto.BlogDTO;
import com.dukan.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public List<BlogDTO> getBlogs() {
        log.info("ActionLog.start blogs get method");

        List<BlogEntity> list = blogRepository.findAll();
        if (list.isEmpty())
            throw new NotFoundException("BLOG_NOT_FOUND");

        log.info("ActionLog.end blogs get method");
        return BlogMapper.INSTANCE.entityToDtoList(list);
    }

    public BlogDTO getBlog(Long id) {
        log.info("ActionLog.start get blog with id: {}", id);

        BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("BLOG_NOT_FOUND");
        });

        log.info("ActionLog.end get blog with id: {}", id);
        return BlogMapper.INSTANCE.entityToDto(blogEntity);
    }

    public void addBlog(BlogDTO blogDTO) {
        log.info("ActionLog.start blog post method");

        blogRepository.save(BlogMapper.INSTANCE.dtoToEntity(blogDTO));

        log.info("ActionLog.end blog post method");
    }

    public void updateBlog(Long id, BlogDTO blogDTO) {
        log.info("ActionLog.start update blog with id: {}", id);

        BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(() ->
                new NotFoundException("BLOG_NOT_FOUND"));
        BeanUtils.copyProperties(blogDTO, blogEntity, "id");
        blogRepository.save(blogEntity);

        log.info("ActionLog.end update blog with id: {}", id);
    }


    public void deleteBlog(Long id) {
        log.info("ActionLog.end delete blog id: {}", id);

        if (!blogRepository.existsById(id))
            throw new NotFoundException("BLOG_NOT_EXİST");
        blogRepository.deleteById(id);

        log.info("ActionLog.end delete blog id: {}", id);
    }


}

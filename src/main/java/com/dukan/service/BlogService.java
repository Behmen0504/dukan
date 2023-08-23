package com.dukan.service;

import com.dukan.dao.entity.BlogEntity;
import com.dukan.dao.repository.BlogRepository;
import com.dukan.mapper.BlogMapper;
import com.dukan.model.BlogDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.BlogRequestDTO;
import com.dukan.myenums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<BlogDTO> getBlogs() {
        log.info("ActionLog.getBlogs start");
        List<BlogDTO> blogDTOS = BlogMapper.INSTANCE.mapEntitiesToDtos(blogRepository.findAll());
        log.info("ActionLog.getBlogs end");
        return blogDTOS;
    }

    public BlogDTO getBlog(Long id) {
        log.info("ActionLog.getBlog start");
        BlogDTO blogDTO = BlogMapper.INSTANCE.mapEntityToDto(
                blogRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            log.error("ActionLog.getBlog.error blog not found with id: {}", id);
                            throw new NotFoundException("BLOG_NOT_FOUND");
                        }
                ));
        log.info("ActionLog.getBlog end");
        return blogDTO;
    }
    public void addBlog(BlogRequestDTO requestDTO) {
        log.info("ActionLog.addBlog start");
        BlogEntity blogEntity = BlogMapper.INSTANCE.mapBlogRequestDtoToEntity(requestDTO);
        blogRepository.save(blogEntity);
        log.info("ActionLog.addBlog end");
    }

    public void updateBlog(Long id, BlogRequestDTO blogDTO) {
        log.info("ActionLog.updateBlog start");
        BlogEntity blogEntity = blogRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateBlog end");
    }

    public void deleteBlog(Long id) {
        log.info("ActionLog.deleteBlog start");
        blogRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.DeleteBlog.error blog not found with id: {}", id);
                    throw new NotFoundException("BLOG_NOT_FOUND");
                }
        );
        log.info("ActionLog.deleteBlog end");
        blogRepository.deleteById(id);
    }
}

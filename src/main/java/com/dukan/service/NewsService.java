package com.dukan.service;

import com.dukan.dao.entity.NewsEntity;
import com.dukan.dao.repository.NewsRepository;
import com.dukan.mapper.NewsMapper;
import com.dukan.model.NewsDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.NewsRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<NewsDTO> getNews() {
        log.info("ActionLog.getNews start");
        List<NewsDTO> newsDTOS = NewsMapper.INSTANCE.mapEntitiesToDtos(newsRepository.findAll());
        log.info("ActionLog.getNews end");
        return newsDTOS;
    }

    public NewsDTO getNewsById(Long id) {
        log.info("ActionLog.getNews start");
        NewsDTO newsDTO = NewsMapper.INSTANCE.mapEntityToDto(newsRepository.findById(id).get());
        log.info("ActionLog.getNews end");
        return newsDTO;
    }
    public void addNews(NewsRequestDTO requestDTO) {
        log.info("ActionLog.addNews start");
        newsRepository.save(NewsMapper.INSTANCE.mapDtoToEntity(requestDTO));
        log.info("ActionLog.addNews end");
    }

    public void updateNews(Long id, NewsRequestDTO requestDTO) {
        log.info("ActionLog.updateNews start");
        NewsEntity newsEntity = newsRepository.findById(id).get();
        newsEntity.setTitle(requestDTO.getTitle());
        newsEntity.setImage(requestDTO.getImage());
        newsEntity.setStatus(requestDTO.getStatus());
        newsEntity.setDescription(requestDTO.getDescription());
        newsRepository.save(newsEntity);
        log.info("ActionLog.updateNews end");
    }
    public void deleteNews(Long id) {
        log.info("ActionLog.deleteNews start");
        newsRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteNews.error news not found with id: {}", id);
                    throw new NotFoundException("NEWS_NOT_FOUND");
                }
        );
        log.info("ActionLog.deleteNews end");
        newsRepository.deleteById(id);
    }
}

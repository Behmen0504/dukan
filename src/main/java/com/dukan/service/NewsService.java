package com.dukan.service;

import com.dukan.dao.entity.NewsEntity;
import com.dukan.dao.repository.NewsRepository;
import com.dukan.mapper.NewsMapper;
import com.dukan.model.NewsDTO;
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
    public void addNews(NewsDTO newsDTO) {
        log.info("ActionLog.addNews start");
        newsRepository.save(NewsMapper.INSTANCE.mapDtoToEntity(newsDTO));
        log.info("ActionLog.addNews end");
    }

    public void updateNews(Long id, NewsDTO newsDTO) {
        log.info("ActionLog.updateNews start");
        NewsEntity newsEntity = newsRepository.findById(id).get();
        newsEntity.setTitle(newsDTO.getTitle());
        newsEntity.setImage(newsDTO.getImage());
        newsEntity.setStatus(newsDTO.getStatus());
        newsEntity.setDescription(newsDTO.getDescription());
        newsRepository.save(newsEntity);
        log.info("ActionLog.updateNews end");
    }
}

package com.dukan.service;

import com.dukan.dao.entity.SlideImageEntity;
import com.dukan.dao.repository.SlideImageRepository;
import com.dukan.mapper.SlideImageMapper;
import com.dukan.model.SlideImageDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.SlideImageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SlideImageService {
    private final SlideImageRepository slideImageRepository;

    public List<SlideImageDTO> getSlideImages() {
        log.info("ActionLog.getSlideImages start");
        List<SlideImageDTO> slideImageDTOS = SlideImageMapper.INSTANCE.mapEntitiesToDtos(slideImageRepository.findAll());
        log.info("ActionLog.getSlideImages end");
        return slideImageDTOS;
    }

    public SlideImageDTO getSlideImage(Long id) {
        log.info("ActionLog.getSlideImage start");
        SlideImageDTO slideImageDTO = SlideImageMapper.INSTANCE.mapEntityToDto(
                slideImageRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("ActionLog.getSlideImage.error slide image not found with id: {}", id);
                                    throw new NotFoundException("SLIDEIMAGE_NOT_FOUND");
                                }
                        ));
        log.info("ActionLog.getSlideImage end");
        return slideImageDTO;
    }

    public void addSlideImage(SlideImageRequestDTO requestDTO) {
        log.info("ActionLog.addSlideImage start");
        SlideImageEntity slideImageEntity = SlideImageMapper.INSTANCE.mapSlideImageRequestDtoToEntity(requestDTO);
        slideImageRepository.save(slideImageEntity);
        log.info("ActionLog.addSlideImage end");
    }

    public void updateSlideImage(Long id, SlideImageRequestDTO requestDTO) {
        log.info("ActionLog.updateSlideImage start");
        SlideImageEntity slideImageEntity = slideImageRepository.findById(id).get();
//        newsRepository.save(slideImageEntity);
        log.info("ActionLog.updateSlideImage end");
    }

    public void deleteSlideImage(Long id) {
        log.info("ActionLog.deleteSlideImage start");
        slideImageRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteSlideImage.error slide image not found with id: {}", id);
                    throw new NotFoundException("SLIDEIMAGE_NOT_FOUND");
                }
        );
        slideImageRepository.deleteById(id);
        log.info("ActionLog.deleteSlideImage end");

    }
}

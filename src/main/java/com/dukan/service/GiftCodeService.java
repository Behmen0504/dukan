package com.dukan.service;

import com.dukan.dao.entity.GiftCodeEntity;
import com.dukan.dao.repository.GiftCodeRepository;
import com.dukan.mapper.GiftCodeMapper;
import com.dukan.model.GiftCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GiftCodeService {
    private final GiftCodeRepository giftCodeRepository;

    public GiftCodeService(GiftCodeRepository giftCodeRepository) {
        this.giftCodeRepository = giftCodeRepository;
    }

    public List<GiftCodeDTO> getGiftCodes() {
        log.info("ActionLog.getGiftCodes start");
        List<GiftCodeDTO> giftCodeDTOS = GiftCodeMapper.INSTANCE.mapEntitiesToDtos(giftCodeRepository.findAll());
        log.info("ActionLog.getGiftCodes end");
        return giftCodeDTOS;
    }

    public GiftCodeDTO getGiftCode(Long id) {
        log.info("ActionLog.getGiftCode start");
        GiftCodeDTO giftCodeDTO = GiftCodeMapper.INSTANCE.mapEntityToDto(giftCodeRepository.findById(id).get());
        log.info("ActionLog.getGiftCode end");
        return giftCodeDTO;
    }
    public void addGiftCode(GiftCodeDTO giftCodeDTO) {
        log.info("ActionLog.addGiftCode start");
        giftCodeRepository.save(GiftCodeMapper.INSTANCE.mapDtoToEntity(giftCodeDTO));
        log.info("ActionLog.addGiftCode end");
    }

    public void updateGiftCode(Long id, GiftCodeDTO giftCodeDTO) {
        log.info("ActionLog.updateGiftCode start");
//        GiftCodeEntity giftCodeEntity = giftCodeRepository.findById(id).get();
//        giftCodeEntity.setTitle(newsDTO.getTitle());
//        giftCodeEntity.setImage(newsDTO.getImage());
//        giftCodeEntity.setStatus(newsDTO.getStatus());
//        giftCodeEntity.setDescription(newsDTO.getDescription());
//        giftCodeRepository.save(newsEntity);
        log.info("ActionLog.updateGiftCode end");
    }
}

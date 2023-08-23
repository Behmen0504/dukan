package com.dukan.service;


import com.dukan.dao.entity.ProductImageEntity;
import com.dukan.dao.repository.ProductImageRepository;
import com.dukan.mapper.ProductImageMapper;
import com.dukan.model.ProductImageDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.ProductImageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public List<ProductImageDTO> getProductImages() {
        log.info("ActionLog.getProductImages start");
        List<ProductImageDTO> productImageDTOS = ProductImageMapper.INSTANCE.mapEntitiesToDtos(productImageRepository.findAll());
        log.info("ActionLog.getProductImages end");
        return productImageDTOS;
    }

    public ProductImageDTO getProductImage(Long id) {
        log.info("ActionLog.getProductImage start");
        ProductImageDTO productImageDTO = ProductImageMapper.INSTANCE.mapEntityToDto(
                productImageRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("ActionLog.getProductImage.error product image not found with id: {}", id);
                                    throw new NotFoundException("PRODUCTIMAGE_NOT_FOUND");
                                }
                        ));
        log.info("ActionLog.getProductImage end");
        return productImageDTO;
    }

    public void addProductImage(ProductImageRequestDTO requestDTO) {
        log.info("ActionLog.addProductImage start");
        ProductImageEntity productImageEntity = ProductImageMapper.INSTANCE.mapProductImageRequestDtoToEntity(requestDTO);
        productImageRepository.save(productImageEntity);
        log.info("ActionLog.addProductImage end");
    }

    public void updateProductImage(Long id, ProductImageRequestDTO productImageRequestDTO) {
        log.info("ActionLog.updateProductImage start");
        ProductImageEntity productImageEntity = productImageRepository.findById(id).get();
//        newsRepository.save(productImageEntity);
        log.info("ActionLog.updateProductImage end");
    }

    public void deleteProductImage(Long id) {
        log.info("ActionLog.deleteProductImage start");
        productImageRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteProductImage.error product image not found with id: {}", id);
                    throw new NotFoundException("PRODUCTIMAGE_NOT_FOUND");
                }
        );
        productImageRepository.deleteById(id);
        log.info("ActionLog.deleteProductImage end");

    }
}

package com.dukan.service;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.ProductImageEntity;
import com.dukan.dao.repository.OrderRepository;
import com.dukan.dao.repository.ProductImageRepository;
import com.dukan.dao.repository.ProductRepository;
import com.dukan.mapper.ProductMapper;
import com.dukan.model.ProductDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.ProductRequestDTO;
import com.dukan.myenums.Status;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final OrderRepository orderRepository;

    public List<ProductDTO> getProducts() {
        log.info("ActionLog.getProducts start");
        List<ProductDTO> productDTOS = ProductMapper.INSTANCE.mapEntitiesToDtos(productRepository.getProductEntitiesByStatus(Status.ENABLE));
        log.info("ActionLog.getProducts end");
        return productDTOS;
    }

    public ProductDTO getProduct(Long id) {
        log.info("ActionLog.getProduct start");
        ProductDTO productDTO = ProductMapper.INSTANCE.mapEntityToDto(
                productRepository
                        .findProductEntityByIdAndStatus(id, Status.ENABLE));
        log.info("ActionLog.getProduct end");
        return productDTO;
    }

    public void addProduct(ProductRequestDTO requestDTO) {
        log.info("ActionLog.addProduct start");
        ProductEntity productEntity = ProductMapper.INSTANCE.mapProductRequestDtoToEntity(requestDTO);
        productRepository.save(productEntity);
        log.info("ActionLog.addProduct end");
    }

    public void updateProduct(Long id, ProductDTO productDTO) {
        log.info("ActionLog.updateProduct start");
        ProductEntity productEntity = productRepository.findById(id).get();
//        newsRepository.save(newsEntity);
        log.info("ActionLog.updateProduct end");
    }

    @Transactional
    public void deleteProduct(Long id) {
        log.info("ActionLog.deleteProduct start");
//        productRepository.findById(id)
//                .orElseThrow(
//                () -> {
//                    log.error("ActionLog.deleteProduct.error product not found with id: {}", id);
//                    throw new NotFoundException("PRODUCT_NOT_FOUND");
//                }
//        );
        ProductEntity productEntity = productRepository.findProductEntityByIdAndStatus(id, Status.ENABLE);
        if (productEntity == null) {
            log.error("ActionLog.deleteProduct.error product not found with id: {}", id);
            throw new NotFoundException("PRODUCT_NOT_FOUND");
        }
        List<ProductImageEntity> productImageEntities = productImageRepository.getProductImageEntitiesByProduct_Id(id);
        List<OrderEntity> orderEntities = orderRepository.getOrderEntitiesByProduct_Id(id);
        if(productImageEntities != null){
            productImageEntities.forEach(productImageEntity -> productImageEntity.setStatus(Status.DISABLE));
            productImageRepository.saveAll(productImageEntities);
        }
        if (orderEntities != null){
            orderEntities.forEach(orderEntity -> orderEntity.setStatus(Status.DISABLE));
            orderRepository.saveAll(orderEntities);
        }
        productEntity.setStatus(Status.DISABLE);
        productRepository.save(productEntity);
        log.info("ActionLog.deleteProduct end");
    }
}

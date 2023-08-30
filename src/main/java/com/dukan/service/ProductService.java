package com.dukan.service;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.ProductImageEntity;
import com.dukan.dao.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    private final OrderRepository orderRepository;

    public List<ProductDTO> getProducts() {
        log.info("ActionLog.getProducts start");
        List<ProductDTO> productDTOS = ProductMapper.INSTANCE
                .mapEntitiesToDtos(productRepository.getProductEntitiesByStatus(Status.ENABLE));
        log.info("ActionLog.getProducts end");
        return productDTOS;
    }

    public ProductDTO getProduct(Long id) {
        log.info("ActionLog.getProduct start");
        var product = productRepository.findProductEntityByIdAndStatus(id, Status.ENABLE);
        if (product == null) {
            log.error("ActionLog.getProduct.error product not found with id: {}", id);
            throw new NotFoundException("PRODUCT_NOT_FOUND");
        }
        ProductDTO productDTO = ProductMapper.INSTANCE.mapEntityToDto(product);
        log.info("ActionLog.getProduct end");
        return productDTO;
    }

    public void addProduct(ProductRequestDTO requestDTO) {
        log.info("ActionLog.addProduct start");
        ProductEntity productEntity = ProductMapper.INSTANCE.mapProductRequestDtoToEntity(requestDTO);
        productRepository.save(productEntity);
        log.info("ActionLog.addProduct end");
    }

    public void updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        log.info("ActionLog.updateProduct start");
        var category = categoryRepository
                .findById(productRequestDTO.getCategoryId()).orElseThrow(() -> {
                    log.error("ActionLog.updateProduct.error category not found with id: {}", id);
                    throw new NotFoundException("CATEGORY_NOT_FOUND");
                });
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(() -> {
                    log.error("ActionLog.updateProduct.error product not found with id: {}", id);
                    throw new NotFoundException("PRODUCT_NOT_FOUND");
                });
        productEntity.setName(productRequestDTO.getName());
        productEntity.setStatus(productRequestDTO.getStatus());
        productEntity.setStock(productRequestDTO.getStock());
        productEntity.setStockCode(productRequestDTO.getStockCode());
        productEntity.setDescription(productRequestDTO.getDescription());
        productEntity.setPrice(productRequestDTO.getPrice());
        productEntity.setSort(productRequestDTO.getSort());
        productEntity.setCategory(category);

        productRepository.save(productEntity);
        log.info("ActionLog.updateProduct end");
    }

    @Transactional
    public void deleteProduct(Long id) {
        log.info("ActionLog.deleteProduct start");
        ProductEntity productEntity = productRepository.findProductEntityByIdAndStatus(id, Status.ENABLE);
        if (productEntity == null) {
            log.error("ActionLog.deleteProduct.error product not found with id: {}", id);
            throw new NotFoundException("PRODUCT_NOT_FOUND");
        }
        List<ProductImageEntity> productImageEntities = productImageRepository.getProductImageEntitiesByProduct_Id(id);
        List<OrderEntity> orderEntities = orderRepository.getOrderEntitiesByProduct_Id(id);
        if (productImageEntities != null) {
            productImageEntities.forEach(productImageEntity -> productImageEntity.setStatus(Status.DISABLE));
            productImageRepository.saveAll(productImageEntities);
        }
        if (orderEntities != null) {
            orderEntities.forEach(orderEntity -> orderEntity.setStatus(Status.DISABLE));
            orderRepository.saveAll(orderEntities);
        }
        productEntity.setStatus(Status.DISABLE);
        productRepository.save(productEntity);
        log.info("ActionLog.deleteProduct end");
    }
}

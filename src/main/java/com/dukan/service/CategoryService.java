package com.dukan.service;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.repository.CategoryRepository;
import com.dukan.dao.repository.ProductRepository;
import com.dukan.mapper.CategoryMapper;
import com.dukan.model.CategoryDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.CategoryRequestDTO;
import com.dukan.myenums.Status;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<CategoryDTO> getCategories() {
        log.info("ActionLog.getCategories start");
        List<CategoryDTO> categoryDTOS = CategoryMapper.INSTANCE.mapEntitiesToDtos(categoryRepository.getCategoryEntitiesByStatus(Status.ENABLE));
        log.info("ActionLog.getCategories end");
        return categoryDTOS;
    }

    public CategoryDTO getCategory(Long id) {
        log.info("ActionLog.getCategory start");
        var category = categoryRepository.findCategoryEntityByIdAndStatus(id, Status.ENABLE);
        if (category == null) {
            log.error("ActionLog.getCategory.error category not found with id: {}", id);
            throw new NotFoundException("CATEGORY_NOT_FOUND");
        }
        CategoryDTO categoryDTO = CategoryMapper.INSTANCE
                .mapEntityToDto(category);
        log.info("ActionLog.getCategory end");
        return categoryDTO;
    }

    public void addCategory(CategoryRequestDTO requestDTO) {
        log.info("ActionLog.addCategory start");
        CategoryEntity categoryEntity = CategoryMapper.INSTANCE.mapCategoryRequestDtoToEntity(requestDTO);
        categoryRepository.save(categoryEntity);
        log.info("ActionLog.addCategory end");
    }

    public void updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        log.info("ActionLog.updateCategory start");
        var category = categoryRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.getCategory.error category not found with id: {}", id);
            throw new NotFoundException("CATEGORY_NOT_FOUND");
        });
        category.setName(categoryRequestDTO.getName());
        category.setIcon(categoryRequestDTO.getIcon());
        category.setIsShowingHomePage(categoryRequestDTO.getIsShowingHomePage());
        category.setStatus(categoryRequestDTO.getStatus());
        category.setSort(categoryRequestDTO.getSort());

        if (categoryRequestDTO.getStatus() == null || categoryRequestDTO.getStatus() == Status.ENABLE) {
            List<ProductEntity> productEntities = productRepository.getProductEntitiesByCategory_Id(id);
            productEntities.forEach(productEntity -> productEntity.setStatus(Status.ENABLE));
            productRepository.saveAll(productEntities);
        }

        categoryRepository.save(category);
        log.info("ActionLog.updateCategory end");
    }


    @Transactional
    public void deleteCategory(Long id) {
        log.info("ActionLog.deleteCategory start");
        var category = categoryRepository.findCategoryEntityByIdAndStatus(id, Status.ENABLE);
        if (category == null) {
            log.error("ActionLog.deleteCategory.error category not found with id: {}", id);
            throw new NotFoundException("CATEGORY_NOT_FOUND");
        }
        List<ProductEntity> productEntities = productRepository.getProductEntitiesByCategory_Id(id);
        productEntities.forEach(productEntity -> productEntity.setStatus(Status.DISABLE));
        productRepository.saveAll(productEntities);
        category.setStatus(Status.DISABLE);
        categoryRepository.save(category);
        log.info("ActionLog.deleteCategory end");
    }
}

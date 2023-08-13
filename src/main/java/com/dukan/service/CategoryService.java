package com.dukan.service;

import com.dukan.dao.entity.CategoryEntity;
import com.dukan.dao.repository.CategoryRepository;
import com.dukan.mapper.CategoryMapper;
import com.dukan.model.CategoryDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.CategoryRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategories() {
        log.info("ActionLog.getCategories start");
        List<CategoryDTO> categoryDTOS = CategoryMapper.INSTANCE.mapEntitiesToDtos(categoryRepository.findAll());
        log.info("ActionLog.getCategories end");
        return categoryDTOS;
    }

    public CategoryDTO getCategory(Long id) {
        log.info("ActionLog.getCategory start");
        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.mapEntityToDto(categoryRepository.findById(id).get());
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
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
//        categoryRepository.save(categoryEntity);
        log.info("ActionLog.updateCategory end");
    }
    public void deleteCategory(Long id) {
        log.info("ActionLog.deleteCategory start");
        categoryRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.deleteCategory.error category not found with id: {}", id);
                    throw new NotFoundException("CATEGORY_NOT_FOUND");
                }
        );
        log.info("ActionLog.deleteCategory end");
        categoryRepository.deleteById(id);
    }
}

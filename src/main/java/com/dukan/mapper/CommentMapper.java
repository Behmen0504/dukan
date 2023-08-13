package com.dukan.mapper;

import com.dukan.dao.entity.*;
import com.dukan.model.CommentDTO;
import com.dukan.model.ProductDTO;
import com.dukan.model.requests.CommentRequestDTO;
import com.dukan.model.requests.ProductRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class CommentMapper {
    public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    public abstract CommentDTO mapEntityToDto(CommentEntity commentEntity);

    public abstract CommentEntity mapDtoToEntity(CommentDTO commentDTO);

    @Mappings({
            @Mapping(source = "requestDto.productId", target = "product", qualifiedByName = "createProductEntity"),
            @Mapping(source = "requestDto.userId", target = "user", qualifiedByName = "createUserEntity"),
            @Mapping(source = "requestDto.commentId", target = "comment", qualifiedByName = "createCommentEntity")
    })
    public abstract CommentEntity mapCommentRequestDtoToEntity(CommentRequestDTO requestDto);

    protected ProductEntity createProductEntity(Long id) {
        if(id == null) return null;
        return ProductEntity.builder().id(id).build();
    }
    protected UserEntity createUserEntity(Long id) {
        if(id == null) return null;
        return UserEntity.builder().id(id).build();
    }
    protected CommentEntity createCommentEntity(Long id) {
        if(id == null) return null;
        return CommentEntity.builder().id(id).build();
    }
    public List<CommentDTO> mapEntitiesToDtos(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }
}

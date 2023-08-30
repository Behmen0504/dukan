package com.dukan.service;

import com.dukan.dao.entity.OrderEntity;
import com.dukan.dao.entity.ProductEntity;
import com.dukan.dao.entity.UserEntity;
import com.dukan.dao.repository.FavoriteRepository;
import com.dukan.dao.repository.OrderRepository;
import com.dukan.dao.repository.UserRepository;
import com.dukan.mapper.UserMapper;
import com.dukan.model.UserDTO;
import com.dukan.model.exception.NotFoundException;
import com.dukan.model.requests.UserRequestDTO;
import com.dukan.myenums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;
    private final OrderRepository orderRepository;

    public List<UserDTO> getUsers() {
        log.info("ActionLog.getUsers start");
        List<UserDTO> userDTOS = UserMapper.INSTANCE.mapEntitiesToDtos(userRepository.findAll());
        log.info("ActionLog.getUsers end");
        return userDTOS;
    }

    public UserDTO getUser(Long id) {
        log.info("ActionLog.getUser start");
        UserDTO userDTO = UserMapper.INSTANCE.mapEntityToDto(userRepository.findById(id).get());
        log.info("ActionLog.getUser end");
        return userDTO;
    }

    public void addUser(UserRequestDTO requestDTO) {
        log.info("ActionLog.addUser start");
        UserEntity userEntity = UserMapper.INSTANCE.mapUserRequestDtoToEntity(requestDTO);
        userRepository.save(userEntity);
        log.info("ActionLog.addUser end");
    }

    public void updateUser(Long id, UserRequestDTO userRequestDTO) {
        log.info("ActionLog.updateUser start");
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.updateUser.error user not found with id: {}", id);
            throw new NotFoundException("USER_NOT_FOUND");
        });
        userEntity.setName(userRequestDTO.getName());
        userEntity.setSurname(userRequestDTO.getSurname());
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setPhoneNumber(userRequestDTO.getPhoneNumber());
        userEntity.setPassword(userRequestDTO.getPassword());
        userEntity.setGender(userRequestDTO.getGender());
        userEntity.setStatus(userRequestDTO.getStatus());

        userRepository.save(userEntity);
        log.info("ActionLog.updateUser end");
    }

    @Transactional
    public void deleteUser(Long id) {
        log.info("ActionLog.deleteUser start");
        var user = userRepository.findUserEntityByIdAndStatus(id, Status.ENABLE);
        if (user == null) {
            log.error("ActionLog.deleteUser.error user not found with id: {}", id);
            throw new NotFoundException("USER_NOT_FOUND");
        }
        favoriteRepository.deleteByUser_Id(id);
        List<OrderEntity> orderEntities = orderRepository.getOrderEntitiesByUser_Id(id);
        if (orderEntities != null) {
            orderEntities.forEach(orderEntity -> orderEntity.setStatus(Status.DISABLE));
            orderRepository.saveAll(orderEntities);
        }
        user.setStatus(Status.DISABLE);
        userRepository.save(user);
        log.info("ActionLog.deleteUser end");
    }
}

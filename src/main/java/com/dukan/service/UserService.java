package com.dukan.service;

import com.dukan.dao.entity.UserEntity;
import com.dukan.dao.repository.UserRepository;
import com.dukan.mapper.UserMapper;
import com.dukan.model.UserDTO;
import com.dukan.model.requests.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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

    public void updateUser(Long id, UserRequestDTO requestDTO) {
        log.info("ActionLog.updateUser start");
        UserEntity userEntity = userRepository.findById(id).get();
//        newsRepository.save(userEntity);
        log.info("ActionLog.updateUser end");
    }
}

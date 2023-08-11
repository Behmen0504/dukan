package com.dukan.controller;

import com.dukan.model.UserDTO;
import com.dukan.model.requests.UserRequestDTO;
import com.dukan.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserRequestDTO requestDTO){
        userService.addUser(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable Long id,@RequestBody UserRequestDTO userRequestDTO){
        userService.updateUser(id,userRequestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}

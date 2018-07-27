package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @PostMapping(path = "user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserIdResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @PutMapping(path = "edit")
    @ResponseStatus(HttpStatus.OK)
    public UserIdResponse update(@RequestBody UserEntity userEntity){
        return userService.update(userEntity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}

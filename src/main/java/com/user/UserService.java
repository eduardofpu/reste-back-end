package com.user;

import java.util.List;


public interface UserService {
    List<UserResponse> findAll();
    UserIdResponse create(UserRequest user);
    UserIdResponse update(UserEntity user);
    void delete(Long id);
}

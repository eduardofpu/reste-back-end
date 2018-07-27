package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserRepository repository;
    private Validator validator;

    @Autowired
    public UserServiceImp(UserRepository repository, Validator validator) {

        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserEntity> users = repository.findAll();
        return UserBilder.builder().users(users).build();
    }

    @Override
    public UserIdResponse create(UserRequest userRequest) {

        UserEntity user = UserEntity.create(
                userRequest.getName(),
                userRequest.getPassword(),
                repository,validator);

        return new UserIdResponse(user.getId());
    }

    @Override
    public UserIdResponse update(UserEntity userEntity) {

        UserEntity user = UserEntity.update(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getPassword(),
                repository,validator);

        return new UserIdResponse(user.getId());
    }

    @Override
    public void delete(Long id) {
        UserEntity.delete(id,repository,validator);
    }

}

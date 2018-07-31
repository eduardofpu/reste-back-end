package com.user;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class UserServiceTest extends AbstractTest {

    @Test
    public void findAll() {

        UserEntity user = save();
        UserEntity user2 = save();

        List<UserResponse> list = userService.findAll();
        int count = Integer.parseInt(String.valueOf(repository.count()));

        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user2.getId()).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(count);

    }

    @Test
    public void create() {
        UserRequest userRequest = new UserRequest("Matheus", "123");
        UserIdResponse userIdResponse = userService.create(userRequest);

        UserEntity one = repository.findOne(userIdResponse.getId());

        Assertions.assertThat(one.getId()).isEqualTo(userIdResponse.getId());
        Assertions.assertThat(userRequest.getName()).isEqualTo(userRequest.getName());
        Assertions.assertThat(userRequest.getPassword()).isEqualTo(userRequest.getPassword());
    }

    @Test
    public void update() {
        UserEntity user = save();
        UserEntity edit = new UserEntity(user.getId(), "Ludimila Martins", "12345");

        UserIdResponse update = userService.update(edit);
        UserEntity one = repository.findOne(update.getId());

        Assertions.assertThat(one.getId()).isEqualTo(edit.getId());
        Assertions.assertThat(one.getName()).isEqualTo(edit.getName());
        Assertions.assertThat(one.getPassword()).isEqualTo(edit.getPassword());
    }

    @Test
    public void delete() {
        UserEntity user = save();

        Assertions.assertThat(user.getId()).isNotNull();
        userService.delete(user.getId());


    }

    private UserEntity save() {
        UserEntity created = new UserEntity("Ludimila Alves", "123");
        UserEntity user = repository.save(created);
        return user;
    }

}
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

        Assertions.assertThat(userIdResponse.getId()).isNotNull();
        Assertions.assertThat(userRequest.getName()).isEqualTo("Matheus");
        Assertions.assertThat(userRequest.getPassword()).isEqualTo("123");
    }

    @Test
    public void update() {
        UserEntity user = save();
        UserEntity edit = new UserEntity(user.getId(), "Ludimila Martins", "12345");

        UserIdResponse update = userService.update(edit);
        UserEntity one = repository.findOne(update.getId());

        Assertions.assertThat(one.getId()).isEqualTo(user.getId());
        Assertions.assertThat(edit.getName()).isEqualTo("Ludimila Martins");
        Assertions.assertThat(edit.getPassword()).isEqualTo("12345");
    }

    @Test
    public void delete() {
        UserEntity user = save();
        userService.delete(user.getId());
        Assertions.assertThat(user.getId()).isNotNull();

    }

    private UserEntity save() {
        UserEntity created = new UserEntity("Ludimila Alves", "123");
        UserEntity user = repository.save(created);
        return user;
    }

}
package com.user;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class UserEntityTest extends AbstractTest{

    @Test
    public void create(){
        UserEntity userEntity = UserEntity.create("Ludimila", "1234", repository, validator);
        UserEntity one = repository.findOne(userEntity.getId());

        Assertions.assertThat(one.getId()).isNotNull();
        Assertions.assertThat(one.getName()).isEqualTo("Ludimila");
        Assertions.assertThat(one.getPassword()).isEqualTo("1234");

    }

    @Test
    public void update(){
       UserEntity user = save();
        UserEntity edit = UserEntity.update(user.getId(), "Ludimila Martins", "12345", repository, validator);
        UserEntity one = repository.findOne(edit.getId());

        Assertions.assertThat(one.getId()).isEqualTo(user.getId());
        Assertions.assertThat(one.getName()).isEqualTo("Ludimila Martins");
        Assertions.assertThat(one.getPassword()).isEqualTo("12345");
    }

    @Test
    public void delete(){
        UserEntity user = save();
        UserEntity.delete(user.getId(),repository,validator);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    private UserEntity save(){
        UserEntity created = new UserEntity("Ludimila Alves","123");
        UserEntity user = repository.save(created);
        return user;
    }
}
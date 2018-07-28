package com.user;

import org.junit.Test;


public class UserEntityTest extends AbstractTest{

    @Test
    public void create(){
        UserEntity.create("Ludimila","1234",repository,validator);
    }

    @Test
    public void update(){
       UserEntity user = save();
       UserEntity.update(user.getId(),"Ludimila Martins","12345",repository,validator);
    }

    @Test
    public void delete(){
        UserEntity user = save();
        UserEntity.delete(user.getId(),repository,validator);
    }

    private UserEntity save(){
        UserEntity created = new UserEntity("Ludimila Alves","123");
        UserEntity user = repository.save(created);
        return user;
    }
}
package com.user;

import org.junit.Test;

public class ValidatorTest extends AbstractTest{

    @Test
    public void verifyIfUserExists() {
        UserEntity created = save();
        validator.verifyIfUserExists(created.getId());
    }

    @Test
    public void verifyIfNameIsPasswordNotNull() {
        UserEntity created = save();
        validator.verifyIfNameIsPasswordNotNull(created.getName(), created.getPassword());
    }

    @Test
    public void validate() {
        UserEntity created = save();
        validator.validate(created.getId(), created.getName(), created.getPassword());
    }

    private UserEntity save() {
        UserEntity created = new UserEntity("Ludimila Alves", "123");
        UserEntity user = repository.save(created);
        return user;
    }

}
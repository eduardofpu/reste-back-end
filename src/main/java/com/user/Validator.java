package com.user;

public interface Validator {
    void verifyIfUserExists(Long id);
    void verifyIfNameIsPasswordNotNull(String name, String password);
}

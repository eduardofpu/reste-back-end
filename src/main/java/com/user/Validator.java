package com.user;

public interface Validator {
    void verifyIfUserExists(Long id);
    void verifyIfNameIsPasswordNotNull(String name, String password);
    void validate(Long id, String name, String password);
}

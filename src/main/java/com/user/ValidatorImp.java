package com.user;

import com.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorImp implements Validator {

    private UserRepository repository;

    @Autowired
    public ValidatorImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void verifyIfUserExists(Long id) {
        if(repository.findOne(id) == null){
            throw new ResourceNotFoundException("User not found for ID: "+id);
        }
    }

    @Override
    public void verifyIfNameIsPasswordNotNull(String name, String password) {
        if(name == null || password == null){
            throw new ResourceNotFoundException("Name or Password not null");
        }
    }
}

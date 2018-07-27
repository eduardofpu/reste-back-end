package com.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public UserEntity(Long id) {
        this.id = id;
    }

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public static UserEntity create(String name, String password, UserRepository repository, Validator validator) {
        validator.verifyIfNameIsPasswordNotNull(name, password);
        UserEntity user = new UserEntity(name, password);
        return repository.save(user);
    }

    public static UserEntity update(Long id, String name, String password, UserRepository repository, Validator validator) {

        validator.verifyIfUserExists(id);
        validator.verifyIfNameIsPasswordNotNull(name, password);

        UserEntity user = new UserEntity(id, name, password);
        return repository.save(user);
    }

    public static void  delete(Long id, UserRepository repository, Validator validator) {

        validator.verifyIfUserExists(id);
        UserEntity userId = new UserEntity(id);
          repository.delete(userId);
    }
}
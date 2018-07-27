package com.user;

import java.util.List;
import java.util.stream.Collectors;

public class UserBilder {
    private List<UserEntity> users;

    public UserBilder users(List<UserEntity> users) {
        this.users = users;
        return this;
    }

    public static UserBilder builder() {
        return new UserBilder();
    }

    public List<UserResponse> build() {
        return this.users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }
}

package com.tecsus.ddc.user.builders;

import com.tecsus.ddc.user.User;
import com.tecsus.ddc.user.enums.Role;

public final class UserBuilder {
    private User user;

    private UserBuilder() {
        user = new User();
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder username(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder role(Role role) {
        user.setRole(role);
        return this;
    }

    public User build() {
        return user;
    }
}

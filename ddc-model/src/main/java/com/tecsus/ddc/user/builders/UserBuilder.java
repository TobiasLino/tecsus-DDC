package com.tecsus.ddc.user.builders;

import com.tecsus.ddc.user.User;
import com.tecsus.ddc.user.enums.Role;

/**
 * @author TOBIASDASILVALINO
 */
public class UserBuilder {

    private String name;
    private String username;
    private String passwd;
    private Role role;
    
    public User build() {
        return new User(name, username, passwd, role);
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder passwd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public UserBuilder role(Role role) {
        this.role = role;
        return this;
    }
}

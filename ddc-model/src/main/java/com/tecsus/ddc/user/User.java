package com.tecsus.ddc.user;

import com.tecsus.ddc.user.enums.Role;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class User {

    private String name;
    private String username;
    private String passwd;
    private Role role;

    public User(
            final String name,
            final String username,
            final String passwd,
            final Role role) {
        this.name = name;
        this.username = username;
        this.passwd = passwd;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(passwd, user.passwd) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, passwd, role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

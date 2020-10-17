package com.tecsus.ddc.user;

import com.tecsus.ddc.user.enums.Role;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class User {

    private String name;
    private String username;
    private Role role;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, role);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}

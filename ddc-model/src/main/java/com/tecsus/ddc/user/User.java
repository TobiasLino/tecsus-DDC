package com.tecsus.ddc.user;

import com.tecsus.ddc.user.enums.Role;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class User {

    private java.lang.String name;
    private java.lang.String username;
    private Role role;

    public User() {
    }

    @Override
    public java.lang.String toString() {
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

    public java.lang.String getName() {
        return name;
    }

    public void setName(final java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(final java.lang.String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}

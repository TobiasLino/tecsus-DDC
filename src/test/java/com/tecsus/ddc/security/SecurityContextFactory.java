package com.tecsus.ddc.security;

import com.tecsus.ddc.user.LoggedUser;
import com.tecsus.ddc.user.Role;
import com.tecsus.ddc.user.User;

import java.util.ArrayList;

public class SecurityContextFactory implements WithSecurityContextFactory<WithUser> {

    @Override
    public SecurityContext createSecurityContext(WithUser annotatedUser) {
        final LoggedUser loggedUser = new LoggedUser();
        final ArrayList<Role> authorities = new ArrayList<>();

        for (String str : annotatedUser.authorities())
            authorities.add(Role.valueOf(str));

        final User user = User.builder()
                .login(annotatedUser.login())
                .username(annotatedUser.username())
                .password(annotatedUser.password())
                .roles(authorities)
                .build();

        loggedUser.setUser(user);

        SecurityContext context = new SecurityContext();
        SecurityContext.loggedUser = loggedUser;
        return context;
    }
}

package com.tecsus.ddc.user;

import com.tecsus.ddc.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TOBIASDASILVALINO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    private java.lang.String name;
    private java.lang.String username;
    private Role role;
}

package com.example.pizza.enums.secure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.pizza.enums.secure.Permission.ADMIN_CREATE;
import static com.example.pizza.enums.secure.Permission.ADMIN_DELETE;
import static com.example.pizza.enums.secure.Permission.ADMIN_READ;
import static com.example.pizza.enums.secure.Permission.ADMIN_UPDATE;
import static com.example.pizza.enums.secure.Permission.CUSTOMER_CREATE;
import static com.example.pizza.enums.secure.Permission.CUSTOMER_DELETE;
import static com.example.pizza.enums.secure.Permission.CUSTOMER_READ;
import static com.example.pizza.enums.secure.Permission.CUSTOMER_UPDATE;


@RequiredArgsConstructor
public enum Role {

    CUSTOMER(Set.of(
            CUSTOMER_READ,
            CUSTOMER_CREATE,
            CUSTOMER_UPDATE,
            CUSTOMER_DELETE
    )),

    ADMIN(Set.of(
            ADMIN_READ,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE
    ));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toCollection(ArrayList::new));

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}

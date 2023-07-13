package ch.zkb.m223.service;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Role;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    @Inject
    ApplicationUserService userService;

    public Response register(ApplicationUser applicationUser) {
        Optional<ApplicationUser> user = userService.read(applicationUser.getEmail());

        if (user.isPresent()) {
            return Response.status(409, "User already exists").build();
        }

        userService.create(applicationUser);

        return Response.ok().build();
    }

    public Response login(String email, String password) {
        Optional<ApplicationUser> user = userService.read(email);

        if (!user.isPresent()) {
            return Response.status(404, "User doesn't exist").build();
        }

        String pwd = user.get().getPassword();

        if (password.equals(pwd)) {
            Set<String> roles = new HashSet<String>();

            for (int i = 0; i < Role.values().length; i++) {
                roles.add(Role.values()[i].label);
            }

            String token = Jwt
                    .issuer("http://localhost:8080")
                    .upn(pwd)
                    .groups(roles)
                    .expiresIn(Duration.ofHours(24))
                    .sign();

            return Response
                    .ok(user.get())
                    .header("Authorization", "Bearer " + token)
                    .build();
        }

        return Response.status(400, "Password or Email is wrong").build();
    }
}

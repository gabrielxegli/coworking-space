package ch.zkb.m223.controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Credentials;
import ch.zkb.m223.service.AuthService;

@Path("auth")
@PermitAll
public class AuthController {
    @Inject
    AuthService service;

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(ApplicationUser user) {
        return service.register(user);
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials) {
        return service.login(credentials);
    }
}

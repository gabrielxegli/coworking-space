package ch.zkb.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.ApplicationUserService;

@Path("users")
@RolesAllowed({ Roles.ADMIN, Roles.MEMBER })
public class ApplicationUserController {
    @Inject
    ApplicationUserService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ApplicationUser create(ApplicationUser user) {
        return service.create(user);
    }

    @GET
    public List<ApplicationUser> list() {
        return service.read();
    }

    @GET
    @Path("{id}")
    public ApplicationUser get(@PathParam("id") int id) {
        return service.read(Integer.toUnsignedLong(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public ApplicationUser update(ApplicationUser user) {
        return service.update(user.getId(), user);
    }

    @DELETE
    @Path("{id}")
    public ApplicationUser delete(@PathParam("id") int id) {
        return service.delete(Integer.toUnsignedLong(id));
    }
}

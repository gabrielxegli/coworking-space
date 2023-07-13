package ch.zkb.m223.controller;

import java.util.List;

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

import ch.zkb.m223.model.Drink;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.DrinkService;

@Path("drinks")
@RolesAllowed({ Roles.ADMIN, Roles.MEMBER })
public class DrinkController {
    @Inject
    DrinkService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Drink create(Drink drink) {
        return service.create(drink);
    }

    @GET
    public List<Drink> list() {
        return service.read();
    }

    @GET
    @Path("{id}")
    public Drink get(@PathParam("id") Long id) {
        return service.read(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Drink update(Drink drink) {
        return service.update(drink.getId(), drink);
    }

    @DELETE
    @Path("{id}")
    public Drink delete(@PathParam("id") Long id) {
        return service.delete(id);
    }
}

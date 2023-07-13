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

import ch.zkb.m223.model.Request;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.RequestService;

@Path("requests")
@RolesAllowed({ Roles.ADMIN, Roles.MEMBER })
public class RequestController {
    @Inject
    RequestService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Request create(Request request) {
        return service.create(request);
    }

    @GET
    public List<Request> list() {
        return service.read();
    }

    @GET
    @Path("{id}")
    public Request get(@PathParam("id") Long id) {
        return service.read(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Request update(Request request) {
        return service.update(request.getId(), request);
    }

    @DELETE
    @Path("{id}")
    public Request delete(@PathParam("id") Long id) {
        return service.delete(id);
    }
}

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

import ch.zkb.m223.model.Booking;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.BookingService;

@Path("bookings")
@RolesAllowed({ Roles.ADMIN, Roles.MEMBER })
public class BookingController {
    @Inject
    BookingService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking create(Booking booking) {
        return service.create(booking);
    }

    @GET
    public List<Booking> list() {
        return service.read();
    }

    @GET
    @Path("{id}")
    public Booking get(@PathParam("id") Long id) {
        return service.read(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking update(Booking booking) {
        return service.update(booking.getId(), booking);
    }

    @DELETE
    @Path("{id}")
    public Booking delete(@PathParam("id") Long id) {
        return service.delete(id);
    }
}

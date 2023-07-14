package ch.zkb.m223;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ch.zkb.m223.model.Booking;
import ch.zkb.m223.model.Credentials;
import ch.zkb.m223.model.Drink;
import ch.zkb.m223.model.Role;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.BookingService;
import ch.zkb.m223.service.AuthService;
import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDateTime;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
@TestSecurity(user = "email1", roles = Roles.ADMIN)
public class BookingResourceTest {
    private static int bookingId = 1;

    @Test
    public void testCreateBooking() {
        Booking booking = new Booking();

        booking.setDate(LocalDateTime.now());
        booking.setDrink(new Drink());
        booking.setIsHalfDay(false);

        given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/bookings")
                .then()
                .statusCode(200)
                .body("date", equalTo(booking.getDate()));
    }

    @Test
    public void testGetBooking() throws Exception {

        given()
                .when()
                .pathParam("id", bookingId)
                .get("/bookings/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(bookingId));

    }

    @Test
    public void testUpdateBooking() {

        Booking booking = new Booking();

        booking.setId(Integer.toUnsignedLong(bookingId));
        booking.setDate(LocalDateTime.now());
        booking.setDrink(null);
        booking.setIsHalfDay(true);

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(booking)
                .put("/bookings")
                .then()
                .statusCode(200)
                .body("data", equalTo(booking.getDate()));

    }

    @Test
    public void testDeleteBooking() {

        given()
                .when()
                .delete("/bookings/{id}", bookingId)
                .then()
                .statusCode(200);
    }

    @Test
    public void testListBookings() {
        given()
                .when()
                .get("/bookings")
                .then()
                .statusCode(200);
    }

}

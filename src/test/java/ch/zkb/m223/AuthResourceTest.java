package ch.zkb.m223;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.google.common.net.MediaType;

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Credentials;
import ch.zkb.m223.model.Role;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.quarkus.test.h2.H2DatabaseTestResource;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
public class AuthResourceTest {
    static final String email = "mail@gabriel-egli.ch";
    static final String pwd = "secret";

    @Test
    @Order(1)
    void registerTest() {
        ApplicationUser user = new ApplicationUser();

        user.setEmail(email);
        user.setPassword(pwd);
        user.setFirstname("Gabriel");
        user.setLastname("Egli");
        user.setRole(Role.Admin);

        given().when().contentType("application/json").body(user).post("/auth/register").then().statusCode(200);
    }

    @Test
    void loginTest() {
        Credentials cred = new Credentials();

        cred.setEmail(email);
        cred.setPassword(pwd);

        given().when().contentType("application/json").body(cred).post("/auth/login").then()
                .statusCode(200).header("Authorization",
                        not(blankOrNullString()));
    }
}

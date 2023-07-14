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

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Credentials;
import ch.zkb.m223.model.Role;
import ch.zkb.m223.model.Role.Roles;
import ch.zkb.m223.service.ApplicationUserService;
import ch.zkb.m223.service.AuthService;
import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import io.vertx.mutiny.core.http.HttpClient;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import javax.annotation.security.RolesAllowed;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
@TestSecurity(user = "email1", roles = Roles.ADMIN)
public class ApplicationUserResourceTest {
    private static int userId = 1;

    /*
     * private static String authToken;
     * 
     * 
     * @BeforeAll
     * public static void obtainAuthToken() throws Exception {
     * Credentials cred = new Credentials();
     * 
     * cred.setEmail("email1");
     * cred.setPassword("password1");
     * 
     * // Convert the user object to JSON
     * ObjectMapper objectMapper = new ObjectMapper();
     * String credJson = null;
     * try {
     * credJson = objectMapper.writeValueAsString(cred);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * 
     * authToken = given()
     * .contentType(ContentType.JSON)
     * .body(credJson)
     * .when()
     * .post("/auth/login")
     * .then()
     * .statusCode(200)
     * .extract()
     * .header("Authorization");
     * }
     */

    @Test
    public void testCreateUser() {
        ApplicationUser user = new ApplicationUser();

        user.setEmail("mail2@gabriel-egli.ch");
        user.setPassword("secret");
        user.setFirstname("Gabriel2");
        user.setLastname("Egli2");
        user.setRole(Role.Admin);

        // Convert the user object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = null;
        try {
            userJson = objectMapper.writeValueAsString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        given()
                .contentType(ContentType.JSON)
                .body(userJson)
                .when()
                .post("/users")
                .then()
                .statusCode(200)
                .body("email", equalTo(user.getEmail()));
    }

    @Test
    public void testGetUser() throws Exception {

        given()
                .when()
                .pathParam("id", userId)
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));

    }

    @Test
    public void testUpdateUser() {

        ApplicationUser user = new ApplicationUser();

        user.setId(Integer.toUnsignedLong(userId));
        user.setEmail("update1");
        user.setPassword("update1");
        user.setFirstname("update1");
        user.setLastname("update1");
        user.setRole(Role.Admin);

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(user)
                .put("/users")
                .then()
                .statusCode(200)
                .body("email", equalTo(user.getEmail()));

    }

    @Test
    public void testDeleteUser() {

        given()
                .when()
                .delete("/users/{id}", userId)
                .then()
                .statusCode(200);
    }

    @Test
    public void testListUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }

}

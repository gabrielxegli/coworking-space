package ch.zkb.m223.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zkb.m223.model.ApplicationUser;
import ch.zkb.m223.model.Booking;
import ch.zkb.m223.model.Drink;
import ch.zkb.m223.model.Request;
import ch.zkb.m223.model.Role;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
@IfBuildProfile("dev")
public class TestDataService {
    @Inject
    private EntityManager em;

    @Transactional
    void setTestData(@Observes StartupEvent ev) {
        Log.info("Adding Test Data");

        Drink drink1 = new Drink();
        drink1.setActive(true);
        drink1.setTitle("Drink1");
        em.persist(drink1);

        Booking booking1 = new Booking();
        booking1.setDate(LocalDateTime.now());
        booking1.setDrink(drink1);
        booking1.setIsHalfDay(false);
        em.persist(booking1);

        ApplicationUser user1 = new ApplicationUser();
        user1.setFirstname("firstname1");
        user1.setLastname("lastname2");
        user1.setEmail("email1");
        user1.setPassword("password1");
        user1.setRole(Role.Member);
        em.persist(user1);

        Request request1 = new Request();
        request1.setConfirmed(false);
        request1.setBooking(booking1);
        request1.setUser(user1);
        em.persist(request1);

        Drink drink2 = new Drink();
        drink2.setActive(true);
        drink2.setTitle("Drink2");
        em.persist(drink2);

        Booking booking2 = new Booking();
        booking2.setDate(LocalDateTime.now().plusDays(1));
        booking2.setDrink(drink2);
        booking2.setIsHalfDay(true);
        em.persist(booking2);

        ApplicationUser user2 = new ApplicationUser();
        user2.setFirstname("firstname2");
        user2.setLastname("lastname2");
        user2.setEmail("email2");
        user2.setPassword("password2");
        user2.setRole(Role.Member);
        em.persist(user2);

        Request request2 = new Request();
        request2.setConfirmed(true);
        request2.setBooking(booking2);
        request2.setUser(user2);
        em.persist(request2);

        Drink drink3 = new Drink();
        drink3.setActive(false);
        drink3.setTitle("Drink3");
        em.persist(drink3);

        Booking booking3 = new Booking();
        booking3.setDate(LocalDateTime.now().plusDays(2));
        booking3.setDrink(drink3);
        booking3.setIsHalfDay(false);
        em.persist(booking3);

        ApplicationUser user3 = new ApplicationUser();
        user3.setFirstname("firstname3");
        user3.setLastname("lastname3");
        user3.setEmail("email3");
        user3.setPassword("password3");
        user3.setRole(Role.Admin);
        em.persist(user3);

        Request request3 = new Request();
        request3.setConfirmed(true);
        request3.setBooking(booking3);
        request3.setUser(user3);
        em.persist(request3);

        Drink drink4 = new Drink();
        drink4.setActive(true);
        drink4.setTitle("Drink4");
        em.persist(drink4);

        Booking booking4 = new Booking();
        booking4.setDate(LocalDateTime.now().plusDays(3));
        booking4.setDrink(drink4);
        booking4.setIsHalfDay(true);
        em.persist(booking4);

        ApplicationUser user4 = new ApplicationUser();
        user4.setFirstname("firstname4");
        user4.setLastname("lastname4");
        user4.setEmail("email4");
        user4.setPassword("password4");
        user4.setRole(Role.Member);
        em.persist(user4);

        Request request4 = new Request();
        request4.setConfirmed(false);
        request4.setBooking(booking4);
        request4.setUser(user4);
        em.persist(request4);

        Log.info("Finished Adding Test Data");
    }
}

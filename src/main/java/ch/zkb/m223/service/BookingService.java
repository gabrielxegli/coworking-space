package ch.zkb.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ch.zkb.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    private EntityManager em;

    @Transactional
    public Booking create(Booking booking) {
        return em.merge(booking);
    }

    @Transactional
    public Booking read(Long id) {
        return em.find(Booking.class, id);
    }

    @Transactional
    public List<Booking> read() {
        TypedQuery<Booking> q = em.createQuery("FROM Booking", Booking.class);

        return q.getResultList();
    }

    @Transactional
    public Booking update(Long id, Booking booking) {
        booking.setId(id);

        return em.merge(booking);
    }

    @Transactional
    public Booking delete(Long id) {
        Booking booking = em.find(Booking.class, id);

        em.remove(booking);

        return booking;
    }

}

package ch.zkb.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ch.zkb.m223.model.ApplicationUser;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    private EntityManager em;

    @Transactional
    public ApplicationUser create(ApplicationUser user) {
        return em.merge(user);
    }

    @Transactional
    public ApplicationUser read(Long id) {
        return em.find(ApplicationUser.class, id);
    }

    @Transactional
    public Optional<ApplicationUser> read(String email) {
        TypedQuery<ApplicationUser> q = em.createQuery("FROM ApplicationUser WHERE email=" + email,
                ApplicationUser.class);

        Optional<ApplicationUser> user = q.getResultStream().findFirst();

        return user;
    }

    @Transactional
    public List<ApplicationUser> read() {
        TypedQuery<ApplicationUser> q = em.createQuery("FROM ApplicationUser", ApplicationUser.class);

        return q.getResultList();
    }

    @Transactional
    public ApplicationUser update(Long id, ApplicationUser user) {
        user.setId(id);

        return em.merge(user);
    }

    @Transactional
    public ApplicationUser delete(Long id) {
        ApplicationUser user = em.find(ApplicationUser.class, id);

        em.remove(id);

        return user;
    }

}

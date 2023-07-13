package ch.zkb.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ch.zkb.m223.model.Request;

@ApplicationScoped
public class RequestService {
    @Inject
    private EntityManager em;

    @Transactional
    public Request create(Request request) {
        return em.merge(request);
    }

    @Transactional
    public Request read(Long id) {
        return em.find(Request.class, id);
    }

    @Transactional
    public List<Request> read() {
        TypedQuery<Request> q = em.createQuery("FROM Request", Request.class);

        return q.getResultList();
    }

    @Transactional
    public Request update(Long id, Request request) {
        request.setId(id);

        return em.merge(request);
    }

    @Transactional
    public Request delete(Long id) {
        Request request = em.find(Request.class, id);

        em.remove(id);

        return request;
    }

}

package ch.zkb.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ch.zkb.m223.model.Drink;

@ApplicationScoped
public class DrinkService {
    @Inject
    private EntityManager em;

    @Transactional
    public Drink create(Drink drink) {
        return em.merge(drink);
    }

    @Transactional
    public Drink read(Long id) {
        return em.find(Drink.class, id);
    }

    @Transactional
    public List<Drink> read() {
        TypedQuery<Drink> q = em.createQuery("FROM Drink", Drink.class);

        return q.getResultList();
    }

    @Transactional
    public Drink update(Long id, Drink drink) {
        drink.setId(id);

        return em.merge(drink);
    }

    @Transactional
    public Drink delete(Long id) {
        Drink drink = em.find(Drink.class, id);

        em.remove(drink);

        return drink;
    }

}

package ru.geekbrains.java4.lesson5.repository;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public abstract class AbstractRepository<T> {

    EntityManagerFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    EntityManager em = factory.createEntityManager();

    private Class<T> clazz;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public void save(T e) {
        em.getTransaction().begin();
        em.persist(e);
        //em.merge(e);
        em.getTransaction().commit();
    }

    public void remove(T e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public T findById(long id) {
        em.getTransaction().begin();
        T e = em.find(clazz, id);
        em.getTransaction().commit();
        return e;
    }

    public List<T> findAll() {
        em.getTransaction().begin();
        List<T> l = (List<T>) em.createQuery( "from " + clazz.getName() )
                .getResultList();
        em.getTransaction().commit();
        return l;
    }


}

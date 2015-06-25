package com.servicemesh.devops.demo.quickquote.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;

public class GenericDAO<T> {

    private final Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }

    public List<T> list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Criteria criteria = session.createCriteria(this.type);
        List objs = criteria.list();

        session.close();
        return objs;
    }

    public T read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        T obj = (T) session.get(getMyType(), id);
        session.close();
        return obj;
    }

    public T save(T obj) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(obj);

        session.getTransaction().commit();

        session.close();

        return obj;
    }

    public T update(T obj) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(obj);

        session.getTransaction().commit();

        session.close();
        return obj;

    }

    public void delete(T obj) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(obj);

        session.getTransaction().commit();

        session.close();
    }
}

package com.leftiejy.repository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class CommonRepository<T, ID extends Serializable> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonRepository.class);

    @Autowired
    private EntityManager entityManager;

    private Class<T> persistentClass;

    public CommonRepository() {
        ParameterizedType superclass =
            (ParameterizedType) getClass().getGenericSuperclass();

        persistentClass = (Class<T>) superclass.getActualTypeArguments()[0];

    }


    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public T save(T transientInstance) {
        getSession().saveOrUpdate(transientInstance);
        return transientInstance;
    }

    public T insert(T transientInstance) {
        getSession().save(transientInstance);
        return transientInstance;
    }

    public T update(T transientInstance) {
        getSession().update(transientInstance);
        return transientInstance;
    }

    public T merge(T instance) {
        getSession().merge(instance);
        return instance;
    }

    public void delete(T persistentInstance) {
        getSession().delete(persistentInstance);
    }

    public boolean deleteById(ID id) {
        T instance = this.findById(id);
        if (instance == null) {
            return false;
        }
        getSession().delete(instance);
        return true;
    }

    public T findById(ID id) {
        return getSession().get(persistentClass, id);
    }

    public Query createQuery(String sqlQuery) {
        return this.getSession().createQuery(sqlQuery);
    }

    public SQLQuery createSQLQuery(String sqlQuery) {
        return this.getSession().createSQLQuery(sqlQuery);
    }

    public Criteria createCriteria() {
        return this.getSession().createCriteria(persistentClass);
    }
    public List<T> list() {
        return this.getSession().createCriteria(persistentClass).list();
    }
}

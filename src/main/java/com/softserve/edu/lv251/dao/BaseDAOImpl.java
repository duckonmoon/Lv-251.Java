package com.softserve.edu.lv251.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public BaseDAOImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void addEntity(T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void updateEntity(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public T getEntityByID(Long entityId) {
        return entityManager.find(entityClass, entityId);
    }

    @Override
    public List<T> getEntitiesByColumnNameAndValue(String columnName, Object value) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery((entityClass));
        Root<T> tRoot = criteriaQuery.from(entityClass);
        criteriaQuery.select(tRoot).where(criteriaBuilder.equal(tRoot.get(columnName), value));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<T> getAllEntities() {
        CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery((entityClass));
        Root<T> tRoot = criteriaQuery.from(entityClass);
        criteriaQuery.select(tRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    @Transactional
    public void deleteEntity(T entity) {
        entityManager.remove(entity);
    }
}
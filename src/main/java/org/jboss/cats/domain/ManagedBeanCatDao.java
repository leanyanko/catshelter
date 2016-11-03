package org.jboss.cats.domain;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Created by Anna on 31/10/2016.
 */
public class ManagedBeanCatDao implements CatDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    UserTransaction utx;

    @Override
    public Cat getForName(String name) {
        return null;
    }

    public void addCat (Cat cat) {
        try {
            try {
                utx.begin();
                entityManager.persist(cat);

            } finally {
                utx.commit();
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }
}

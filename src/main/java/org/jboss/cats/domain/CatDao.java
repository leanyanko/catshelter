package org.jboss.cats.domain;

/**
 * Created by Anna on 30/10/2016.
 */
public interface CatDao {
    Cat getForName(String name);
    void addCat(Cat cat);
}

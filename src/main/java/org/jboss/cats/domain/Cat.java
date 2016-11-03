package org.jboss.cats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Anna on 30/10/2016.
 */
@Entity
@Table(name = "Users")
public class Cat {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String color;

    private int age;

    private String fluffy;

    public String isFluffy() {
        return fluffy;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFluffy(String fluffy) {
        this.fluffy = fluffy;
    }

    public void setName(String name) {
        this.name = name;
    }
}

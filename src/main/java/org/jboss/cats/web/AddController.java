package org.jboss.cats.web;

import org.jboss.cats.domain.Cat;
import org.jboss.cats.domain.CatDao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Anna on 30/10/2016.
 */
@Named
@RequestScoped
public class AddController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CatDao catDao;

    @Named
    @Produces
    @RequestScoped
    private Cat newCat = new Cat();

    public void add() {
        try {
            catDao.addCat(newCat);
            String message = "A new user with id " + newCat.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }

    }

}

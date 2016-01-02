package hu.infokristaly.homeworks.primefacesbasics;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class ExceptionHandlerView {

    public void throwViewExpiredException() {
        System.out.println("throw exeption");
        throw new ViewExpiredException("A ViewExpiredException!",
                FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }
}

package hu.bme.aut.mobsoft.lab.mobsoft.interactor.events;

import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementDetails;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class GetElementDetailsEvent {
    private int code;
    private ElementDetails element;
    private Throwable throwable;

    public GetElementDetailsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ElementDetails getElement() {
        return element;
    }

    public void setElement(ElementDetails element) {
        this.element = element;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

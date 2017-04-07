package hu.bme.aut.mobsoft.lab.mobsoft.interactor.events;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class SaveFavouriteEvent {
    private int code;
    private Element element;
    private Throwable throwable;

    public SaveFavouriteEvent() {
    }

    public SaveFavouriteEvent(int code, Element element, Throwable throwable) {
        this.code = code;
        this.element = element;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

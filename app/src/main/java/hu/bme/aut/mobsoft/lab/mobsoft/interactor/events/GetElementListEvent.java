package hu.bme.aut.mobsoft.lab.mobsoft.interactor.events;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class GetElementListEvent {
    private int code;
    private List<Element> movies;
    private Throwable throwable;

    public GetElementListEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Element> getMovies() {
        return movies;
    }

    public void setMovies(List<Element> movies) {
        this.movies = movies;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

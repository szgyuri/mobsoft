package hu.bme.aut.mobsoft.lab.mobsoft.interactor.events;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class GetMovieEvent {
    private int code;
    private Movie movie;
    private Throwable throwable;

    public GetMovieEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public interface Repository {
    void open(Context context);

    void close();

    List<Movie> getMoviesList();

    Movie getMovie(long id);

    boolean isInDB(Movie movie);
}

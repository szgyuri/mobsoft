package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    private List<Movie> movies;

    @Override
    public void open(Context context) {
        Movie movie0 = new Movie(0L, "Rocky");
        Movie movie1 = new Movie(1L, "300");

        movies = new ArrayList<>();
        movies.add(movie0);
        movies.add(movie1);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Movie> getMoviesList() {
        return movies;
    }

    @Override
    public Movie getMovie(long id) {
        for (Movie movie: movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return new Movie();
    }

    @Override
    public boolean isInDB(Movie movie) {
        return movies.contains(movie);
    }
}

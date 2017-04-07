package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Movie> getMoviesList() {
        return SugarRecord.listAll(Movie.class);
    }

    @Override
    public Movie getMovie(long id) {
        List<Movie> movies = getMoviesList();
        for (Movie movie: movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return new Movie();
    }

    /*@Override
    public void updateMovies(List<Movie> movies) {
        List<Movie> favourites = getMoviesList();
        List<Movie> toUpdate = new ArrayList<>(favourites.size());
        for (Movie favourite : favourites) {
            for (Movie todo : movies) {
                toUpdate.add(todo);
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }*/

    @Override
    public boolean isInDB(Movie movie) {
        return SugarRecord.findById(Movie.class, movie.getId()) != null;
    }
}

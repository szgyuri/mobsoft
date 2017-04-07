package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public interface ElementListScreen {
    void onSuccessGetMovieList(List<Movie> movies);
    void onFailure();
}

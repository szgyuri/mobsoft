package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public interface ElementDetailsScreen {
    void addedToFavourite(String id);
    void onFailure();
    void onSuccessGetMovie(Movie movie);
}

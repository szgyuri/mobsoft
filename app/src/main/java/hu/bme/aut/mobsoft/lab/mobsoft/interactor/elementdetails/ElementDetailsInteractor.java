package hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetMovieEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Movie;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.Repository;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class ElementDetailsInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ElementDetailsInteractor() {
        MobSoftApplication.injector.inject(this);}

    public void getMovie(long id) {
        GetMovieEvent event = new GetMovieEvent();
        try {
            Movie movie = repository.getMovie(id);
            event.setMovie(movie);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

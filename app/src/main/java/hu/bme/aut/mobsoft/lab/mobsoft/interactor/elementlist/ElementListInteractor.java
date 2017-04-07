package hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementListEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.Repository;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class ElementListInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ElementListInteractor() {
        MobSoftApplication.injector.inject(this);}

    public void getMovieList() {
        GetElementListEvent event = new GetElementListEvent();
        try {
            List<Element> movies = repository.getElementList();
            event.setMovies(movies);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

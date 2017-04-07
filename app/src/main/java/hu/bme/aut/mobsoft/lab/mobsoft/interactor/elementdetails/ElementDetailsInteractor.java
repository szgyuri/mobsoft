package hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.SaveFavouriteEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
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
        MobSoftApplication.injector.inject(this);
    }

    public void saveFavourite(Element element) {
        SaveFavouriteEvent event = new SaveFavouriteEvent();
        event.setElement(element);
        try {
            repository.saveFavourite(element);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getMovie(long id) {
        GetElementEvent event = new GetElementEvent();
        try {
            Element element = repository.getElement(id);
            event.setElement(element);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

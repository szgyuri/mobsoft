package hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementDetailsEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementListEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementDetails;
import hu.bme.aut.mobsoft.lab.mobsoft.network.element.ElementApi;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.Repository;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class ElementDetailsInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    ElementApi elementApi;

    public ElementDetailsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void saveFavouriteById(String id) {
        repository.saveFavouriteById(id);
    }

    public void getMovie(String id) {
        try {
            ElementDetails elementDetails = elementApi.getElementDetails("/?i=" + id).execute().body();
            postElementDetails(elementDetails);
        } catch (Exception e) {
            GetElementListEvent event = new GetElementListEvent();
            event.setThrowable(e);
            bus.post(event);
        }
    }

    private void postElementDetails(ElementDetails elementDetails) {
        GetElementDetailsEvent event = new GetElementDetailsEvent();
        try {
            event.setElement(elementDetails);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}

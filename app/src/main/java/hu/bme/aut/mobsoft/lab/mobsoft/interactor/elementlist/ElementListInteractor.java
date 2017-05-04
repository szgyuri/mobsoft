package hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementListEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementResponse;
import hu.bme.aut.mobsoft.lab.mobsoft.network.element.ElementApi;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.Repository;
import hu.bme.aut.mobsoft.lab.mobsoft.util.Constants;
import hu.bme.aut.mobsoft.lab.mobsoft.util.ElementType;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class ElementListInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    ElementApi elementApi;
    @Inject
    SharedPreferences sp;

    public ElementListInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getMovieListByText(ElementType elementType, String text) {
        try {
            ElementResponse elementResponse = elementApi.getElementsByText("/?s=" + text, elementType.name(), 1).execute().body();
            List<Element> elementList = elementResponse.getElementList();

            elementResponse = elementApi.getElementsByText("/?s=" + text, elementType.name(), 2).execute().body();
            elementList.addAll(elementResponse.getElementList());

            postElementList(elementList);
        } catch (Exception e) {
            GetElementListEvent event = new GetElementListEvent();
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getMovieList(ElementType elementType) {
        try {
            ElementResponse elementResponse = elementApi.getElements(elementType.name(), 1).execute().body();
            List<Element> elementList = elementResponse.getElementList();

            elementResponse = elementApi.getElements(elementType.name(), 3).execute().body();
            elementList.addAll(elementResponse.getElementList());

            repository.saveElementList(elementList);
            postElementList(elementList);
        } catch (Exception e) {
            GetElementListEvent event = new GetElementListEvent();
            event.setThrowable(e);
            bus.post(event);
        }
    }

    private void postElementList(List<Element> elementList) {
        GetElementListEvent event = new GetElementListEvent();
        try {
            setFavourite(elementList);
            event.setElementList(elementList);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    private void setFavourite(List<Element> elementList) {
        Set<String> stringSet = sp.getStringSet(Constants.FAVOURITE_SP_KEY, new HashSet<String>());
        for (Element element: elementList) {
            if (stringSet.contains(element.getImdbID())) {
                element.setFavourite(true);
            } else {
                element.setFavourite(false);
            }
        }

        /*for (Element element: elementList) {
            if (repository.isInDBElementById(element.getImdbID())) {
                element.setFavourite(true);
            } else {
                element.setFavourite(false);
            }
        }*/
    }
}

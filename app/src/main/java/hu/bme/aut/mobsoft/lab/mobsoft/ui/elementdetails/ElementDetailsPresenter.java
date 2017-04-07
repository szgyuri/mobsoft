package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails.ElementDetailsInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;

import static hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication.injector;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementDetailsPresenter extends Presenter<ElementDetailsScreen> {
    private static ElementDetailsPresenter instance = null;

    @Inject
    ElementDetailsInteractor elementDetailsInteractor;
    @Inject
    EventBus bus;
    @Inject
    Executor executor;

    public ElementDetailsPresenter() {
    }

    @Override
    public void attachScreen(ElementDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void saveFavourite(Element element) {
        elementDetailsInteractor.saveFavourite(element);
        // TODO ode majd a getElement()-hez hasonló kezelés kell, meg kell mondani, h mi legyen
        // ha nem sikerült a mentés meg ilyenek
    }

    public void getElement(final long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementDetailsInteractor.getMovie(id);
            }
        });
    }

    public void onEventElementListThread(GetElementEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.onFailure();
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.onSuccessGetElement(event.getElement());
            }
        }
    }
}

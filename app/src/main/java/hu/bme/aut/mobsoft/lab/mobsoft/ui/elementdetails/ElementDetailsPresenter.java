package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails.ElementDetailsInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementDetailsEvent;
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

    public void saveFavouriteById(String id) {
        elementDetailsInteractor.saveFavouriteById(id);
    }

    public void getElement(final String id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementDetailsInteractor.getMovie(id);
            }
        });
    }

    public void onEventMainThread(GetElementDetailsEvent event) {
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

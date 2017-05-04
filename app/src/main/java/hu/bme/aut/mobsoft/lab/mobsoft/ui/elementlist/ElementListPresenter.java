package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist.ElementListInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetElementListEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;
import hu.bme.aut.mobsoft.lab.mobsoft.util.ElementType;

import static hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication.injector;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementListPresenter extends Presenter<ElementListScreen> {
    private static ElementListPresenter instance = null;

    @Inject
    ElementListInteractor elementListInteractor;
    @Inject
    EventBus bus;
    @Inject
    Executor executor;

    public ElementListPresenter() {
    }

    @Override
    public void attachScreen(ElementListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getMoviesList(final ElementType elementType) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementListInteractor.getMovieList(elementType);
            }
        });
    }

    public void getMoviesListByText(final ElementType elementType, final String text) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementListInteractor.getMovieListByText(elementType, text);
            }
        });
    }

    public void onEventMainThread(GetElementListEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.onFailure();
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.onSuccessGetElementList(event.getElementList());
            }
        }
    }
}

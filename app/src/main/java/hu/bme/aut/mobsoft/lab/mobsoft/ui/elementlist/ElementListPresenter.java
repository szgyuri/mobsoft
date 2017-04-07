package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist.ElementListInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.events.GetMoviesListEvent;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;

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

    public void getMoviesList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementListInteractor.getMovieList();
            }
        });
    }

    public void onEventMovieListThread(GetMoviesListEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.onFailure();
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.onSuccessGetMovieList(event.getMovies());
            }
        }
    }
}

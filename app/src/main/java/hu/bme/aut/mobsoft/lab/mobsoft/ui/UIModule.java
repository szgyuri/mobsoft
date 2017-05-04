package hu.bme.aut.mobsoft.lab.mobsoft.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails.ElementDetailsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.ElementListPresenter;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public ElementListPresenter provideElementListPresenter() {
        return new ElementListPresenter();
    }

    @Provides
    @Singleton
    public ElementDetailsPresenter provideElementDetailsPresenter() {
        return new ElementDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
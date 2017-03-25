package hu.bme.aut.mobsoft.lab.mobsoft.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails.ElementDetailsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.ElementListPresenter;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.main.MainPresenter;

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
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
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

}
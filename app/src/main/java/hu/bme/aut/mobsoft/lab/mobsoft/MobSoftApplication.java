package hu.bme.aut.mobsoft.lab.mobsoft;

import android.app.Application;

import hu.bme.aut.mobsoft.lab.mobsoft.ui.DaggerMobSoftApplicationComponent;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.UIModule;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder().
                uIModule(new UIModule(this))
                .build();
    }
}
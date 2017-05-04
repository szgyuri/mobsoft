package hu.bme.aut.mobsoft.lab.mobsoft;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoft.interactor.InteractorModule;
import hu.bme.aut.mobsoft.lab.mobsoft.network.NetworkModule;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.Repository;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.RepositoryModule;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.UIModule;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder()
                .uIModule(new UIModule(this))
                .networkModule(new NetworkModule())
                .repositoryModule(new RepositoryModule())
                .interactorModule(new InteractorModule())
                .build();

        Fabric.with(this, new Crashlytics());

        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
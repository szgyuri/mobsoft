package hu.bme.aut.mobsoft.lab.mobsoft;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

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

    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
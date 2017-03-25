package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.R;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementDetailsActivity extends AppCompatActivity implements ElementDetailsScreen {
    @Inject
    ElementDetailsPresenter elementDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        elementDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        elementDetailsPresenter.detachScreen();
    }

    @Override
    public void addedToFavourite(String id) {
        //TODO
    }
}

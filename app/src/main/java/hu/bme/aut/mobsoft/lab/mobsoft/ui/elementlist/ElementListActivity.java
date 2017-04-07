package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.R;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementListActivity extends AppCompatActivity implements ElementListScreen {
    @Inject
    ElementListPresenter elementListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        elementListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        elementListPresenter.detachScreen();
    }

    @Override
    public void onSuccessGetElementList(List<Element> movies) {
        //TODO set movies
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(), "Nem sikerült az elemek lekérése, kérlek próbáld újra!", Toast.LENGTH_LONG).show();
    }
}

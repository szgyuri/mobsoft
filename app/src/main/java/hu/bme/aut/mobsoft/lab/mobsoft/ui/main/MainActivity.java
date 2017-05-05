package hu.bme.aut.mobsoft.lab.mobsoft.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.R;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.ElementListActivity;
import hu.bme.aut.mobsoft.lab.mobsoft.util.Constants;
import hu.bme.aut.mobsoft.lab.mobsoft.util.ElementType;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    private ElementType elementType;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MobSoftApplication.injector.inject(this);

        initTracker();
        sendTrackerEvent();
    }

    private void initTracker() {
        MobSoftApplication app = (MobSoftApplication) getApplication();
        Tracker mTracker = app.getDefaultTracker();
        mTracker.setScreenName("MainActivity" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    private void sendTrackerEvent() {
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Starting App")
                .build());
    }

    @OnClick(R.id.movies)
    void clickMovies() {
        elementType = ElementType.MOVIE;
        startElementListActivity();
    }

    @OnClick(R.id.series)
    void clickSeries() {
        elementType = ElementType.SERIES;
        startElementListActivity();
    }

    private void startElementListActivity() {
        Intent i = new Intent();
        i.setClass(this, ElementListActivity.class);
        i.putExtra(Constants.ELEMENT_TYPE, elementType);
        startActivity(i);
    }
}
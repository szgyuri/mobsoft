package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.R;
import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementDetails;
import hu.bme.aut.mobsoft.lab.mobsoft.util.Constants;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementDetailsActivity extends AppCompatActivity implements ElementDetailsScreen {

    private String imdbID;
    private boolean isFavourite;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.poster)
    ImageView poster;
    @BindView(R.id.year)
    TextView year;
    @BindView(R.id.director)
    TextView director;
    @BindView(R.id.runtime)
    TextView runtime;
    @BindView(R.id.genre)
    TextView genre;
    @BindView(R.id.actors)
    TextView actors;
    @BindView(R.id.language)
    TextView language;
    @BindView(R.id.plot)
    TextView plot;
    @BindView(R.id.favourite)
    ImageView favourite;

    @Inject
    ElementDetailsPresenter elementDetailsPresenter;
    @Inject
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_details);

        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                imdbID = extras.getString(Constants.ELEMENT_DETAILS_IMDB_ID);
                isFavourite = extras.getBoolean(Constants.ELEMENT_DETAILS_FAVOURITE);
            }
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        MobSoftApplication.injector.inject(this);

        Set<String> stringSet = sp.getStringSet(Constants.FAVOURITE_SP_KEY, new HashSet<String>());
        if (stringSet.contains(imdbID)) {
            isFavourite = true;
        } else {
            isFavourite = false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        elementDetailsPresenter.attachScreen(this);
        elementDetailsPresenter.getElement(imdbID);
    }

    @Override
    protected void onStop() {
        super.onStop();
        elementDetailsPresenter.detachScreen();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
        Set<String> stringSet = sp.getStringSet(Constants.FAVOURITE_SP_KEY, new HashSet<String>());

        if (isFavourite) {
            stringSet.add(imdbID);
        } else {
            if (stringSet.contains(imdbID)) {
                stringSet.remove(imdbID);
            }
        }
        sp.edit().putStringSet(Constants.FAVOURITE_SP_KEY, stringSet).commit();
        //elementDetailsPresenter.saveFavouriteById(imdbID);
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(), R.string.tryItAgain, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.favourite)
    void clickedFavourite() {
        if (!isFavourite) {
            favourite.setImageResource(R.drawable.loved);
        } else {
            favourite.setImageResource(R.drawable.unloved);
        }
        isFavourite = !isFavourite;
    }

    @Override
    public void onSuccessGetElement(ElementDetails element) {
        if (isFavourite) {
            favourite.setImageResource(R.drawable.loved);
        } else {
            favourite.setImageResource(R.drawable.unloved);
        }

        title.setText(element.getTitle());
        Picasso.with(this).load(element.getPoster()).into(poster);
        year.setText(element.getReleased());
        director.setText(String.format("%s %s", getString(R.string.director), element.getDirector()));
        runtime.setText(String.format("%s %s", getString(R.string.runtime), element.getRuntime()));
        genre.setText(String.format("%s %s", getString(R.string.genre), element.getGenre()));
        actors.setText(String.format("%s %s", getString(R.string.actors), element.getActors()));
        language.setText(String.format("%s %s", getString(R.string.languages), element.getLanguage()));
        plot.setText(element.getPlot());
    }
}

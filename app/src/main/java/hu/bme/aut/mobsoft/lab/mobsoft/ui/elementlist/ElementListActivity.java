package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.bme.aut.mobsoft.lab.mobsoft.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoft.R;
import hu.bme.aut.mobsoft.lab.mobsoft.adapter.RVAdapter;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails.ElementDetailsActivity;
import hu.bme.aut.mobsoft.lab.mobsoft.util.Constants;
import hu.bme.aut.mobsoft.lab.mobsoft.util.ElementType;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementListActivity extends AppCompatActivity implements ElementListScreen, OnClickCardListener,
        SearchView.OnQueryTextListener{

    private ElementType elementType;
    private List<Element> elementList;

    private String searchText = "";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    ElementListPresenter elementListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_list);

        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                elementType = (ElementType) extras.getSerializable(Constants.ELEMENT_TYPE);
            }
        }

        initRecyclerView();
        setSupportActionBar(toolbar);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_element_list, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setBackgroundColor(Color.WHITE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false);
            searchView.setOnQueryTextListener(this);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        elementListPresenter.attachScreen(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    protected void onStop() {
        super.onStop();
        elementListPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!searchText.equals("")) {
            elementListPresenter.getMoviesListByText(elementType, searchText);
        } else {
            elementListPresenter.getMoviesList(elementType);
        }
    }

    @Override
    public void onSuccessGetElementList(List<Element> elementList) {
        this.elementList = elementList;
        RVAdapter rvAdapter = new RVAdapter(elementList, this, this);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(), R.string.tryItAgain, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickCard(View view) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        Element clickedElement = elementList.get(itemPosition);

        Intent i = new Intent();
        i.setClass(this, ElementDetailsActivity.class);
        i.putExtra(Constants.ELEMENT_DETAILS_IMDB_ID, clickedElement.getImdbID());
        startActivity(i);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (!query.equals("")) {
            searchText = query;
            elementListPresenter.getMoviesListByText(elementType, query);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (!newText.equals("")) {
            searchText = newText;
            elementListPresenter.getMoviesListByText(elementType, newText);
        }
        return true;
    }
}

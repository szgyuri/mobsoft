package hu.bme.aut.mobsoft.lab.mobsoft.ui.main;

import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
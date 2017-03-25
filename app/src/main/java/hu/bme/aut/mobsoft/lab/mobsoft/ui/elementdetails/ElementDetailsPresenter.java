package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementDetailsPresenter extends Presenter<ElementDetailsScreen> {
    private static ElementDetailsPresenter instance = null;

    public ElementDetailsPresenter() {
    }

    @Override
    public void attachScreen(ElementDetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}

package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import hu.bme.aut.mobsoft.lab.mobsoft.ui.Presenter;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public class ElementListPresenter extends Presenter<ElementListScreen> {
    private static ElementListPresenter instance = null;

    public ElementListPresenter() {
    }

    @Override
    public void attachScreen(ElementListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}

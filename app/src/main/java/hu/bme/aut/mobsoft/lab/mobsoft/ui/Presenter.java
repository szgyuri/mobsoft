package hu.bme.aut.mobsoft.lab.mobsoft.ui;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
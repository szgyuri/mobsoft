package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public interface ElementListScreen {
    void onSuccessGetElementList(List<Element> movies);
    void onFailure();
}

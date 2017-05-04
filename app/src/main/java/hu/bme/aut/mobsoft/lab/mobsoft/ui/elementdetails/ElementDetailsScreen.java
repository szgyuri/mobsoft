package hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails;

import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementDetails;

/**
 * Created by Szabo Gyorgy on 2017. 03. 24..
 */

public interface ElementDetailsScreen {
    void onFailure();
    void onSuccessGetElement(ElementDetails element);
}

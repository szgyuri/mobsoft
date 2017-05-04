package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public interface Repository {
    void open(Context context);

    void close();

    List<Element> getElementList();

    Element getElement(String id);

    void saveFavouriteById(String id);

    void saveElementList(List<Element> elementList);

    boolean isInDBElementById(String id);

    //boolean isInDB(Element element);
}

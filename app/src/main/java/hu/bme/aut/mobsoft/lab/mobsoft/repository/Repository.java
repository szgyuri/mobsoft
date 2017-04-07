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

    Element getElement(long id);

    void saveFavourite(Element element);

    boolean isInDB(Element element);
}

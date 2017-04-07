package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    private List<Element> elements;

    @Override
    public void open(Context context) {
        Element element0 = new Element(0L, "Rocky");
        Element element1 = new Element(1L, "300");

        elements = new ArrayList<>();
        elements.add(element0);
        elements.add(element1);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Element> getElementList() {
        return elements;
    }

    @Override
    public Element getElement(long id) {
        for (Element element : elements) {
            if (element.getId() == id) {
                return element;
            }
        }
        return new Element();
    }

    @Override
    public void saveFavourite(Element element) {
        elements.add(element);
    }

    @Override
    public boolean isInDB(Element element) {
        return elements.contains(element);
    }
}

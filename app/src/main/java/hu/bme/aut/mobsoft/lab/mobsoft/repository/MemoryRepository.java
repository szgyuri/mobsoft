package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

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
        /*Element element0 = new Element(0L, "Rocky");
        Element element1 = new Element(1L, "300");

        elements = new ArrayList<>();
        elements.add(element0);
        elements.add(element1);*/
    }

    @Override
    public void close() {

    }

    @Override
    public List<Element> getElementList() {
        return elements;
    }

    @Override
    public Element getElement(String id) {
        for (Element element : elements) {
            if (element.getImdbID().equals(id)) {
                return element;
            }
        }
        return new Element();
    }

    @Override
    public void saveFavouriteById(String id) {

    }

    @Override
    public void saveElementList(List<Element> elementList) {

    }

    @Override
    public boolean isInDBElementById(String id) {
        return false;
    }

    /*@Override
    public boolean isInDB(Element element) {
        return elements.contains(element);
    }*/
}

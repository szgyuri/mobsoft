package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementID;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Element> getElementList() {
        return SugarRecord.listAll(Element.class);
    }

    @Override
    public Element getElement(String id) {
        List<Element> movies = getElementList();
        for (Element element : movies) {
            if (element.getImdbID().equals(id)) {
                return element;
            }
        }
        return new Element();
    }

    @Override
    public void saveFavouriteById(String id) {
        SugarRecord.save(new ElementID(id));
    }

    private List<ElementID> getElementIDList() {
        return SugarRecord.listAll(ElementID.class);
    }

    @Override
    public boolean isInDBElementById(String id) {
        List<ElementID> elementIDList = null;
        try {
            elementIDList = getElementIDList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (elementIDList != null && elementIDList.size() > 0) {
            for (ElementID elementID : elementIDList) {
                if (elementID.getId().equals(id)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public void saveElementList(List<Element> elementList) {
        SugarRecord.saveInTx(elementList);
    }

    /*@Override
    public void updateMovies(List<Movie> movies) {
        List<Movie> favourites = getElementList();
        List<Movie> toUpdate = new ArrayList<>(favourites.size());
        for (Movie favourite : favourites) {
            for (Movie todo : movies) {
                toUpdate.add(todo);
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }*/

    /*@Override
    public boolean isInDB(Element element) {
        return SugarRecord.findById(Element.class, element.getImdbID()) != null;
    }*/
}

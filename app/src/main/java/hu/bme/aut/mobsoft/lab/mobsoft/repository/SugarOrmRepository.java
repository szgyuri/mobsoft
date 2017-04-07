package hu.bme.aut.mobsoft.lab.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;

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
    public Element getElement(long id) {
        List<Element> movies = getElementList();
        for (Element element : movies) {
            if (element.getId() == id) {
                return element;
            }
        }
        return new Element();
    }

    @Override
    public void saveFavourite(Element element) {
        SugarRecord.saveInTx(element);
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

    @Override
    public boolean isInDB(Element element) {
        return SugarRecord.findById(Element.class, element.getId()) != null;
    }
}

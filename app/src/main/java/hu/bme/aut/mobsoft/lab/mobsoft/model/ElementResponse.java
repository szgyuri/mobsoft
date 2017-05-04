package hu.bme.aut.mobsoft.lab.mobsoft.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Szabo Gyorgy on 2017. 05. 03..
 */

public class ElementResponse {
    @SerializedName("Search")
    private List<Element> elementList;

    public List<Element> getElementList() {
        return elementList;
    }
}

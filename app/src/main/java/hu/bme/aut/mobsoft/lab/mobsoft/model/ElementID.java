package hu.bme.aut.mobsoft.lab.mobsoft.model;

import com.orm.dsl.Table;

/**
 * Created by Szabo Gyorgy on 2017. 05. 04..
 */

@Table
public class ElementID {
    private String id;

    public ElementID(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

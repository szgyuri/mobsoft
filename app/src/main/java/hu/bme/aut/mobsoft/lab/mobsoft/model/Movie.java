package hu.bme.aut.mobsoft.lab.mobsoft.model;

import com.orm.dsl.Table;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

@Table
public class Movie {
    private Long id = null;
    private String name;


    public Movie() {
    }

    public Movie(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

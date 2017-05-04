package hu.bme.aut.mobsoft.lab.mobsoft.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

@Table
public class Element {
    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Title")
    private String title = null;

    @SerializedName("Year")
    private String year = null;

    @SerializedName("Poster")
    private String posterUrl = null;

    @SerializedName("Type")
    private String type = null;

    private boolean isMovie;

    private boolean isFavourite = false;

    public String getYear() {
        return year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getType() {
        return type;
    }

    /**
     * Unique identifier for given element. Element may be movie or series.
     **/
    @ApiModelProperty(value = "Unique identifier for given element. Element may be movie or series.")
    public String getImdbID() {
        return imdbID;
    }
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }


    /**
     * Title of the element.
     **/
    @ApiModelProperty(value = "Title of the element.")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMovie() {
        return isMovie;
    }

    public void setMovie(boolean movie) {
        isMovie = movie;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}

package hu.bme.aut.mobsoft.lab.mobsoft.model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Szabo Gyorgy on 2017. 05. 03..
 */

public class ElementDetails {

    @SerializedName("Title")
    private String title;

    @SerializedName("Rated")
    private String rated = null;

    @SerializedName("Released")
    private String released = null;

    @SerializedName("Runtime")
    private String runtime = null;

    @SerializedName("Genre")
    private String genre = null;

    @SerializedName("Director")
    private String director = null;

    @SerializedName("Actors")
    private String actors = null;

    @SerializedName("Plot")
    private String plot = null;

    @SerializedName("Language")
    private String language = null;

    @SerializedName("Awards")
    private String awards = null;

    @SerializedName("Poster")
    private String poster = null;

    @SerializedName("imdbRating")
    private String imdbRating = null;

    @SerializedName("imdbVotes")
    private String imdbVotes = null;

    @SerializedName("Production")
    private String production = null;

    public String getTitle() {
        return title;
    }

    public String getProduction() {
        return production;
    }

    /**
     * Rating of the element.
     **/
    @ApiModelProperty(value = "Rating of the element.")
    public String getRated() {
        return rated;
    }
    public void setRated(String rated) {
        this.rated = rated;
    }


    /**
     * Released date of the element.
     **/
    @ApiModelProperty(value = "Released date of the element.")
    public String getReleased() {
        return released;
    }
    public void setReleased(String released) {
        this.released = released;
    }


    /**
     * Runtime of the element.
     **/
    @ApiModelProperty(value = "Runtime of the element.")
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }


    /**
     * Genres of the element, one ore more (action, adventure, fantasy).
     **/
    @ApiModelProperty(value = "Genres of the element, one ore more (action, adventure, fantasy).")
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }


    /**
     * Director of the element.
     **/
    @ApiModelProperty(value = "Director of the element.")
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }


    /**
     * Actors of the element.
     **/
    @ApiModelProperty(value = "Actors of the element.")
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }


    /**
     * Plot of the element.
     **/
    @ApiModelProperty(value = "Plot of the element.")
    public String getPlot() {
        return plot;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }


    /**
     * Language of the element.
     **/
    @ApiModelProperty(value = "Language of the element.")
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }


    /**
     * List of awards of the element.
     **/
    @ApiModelProperty(value = "List of awards of the element.")
    public String getAwards() {
        return awards;
    }
    public void setAwards(String awards) {
        this.awards = awards;
    }


    /**
     * Poster link of the element.
     **/
    @ApiModelProperty(value = "Poster link of the element.")
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }


    /**
     * Rating of the element in imdb.
     **/
    @ApiModelProperty(value = "Rating of the element in imdb.")
    public String getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }


    /**
     * Number of votes in imdb.
     **/
    @ApiModelProperty(value = "Number of votes in imdb.")
    public String getImdbVotes() {
        return imdbVotes;
    }
    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }
}

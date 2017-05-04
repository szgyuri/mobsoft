package hu.bme.aut.mobsoft.lab.mobsoft.network.element;

import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementDetails;
import hu.bme.aut.mobsoft.lab.mobsoft.model.ElementResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Szabo Gyorgy on 2017. 04. 21..
 */

public interface ElementApi {
    /**
     * Array of the movies
     * Gets Element objects, element may be movie or series.\nRequired type paramter, which is series or movie and optional\npage parameter, e.g. page=1 means that you get first page of element list.
     * @param type Type of the element.
     * @param page Page number of the element
     * @return Call<Element>
     */

    @GET("/?s=a")
    Call<ElementResponse> getElements(@Query("type") String type, @Query("page") Integer page);

    @GET
    Call<ElementDetails> getElementDetails(@Url String imdbID);

    @GET
    Call<ElementResponse> getElementsByText(@Url String text, @Query("type") String type, @Query("page") Integer page);
}

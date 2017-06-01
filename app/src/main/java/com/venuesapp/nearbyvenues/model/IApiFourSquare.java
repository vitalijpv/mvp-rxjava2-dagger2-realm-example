package com.venuesapp.nearbyvenues.model;

import com.venuesapp.nearbyvenues.model.json.VenuesData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IApiFourSquare {

    @GET("search?")
    Observable<VenuesData> getVenuesData(@Query("ll") String ll,
                                               @Query("client_id") String client_id,
                                               @Query("client_secret") String client_secret,
                                               @Query("v") String date);

}

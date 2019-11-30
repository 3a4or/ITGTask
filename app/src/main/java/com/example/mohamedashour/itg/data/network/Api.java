package com.example.mohamedashour.itg.data.network;


import com.example.mohamedashour.itg.data.models.Characters;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("characters?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> getCharacters(@Query("limit") int limitNum, @Query("offset") int offsetNum);

    @GET("characters/{characterId}/comics?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> getCharacterComics(@Path("characterId") long id);

    @GET("characters/{characterId}/series?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> getCharacterSeries(@Path("characterId") long id);

    @GET("characters/{characterId}/stories?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> getCharacterStories(@Path("characterId") long id);

    @GET("characters/{characterId}/events?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> getCharacterEvents(@Path("characterId") long id);

    @GET("characters?ts=1&apikey=7ad2d54f9efdfb82c70b9d5ab3010858&hash=d09261b5e8bd946070a938ec20bb6f03")
    Observable<Characters> search(@Query("name") String name);
}

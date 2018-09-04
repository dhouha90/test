package com.example.chikhaouidhouha.test.Service;

import com.example.chikhaouidhouha.test.Model.AllChampionShips;
import com.example.chikhaouidhouha.test.Model.AllTeam;
import com.example.chikhaouidhouha.test.Model.AllaPlayers;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpInterface {
    @GET("search_all_teams.php")
    Observable<AllTeam> searchTeam(@Query("l") String teamName);

    @GET("searchplayers.php")
    Observable<AllaPlayers> searchPlayer(@Query("t") String eventName);

    @GET("all_leagues.php")
    Observable<AllChampionShips> getListChampion();


}

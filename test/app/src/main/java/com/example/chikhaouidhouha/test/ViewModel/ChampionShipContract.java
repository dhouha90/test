package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.Team;

import io.reactivex.Observable;

public interface ChampionShipContract {

    LiveData<Observable<Team>> searchChampionSHip(String eventName);

    void clickChampionShip(View v, Team mTeam);

}

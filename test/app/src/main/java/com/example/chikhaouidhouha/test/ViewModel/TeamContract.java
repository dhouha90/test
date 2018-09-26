package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.ChampionShip;

import io.reactivex.Observable;


public interface TeamContract {
    LiveData<Observable<ChampionShip>> getListChampionShip();

    void ClickItemSearch(View v, String view);
}

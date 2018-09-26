package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.View.ChampionShipList.ChampionShipListAdapter;

import io.reactivex.Observable;


public interface TeamContract {
    public LiveData<ChampionShip> getListChampionShip();
    public void ClickItemSearch(View v,String view);
}

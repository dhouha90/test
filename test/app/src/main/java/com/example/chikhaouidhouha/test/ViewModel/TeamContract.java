package com.example.chikhaouidhouha.test.ViewModel;

import android.view.View;

import com.example.chikhaouidhouha.test.View.ChampionShipList.ChampionShipListAdapter;

public interface TeamContract {
    public void getListChampionShip(ChampionShipListAdapter championShipListAdapter);
    public void ClickItemSearch(View v,String view);
}

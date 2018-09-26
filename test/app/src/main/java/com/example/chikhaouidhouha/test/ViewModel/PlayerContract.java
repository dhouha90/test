package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.View.PlayerList.PlayerListAdaptater;

import io.reactivex.Observable;

public interface PlayerContract {
    LiveData<Observable<Player>> getListPlayer(String teamName);
}

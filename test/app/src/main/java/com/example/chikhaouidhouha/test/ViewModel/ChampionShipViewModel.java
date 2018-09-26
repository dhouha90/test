package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.Team;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.View.PlayerList.PlayerActivity;

import io.reactivex.Observable;

public class ChampionShipViewModel extends ViewModel implements ChampionShipContract {
    private final String TAG = this.getClass().getName();

    public Context mContext;

    public ChampionShipViewModel() {

    }

    @Override
    public LiveData<Observable<Team>> searchChampionSHip(String eventName) {

        final MutableLiveData<Observable<Team>> data = new MutableLiveData<>();
        HttpResponse httpResponse = new HttpResponse();
        data.setValue(httpResponse.getListTeam(eventName));
        return data;



    }

    @Override
    public void clickChampionShip(View v, Team mTeam) {
        mContext = v.getContext();
        Intent intent = new Intent(mContext, PlayerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(StringUtils.Team_NAME, mTeam.getStrTeam());
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }
}

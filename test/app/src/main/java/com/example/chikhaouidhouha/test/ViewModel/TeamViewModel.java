package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.View.TeamList.TeamActivity;

import io.reactivex.Observable;

public class TeamViewModel extends ViewModel implements TeamContract {
    private final String TAG = this.getClass().getName();

    @Override
    public LiveData<Observable<ChampionShip>> getListChampionShip() {
        final MutableLiveData<Observable<ChampionShip>> data = new MutableLiveData<>();
        HttpResponse httpResponse = new HttpResponse();
        data.setValue(httpResponse.getListChampion());
        return data;
    }

    @Override
    public void ClickItemSearch(View v, String ClubName) {
        Context mContext = v.getContext();
        Intent intent = new Intent(mContext, TeamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(StringUtils.CHAMPIONSHIP_NAME, ClubName);
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }
}

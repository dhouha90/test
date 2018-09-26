package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.View.TeamList.TeamActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TeamViewModel extends ViewModel implements TeamContract {
    private final String TAG = this.getClass().getName();

    @Override
    public LiveData<ChampionShip> getListChampionShip() {
        final MutableLiveData<ChampionShip> data = new MutableLiveData<>();
        HttpResponse httpResponse = new HttpResponse();
         httpResponse.getListChampion()
                .subscribe(new Consumer<ChampionShip>() {
                    @Override
                    public void accept(ChampionShip championShip) throws Exception {
                        data.setValue(championShip);
                    }
                });

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

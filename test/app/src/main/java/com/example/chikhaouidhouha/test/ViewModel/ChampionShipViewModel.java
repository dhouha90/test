package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.Team;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.View.PlayerList.PlayerActivity;
import com.example.chikhaouidhouha.test.View.TeamList.TeamListAdaptater;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ChampionShipViewModel extends ViewModel implements ChampionShipContract {
    private final String TAG = this.getClass().getName();

    public Context mContext;

    public ChampionShipViewModel(Context mContext) {
        this.mContext = mContext;
    }

    public ChampionShipViewModel() {

    }

    @Override
    public void searchChampionSHip(String eventName, final TeamListAdaptater mTeamListAdaptater) {

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.getListTeam(eventName).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Observer<Team>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Team team) {
                Log.i(TAG, "onNext: " + team.toString());
                mTeamListAdaptater.addItem(team);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "Onerror " + e.toString());

            }

            @Override
            public void onComplete() {
                mTeamListAdaptater.notifyDataSetChanged();
            }
        });

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

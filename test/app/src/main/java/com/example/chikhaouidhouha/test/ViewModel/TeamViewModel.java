package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.View.ChampionShipList.ChampionShipListAdapter;
import com.example.chikhaouidhouha.test.View.TeamList.TeamActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TeamViewModel extends ViewModel implements TeamContract {
    private final String TAG = this.getClass().getName();
    @Override
    public void getListChampionShip(final ChampionShipListAdapter championShipListAdapter) {

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.getListChampion().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Observer<ChampionShip>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ChampionShip championShip) {
                Log.i(TAG,"onNext"+championShip.toString());
                championShipListAdapter.addData(championShip);

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"onError"+e.toString());

            }

            @Override
            public void onComplete() {
                championShipListAdapter.notifyDataSetChanged();


            }
        });

    }

    @Override
    public void ClickItemSearch(View v,String ClubName) {
        Context mContext = v.getContext();
        Intent intent = new Intent(mContext, TeamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(StringUtils.CHAMPIONSHIP_NAME,ClubName);
        intent.putExtras(bundle);
        mContext.startActivity(intent);


    }
}

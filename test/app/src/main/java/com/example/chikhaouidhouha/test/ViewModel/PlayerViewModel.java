package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.Service.HttpResponse;
import com.example.chikhaouidhouha.test.View.PlayerList.PlayerListAdaptater;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PlayerViewModel extends ViewModel implements PlayerContract {
    private final String TAG = this.getClass().getName();
    @Override
    public void getListPlayer(String teamName, final PlayerListAdaptater mlistAdaptaterPlayer) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.getListPlayer(teamName).observeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Player>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Player player) {
                        Log.i(TAG, "onNext: "+ player.toString());
                        mlistAdaptaterPlayer.addItem(player);

                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.i(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {
                        mlistAdaptaterPlayer.notifyDataSetChanged();

                    }
                });

    }
}

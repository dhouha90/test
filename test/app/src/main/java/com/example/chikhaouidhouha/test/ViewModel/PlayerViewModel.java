package com.example.chikhaouidhouha.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.Service.HttpResponse;

import io.reactivex.Observable;

public class PlayerViewModel extends ViewModel implements PlayerContract {
    private final String TAG = this.getClass().getName();

    @Override
    public LiveData<Observable<Player>> getListPlayer(String teamName) {
        final MutableLiveData<Observable<Player>> data = new MutableLiveData<>();
        HttpResponse httpResponse = new HttpResponse();
        data.setValue(httpResponse.getListPlayer(teamName));
        return data;


    }
}

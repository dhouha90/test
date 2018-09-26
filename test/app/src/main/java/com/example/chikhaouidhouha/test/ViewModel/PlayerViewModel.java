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

               /* .subscribe(new Consumer<Player>() {
                    @Override
                    public void accept(Player player) throws Exception {
                        data.setValue(player);
                    }
                });

        return data;*/
               /* .observeOn(AndroidSchedulers.mainThread())

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
                });*/

    }
}

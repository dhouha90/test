package com.example.chikhaouidhouha.test.View.PlayerList;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.ViewModel.PlayerViewModel;
import com.example.chikhaouidhouha.test.ViewModel.TeamViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PlayerActivity extends AppCompatActivity {
    /*dans ce class on va recuperer la liste des jouers dans cette équipe
     * */

    PlayerListAdaptater mPlayerListAdaptater;
    PlayerViewModel mPlayerViewModel ;
    String mClubName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_player);
        mClubName = getIntent().getExtras().getString(StringUtils.Team_NAME);
        getSupportActionBar().setTitle(mClubName);
        RecyclerView rv = findViewById(R.id.list_player);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mPlayerListAdaptater = new PlayerListAdaptater();
        rv.setAdapter(mPlayerListAdaptater);
        mPlayerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        mPlayerViewModel.getListPlayer(mClubName).observe(this, new Observer<Observable<Player>>() {
            @Override
            public void onChanged(@Nullable Observable<Player> playerObservable) {
                playerObservable.toList()
                        .subscribe(new SingleObserver<List<Player>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Player> players) {
                        mPlayerListAdaptater.addItem(players);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




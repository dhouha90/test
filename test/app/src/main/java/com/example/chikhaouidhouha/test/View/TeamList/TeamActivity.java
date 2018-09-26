package com.example.chikhaouidhouha.test.View.TeamList;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.chikhaouidhouha.test.Model.Team;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.ViewModel.ChampionShipViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TeamActivity extends AppCompatActivity {
    /*dans ce class on va recuperer la liste des equipes dans cette ligue
     * */
    private TeamListAdaptater mSearchTeam;
    ChampionShipViewModel mChampionShipViewModel;
    String mChampionShipName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_team);
        mChampionShipName = getIntent().getExtras().getString(StringUtils.CHAMPIONSHIP_NAME);
        getSupportActionBar().setTitle(mChampionShipName);
        RecyclerView rv = findViewById(R.id.list_team);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSearchTeam = new TeamListAdaptater();
        rv.setAdapter(mSearchTeam);


        mChampionShipViewModel = ViewModelProviders.of(this).get(ChampionShipViewModel.class);
        mChampionShipViewModel.searchChampionSHip(mChampionShipName).observe(this, new Observer<Observable<Team>>() {
            @Override
            public void onChanged(@Nullable Observable<Team> teamObservable) {
                teamObservable.toList()
                        .subscribe(new SingleObserver<List<Team>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(List<Team> teams) {
                                mSearchTeam.addItem(teams);
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

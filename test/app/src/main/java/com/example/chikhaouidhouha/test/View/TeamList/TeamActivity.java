package com.example.chikhaouidhouha.test.View.TeamList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.ViewModel.ChampionShipViewModel;

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
        mChampionShipViewModel = new ChampionShipViewModel(getApplicationContext());
        rv.setAdapter(mSearchTeam);
        mChampionShipViewModel.searchChampionSHip(mChampionShipName, mSearchTeam);
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

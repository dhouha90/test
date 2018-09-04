package com.example.chikhaouidhouha.test.View.PlayerList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.Utils.StringUtils;
import com.example.chikhaouidhouha.test.ViewModel.PlayerViewModel;

public class PlayerActivity extends AppCompatActivity {
    /*dans ce class on va recuperer la liste des jouers dans cette équipe
     * */

    PlayerListAdaptater mPlayerListAdaptater;
    PlayerViewModel mPlayerViewModel = new PlayerViewModel();
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
        mPlayerViewModel.getListPlayer(mClubName, mPlayerListAdaptater);
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




package com.example.chikhaouidhouha.test.View.ChampionShipList;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.ViewModel.TeamViewModel;
import com.example.chikhaouidhouha.test.databinding.ActivityChampionshipBinding;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class ChampionShipActivity extends AppCompatActivity {

    /*dans ce class on va recuperer la liste de ligue qui existe dans  {all_leagues.php}
     * et quand l'utilisateur tappe le nom d'un lique , on va chercher ca dans la liste
     * */

    private ActivityChampionshipBinding activityMainBinding;
    private ChampionShipListAdapter adapter = new ChampionShipListAdapter();
    private TeamViewModel mHomeSearchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_championship);
        activityMainBinding.search.setActivated(true);
        activityMainBinding.search.setQueryHint(getResources().getString(R.string.championShip_Placeholder));
        activityMainBinding.search.onActionViewExpanded();
        activityMainBinding.search.setIconified(false);
        activityMainBinding.search.clearFocus();
        mHomeSearchViewModel = ViewModelProviders.of(this).get(TeamViewModel.class);
        mHomeSearchViewModel.getListChampionShip().observe(this, new Observer<Observable<ChampionShip>>() {
            @Override
            public void onChanged(@Nullable Observable<ChampionShip> championShipObservable) {
                championShipObservable.subscribe(new io.reactivex.Observer<ChampionShip>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChampionShip championShip) {
                        adapter.addData(championShip);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        adapter.notifyDataSetChanged();
                    }
                });


            }
        });

        activityMainBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                activityMainBinding.listView.setAdapter(adapter);
                return false;
            }
        });
    }
}



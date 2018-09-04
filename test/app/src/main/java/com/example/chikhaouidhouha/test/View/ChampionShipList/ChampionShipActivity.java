package com.example.chikhaouidhouha.test.View.ChampionShipList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;

import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.ViewModel.TeamViewModel;
import com.example.chikhaouidhouha.test.databinding.ActivityChampionshipBinding;

public class ChampionShipActivity extends AppCompatActivity {

    /*dans ce class on va recuperer la liste de ligue qui existe dans  {all_leagues.php}
    * et quand l'utilisateur tappe le nom d'un lique , on va chercher ca dans la liste
    * */

    private ActivityChampionshipBinding activityMainBinding;
    private ChampionShipListAdapter adapter = new ChampionShipListAdapter();
    private TeamViewModel mHomeSearchViewModel = new TeamViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_championship);
        activityMainBinding.search.setActivated(true);
        activityMainBinding.search.setQueryHint(getResources().getString(R.string.championShip_Placeholder));
        activityMainBinding.search.onActionViewExpanded();
        activityMainBinding.search.setIconified(false);
        activityMainBinding.search.clearFocus();
        mHomeSearchViewModel.getListChampionShip(adapter);

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



package com.example.chikhaouidhouha.test.ViewModel;

import android.view.View;

import com.example.chikhaouidhouha.test.Model.Team;
import com.example.chikhaouidhouha.test.View.TeamList.TeamListAdaptater;

public interface ChampionShipContract {

   void searchChampionSHip(String eventName,final TeamListAdaptater mTeamListAdaptater);
   void clickChampionShip(View v, Team mTeam);

}

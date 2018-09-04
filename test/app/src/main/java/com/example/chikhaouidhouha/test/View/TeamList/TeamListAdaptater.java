package com.example.chikhaouidhouha.test.View.TeamList;


import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.chikhaouidhouha.test.Model.Team;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.ViewModel.ChampionShipViewModel;
import com.example.chikhaouidhouha.test.databinding.ItemTeamAdaptaterBinding;

import java.util.ArrayList;
import java.util.List;

public class TeamListAdaptater extends RecyclerView.Adapter<TeamListAdaptater.TeamHolder> {
List<Team> mAllAllTeam = new ArrayList<>();

    public TeamListAdaptater() {
    }
    public void addItem(Team data) {
        mAllAllTeam.add(data);
    }

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemTeamAdaptaterBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from
                (parent.getContext()), R.layout.item_team_adaptater, parent, false);
        return new TeamHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
        holder.feeditemBinding.setTeam(mAllAllTeam.get(position));
        holder.feeditemBinding.setPresenter(new ChampionShipViewModel());



    }

    @Override
    public int getItemCount() {

            return mAllAllTeam.size();

    }

    class TeamHolder extends RecyclerView.ViewHolder{
        private ItemTeamAdaptaterBinding feeditemBinding;



        public TeamHolder(ItemTeamAdaptaterBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            feeditemBinding=viewDataBinding;
        }
    }
}

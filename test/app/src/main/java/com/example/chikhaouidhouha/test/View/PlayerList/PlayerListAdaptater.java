package com.example.chikhaouidhouha.test.View.PlayerList;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.databinding.ItemPlayerAdaptaterBinding;

import java.util.ArrayList;
import java.util.List;

public class PlayerListAdaptater extends RecyclerView.Adapter<PlayerListAdaptater.PlayerHolder> {

    List<Player> mAllPlayer = new ArrayList<>();

    public PlayerListAdaptater() {
    }

    public void addItem(Player data) {
        mAllPlayer.add(data);
    }

    @NonNull
    @Override
    public PlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPlayerAdaptaterBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from
                (parent.getContext()), R.layout.item_player_adaptater, parent, false);
        return new PlayerHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerHolder holder, int position) {
        holder.feeditemBinding.setPlayer(mAllPlayer.get(position));
    }

    @Override
    public int getItemCount() {
        return mAllPlayer.size();
    }

    class PlayerHolder extends RecyclerView.ViewHolder {
        private ItemPlayerAdaptaterBinding feeditemBinding;

        public PlayerHolder(ItemPlayerAdaptaterBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            feeditemBinding = viewDataBinding;
        }
    }
}

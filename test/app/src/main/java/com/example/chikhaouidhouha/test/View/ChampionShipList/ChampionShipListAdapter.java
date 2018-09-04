package com.example.chikhaouidhouha.test.View.ChampionShipList;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.R;
import com.example.chikhaouidhouha.test.ViewModel.TeamViewModel;
import com.example.chikhaouidhouha.test.databinding.ItemChampionshipAdaptaterBinding;

import java.util.ArrayList;
import java.util.List;

public class ChampionShipListAdapter extends BaseAdapter implements Filterable {
    private List<ChampionShip> allChampionShip = new ArrayList<>();
    private List<String> mData = new ArrayList<>();
    private List<String> mStringFilterList = new ArrayList<>();
    private ValueFilter valueFilter;
    private LayoutInflater inflater;


    public void addData(ChampionShip data) {
        allChampionShip.add(data);
        mData.add(data.getStrLeague());
        mStringFilterList.add(data.getStrLeague());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        ItemChampionshipAdaptaterBinding itemChampionshipAdaptaterBinding = DataBindingUtil.inflate(inflater, R.layout.item_championship_adaptater, parent, false);
        itemChampionshipAdaptaterBinding.setTeamViewModel(new TeamViewModel());
        itemChampionshipAdaptaterBinding.setChampionShip(allChampionShip.get(position));
        return itemChampionshipAdaptaterBinding.getRoot();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<String> filterList = new ArrayList<>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(mStringFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mData = (List<String>) results.values;
            notifyDataSetChanged();
        }

    }

}

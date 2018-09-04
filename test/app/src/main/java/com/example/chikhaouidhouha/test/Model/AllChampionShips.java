package com.example.chikhaouidhouha.test.Model;

import java.util.List;

public class AllChampionShips {
    List<ChampionShip> leagues;

    public List<ChampionShip> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<ChampionShip> leagues) {
        this.leagues = leagues;
    }

    @Override
    public String toString() {
        return "AllChampionShips{" +
                "championShips=" + leagues +
                '}';
    }
}

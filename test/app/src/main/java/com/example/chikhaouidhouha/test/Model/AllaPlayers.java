package com.example.chikhaouidhouha.test.Model;

import java.util.List;

public class AllaPlayers {
    List<Player> player;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "AllaPlayers{" +
                "player=" + player +
                '}';
    }
}

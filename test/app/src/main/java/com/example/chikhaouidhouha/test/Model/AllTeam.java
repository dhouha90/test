package com.example.chikhaouidhouha.test.Model;

import java.util.List;

public class AllTeam {
    List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "AllTeam{" +
                "teams=" + teams +
                '}';
    }
}

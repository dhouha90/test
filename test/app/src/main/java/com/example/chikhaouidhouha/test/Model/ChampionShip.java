package com.example.chikhaouidhouha.test.Model;

public class ChampionShip {
    String idLeague;
    String strLeague;
    String strSport;
    String strLeagueAlternate;

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    @Override
    public String toString() {
        return "ChampionShip{" +
                "idLeague='" + idLeague + '\'' +
                ", strLeague='" + strLeague + '\'' +
                ", strSport='" + strSport + '\'' +
                ", strLeagueAlternate='" + strLeagueAlternate + '\'' +
                '}';
    }
}

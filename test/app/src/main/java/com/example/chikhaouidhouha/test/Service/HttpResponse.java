package com.example.chikhaouidhouha.test.Service;


import com.example.chikhaouidhouha.test.Model.AllChampionShips;
import com.example.chikhaouidhouha.test.Model.AllTeam;
import com.example.chikhaouidhouha.test.Model.AllaPlayers;
import com.example.chikhaouidhouha.test.Model.ChampionShip;
import com.example.chikhaouidhouha.test.Model.Player;
import com.example.chikhaouidhouha.test.Model.Team;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HttpResponse {

    private final String TAG = this.getClass().getName();

    public Observable<Team> getListTeam(String mTeamName) {
        return HttpService.getInterface()
                .searchTeam(mTeamName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<AllTeam, Observable<Team>>() {
                    @Override
                    public Observable<Team> apply(AllTeam allTeam) throws Exception {
                        return Observable.just(allTeam).flatMap(new Function<AllTeam, Observable<Team>>() {
                            @Override
                            public Observable<Team> apply(AllTeam allTeam) throws Exception {
                                return Observable.fromIterable(allTeam.getTeams());
                            }
                        });
                    }
                });

    }

    public Observable<Player> getListPlayer(String mClubName) {
        return HttpService.getInterface()
                .searchPlayer(mClubName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<AllaPlayers, ObservableSource<Player>>() {
                    @Override
                    public ObservableSource<Player> apply(AllaPlayers allaPlayers) throws Exception {
                        return Observable.just(allaPlayers).flatMap(new Function<AllaPlayers, ObservableSource<Player>>() {
                            @Override
                            public ObservableSource<Player> apply(AllaPlayers allaPlayers) throws Exception {
                                return Observable.fromIterable(allaPlayers.getPlayer());
                            }
                        });
                    }
                });

    }

    public Observable<ChampionShip> getListChampion() {
        return HttpService.getInterface()
                .getListChampion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<AllChampionShips, ObservableSource<ChampionShip>>() {
                    @Override
                    public ObservableSource<ChampionShip> apply(AllChampionShips allChampionShips) throws Exception {
                        return Observable.just(allChampionShips).flatMap(new Function<AllChampionShips, ObservableSource<ChampionShip>>() {
                            @Override
                            public ObservableSource<ChampionShip> apply(AllChampionShips allChampionShips) throws Exception {
                                return Observable.fromIterable(allChampionShips.getLeagues());
                            }
                        });
                    }
                });
    }


}

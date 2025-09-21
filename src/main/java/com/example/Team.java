package com.example;
import java.util.List;
class Team {
    private String TeamName;
    private List<Player> list_of_players;
    private int num_of_games;
    private List<Game> list_of_games; 
    
    
    public  void SetTeamName(String newval) {
        TeamName = newval;
    }
    public String GetTeamName() {
        return TeamName;
    }
    public void SetNum_of_games(int newval) { 
        num_of_games = newval;
    }
    public int GetNum_of_games() {
        return num_of_games;
    }
    public void SetList_of_players(List<Player> newval) {
        list_of_players = newval;
    }
    public List<Player> GetList_of_playes() {
        return list_of_players;
    }
    public void SetList_of_games(List<Game> newval) {
        list_of_games = newval;
    }
    public List<Game> GetList_of_games() {
        return list_of_games;
    }
}

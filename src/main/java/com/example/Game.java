package com.example;
import javax.persistence.*;
 
@Entity
@Table (name = "kurs.games")
class Game {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGame;
    private int opositeTeam;
    private int firstScore;
    private int secondScore;
    private String Date;

    public void SetGId(int newval) {
        idGame = newval; 
    }
    @Column(name = "idGame")
    public int GetGId() {
        return idGame;
    }

    public void SetOpositeTeam(int newval) {
        opositeTeam = newval;
    }
    @Column(name = "opositeTeam")
    public int GetOpositeTeam() {
        return opositeTeam;
    }

    public void SetFirstScore(int newval) {
            firstScore = newval;
    }
    @Column(name = "firstScore")
    public int GetFirstScore() {
        return firstScore;
    }

    public void SetSecondScore(int newval) {
        secondScore = newval;
    }
    @Column(name = "secondScore")
    public int GetSecondScore() {
        return secondScore;
    }

    public void SetDate(String newval) {
        Date = newval;
    }
    @Column(name ="Date")
    public String GetDate() {
        return Date;
    }
}

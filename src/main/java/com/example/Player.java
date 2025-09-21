package com.example;
import javax.persistence.*;


@Entity 
@Table (name= "kurs.players")
class Player {
    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPlayer;
    private String PlayerName;
    private String result;
    private int special;


    public void setspecial(int newval) {
        special = newval;
    }

    @Column(name="special")
    public int getspecial() {
        return special;        
    }

    public void SetPlId(int newval) { 
        idPlayer = newval;
    }
    @Column(name="idPlayer")
    public int getPlId() {
        return idPlayer;
    }

    public void setPlayerName(String newval) {
        PlayerName = newval;
    }
    @Column(name="PlayerName")
    public String getPlayerName() {
        return PlayerName;
    }

    public void setResult(String newval) {
        result = newval;
    }
    @Column(name="result")
    public String getResult() {
        return result;
    }
}
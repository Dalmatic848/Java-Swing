package com.example;
import javax.persistence.*;

@Entity
@Table (name ="kurs.opositeteams")
class OpositeTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idopositeTeam;
    private String opositeTeamName;

    public void setOpositeTeam_id(int newval) {
        idopositeTeam = newval;
    }
    @Column(name = "idopositeTeam")
    public int getOpositeTeam_id() {
        return idopositeTeam;
    }

    public void setOpositeTeamName(String newval) {
        opositeTeamName = newval;
    }
    @Column(name = "opositeTeamName")
    public String getopositeTeamName() {
        return opositeTeamName;
    }
}

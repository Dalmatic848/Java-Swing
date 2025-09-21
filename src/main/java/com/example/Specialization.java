package com.example;
import javax.persistence.*;

@Entity
@Table (name ="kurs.specializations")
class Specialization { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Specialization_id;
    private String SpecName;

    public void setSpId(int newval) {
        Specialization_id = newval;
    }
    @Column(name = "Specializtion_id")
    public int getSpId() {
        return Specialization_id;
    }

    public void setSpecName(String newval) {
        SpecName = newval;
    }
    @Column(name = "SpecName")
    public String getSpecName() {
        return SpecName;
    }
}
package com.example.navigater.model;

import java.util.ArrayList;

public class Medicine {

    int nb;
    ArrayList<String> medicine;

    public Medicine(int nb, ArrayList<String> medicine) {
        this.nb = nb;
        this.medicine = medicine;
    }

    public Medicine() {
        this.medicine = new ArrayList<>();
    }

    public ArrayList<String> getMedicine() {
        return medicine;
    }

    public void setMedicine(String content) {
        medicine.add(content);
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}

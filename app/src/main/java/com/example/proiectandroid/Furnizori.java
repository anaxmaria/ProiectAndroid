package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//definire tabela
@Entity(tableName = "Furnizori")

public class Furnizori {

    //definire campuri
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Denumire")
    private String denumireFurnizor;

    @ColumnInfo(name = "Telefon")
    private String nrTelefon;

    @ColumnInfo(name = "E-mail")
    private String adresaEmail;

    @ColumnInfo(name = "Adresa")
    private String locatie;

    public Furnizori() {
    }

    public Furnizori(int ID, String denumireFurnizor, String nrTelefon, String adresaEmail, String locatie) {
        this.ID = ID;
        this.denumireFurnizor = denumireFurnizor;
        this.nrTelefon = nrTelefon;
        this.adresaEmail = adresaEmail;
        this.locatie = locatie;
    }

    public Furnizori(String denumireFurnizor, String nrTelefon, String adresaEmail, String locatie) {
        this.denumireFurnizor = denumireFurnizor;
        this.nrTelefon = nrTelefon;
        this.adresaEmail = adresaEmail;
        this.locatie = locatie;
    }

    public Furnizori(String denumireFurnizor) {
        this.denumireFurnizor = denumireFurnizor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDenumireFurnizor() {
        return denumireFurnizor;
    }

    public void setDenumireFurnizor(String denumireFurnizor) {
        this.denumireFurnizor = denumireFurnizor;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getAdresaEmail() {
        return adresaEmail;
    }

    public void setAdresaEmail(String adresaEmail) {
        this.adresaEmail = adresaEmail;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Furnizori{" +
                "ID=" + ID +
                ", denumireFurnizor='" + denumireFurnizor + '\'' +
                ", nrTelefon=" + nrTelefon +
                ", adresaEmail='" + adresaEmail + '\'' +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}

package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//definire tabela
@Entity(tableName = "Factura_Nationala", foreignKeys = @ForeignKey(entity = Furnizori.class,parentColumns = "ID", childColumns = "Furnizor",
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class FacturaNationala {

    //definire campuri
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Denumire")
    private String denumireFactura;

    @ColumnInfo(name = "Furnizor")
    private int idFurnizor;

    @ColumnInfo(name = "Total_Plata")
    private float pret;

    @ColumnInfo(name = "Serie")
    private String serie;

    @ColumnInfo(name="Data_Scadenta")
    private String dataScadenta;

    @ColumnInfo(name = "Tip_Factura")
    private String tipFactura;

    @ColumnInfo(name = "Moneda")
    private String moneda;

    public FacturaNationala() {
    }

    @Ignore
    public FacturaNationala(int ID, String denumireFactura, int idFurnizor, float pret, String serie, String dataScadenta, String tipFactura, String moneda) {
        this.ID = ID;
        this.denumireFactura = denumireFactura;
        this.idFurnizor = idFurnizor;
        this.pret = pret;
        this.serie = serie;
        this.dataScadenta = dataScadenta;
        this.tipFactura = tipFactura;
        this.moneda = moneda;
    }

    public FacturaNationala(String denumireFactura, int idFurnizor, float pret, String serie, String dataScadenta, String tipFactura, String moneda) {
        this.denumireFactura = denumireFactura;
        this.idFurnizor = idFurnizor;
        this.pret = pret;
        this.serie = serie;
        this.dataScadenta = dataScadenta;
        this.tipFactura = tipFactura;
        this.moneda = moneda;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDenumireFactura() {
        return denumireFactura;
    }

    public void setDenumireFactura(String denumireFactura) {
        this.denumireFactura = denumireFactura;
    }

    public int getIdFurnizor() {
        return idFurnizor;
    }

    public void setIdFurnizor(int idFurnizor) {
        this.idFurnizor = idFurnizor;
    }

    public String getMoneda() { return moneda; }

    public void setMoneda(String moneda) { this.moneda = moneda; }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDataScadenta() {
        return dataScadenta;
    }

    public void setDataScadenta(String dataScadenta) {
        this.dataScadenta = dataScadenta;
    }

    public String getTipFactura() {
        return tipFactura;
    }

    public void setTipFactura(String tipFactura) {
        this.tipFactura = tipFactura;
    }

    @Override
    public String toString() {
        return "FacturaNationala{" +
                "ID=" + ID +
                ", denumireFactura='" + denumireFactura + '\'' +
                ", idFurnizor=" + idFurnizor +
                ", pret=" + pret +
                ", serie='" + serie + '\'' +
                ", dataScadenta='" + dataScadenta + '\'' +
                ", tipFactura='" + tipFactura + '\'' +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}

package com.example.proiectandroid;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Istoric_Facturi", foreignKeys = @ForeignKey(entity = Furnizori.class,parentColumns = "ID", childColumns = "Furnizor",
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class FacturaPlatita implements Parcelable {

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

    @ColumnInfo(name="Data_Plata")
    private String dataPlata;

    @ColumnInfo(name = "Tip_Factura")
    private String tipFactura;

    @ColumnInfo(name = "Moneda")
    private String moneda;

    public FacturaPlatita() {
    }

    @Ignore
    public FacturaPlatita(int ID, String denumireFactura, int idFurnizor, float pret, String serie, String dataPlata, String tipFactura, String moneda) {
        this.ID = ID;
        this.denumireFactura = denumireFactura;
        this.idFurnizor = idFurnizor;
        this.pret = pret;
        this.serie = serie;
        this.tipFactura = tipFactura;
        this.moneda = moneda;
        this.dataPlata = dataPlata;
    }

    public FacturaPlatita(String denumireFactura, int idFurnizor, float pret, String serieFactura, String dataPlata, String tipFactura, String moneda) {
        this.denumireFactura = denumireFactura;
        this.idFurnizor = idFurnizor;
        this.pret = pret;
        this.serie = serieFactura;
        this.tipFactura = tipFactura;
        this.moneda = moneda;
        this.dataPlata = dataPlata;
    }

    protected FacturaPlatita(Parcel in) {
        ID = in.readInt();
        denumireFactura = in.readString();
        idFurnizor = in.readInt();
        pret = in.readFloat();
        serie = in.readString();
        dataPlata = in.readString();
        tipFactura = in.readString();
        moneda = in.readString();
    }

    public static final Creator<FacturaPlatita> CREATOR = new Creator<FacturaPlatita>() {
        @Override
        public FacturaPlatita createFromParcel(Parcel in) {
            return new FacturaPlatita(in);
        }

        @Override
        public FacturaPlatita[] newArray(int size) {
            return new FacturaPlatita[size];
        }
    };

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

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDataPlata() {
        return dataPlata;
    }

    public void setDataPlata(String dataPlata) {
        this.dataPlata = dataPlata;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipFactura() {
        return tipFactura;
    }

    public void setTipFactura(String tipFactura) {
        this.tipFactura = tipFactura;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "FacturaPlatita{" +
                "ID=" + ID +
                ", denumireFactura='" + denumireFactura + '\'' +
                ", idFurnizor=" + idFurnizor +
                ", pret=" + pret +
                ", serie='" + serie + '\'' +
                ", dataPlata='" + dataPlata + '\'' +
                ", tipFactura='" + tipFactura + '\'' +
                ", moneda='" + moneda + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(denumireFactura);
        dest.writeInt(idFurnizor);
        dest.writeFloat(pret);
        dest.writeString(serie);
        dest.writeString(dataPlata);
        dest.writeString(tipFactura);
        dest.writeString(moneda);
    }
}

package com.example.proiectandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Factura implements Parcelable {
    private String denumireFactura;
    private String furnizorFactura;
    private float pretFactura;
    private String serieFactura;
    private String dataScadentaFactura;

    private boolean platita;
    private String tipFactura;
    private String moneda;
    public static String[] furnizori={"ENEL","AQUA NOVA","ENGIE","DIGI","VODAFONE","TELEKOM","FAN COURIER"
            ,"SAMEDAY","EON","ORANGE","RCS&RDS","UPC","EBAY","AMAZON","ALIEXPRESS","-"};

    public Factura(String denumireFactura, String furnizorFactura, float pretFactura, String serieFactura, String dataScadentaFactura, String tipFactura, String moneda) {
        this.denumireFactura = denumireFactura;
        this.furnizorFactura = furnizorFactura;
        this.pretFactura = pretFactura;
        this.serieFactura = serieFactura;
        this.dataScadentaFactura = dataScadentaFactura;
        this.tipFactura = tipFactura;
        this.moneda = moneda;
    }

    public Factura(String denumireFactura, String furnizorFactura, float pretFactura, String serieFactura, String dataScadentaFactura, String tipFactura) {
        this.denumireFactura = denumireFactura;
        this.furnizorFactura = furnizorFactura;
        this.pretFactura = pretFactura;
        this.serieFactura = serieFactura;
        this.dataScadentaFactura = dataScadentaFactura;
        this.tipFactura = tipFactura;
    }

    protected Factura(Parcel in) {
        denumireFactura = in.readString();
        furnizorFactura = in.readString();
        pretFactura = in.readFloat();
        serieFactura = in.readString();
        dataScadentaFactura = in.readString();
        tipFactura = in.readString();
        moneda = in.readString();
    }

    public static final Creator<Factura> CREATOR = new Creator<Factura>() {
        @Override
        public Factura createFromParcel(Parcel in) {
            return new Factura(in);
        }

        @Override
        public Factura[] newArray(int size) {
            return new Factura[size];
        }
    };

    public String getDenumireFactura() {
        return denumireFactura;
    }

    public void setDenumireFactura(String denumireFactura) {
        this.denumireFactura = denumireFactura;
    }

    public String getFurnizorFactura() {
        return furnizorFactura;
    }

    public void setFurnizorFactura(String furnizorFactura) {
        this.furnizorFactura = furnizorFactura;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getPretFactura() {
        return pretFactura;
    }

    public void setPretFactura(float pretFactura) {
        this.pretFactura = pretFactura;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public String getDataScadentaFactura() {
        return dataScadentaFactura;
    }

    public void setDataScadentaFactura(String dataScadentaFactura) {
        this.dataScadentaFactura = dataScadentaFactura;
    }


    public String getTipFactura() {
        return tipFactura;
    }

    public void setTipFactura(String tipFactura) {
        this.tipFactura = tipFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "denumireFactura='" + denumireFactura + '\'' +
                ", furnizorFactura='" + furnizorFactura + '\'' +
                ", pretFactura=" + pretFactura +
                ", serieFactura='" + serieFactura + '\'' +
                ", dataScadentaFactura='" + dataScadentaFactura + '\'' +
                ", platita=" + platita +
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
        dest.writeString(denumireFactura);
        dest.writeString(furnizorFactura);
        dest.writeFloat(pretFactura);
        dest.writeString(serieFactura);
        dest.writeString(dataScadentaFactura);
        dest.writeString(tipFactura);
        dest.writeString(moneda);
    }

    public boolean isPlatita() {
        return platita;
    }

    public void setPlatita(boolean platita) {
        this.platita = platita;
    }
}

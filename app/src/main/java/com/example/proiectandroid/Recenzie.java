package com.example.proiectandroid;


//clasa dupa care vom construim o recenzie;recenzie adaugata in firebase si regasita
public class Recenzie {
    private String nota;
    private String recenzieText;
    private String data;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getRecenzieText() {
        return recenzieText;
    }

    public void setRecenzieText(String recenzieText) {
        this.recenzieText = recenzieText;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Recenzie() {
    }

    public Recenzie(String nota, String recenzieText, String data) {
        this.nota = nota;
        this.recenzieText = recenzieText;
        this.data = data;
    }

    public Recenzie(String recenzieText, String data) {
        this.recenzieText = recenzieText;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Recenzie{" +
                "nota='" + nota + '\'' +
                ", recenzieText='" + recenzieText + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

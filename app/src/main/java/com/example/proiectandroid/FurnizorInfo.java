package com.example.proiectandroid;

//clasa cu care vom construi obiecte pe care le vom popula cu info din XML
public class FurnizorInfo {
    private String adresa;
    private String oras;
    private String judet;
    private String denumire;
    private String categorie;
    private String telefon;
    private String codPostal;
    private String utilitate;
    private String fax;
    private String email;

    public FurnizorInfo() {
    }

    public FurnizorInfo(String adresa, String oras, String judet, String denumire, String categorie, String telefon, String codPostal, String utilitate, String fax, String email) {
        this.adresa = adresa;
        this.oras = oras;
        this.judet = judet;
        this.denumire = denumire;
        this.categorie = categorie;
        this.telefon = telefon;
        this.codPostal = codPostal;
        this.utilitate = utilitate;
        this.fax = fax;
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getUtilitate() {
        return utilitate;
    }

    public void setUtilitate(String utilitate) {
        this.utilitate = utilitate;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FurnizorInfo{" +
                "adresa='" + adresa + '\'' +
                ", oras='" + oras + '\'' +
                ", judet='" + judet + '\'' +
                ", denumire='" + denumire + '\'' +
                ", categorie='" + categorie + '\'' +
                ", telefon='" + telefon + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", utilitate='" + utilitate + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//definire interfaata DAO
@Dao
public interface DAO {

    //definire operatii DML

    //furnizor
    @Insert
    public void insertFurnizor(Furnizori furnizor);

    @Insert
    public void insertFacturaPlatita(FacturaPlatita facturaPlatita);

    @Query("SELECT ID FROM Furnizori WHERE Denumire = :denumireFurnizor")
    public int getFurnizor(String denumireFurnizor);

    @Query("SELECT Denumire FROM Furnizori WHERE ID = :idFurnizor")
    public String getDenumireFurnizor(int idFurnizor);

    @Query("DELETE FROM Furnizori")
    public void deleteListaFurnizori();

    //istoric facturi
    @Query("DELETE FROM Istoric_Facturi")
    public void deleteIstoric();

    @Query("SELECT * FROM Istoric_Facturi")
    public List<FacturaPlatita> getListaFacturi();

    @Query("SELECT COUNT (*) FROM Istoric_Facturi")
    public int getNrTotalFacturiPlatite();

    //verificam numarul de facturi de la fiecare furnizor din istoric facturi
    @Query("SELECT COUNT (*) FROM Istoric_Facturi WHERE Furnizor = :idFurnizor")
    public int getNumarFacturi(int idFurnizor);

    //factura nationala
    @Insert
    public void insertFacturaNat(FacturaNationala facturaNationala);

    @Query("SELECT * FROM Factura_Nationala")
    public List<FacturaNationala> getListaFacturiNationale();

    @Query("SELECT Serie FROM Factura_Nationala")
    public List<String> getListaSeriiNat();

    @Query("SELECT ID FROM Factura_Nationala WHERE Serie = :serieFactNat")
    public int getIdFactNat(String serieFactNat);

    @Query("DELETE FROM Factura_Nationala WHERE ID = :idFacturaNat")
    public void deleteFactNat(int idFacturaNat);

    @Query("DELETE FROM Factura_Nationala")
    public void deleteFactNat();

    @Query("UPDATE Factura_Nationala SET Denumire=:den, Total_Plata=:plata, Serie=:serie, Data_Scadenta=:data, Tip_Factura=:tip WHERE ID=:idFacturaNat")
    public void updateFactNat(String den,Float plata,String serie,String data,String tip,int idFacturaNat);

    @Query("SELECT COUNT (*) FROM factura_nationala")
    public int getNrTotalFacturiNationale();

    //factura internationala
    @Insert
    public void insertFacturaInt(FacturaInt facturaInt);

    @Query("SELECT Serie FROM Factura_Internationala")
    public List<String> getListaSeriiInt();

    @Query("SELECT ID FROM factura_internationala WHERE Serie = :serieFactInt")
    public int getIdFactInt(String serieFactInt);

    @Query("SELECT * FROM factura_internationala")
    public List<FacturaInt> getListaFacturiInternationale();

    @Query("DELETE FROM Factura_Internationala WHERE ID = :idFacturaInt")
    public void deleteFactInt(int idFacturaInt);

    @Query("DELETE FROM Factura_Internationala")
    public void deleteFactInt();

    @Query("UPDATE Factura_Internationala SET Denumire=:den, Total_Plata=:plata, Serie=:serie, Data_Scadenta=:data,Moneda=:moneda,Tip_Factura=:tip WHERE ID=:idFacturaInt")
    public void updateFactInt(String den,Float plata,String serie,String data,String moneda,String tip,int idFacturaInt);

    @Query("SELECT COUNT (*) FROM factura_internationala")
    public int getNrTotalFacturiInternationale();

}

package com.example.proiectandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.transform.Result;

public class Formular extends AppCompatActivity  {

    private Button btnDataEmitere;
    private TextView tvEmitere;
    private Button btnDataScadenta;
    private TextView tvDataScadenta;
    private Intent intent;
    private final String DATE_FORMAT="dd/mm/yyyy";
    Spinner spinner;
    LinearLayout layoutFormular;
    Typeface typeface;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);

        layoutFormular = findViewById(R.id.layoutFormular);

        ///-----SHARED PREFERENCES-------////////
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color=sharedPreferences.getString("culoare","black");
        if(!sharedPreferences.getString("font","-").equals("-"))
        {
            //doar daca ne schimbam fontul
            Settings.font=sharedPreferences.getString("font","-");

            if(Settings.font.equals("Artifika"))
            {
                typeface= ResourcesCompat.getFont(this, R.font.artifika);

            }
            if(Settings.font.equals("Autor"))
            {
                typeface= ResourcesCompat.getFont(this, R.font.autour_one);
            }
            if(Settings.font.equals("Petrona"))
            {
                typeface= ResourcesCompat.getFont(this, R.font.petrona);
            }
        }

        layoutFormular = findViewById(R.id.layoutFormular);

        for(int i=0; i< layoutFormular.getChildCount(); i++){
            if(layoutFormular.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormular.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }
        LinearLayout layoutFormCamp1;
        LinearLayout layoutFormCamp2;
        LinearLayout layoutFormCamp3;
        LinearLayout layoutFormCamp4;
        LinearLayout layoutFormCamp5;
        LinearLayout layoutFormCamp6;
        LinearLayout layoutFormCamp7;
        LinearLayout layoutFormCamp8;
        LinearLayout layoutFormCamp9;
        LinearLayout layoutFormCamp10;
        RadioGroup radioGroupMonedaColor=findViewById(R.id.RadioGroupMoneda);
        RadioGroup radioGroupFormularColor=findViewById(R.id.RadioGroupFormular);


        layoutFormCamp1=findViewById(R.id.layoutFormCamp1);
        layoutFormCamp2=findViewById(R.id.layoutFormCamp2);
        layoutFormCamp3=findViewById(R.id.layoutFormCamp3);
        layoutFormCamp4=findViewById(R.id.layoutFormCamp4);
        layoutFormCamp5=findViewById(R.id.layoutFormCamp5);
        layoutFormCamp6=findViewById(R.id.layoutFormCamp6);
        layoutFormCamp7=findViewById(R.id.layoutFormCamp7);
        layoutFormCamp8=findViewById(R.id.layoutFormCamp8);
        layoutFormCamp9=findViewById(R.id.layoutFormCamp9);
        layoutFormCamp10=findViewById(R.id.layoutFormCamp10);


        for(int i=0; i< layoutFormCamp1.getChildCount(); i++){
            if(layoutFormCamp1.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp1.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }


        for(int i=0; i< layoutFormCamp2.getChildCount(); i++){
            if(layoutFormCamp2.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp2.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }

        for(int i=0; i< layoutFormCamp3.getChildCount(); i++){
            if(layoutFormCamp3.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp3.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }
        for(int i=0; i< layoutFormCamp4.getChildCount(); i++){
            if(layoutFormCamp4.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp4.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }

        for(int i=0; i< layoutFormCamp5.getChildCount(); i++){
            if(layoutFormCamp5.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp5.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }
        for(int i=0; i< layoutFormCamp6.getChildCount(); i++){
            if(layoutFormCamp6.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp6.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }

        for(int i=0; i< layoutFormCamp7.getChildCount(); i++){
            if(layoutFormCamp7.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp7.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }


        for(int i=0; i< layoutFormCamp8.getChildCount(); i++){
            if(layoutFormCamp8.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp8.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }

        for(int i=0; i< layoutFormCamp9.getChildCount(); i++){
            if(layoutFormCamp9.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutFormCamp9.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }

        Button btnData = findViewById(R.id.btnDataScadenta);

        if(Settings.color.equals("Negru")){
            btnData.setTextColor(Color.BLACK);
            btnData.setTypeface(typeface);
        }
        if(Settings.color.equals("Alb")){
            btnData.setTextColor(Color.WHITE);
            btnData.setTypeface(typeface);
        }
        if(Settings.color.equals("Gri")){
            btnData.setTextColor(Color.GRAY);
            btnData.setTypeface(typeface);
        }
        if(Settings.color.equals("Rosu")){
            btnData.setTextColor(Color.RED);
            btnData.setTypeface(typeface);
        }

        for(int i=0; i< radioGroupFormularColor.getChildCount(); i++){
            if(radioGroupFormularColor.getChildAt(i) instanceof RadioButton){
                RadioButton tv = (RadioButton) radioGroupFormularColor.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }
        for(int i=0; i< radioGroupMonedaColor.getChildCount(); i++){
            if(radioGroupMonedaColor.getChildAt(i) instanceof RadioButton){
                RadioButton tv = (RadioButton) radioGroupMonedaColor.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                    tv.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                    tv.setTypeface(typeface);
                }
            }
        }


        if(Settings.theme == true){
            layoutFormular.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
        }
        ///-----SHARED PREFERENCES-------////////
        final RadioGroup radioGroupMoneda = findViewById(R.id.RadioGroupMoneda);

        //verificam daca suntem pe modul de adaugare si ce tip de factura adaugam
        if(getIntent() != null && getIntent().getStringExtra("tip_factura") != null && getIntent().getStringExtra("tip_factura").equals("national")){

            //suntem pe modul de adaugare a unei facturi nationale
            Button btnEditare = findViewById(R.id.editareBtn);
            btnEditare.setVisibility(Button.GONE);

            RadioButton radioButtonRON = findViewById(R.id.Moneda1); //RON
            radioButtonRON.setChecked(true);

            RadioButton radioButtonEUR = findViewById(R.id.Moneda2); //EUR
            radioButtonEUR.setEnabled(false);

            RadioButton radioButtonUSD = findViewById(R.id.Moneda3); //USD
            radioButtonUSD.setEnabled(false);

            RadioButton radioButtonGBP = findViewById(R.id.Moneda4); //GBP
            radioButtonGBP.setEnabled(false);

            //----adaugarea de furnziori la spinner---
            final Spinner spinnerFurnNat=findViewById(R.id.spinnerFurnizori);
            ArrayAdapter arrayAdapterFurnizori=new ArrayAdapter(this, android.R.layout.simple_list_item_1,Factura.furnizori){
                @Override
                public boolean isEnabled(int position) {
                    if(position==14 || position==13 || position==12)
                    {
                        return false;
                    }

                    return super.isEnabled(position);
                }
            };
            spinnerFurnNat.setAdapter(arrayAdapterFurnizori);


        }

        else {
            if(getIntent() != null && getIntent().getExtras().getParcelable("factura_editata_nat") != null){

                //------------suntem pe modul de editare a unei facturi nationale--------
                Button btnAdaugare = findViewById(R.id.adaugaBtn);
                btnAdaugare.setVisibility(Button.GONE);

                RadioButton radioButtonRON = findViewById(R.id.Moneda1); //RON
                radioButtonRON.setChecked(true);

                RadioButton radioButtonEUR = findViewById(R.id.Moneda2); //EUR
                radioButtonEUR.setEnabled(false);

                RadioButton radioButtonUSD = findViewById(R.id.Moneda3); //USD
                radioButtonUSD.setEnabled(false);

                RadioButton radioButtonGBP = findViewById(R.id.Moneda4); //GBP
                radioButtonGBP.setEnabled(false);


                final EditText etDenumire=findViewById(R.id.etDenumirefactura);
                final EditText etPret=findViewById(R.id.etPretFactura);
                final EditText etserieFactura=findViewById(R.id.etSerieFactura);
                final TextView tvDataScadenta=findViewById(R.id.tvDataScadenta);
                final RadioGroup radioGroup=findViewById(R.id.RadioGroupFormular);
                RadioButton radioButtonTiparita = findViewById(R.id.Opt1);
                RadioButton radioButtonDigitala = findViewById(R.id.Opt2);


                Bundle bundle_facturi = getIntent().getExtras();
                final Factura factura_editata = bundle_facturi.getParcelable("factura_editata_nat");

                etDenumire.setText(factura_editata.getDenumireFactura());
                String furnizor_factura = factura_editata.getFurnizorFactura();
                spinner =findViewById(R.id.spinnerFurnizori);
                for(int i=0; i<Factura.furnizori.length; i++){
                    if(furnizor_factura.equals(Factura.furnizori[i])){
                        spinner.setSelection(i);
                    }
                }
                etPret.setText(factura_editata.getPretFactura()+"");
                etserieFactura.setText(factura_editata.getSerieFactura());
                tvDataScadenta.setText(factura_editata.getDataScadentaFactura());

                String tip_factura = factura_editata.getTipFactura();
                if(tip_factura.equals(radioButtonTiparita.getText().toString())){
                    radioButtonTiparita.setChecked(true);
                }
                else{
                    radioButtonDigitala.setChecked(true);
                }

                //adaugarea de furnziori la spinner
                final Spinner spinnerFurnizori=findViewById(R.id.spinnerFurnizori);
                ArrayAdapter arrayAdapterFurnizori=new ArrayAdapter(this, android.R.layout.simple_list_item_1,Factura.furnizori){
                    @Override
                    public boolean isEnabled(int position) {
                        if(position >= 0 && position <=15)
                        {
                            return false;
                        }

                        return super.isEnabled(position);
                    }
                };

                //furnizorul nu se poate edita, spinnerul este dezactivat in mod editare
                spinnerFurnizori.setEnabled(false);

                spinnerFurnizori.setAdapter(arrayAdapterFurnizori);


                //tratam evenimentul de click pe butonul de editare factura
                Button editareBtn = findViewById(R.id.editareBtn);
                editareBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int idFactEditata = MainActivity.getFacturiDB().getDAO().getIdFactNat(factura_editata.getSerieFactura());


                        int radioGroupId = radioGroup.getCheckedRadioButtonId();
                        RadioButton rbSelectat = findViewById(radioGroupId);
                        //----actualizam factura----
                        MainActivity.getFacturiDB().getDAO().updateFactNat(etDenumire.getText().toString(),
                                Float.parseFloat(etPret.getText().toString()),etserieFactura.getText().toString(),
                                tvDataScadenta.getText().toString(), rbSelectat.getText().toString(),idFactEditata);

                        Intent it = new Intent();
                        it.putExtra("mod_editare",205);
                        setResult(RESULT_OK);

                        finish();
                    }
                });


            }
            else
            {
                //daca editam o factura internationala
                if(getIntent() != null && getIntent().getExtras().getParcelable("factura_editata_int") != null){
                    Button btnAdaugare = findViewById(R.id.adaugaBtn);
                    btnAdaugare.setVisibility(Button.GONE);
                    RadioButton radioButtonRON = findViewById(R.id.Moneda1); //RON
                    radioButtonRON.setEnabled(false);

                    RadioButton radioButtonEUR = findViewById(R.id.Moneda2); //EUR


                    RadioButton radioButtonUSD = findViewById(R.id.Moneda3); //USD


                    RadioButton radioButtonGBP = findViewById(R.id.Moneda4); //GBP




                    final EditText etDenumire=findViewById(R.id.etDenumirefactura);
                    final EditText etPret=findViewById(R.id.etPretFactura);
                    final EditText etserieFactura=findViewById(R.id.etSerieFactura);
                    final TextView tvDataScadenta=findViewById(R.id.tvDataScadenta);
                    final RadioGroup radioGroup=findViewById(R.id.RadioGroupFormular);
                    RadioButton radioButtonTiparita = findViewById(R.id.Opt1);
                    RadioButton radioButtonDigitala = findViewById(R.id.Opt2);


                    Bundle bundle_facturi = getIntent().getExtras();
                    final Factura factura_editata = bundle_facturi.getParcelable("factura_editata_int");

                    switch (factura_editata.getMoneda())
                    {
                        case "EUR":
                            radioButtonEUR.setChecked(true);
                        case "USD":
                            radioButtonUSD.setChecked(true);
                        case "GBP":
                            radioButtonGBP.setChecked(true);
                    }
                    etDenumire.setText(factura_editata.getDenumireFactura());
                    String furnizor_factura = factura_editata.getFurnizorFactura();

                    spinner =findViewById(R.id.spinnerFurnizori);
                    for(int i=0; i<Factura.furnizori.length; i++){
                        if(furnizor_factura.equals(Factura.furnizori[i])){
                            spinner.setSelection(i);
                        }
                    }
                    etPret.setText(factura_editata.getPretFactura()+"");
                    etserieFactura.setText(factura_editata.getSerieFactura());
                    tvDataScadenta.setText(factura_editata.getDataScadentaFactura());

                    String tip_factura = factura_editata.getTipFactura();
                    if(tip_factura.equals(radioButtonTiparita.getText().toString())){
                        radioButtonTiparita.setChecked(true);
                    }
                    else{
                        radioButtonDigitala.setChecked(true);
                    }

                    //adaugarea de furnziori la spinner
                    final Spinner spinnerFurnizori=findViewById(R.id.spinnerFurnizori);
                    ArrayAdapter arrayAdapterFurnizori=new ArrayAdapter(this, android.R.layout.simple_list_item_1,Factura.furnizori){
                        @Override
                        public boolean isEnabled(int position) {
                            if(position >= 13 && position <=15)
                            {
                                return false;
                            }

                            return super.isEnabled(position);
                        }
                    };
                    String furnizor=factura_editata.getFurnizorFactura();

                    spinnerFurnizori.setSelection(13);

                    spinnerFurnizori.setAdapter(arrayAdapterFurnizori);


                    Button editareBtn = findViewById(R.id.editareBtn);
                    editareBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int idFactEditata = MainActivity.getFacturiDB().getDAO().getIdFactInt(factura_editata.getSerieFactura());


                            int radioGroupId = radioGroup.getCheckedRadioButtonId();
                            RadioButton rbSelectat = findViewById(radioGroupId);
                            RadioButton monedaSelect=findViewById(radioGroupMoneda.getCheckedRadioButtonId());

                            MainActivity.getFacturiDB().getDAO().updateFactInt(etDenumire.getText().toString(),
                                    Float.parseFloat(etPret.getText().toString()),etserieFactura.getText().toString(),
                                    tvDataScadenta.getText().toString(), monedaSelect.getText().toString(),rbSelectat.getText().toString(),idFactEditata);

                            Intent it = new Intent();
                            it.putExtra("mod_editare",206);
                            setResult(RESULT_OK);
                            finish();
                        }
                    });


                }
                else
                {
                    {
                        //daca adaugam o factura internationala
                        Button btnEditare = findViewById(R.id.editareBtn);
                        btnEditare.setVisibility(Button.GONE);

                        RadioButton radioButtonRON = findViewById(R.id.Moneda1); //RON
                        radioButtonRON.setEnabled(false);

                        //adaugarea de furnziori la spinner
                        final Spinner spinnerFurnInt=findViewById(R.id.spinnerFurnizori);

                        ArrayAdapter arrayAdapterFurnizori=new ArrayAdapter(this, android.R.layout.simple_list_item_1,Factura.furnizori){
                            @Override
                            public boolean isEnabled(int position) {
                                if(position >= 0 && position < 12)
                                {
                                    return false;
                                }

                                return super.isEnabled(position);
                            }
                        };

                        spinnerFurnInt.setAdapter(arrayAdapterFurnizori);
                        //sa fie selectat primul furnizor international cand se deschide activitatea
                        spinnerFurnInt.setSelection(12);
                    }
                }
            }


        }



        Button adaugaBtn = findViewById(R.id.adaugaBtn);
        //tratarea butonului de adauga factura
        adaugaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText etDenumire=findViewById(R.id.etDenumirefactura);
                spinner = findViewById(R.id.spinnerFurnizori);
                String furnizor=spinner.getSelectedItem().toString();
                EditText etPret=findViewById(R.id.etPretFactura);
                EditText etserieFactura=findViewById(R.id.etSerieFactura);
                RadioGroup radioGroupMoneda = findViewById(R.id.RadioGroupMoneda);
                RadioButton radioButtonMoneda = findViewById(radioGroupMoneda.getCheckedRadioButtonId());
                TextView tvDataScadenta=findViewById(R.id.tvDataScadenta);
                RadioGroup radioGroup=findViewById(R.id.RadioGroupFormular);
                RadioButton radioButton=findViewById(radioGroup.getCheckedRadioButtonId());



                if(etDenumire.getText()==null || etDenumire.getText().toString().isEmpty()||
                        etPret.getText()==null || etPret.getText().toString().isEmpty()||
                        etserieFactura.getText()==null || radioButtonMoneda == null || etserieFactura.getText().toString().isEmpty()||
                        tvDataScadenta.getText().toString().isEmpty() || radioButton==null)
                {
                    AlertDialog dialog=new AlertDialog.Builder(Formular.this).setTitle(R.string.titluDialogComepletareCampuri)
                            .setMessage(R.string.mesajDialogComepletareCampuri)
                            .setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).create();
                    dialog.show();
                    return;
                }

                String tipFactura=radioButton.getText().toString();
                String monedaPlata = radioButtonMoneda.getText().toString();

                final Factura factura=new Factura(etDenumire.getText().toString(),
                        furnizor,Float.parseFloat(etPret.getText().toString()),
                        etserieFactura.getText().toString(),tvDataScadenta.getText().toString(),
                        tipFactura,radioButtonMoneda.getText().toString());


                if(getIntent() != null && getIntent().getStringExtra("tip_factura")!=null && getIntent().getStringExtra("tip_factura").equals("national")){
                    Intent intent=new Intent();
                    //factura.setMoneda("RON");

                    //verificam ca seria facturii nationale este unica
                    List<String> listaSeriiNat = new ArrayList<>();
                    listaSeriiNat = MainActivity.getFacturiDB().getDAO().getListaSeriiNat();
                    if(listaSeriiNat.contains(factura.getSerieFactura())){
                        AlertDialog dialog = new AlertDialog.Builder(Formular.this).setTitle(R.string.titluDialogSerie)
                                .setMessage(R.string.mesajDialogSerie).setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).create();
                        dialog.show();
                        return;
                    }


                    int idFurnizor = MainActivity.getFacturiDB().getDAO().getFurnizor(factura.getFurnizorFactura());

                    FacturaNationala factNat = new FacturaNationala(factura.getDenumireFactura(),idFurnizor,
                            factura.getPretFactura(), factura.getSerieFactura(),factura.getDataScadentaFactura(),factura.getTipFactura(), factura.getMoneda());
                    MainActivity.getFacturiDB().getDAO().insertFacturaNat(factNat);

                    intent.putExtra("factura",factura);
                    setResult(RESULT_OK,intent);
                    finish();
                }
                else {
                    //trebuie sa adaug o factura internationala

                    Intent intent=new Intent();
                    final String monedaInt = radioButtonMoneda.getText().toString();
                    factura.setMoneda(monedaInt);

                    //verificam ca seria facturii internationale este unica
                    List<String> listaSeriiInt = new ArrayList<>();
                    listaSeriiInt = MainActivity.getFacturiDB().getDAO().getListaSeriiInt();
                    if(listaSeriiInt.contains(factura.getSerieFactura())){
                        AlertDialog dialog = new AlertDialog.Builder(Formular.this).setTitle(R.string.titluDialogSerie)
                                .setMessage(R.string.mesajDialogSerie).setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).create();
                        dialog.show();
                        return;
                    }

                    // preluam cursul valutar curent pentru a realiza conversia in RON a pretului
                    final ValutaCurenta valutaCurenta=new ValutaCurenta(){
                        @Override
                        protected void onPostExecute(InputStream inputStream) {
                            switch (factura.getMoneda())
                            {
                                case "EUR":
                                    float pretInEur=factura.getPretFactura();
                                    float pretInLei=ValutaCurenta.moneda.getEUR()*pretInEur;
                                    factura.setPretFactura(pretInLei);
                                    break;
                                case "GBP":
                                    float pretInGBP=factura.getPretFactura();
                                    float pretDinGBPINLEI=ValutaCurenta.moneda.getGBP()*pretInGBP;
                                    factura.setPretFactura(pretDinGBPINLEI);
                                    break;
                                case"USD":
                                    float pretInUSD=factura.getPretFactura();
                                    float pretDinUSDINLEI=ValutaCurenta.moneda.getUSD()*pretInUSD;
                                    factura.setPretFactura(pretDinUSDINLEI);
                                    break;
                                case "RON":
                                    factura.setPretFactura(factura.getPretFactura());
                                    break;

                            }

                            Intent intent1= new Intent();
                            intent1.putExtra("numeFacturaInternationala",factura);
                            setResult(RESULT_OK,intent1);

                            int idFurnizor = MainActivity.getFacturiDB().getDAO().getFurnizor(factura.getFurnizorFactura());

                            FacturaInt factInt = new FacturaInt(factura.getDenumireFactura(),idFurnizor,
                                    factura.getPretFactura(), factura.getSerieFactura(),factura.getDataScadentaFactura(),factura.getTipFactura(),factura.getMoneda());
                            MainActivity.getFacturiDB().getDAO().insertFacturaInt(factInt);

                            finish();


                            super.onPostExecute(inputStream);
                        }
                    };

                        try {
                            valutaCurenta.execute(new URL("https://www.bnr.ro/nbrfxrates.xml"));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                }

            }
        });



        btnDataScadenta=findViewById(R.id.btnDataScadenta);
        tvDataScadenta=findViewById(R.id.tvDataScadenta);
        btnDataScadenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                DatePickerDialog datePickerDialog=new DatePickerDialog(Formular.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int luna = month+1;
                        String dataScadenta=dayOfMonth+"/"+luna+"/"+year;

                        tvDataScadenta.setText(dataScadenta);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

    }

}
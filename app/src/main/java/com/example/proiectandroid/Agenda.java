package com.example.proiectandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Agenda extends AppCompatActivity {
        CalendarView calendarView;
        DrawerLayout drawerLayout;
        int nrTotalFacturiPlatite;
    LinearLayout header;
    LinearLayout menu;

    LinearLayout layoutColor;
    LinearLayout layoutOpt1;
    LinearLayout layoutOpt2;
    LinearLayout layoutOpt3;
    LinearLayout layoutOpt4;
    LinearLayout layoutOpt5;
    LinearLayout layoutOpt6;
    LinearLayout layoutOpt7;
    LinearLayout layout;
    Typeface typeface;
    int progresReal;
    TextView tvTitlu;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);
        layout=findViewById(R.id.layoutAgenda);

        layoutOpt1=findViewById(R.id.optiuniMenu1);
        layoutOpt2=findViewById(R.id.optiuniMenu2);
        layoutOpt3=findViewById(R.id.optiuniMenu3);
        layoutOpt4=findViewById(R.id.optiuniMenu4);
        layoutOpt5=findViewById(R.id.optiuniMenu5);
        layoutOpt6=findViewById(R.id.optiuniMenu6);
        layoutOpt7=findViewById(R.id.optiuniMenu7);

        tvTitlu=findViewById(R.id.textView1);
        TextView tvEnel = findViewById(R.id.textViewEnel);
        TextView tvAqua = findViewById(R.id.textViewAqua);
        TextView tvEngie = findViewById(R.id.textViewEngie);
        TextView tvDigi = findViewById(R.id.textViewDigi);
        TextView tvVdf = findViewById(R.id.textViewVdf);
        TextView tvTelekom = findViewById(R.id.textViewTlk);
        TextView tvFan = findViewById(R.id.textViewFan);
        TextView tvSameday = findViewById(R.id.textViewSameday);
        TextView tvEon = findViewById(R.id.textViewEon);
        TextView tvOrange = findViewById(R.id.textViewOrange);
        TextView tvRcsRds = findViewById(R.id.textViewRcsRds);
        TextView tvUpc = findViewById(R.id.textViewUpc);
        TextView tvEbay = findViewById(R.id.textViewEbay);
        TextView tvAmazon = findViewById(R.id.textViewAmazon);
        TextView tvAliexpress = findViewById(R.id.textViewAliexpress);

        //--------------shared Preferences------------------
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color=sharedPreferences.getString("culoare","black");

        if(!sharedPreferences.getString("font","-").equals("-"))
        {
            //doar daca ne schimbam fontul
            Settings.font=sharedPreferences.getString("font","-");
            typeface = null;
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
        if(Settings.theme == true){
            layout.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
        if (Settings.color.equals("Negru")) {
            tvTitlu.setTextColor(Color.BLACK);
            tvTitlu.setTypeface(typeface);
            tvEngie.setTextColor(Color.BLACK);
            tvEngie.setTypeface(typeface);
            tvEnel.setTextColor(Color.BLACK);
            tvEnel.setTypeface(typeface);
            tvEbay.setTextColor(Color.BLACK);
            tvEbay.setTypeface(typeface);
            tvAliexpress.setTextColor(Color.BLACK);
            tvAliexpress.setTypeface(typeface);
            tvAqua.setTextColor(Color.BLACK);
            tvAqua.setTypeface(typeface);
            tvEon.setTextColor(Color.BLACK);
            tvEon.setTypeface(typeface);
            tvFan.setTextColor(Color.BLACK);
            tvFan.setTypeface(typeface);
            tvOrange.setTextColor(Color.BLACK);
            tvOrange.setTypeface(typeface);
            tvVdf.setTextColor(Color.BLACK);
            tvVdf.setTypeface(typeface);
            tvAmazon.setTextColor(Color.BLACK);
            tvAmazon.setTypeface(typeface);
            tvRcsRds.setTextColor(Color.BLACK);
            tvRcsRds.setTypeface(typeface);
            tvSameday.setTextColor(Color.BLACK);
            tvSameday.setTypeface(typeface);
            tvTelekom.setTextColor(Color.BLACK);
            tvTelekom.setTypeface(typeface);
            tvUpc.setTextColor(Color.BLACK);
            tvUpc.setTypeface(typeface);
            tvDigi.setTextColor(Color.BLACK);
            tvDigi.setTypeface(typeface);
        }
        if (Settings.color.equals("Alb")) {
            tvTitlu.setTextColor(Color.WHITE);
            tvTitlu.setTypeface(typeface);
            tvEngie.setTextColor(Color.WHITE);
            tvEngie.setTypeface(typeface);
            tvEnel.setTextColor(Color.WHITE);
            tvEnel.setTypeface(typeface);
            tvEbay.setTextColor(Color.WHITE);
            tvEbay.setTypeface(typeface);
            tvAliexpress.setTextColor(Color.WHITE);
            tvAliexpress.setTypeface(typeface);
            tvAqua.setTextColor(Color.WHITE);
            tvAqua.setTypeface(typeface);
            tvEon.setTextColor(Color.WHITE);
            tvEon.setTypeface(typeface);
            tvFan.setTextColor(Color.WHITE);
            tvFan.setTypeface(typeface);
            tvOrange.setTextColor(Color.WHITE);
            tvOrange.setTypeface(typeface);
            tvVdf.setTextColor(Color.WHITE);
            tvVdf.setTypeface(typeface);
            tvAmazon.setTextColor(Color.WHITE);
            tvAmazon.setTypeface(typeface);
            tvRcsRds.setTextColor(Color.WHITE);
            tvRcsRds.setTypeface(typeface);
            tvSameday.setTextColor(Color.WHITE);
            tvSameday.setTypeface(typeface);
            tvTelekom.setTextColor(Color.WHITE);
            tvTelekom.setTypeface(typeface);
            tvUpc.setTextColor(Color.WHITE);
            tvUpc.setTypeface(typeface);
            tvDigi.setTextColor(Color.WHITE);
            tvDigi.setTypeface(typeface);
        }
        if (Settings.color.equals("Gri")) {
            tvTitlu.setTextColor(Color.GRAY);
            tvTitlu.setTypeface(typeface);
            tvEngie.setTextColor(Color.GRAY);
            tvEngie.setTypeface(typeface);
            tvEnel.setTextColor(Color.GRAY);
            tvEnel.setTypeface(typeface);
            tvEbay.setTextColor(Color.GRAY);
            tvEbay.setTypeface(typeface);
            tvAliexpress.setTextColor(Color.GRAY);
            tvAliexpress.setTypeface(typeface);
            tvAqua.setTextColor(Color.GRAY);
            tvAqua.setTypeface(typeface);
            tvEon.setTextColor(Color.GRAY);
            tvEon.setTypeface(typeface);
            tvFan.setTextColor(Color.GRAY);
            tvFan.setTypeface(typeface);
            tvOrange.setTextColor(Color.GRAY);
            tvOrange.setTypeface(typeface);
            tvVdf.setTextColor(Color.GRAY);
            tvVdf.setTypeface(typeface);
            tvAmazon.setTextColor(Color.GRAY);
            tvAmazon.setTypeface(typeface);
            tvRcsRds.setTextColor(Color.GRAY);
            tvRcsRds.setTypeface(typeface);
            tvSameday.setTextColor(Color.GRAY);
            tvSameday.setTypeface(typeface);
            tvTelekom.setTextColor(Color.GRAY);
            tvTelekom.setTypeface(typeface);
            tvUpc.setTextColor(Color.GRAY);
            tvUpc.setTypeface(typeface);
            tvDigi.setTextColor(Color.GRAY);
            tvDigi.setTypeface(typeface);
        }
        if (Settings.color.equals("Rosu")) {
            tvTitlu.setTextColor(Color.RED);
            tvTitlu.setTypeface(typeface);
            tvEngie.setTextColor(Color.RED);
            tvEngie.setTypeface(typeface);
            tvEnel.setTextColor(Color.RED);
            tvEnel.setTypeface(typeface);
            tvEbay.setTextColor(Color.RED);
            tvEbay.setTypeface(typeface);
            tvAliexpress.setTextColor(Color.RED);
            tvAliexpress.setTypeface(typeface);
            tvAqua.setTextColor(Color.RED);
            tvAqua.setTypeface(typeface);
            tvEon.setTextColor(Color.RED);
            tvEon.setTypeface(typeface);
            tvFan.setTextColor(Color.RED);
            tvFan.setTypeface(typeface);
            tvOrange.setTextColor(Color.RED);
            tvOrange.setTypeface(typeface);
            tvVdf.setTextColor(Color.RED);
            tvVdf.setTypeface(typeface);
            tvAmazon.setTextColor(Color.RED);
            tvAmazon.setTypeface(typeface);
            tvRcsRds.setTextColor(Color.RED);
            tvRcsRds.setTypeface(typeface);
            tvSameday.setTextColor(Color.RED);
            tvSameday.setTypeface(typeface);
            tvTelekom.setTextColor(Color.RED);
            tvTelekom.setTypeface(typeface);
            tvUpc.setTextColor(Color.RED);
            tvUpc.setTypeface(typeface);
            tvDigi.setTextColor(Color.RED);
            tvDigi.setTypeface(typeface);
        }
         for (int i = 0; i < layout.getChildCount(); i++) {
                if (layout.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layout.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }

            for (int i = 0; i < header.getChildCount(); i++) {
                if (header.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) header.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }

            for (int i = 0; i < menu.getChildCount(); i++) {
                if (menu.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) menu.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            /////----setarea culoare si la menu////
            for (int i = 0; i < layoutOpt1.getChildCount(); i++) {
                if (layoutOpt1.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt1.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            for (int i = 0; i < layoutOpt2.getChildCount(); i++) {
                if (layoutOpt2.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt2.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            for (int i = 0; i < layoutOpt3.getChildCount(); i++) {
                if (layoutOpt3.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt3.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            for (int i = 0; i < layoutOpt4.getChildCount(); i++) {
                if (layoutOpt4.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt4.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }


            for (int i = 0; i < layoutOpt5.getChildCount(); i++) {
                if (layoutOpt5.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt5.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            for (int i = 0; i < layoutOpt6.getChildCount(); i++) {
                if (layoutOpt6.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt6.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
            for (int i = 0; i < layoutOpt7.getChildCount(); i++) {
                if (layoutOpt7.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutOpt7.getChildAt(i);
                    if (Settings.color.equals("Negru")) {
                        tv.setTextColor(Color.BLACK);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Alb")) {
                        tv.setTextColor(Color.WHITE);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Gri")) {
                        tv.setTextColor(Color.GRAY);
                        tv.setTypeface(typeface);
                    }
                    if (Settings.color.equals("Rosu")) {
                        tv.setTextColor(Color.RED);
                        tv.setTypeface(typeface);
                    }
                }
            }
        //------------sharedPreferences-------------
        drawerLayout=findViewById(R.id.drawer_layout);

        //verificam numarul de facturi de la fiecare furnizor

        //enel
        int idEnel = MainActivity.getFacturiDB().getDAO().getFurnizor("ENEL");
        int nrFacturiEnel = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idEnel);

        //aqua nova
        int idAqua = MainActivity.getFacturiDB().getDAO().getFurnizor("AQUA NOVA");
        int nrFacturiAqua = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idAqua);

        //engie
        int idEngie = MainActivity.getFacturiDB().getDAO().getFurnizor("ENGIE");
        int nrFacturiEngie = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idEngie);

        //digi
        int idDigi = MainActivity.getFacturiDB().getDAO().getFurnizor("DIGI");
        int nrFacturiDigi = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idDigi);

        //vodafone
        int idVodafone = MainActivity.getFacturiDB().getDAO().getFurnizor("VODAFONE");
        int nrFacturiVodafone = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idVodafone);

        //telekom
        int idTelekom = MainActivity.getFacturiDB().getDAO().getFurnizor("TELEKOM");
        int nrFacturiTelekom = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idTelekom);

        //fan courier
        int idFan = MainActivity.getFacturiDB().getDAO().getFurnizor("FAN COURIER");
        int nrFacturiFan = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idFan);

        //sameday
        int idSameday = MainActivity.getFacturiDB().getDAO().getFurnizor("SAMEDAY");
        int nrFacturiSameday = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idSameday);

        //eon
        int idEon = MainActivity.getFacturiDB().getDAO().getFurnizor("EON");
        int nrFacturiEon = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idEon);

        //orange
        int idOrange = MainActivity.getFacturiDB().getDAO().getFurnizor("ORANGE");
        int nrFacturiOrange = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idOrange);

        //rcs&rds
        int idRCS = MainActivity.getFacturiDB().getDAO().getFurnizor("RCS&RDS");
        int nrFacturiRCS = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idRCS);

        //upc
        int idUpc = MainActivity.getFacturiDB().getDAO().getFurnizor("UPC");
        int nrFacturiUpc = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idUpc);

        //ebay
        int idEbay = MainActivity.getFacturiDB().getDAO().getFurnizor("EBAY");
        int nrFacturiEbay = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idEbay);

        //amazon
        int idAmazon = MainActivity.getFacturiDB().getDAO().getFurnizor("AMAZON");
        int nrFacturiAmazon = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idAmazon);

        //aliexpress
        int idAliexpress = MainActivity.getFacturiDB().getDAO().getFurnizor("ALIEXPRESS");
        int nrFacturiAliexpress = MainActivity.getFacturiDB().getDAO().getNumarFacturi(idAliexpress);


        //afisare procent al facturilor platite apartinand fiecarui furnizor
        //nrTotalFact -> 100% -> tot pbWitdh;
        //nrFacturiFan -> x -> (nrFacturi * pbWidth )/nrTotal

        nrTotalFacturiPlatite = MainActivity.getFacturiDB().getDAO().getNrTotalFacturiPlatite();

        if(nrTotalFacturiPlatite!=0) {
            //enel
            ProgressBar pbEnel = findViewById(R.id.progressBarEnel);
            progresReal = (nrFacturiEnel * 100) / nrTotalFacturiPlatite;
            pbEnel.setProgress(progresReal);
            tvEnel.setText("Enel - " + progresReal + "%");

            //aqua
            ProgressBar pbAqua = findViewById(R.id.progressBarAqua);
            progresReal = (nrFacturiAqua * 100) / nrTotalFacturiPlatite;
            pbAqua.setProgress(progresReal);
            tvAqua.setText("Aqua Nova - " + progresReal + "%");

            //engie
            ProgressBar pbEngie = findViewById(R.id.progressBarEngie);
            progresReal = (nrFacturiEngie * 100) / nrTotalFacturiPlatite;
            pbEngie.setProgress(progresReal);
            tvEngie.setText("Engie - " + progresReal + "%");

            //digi
            ProgressBar pbDigi = findViewById(R.id.progressBarDigi);
            progresReal = (nrFacturiDigi * 100) / nrTotalFacturiPlatite;
            pbDigi.setProgress(progresReal);
            tvDigi.setText("Digi - " + progresReal + "%");

            //vodafone
            ProgressBar pbVdf = findViewById(R.id.progressBarVdf);
            progresReal = (nrFacturiVodafone * 100) / nrTotalFacturiPlatite;
            pbVdf.setProgress(progresReal);
            tvVdf.setText("Vodafone - " + progresReal + "%");

            //telekom
            ProgressBar pbTlk = findViewById(R.id.progressBarTlk);
            progresReal = (nrFacturiTelekom * 100) / nrTotalFacturiPlatite;
            pbTlk.setProgress(progresReal);
            tvTelekom.setText("Telekom - " + progresReal + "%");

            //fan courier
            ProgressBar pbFan = findViewById(R.id.progressBarFan);
            progresReal = (nrFacturiFan * 100) / nrTotalFacturiPlatite;
            pbFan.setProgress(progresReal);
            tvFan.setText("Fan Courier - " + progresReal + "%");

            //sameday
            ProgressBar pbSameday = findViewById(R.id.progressBarSameday);
            progresReal = (nrFacturiSameday * 100) / nrTotalFacturiPlatite;
            pbSameday.setProgress(progresReal);
            tvSameday.setText("Sameday - " + progresReal + "%");

            //eon
            ProgressBar pbEon = findViewById(R.id.progressBarEon);
            progresReal = (nrFacturiEon * 100) / nrTotalFacturiPlatite;
            pbEon.setProgress(progresReal);
            tvEon.setText("Eon - " + progresReal + "%");

            //orange
            ProgressBar pbOrange = findViewById(R.id.progressBarOrange);
            progresReal = (nrFacturiOrange * 100) / nrTotalFacturiPlatite;
            pbOrange.setProgress(progresReal);
            tvOrange.setText("Orange - " + progresReal + "%");

            //rcs&rds
            ProgressBar pbrcs = findViewById(R.id.progressBarRcsRds);
            progresReal = (nrFacturiRCS * 100) / nrTotalFacturiPlatite;
            pbrcs.setProgress(progresReal);
            tvRcsRds.setText("RCS & RDS - " + progresReal + "%");

            //upc
            ProgressBar pbUpc = findViewById(R.id.progressBarUpc);
            progresReal = (nrFacturiUpc * 100) / nrTotalFacturiPlatite;
            pbUpc.setProgress(progresReal);
            tvUpc.setText("UPC - " + progresReal + "%");

            //ebay
            ProgressBar pbEbay = findViewById(R.id.progressBarEbay);
            progresReal = (nrFacturiEbay * 100) / nrTotalFacturiPlatite;
            pbEbay.setProgress(progresReal);
            tvEbay.setText("Ebay - " + progresReal + "%");

            //amazon
            ProgressBar pbAmazon = findViewById(R.id.progressBarAmazon);
            progresReal = (nrFacturiAmazon * 100) / nrTotalFacturiPlatite;
            pbAmazon.setProgress(progresReal);
            tvAmazon.setText("Amazon - " + progresReal + "%");

            //aliexpress
            ProgressBar pbAli = findViewById(R.id.progressBarAliexpress);
            progresReal = (nrFacturiAliexpress * 100) / nrTotalFacturiPlatite;
            pbAli.setProgress(progresReal);
            tvAliexpress.setText("Aliexpress - " + progresReal + "%");
        }
    }


    //metode pt meniu

    public void clickMenu(View view)
    {
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void exitMenu(View view)
    {
        //inchidem meniul
        //intai verificam daca acesta este deschis
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void clickFeedback(View view) {
        Intent intent=new Intent(getApplicationContext(),Feedback.class);
        startActivity(intent);
    }
    public void clickHome(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void clickInternational(View view)
    {
        Intent intent=new Intent(getApplicationContext(),FacturiInternationale.class);
        startActivity(intent);
    }

    public void clickIstoric(View view)
    {
        Intent intent=new Intent(getApplicationContext(),IstoricFacturi.class);
        startActivity(intent);
    }
    public void clickAgenda(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Agenda.class);
        startActivity(intent);
        finish();
    }
    public void clickSettings(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Settings.class);
        startActivity(intent);
    }
    public void clickStatistici(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Statistici.class);
        startActivity(intent);
    }
}
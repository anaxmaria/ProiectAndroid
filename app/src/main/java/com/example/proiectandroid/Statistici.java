package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Statistici extends AppCompatActivity {
    DrawerLayout drawerLayout;

    PieChart pieChart;
    LinearLayout header;
    LinearLayout menu;
    TextView tvTitlu;
    LinearLayout layoutOpt1;
    LinearLayout layoutOpt2;
    LinearLayout layoutOpt3;
    LinearLayout layoutOpt4;
    LinearLayout layoutOpt5;
    LinearLayout layoutOpt6;
    LinearLayout layoutOpt7;
    LinearLayout layoutStatistici;
    LinearLayout layoutPieChart;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistici);

        layoutOpt1=findViewById(R.id.optiuniMenu1);
        layoutOpt2=findViewById(R.id.optiuniMenu2);
        layoutOpt3=findViewById(R.id.optiuniMenu3);
        layoutOpt4=findViewById(R.id.optiuniMenu4);
        layoutOpt5=findViewById(R.id.optiuniMenu5);
        layoutOpt6=findViewById(R.id.optiuniMenu6);
        layoutOpt7=findViewById(R.id.optiuniMenu7);
        layoutStatistici=findViewById(R.id.layoutStatistici);
        layoutPieChart=findViewById(R.id.layoutForDrawing);

        //adaugare view de tip PieChart in layout-ul din Statistici
        LinearLayout activityforDrawing = findViewById(R.id.layoutForDrawing);
        //adaugam graficul obtinut
        pieChart = new PieChart(getApplicationContext());
        activityforDrawing.addView(pieChart);

        //---------shared preferences------
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


        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);
        tvTitlu = findViewById(R.id.textViewTitlu);

        for(int i=0; i< header.getChildCount(); i++){
            if(header.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) header.getChildAt(i);
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

        for(int i=0; i< menu.getChildCount(); i++){
            if(menu.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) menu.getChildAt(i);
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

        /////----setarea culoare si la menu////
        for(int i=0; i< layoutOpt1.getChildCount(); i++){
            if(layoutOpt1.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt1.getChildAt(i);
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
        for(int i=0; i< layoutOpt2.getChildCount(); i++){
            if(layoutOpt2.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt2.getChildAt(i);
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
        for(int i=0; i< layoutOpt3.getChildCount(); i++){
            if(layoutOpt3.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt3.getChildAt(i);
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
        for(int i=0; i< layoutOpt4.getChildCount(); i++){
            if(layoutOpt4.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt4.getChildAt(i);
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


        for(int i=0; i< layoutOpt5.getChildCount(); i++){
            if(layoutOpt5.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt5.getChildAt(i);
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
        for(int i=0; i< layoutOpt6.getChildCount(); i++){
            if(layoutOpt6.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt6.getChildAt(i);
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
        for(int i=0; i< layoutOpt7.getChildCount(); i++){
            if(layoutOpt7.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt7.getChildAt(i);
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

                if(Settings.color.equals("Negru")){
                    tvTitlu.setTextColor(Color.BLACK);
                    tvTitlu.setTypeface(typeface);
                }
                if(Settings.color.equals("Alb")){
                    tvTitlu.setTextColor(Color.WHITE);
                    tvTitlu.setTypeface(typeface);
                }
                if(Settings.color.equals("Gri")){
                    tvTitlu.setTextColor(Color.GRAY);
                    tvTitlu.setTypeface(typeface);
                }
                if(Settings.color.equals("Rosu")){
                    tvTitlu.setTextColor(Color.RED);
                    tvTitlu.setTypeface(typeface);
                }

        if(Settings.theme == true){
            tvTitlu.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            layoutStatistici.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            layoutPieChart.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
        //---------shared preferences------
        drawerLayout=findViewById(R.id.drawer_layout);
    }



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
    public void clickIstoric(View view)
    {
        Intent intent=new Intent(getApplicationContext(),IstoricFacturi.class);
        startActivity(intent);
    }
    public void clickInternational(View view)
    {
        Intent intent=new Intent(getApplicationContext(),FacturiInternationale.class);
        startActivity(intent);
    }
    public void clickAgenda(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Agenda.class);
        startActivity(intent);
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
        finish();
    }
}
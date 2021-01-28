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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {
    static DrawerLayout drawerLayout;
    static boolean theme;
    static String font = "Monospace";
    static String color ;
    static boolean changeColor;
    LinearLayout header;
    LinearLayout menu;
    LinearLayout layoutSetari;
    LinearLayout layoutSettings1;
    LinearLayout layoutSettings2;
    LinearLayout layoutSettings3;
    LinearLayout layoutSettings4;
    LinearLayout layoutSettings5;
    LinearLayout layoutSettings6;





    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        layoutSetari = findViewById(R.id.layoutSettings);
        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);


        drawerLayout=findViewById(R.id.drawer_layout);

        //-----SHARED PREFERENCES----//////////
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        theme = sharedPreferences.getBoolean("darkTheme", false);
        color=sharedPreferences.getString("culoare","black");
        if(!sharedPreferences.getString("font","-").equals("-"))
        {
            //doar daca ne schimbam fontul
            font=sharedPreferences.getString("font","-");
            setareCuloareSiFont();
        }


        setareCuloareSiFont();

        //switch dark theme
        final Switch switchTheme = findViewById(R.id.switchTheme);
        if(theme == true){
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            layoutSetari.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            switchTheme.setChecked(true);
        }
        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchTheme.isChecked()){
                    theme = true;

                    //change theme
                    header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
                    menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
                    layoutSetari.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
                    salvareSetare();
                }
                else{
                    theme = false;

                    //change theme
                    header.setBackgroundColor(getResources().getColor(R.color.headerColor));
                    menu.setBackgroundColor(getResources().getColor(R.color.menu));
                    layoutSetari.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
                    switchTheme.setChecked(false);

                    //shared preferences
                    salvareSetare();
                }
            }
        });

        //modificare textColor






        final RadioGroup radioGroupCuloare = findViewById(R.id.RadioGroupCuloare);

        final RadioButton radioButtonNegru=findViewById(R.id.rbCuloare1);
        final RadioButton radioButtonALB=findViewById(R.id.rbCuloare2);
        final RadioButton radioButtonGri=findViewById(R.id.rbCuloare3);
        final RadioButton radioButtonRosu=findViewById(R.id.rbCuloare4);
        if(color.equals("Alb"))
        {
            radioButtonALB.setChecked(true);
        }
        if(color.equals("Negru"))
        {
            radioButtonNegru.setChecked(true);
        }
        if(color.equals("Gri"))
        {
            radioButtonGri.setChecked(true);
        }
        if(color.equals("Rosu"))
        {
            radioButtonRosu.setChecked(true);
        }
        radioGroupCuloare.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==radioButtonALB.getId())
                {
                    color="Alb";
                    salvareSetare();
                    changeColor=true;
                    setareCuloareSiFont();



                }
                if(checkedId==radioButtonNegru.getId())
                {
                    color="Negru";
                    salvareSetare();
                    changeColor=true;
                    setareCuloareSiFont();

                }
                if(checkedId==radioButtonGri.getId())
                {
                    color="Gri";
                    salvareSetare();
                    changeColor=true;
                    setareCuloareSiFont();

                }
                if(checkedId==radioButtonRosu.getId())
                {
                    color="Rosu";
                    salvareSetare();
                    changeColor=true;
                    setareCuloareSiFont();

                }

            }
        });

        //-----SHARED PREFERENCES----//////////







        //-----setare font-//////
        RadioGroup radioGroupFont=findViewById(R.id.RadioGroupFont);
        final RadioButton radioButtonArtifika=findViewById(R.id.rbFont1);
        final RadioButton radioButtonAutor=findViewById(R.id.rbFont2);
        final RadioButton radioButtonPetrona=findViewById(R.id.rbFont3);
        //---pastratea ultimei optiuni selectate la revenirea in activitate
        if(font.equals("Artifika"))
        {
            radioButtonArtifika.setChecked(true);
        }
        if(font.equals("Autor"))
        {
            radioButtonAutor.setChecked(true);
        }

        if(font.equals("Petrona"))
        {
            radioButtonPetrona.setChecked(true);
        }

        radioGroupFont.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==radioButtonArtifika.getId())
                {
                    font="Artifika";
                    setareCuloareSiFont();
                    salvareSetare();

                }
                if(checkedId==radioButtonAutor.getId())
                {
                    font="Autor";
                    setareCuloareSiFont();
                    salvareSetare();


                }
                if(checkedId==radioButtonPetrona.getId())
                {
                      font="Petrona" ;
                      setareCuloareSiFont();
                    salvareSetare();


                }

            }
        });
        //checkbox- golirea tabelei istoric_facturi
        CheckBox checkBoxDelete = findViewById(R.id.deleteDataBase);
        checkBoxDelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    MainActivity.getFacturiDB().getDAO().deleteIstoric();
                    isChecked = false;
                }
            }
        });
        //checkbox- golirea tabeleleor Factura_Nationala si Factura_Internationala
        CheckBox checkBoxDeleteFacturi = findViewById(R.id.deleteListeFacturi);
        checkBoxDeleteFacturi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    MainActivity.getFacturiDB().getDAO().deleteFactNat();
                    MainActivity.getFacturiDB().getDAO().deleteFactInt();
                    isChecked = false;
                }
            }
        });

    }

    //shared preferences
    public void salvareSetare(){
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("culoare",color);
        editor.putBoolean("darkTheme", theme);
        editor.putString("font",font);

        editor.apply();
    }

    //metodele pentru meniu

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
    }
    public void clickSettings(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Settings.class);
        startActivity(intent);
        finish();
    }
    public void clickStatistici(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Statistici.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setareCuloareSiFont()
    {
        Typeface typeface = null;
        if(font.equals("Artifika"))
        {
            typeface= ResourcesCompat.getFont(this, R.font.artifika);

        }
        if(font.equals("Autor"))
        {
            typeface= ResourcesCompat.getFont(this, R.font.autour_one);
        }
        if(font.equals("Petrona"))
        {
            typeface= ResourcesCompat.getFont(this, R.font.petrona);
        }
        ///---setare culoare meniu---
        LinearLayout layoutOpt1 = findViewById(R.id.optiuniMenu1);
        LinearLayout layoutOpt2 = findViewById(R.id.optiuniMenu2);
        LinearLayout layoutOpt3 = findViewById(R.id.optiuniMenu3);
        LinearLayout layoutOpt4 = findViewById(R.id.optiuniMenu4);
        LinearLayout layoutOpt5 = findViewById(R.id.optiuniMenu5);
        LinearLayout layoutOpt6 = findViewById(R.id.optiuniMenu6);
        LinearLayout layoutOpt7 = findViewById(R.id.optiuniMenu7);
        layoutSettings1=findViewById(R.id.layoutSettings1);
        layoutSettings2=findViewById(R.id.layoutSettings2);

        layoutSettings4=findViewById(R.id.layoutSettings4);

        layoutSettings5=findViewById(R.id.layoutSettings5);
        layoutSettings6=findViewById(R.id.layoutSettings6);

        for(int i=0; i< layoutSettings1.getChildCount(); i++){
            if(layoutSettings1.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSettings1.getChildAt(i);
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

        for(int i=0; i< layoutSettings2.getChildCount(); i++){
            if(layoutSettings2.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSettings2.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }





        for(int i=0; i< layoutSettings4.getChildCount(); i++){
            if(layoutSettings4.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSettings4.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }

        for(int i=0; i< layoutSettings5.getChildCount(); i++){
            if(layoutSettings5.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSettings5.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }


        for(int i=0; i< layoutSettings6.getChildCount(); i++){
            if(layoutSettings6.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSettings6.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }



        for(int i=0; i< layoutSetari.getChildCount(); i++){
            if(layoutSetari.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutSetari.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }

        for(int i=0; i< header.getChildCount(); i++){
            if(header.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) header.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }

        for(int i=0; i< menu.getChildCount(); i++){
            if(menu.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) menu.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
                }
            }
        }
        /////----setarea culoare si la menu////
        for(int i=0; i< layoutOpt1.getChildCount(); i++){
            if(layoutOpt1.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layoutOpt1.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTypeface(typeface);
                    tv.setTextColor(Color.RED);
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


    }


}

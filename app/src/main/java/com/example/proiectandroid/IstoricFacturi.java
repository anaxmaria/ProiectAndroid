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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class IstoricFacturi extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private  static List<Factura> facturiPlatite=new ArrayList<Factura>();
    public ListView lvFacturiPlatite;
    public static FacturaAdapter facturaAdapterIstoric;
    private static List<FacturaPlatita> facturiPlatiteDB = new ArrayList<>();
    private IstoricFacturi istoricFacturi;

    ScrollView scrollView;
    LinearLayout header;
    LinearLayout menu;
    LinearLayout linearLayout;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istoric_facturi);

        ///-----SHARED PREFERENCES-----------
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color=sharedPreferences.getString("culoare","black");



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

            linearLayout = findViewById(R.id.linearLayoutIstoric);
            scrollView = findViewById(R.id.toolbal);
            header = findViewById(R.id.headerId);
            menu = findViewById(R.id.menuId);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                if (linearLayout.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) linearLayout.getChildAt(i);
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


            ///----setare culoare meniu--////
            LinearLayout layoutOpt1 = findViewById(R.id.optiuniMenu1);
            LinearLayout layoutOpt2 = findViewById(R.id.optiuniMenu2);
            LinearLayout layoutOpt3 = findViewById(R.id.optiuniMenu3);
            LinearLayout layoutOpt4 = findViewById(R.id.optiuniMenu4);
            LinearLayout layoutOpt5 = findViewById(R.id.optiuniMenu5);
            LinearLayout layoutOpt6 = findViewById(R.id.optiuniMenu6);
            LinearLayout layoutOpt7 = findViewById(R.id.optiuniMenu7);
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



        if(Settings.theme == true){
            scrollView.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
        ///-----SHARED PREFERENCES-----------
        //--tratatea evenimentului de click al butonului Statistici
        Button btnStatistics = findViewById(R.id.btnStat);
        btnStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), Statistici.class);
                startActivity(it);
            }
        });
        drawerLayout=findViewById(R.id.drawer_layout);

        lvFacturiPlatite=findViewById(R.id.lvFacturiPlatite);
        facturiPlatite.clear();
        FacturaAdapter facturaAdapterIstoric=new FacturaAdapter(this,R.layout.factura_platita_view,facturiPlatite);
        lvFacturiPlatite.setAdapter(facturaAdapterIstoric);
        facturaAdapterIstoric.notifyDataSetChanged();

        facturiPlatiteDB.clear();
            //ne populam listView-ul cu facturi existente in tabela Istoric_Facturi din ROOM
            facturiPlatiteDB = MainActivity.getFacturiDB().getDAO().getListaFacturi();

            for(int i=0; i<facturiPlatiteDB.size(); i++){
                FacturaPlatita fact=facturiPlatiteDB.get(i);
                String denFurnizor = MainActivity.getFacturiDB().getDAO().getDenumireFurnizor(fact.getIdFurnizor());
                facturiPlatite.add(new Factura(fact.getDenumireFactura(),denFurnizor, fact.getPret(),
                        fact.getSerie(),fact.getDataPlata(),fact.getTipFactura(),fact.getMoneda()));
            }

            facturaAdapterIstoric.notifyDataSetChanged();






        //extrag intent-ul cu factura platita de fiecare data cand mi se deschide activitate
        if(getIntent()!=null && getIntent().getExtras()!=null)
        {
                Bundle extras=getIntent().getExtras();
                Factura factura_platita =extras.getParcelable("Factura_Platita");

        }




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
        finish();
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
    }

    public static List<Factura> getFacturiPlatite() {
        return facturiPlatite;
    }

    public static void setFacturiPlatite(List<Factura> facturiPlatite) {
        IstoricFacturi.facturiPlatite = facturiPlatite;
    }

    public ListView getLvFacturiPlatite() {
        return lvFacturiPlatite;
    }

    public void setLvFacturiPlatite(ListView lvFacturiPlatite) {
        this.lvFacturiPlatite = lvFacturiPlatite;
    }

    public static FacturaAdapter getFacturaAdapterIstoric() {
        return facturaAdapterIstoric;
    }

    public static void setFacturaAdapterIstoric(FacturaAdapter facturaAdapterIstoric) {
        IstoricFacturi.facturaAdapterIstoric = facturaAdapterIstoric;
    }





}
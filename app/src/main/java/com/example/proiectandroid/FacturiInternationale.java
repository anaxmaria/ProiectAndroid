package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FacturiInternationale extends AppCompatActivity {

    DrawerLayout drawerLayout;

    private  static List<Factura> facturiInternationale=new ArrayList<>();
    public ListView lvFacturiInternationale;

    private static FacturaAdapter facturaAdapterInt;

    public static List<Factura> getFacturiInternationale() {
        return facturiInternationale;
    }
    private static List<FacturaInt> facturiInternationaleDB = new ArrayList<>();

    ScrollView scrollView;
    LinearLayout header;
    LinearLayout menu;
    LinearLayout linearLayout;
    LinearLayout layoutOpt1;
    LinearLayout layoutOpt2;
    LinearLayout layoutOpt3;
    LinearLayout layoutOpt4;
    LinearLayout layoutOpt5;
    LinearLayout layoutOpt6;
    LinearLayout layoutOpt7;
    Typeface typeface;

    public static void setFacturiInternationale(List<Factura> facturiInternationale) {
        FacturiInternationale.facturiInternationale = facturiInternationale;
    }

    public static FacturaAdapter getFacturaAdapter() {
        return facturaAdapterInt;
    }

    public static void setFacturaAdapter(FacturaAdapter facturaAdapterInt) {
        FacturiInternationale.facturaAdapterInt = facturaAdapterInt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturi_internationale);

        //-----SHARED PREFERENCES-----------////////////
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color=sharedPreferences.getString("culoare","black");
            if(!sharedPreferences.getString("font","-").equals("-")) {
                     //doar daca ne schimbam fontul
            Settings.font = sharedPreferences.getString("font", "-");
            typeface = null;
            if (Settings.font.equals("Artifika")) {
             typeface = ResourcesCompat.getFont(this, R.font.artifika);
                 }
             if (Settings.font.equals("Autor")) {
                typeface = ResourcesCompat.getFont(this, R.font.autour_one); }
                if (Settings.font.equals("Petrona")) { typeface = ResourcesCompat.getFont(this, R.font.petrona);
            }
            }
        scrollView = findViewById(R.id.toolbal);
        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);
        linearLayout=findViewById(R.id.linearLayout);
        layoutOpt1=findViewById(R.id.optiuniMenu1);
        layoutOpt2=findViewById(R.id.optiuniMenu2);
        layoutOpt3=findViewById(R.id.optiuniMenu3);
        layoutOpt4=findViewById(R.id.optiuniMenu4);
        layoutOpt5=findViewById(R.id.optiuniMenu5);
        layoutOpt6=findViewById(R.id.optiuniMenu6);
        layoutOpt7=findViewById(R.id.optiuniMenu7);

        ////--setare culoare text//////
        for(int i=0; i< linearLayout.getChildCount(); i++){
            if(linearLayout.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) linearLayout.getChildAt(i);
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

        if(Settings.theme == true){
            scrollView.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
              //-----SHARED PREFERENCES-----------////////////
        drawerLayout=findViewById(R.id.drawer_layout);

        //setare adapter
        facturaAdapterInt=new FacturaAdapter(getApplicationContext(),R.layout.factura_view,facturiInternationale);
        facturiInternationale.clear();
        lvFacturiInternationale=findViewById(R.id.lvFacturiInternationale);
        lvFacturiInternationale.setAdapter(facturaAdapterInt);
        facturaAdapterInt.notifyDataSetChanged();

        //adaugare facturi din DB
        if(getIntent().getExtras() == null) {
            //verificam de unde deschidem activitatea
            facturiInternationaleDB = MainActivity.getFacturiDB().getDAO().getListaFacturiInternationale();

            for (int i = 0; i < facturiInternationaleDB.size(); i++) {
                FacturaInt fact = facturiInternationaleDB.get(i);
                String denFurnizor = MainActivity.getFacturiDB().getDAO().getDenumireFurnizor(fact.getIdFurnizor());
                facturiInternationale.add(new Factura(fact.getDenumireFactura(), denFurnizor, fact.getPret(),
                        fact.getSerie(), fact.getDataScadenta(), fact.getTipFactura(), fact.getMoneda()));
            }

            facturaAdapterInt.notifyDataSetChanged();
        }

        //tratam evenimentul de click pe butonul de +
        FloatingActionButton addButton = (FloatingActionButton)findViewById(R.id.adaugaFacturaIntBtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(),Formular.class);
                it.putExtra("tip_factura","international");
                startActivityForResult(it,202);
            }
        });
        registerForContextMenu(lvFacturiInternationale);

    }
    //atasam meniul contextul listView-ului nostru
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.long_click_menu, menu);

    }

    //tratam optiunile meniului
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextMenuOp1:
                Intent it4 = new Intent(getApplicationContext(),Formular.class);
                it4.putExtra("factura_editata_int",facturiInternationale.get(FacturaAdapter.getPosition()));
                startActivityForResult(it4,206);
                return false;
            case R.id.contextMenuOp2:
                //stergere factura
                Factura factura=facturiInternationale.get(FacturaAdapter.getPosition());
                int idFactura=MainActivity.getFacturiDB().getDAO().getIdFactInt(factura.getSerieFactura());
                MainActivity.getFacturiDB().getDAO().deleteFactInt(idFactura);
                FacturiInternationale.getFacturiInternationale().remove(FacturaAdapter.getPosition());
                FacturiInternationale.getFacturaAdapter().notifyDataSetChanged();

                return false;
            case R.id.contextMenuOp3:
                //extragem furnizorul facturii respectiva
                String furnizor=facturiInternationale.get(FacturaAdapter.getPosition()).getFurnizorFactura();

                FurnizorInfo furnizorInfo = new FurnizorInfo();

                if(furnizor.equals("RCS&RDS")){
                    furnizorInfo = ExtrageFurnizoriXML.dictionarFurnizori.get("RCSRDS");
                }
                else {
                    furnizorInfo = ExtrageFurnizoriXML.dictionarFurnizori.get(furnizor);
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //facem inflate la layout
                View view=getLayoutInflater().inflate(R.layout.info_furnizor,null);

                //regasire textview-uri
                TextView tvDenumire = view.findViewById(R.id.info_denumire);
                TextView tvTip = view.findViewById(R.id.info_tip);
                TextView tvTelefon = view.findViewById(R.id.info_telefon);
                TextView tvEmail = view.findViewById(R.id.info_email);
                TextView tvFax = view.findViewById(R.id.info_fax);
                TextView tvOras = view.findViewById(R.id.info_oras);
                TextView tvCodPostal = view.findViewById(R.id.info_cod_postal);
                TextView tvAdresa = view.findViewById(R.id.info_adresa);

                //afisare informatii furnizor
                tvDenumire.setText(furnizorInfo.getDenumire());
                tvTip.setText(furnizorInfo.getCategorie());
                tvTelefon.setText(furnizorInfo.getTelefon());
                tvEmail.setText(furnizorInfo.getEmail());
                tvFax.setText(furnizorInfo.getFax());
                tvOras.setText(furnizorInfo.getOras());
                tvCodPostal.setText(furnizorInfo.getCodPostal());
                tvAdresa.setText(furnizorInfo.getAdresa());


                builder.setView(view);

                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setLayout(300, 200); //Controlling width and height.
                alertDialog.show();

            default:
                return super.onContextItemSelected(item);
        }
    }
    //verificam ce obiecte si ce coduri ne trimite inapoi formularul
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==202) //cod adauga
        {
            if(resultCode==RESULT_OK)
            {
                Bundle extras=data.getExtras();
                Factura factura=extras.getParcelable("numeFacturaInternationala");
                adaugaFacturaInter(factura);
                facturaAdapterInt.notifyDataSetChanged();
            }
        }
        if(requestCode==206) //cod editeaza
        {
            if(resultCode==RESULT_OK)
            {
                facturiInternationaleDB.clear();
                facturiInternationale.clear();
                facturaAdapterInt.notifyDataSetChanged();

                facturiInternationaleDB = MainActivity.getFacturiDB().getDAO().getListaFacturiInternationale();

                for (int i = 0; i < facturiInternationaleDB.size(); i++) {
                    FacturaInt fact = facturiInternationaleDB.get(i);
                    String denFurnizor = MainActivity.getFacturiDB().getDAO().getDenumireFurnizor(fact.getIdFurnizor());
                    facturiInternationale.add(new Factura(fact.getDenumireFactura(), fact.getDenumireFactura(), fact.getPret(),
                            fact.getSerie(), fact.getDataScadenta(), fact.getTipFactura(), fact.getMoneda()));
                }

                facturaAdapterInt.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //metoda de adaugarea a unei facturi internationale in lista noastra de facturi
    public static void adaugaFacturaInter(Factura factura)
    {
        List<Factura> facturiInternationale=FacturiInternationale.getFacturiInternationale();
        facturiInternationale.add(factura);
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
    public void clickInternational(View view)
    {
        Intent intent=new Intent(getApplicationContext(),FacturiInternationale.class);
        startActivity(intent);
        finish();
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
    }
    public void clickStatistici(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Statistici.class);
        startActivity(intent);
    }
}
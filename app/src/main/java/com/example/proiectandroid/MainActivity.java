package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    public final int cod = 200;//cod pt a adauga o factura
    public final int codEdit=201;//cod pt a edita
    private  static  List<Factura> facturi=new ArrayList<>();
    public ListView lvFacturi;
    private static FacturaAdapter facturaAdapter;
    private static DataBaseFacturi facturiDB;
    private static List<FacturaNationala> facturiNationaleDB = new ArrayList<>();

    ScrollView scrollView;
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
    Typeface typeface;



    private static boolean inserareFurnizori = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ////--------SHARED PREFERENCES------------//////
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color=sharedPreferences.getString("culoare","black");

        //---------regasim fontul ales------
        if(!sharedPreferences.getString("font","-").equals("-"))
        {
            //doar daca ne schimbam fontul,il punem in variabila statica settings
            Settings.font=sharedPreferences.getString("font","-");
            typeface = null;//setam fontul cu un obiect typeface
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


        ///------------
        scrollView = findViewById(R.id.toolbal);
        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);

        //--------------regasirea layout-uri meniu---------
        layoutOpt1=findViewById(R.id.optiuniMenu1);
        layoutOpt2=findViewById(R.id.optiuniMenu2);
        layoutOpt3=findViewById(R.id.optiuniMenu3);
        layoutOpt4=findViewById(R.id.optiuniMenu4);
        layoutOpt5=findViewById(R.id.optiuniMenu5);
        layoutOpt6=findViewById(R.id.optiuniMenu6);
        layoutOpt7=findViewById(R.id.optiuniMenu7);

        //----------------setarea temei-----------////////
        if(Settings.theme == true){
            scrollView.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
        ////---------setarea temei---------//////

        //////////-------------setare culoare si font-------------///////
            layoutColor = findViewById(R.id.linearLayout);

            for (int i = 0; i < layoutColor.getChildCount(); i++) {
                if (layoutColor.getChildAt(i) instanceof TextView) {
                    TextView tv = (TextView) layoutColor.getChildAt(i);
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
            /////----setarea culoare si font si la meniu-----////
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
                ////----setarea culoare si font si la meniu-----////
        ////////////////--------setarea culoare si font--------//////////////
        drawerLayout=findViewById(R.id.drawer_layout);
        lvFacturi=findViewById(R.id.lvFacturi);

        //--ne abonam la meniul contextul pentru listView-ul nostru-///
        registerForContextMenu(lvFacturi);


        //-----------------baza de date ROOM------------------------
        facturiDB = Room.databaseBuilder(getApplicationContext(), DataBaseFacturi.class, "FacturiDB").allowMainThreadQueries().fallbackToDestructiveMigration().addMigrations(DataBaseFacturi.MIGRATION_4_5).build();

        Furnizori f1 = new Furnizori("ENEL", "0745748593", "enel@gmail.ro", "Bucuresti");
        Furnizori f2 = new Furnizori("AQUA NOVA", "0745238569", "aqua@gmail.ro", "Bucuresti");
        Furnizori f3 = new Furnizori("ENGIE", "0745348475", "engie@gmail.ro", "Bucuresti");
        Furnizori f4 = new Furnizori("DIGI", "0745768721", "digi@gmail.ro", "Bucuresti");
        Furnizori f5 = new Furnizori("VODAFONE", "0745778435", "vodafone@gmail.ro", "Bucuresti");
        Furnizori f6 = new Furnizori("TELEKOM", "0775738495", "telekom@gmail.ro", "Bucuresti");
        Furnizori f7 = new Furnizori("FAN COURIER", "0758734499", "fancourier@gmail.ro", "Bucuresti");
        Furnizori f8 = new Furnizori("SAMEDAY", "0745736466", "sameday@gmail.ro", "Bucuresti");
        Furnizori f9 = new Furnizori("EON", "0765738496", "eon@gmail.ro", "Bucuresti");
        Furnizori f10 = new Furnizori("ORANGE", "0735738567", "orange@gmail.ro", "Bucuresti");
        Furnizori f11 = new Furnizori("RCS&RDS", "0785738675", "rcsrds@gmail.ro", "Bucuresti");
        Furnizori f12 = new Furnizori("UPC", "0747733478", "upc@gmail.ro", "Bucuresti");
        Furnizori f13 = new Furnizori("EBAY", "0795758467", "ebay@gmail.ro", "London");
        Furnizori f14 = new Furnizori("AMAZON", "0745508490", "amazon@gmail.ro", "New York");
        Furnizori f15 = new Furnizori("ALIEXPRESS", "0740735490", "aliexpress@gmail.ro", "Beijing");
        Furnizori f16 = new Furnizori("-", "-", "-", "-");

        inserareFurnizori = getSharedPreferences("SharedPreferences", MODE_PRIVATE).getBoolean("inserareFurnizori",false);

        if(!inserareFurnizori) {


            facturiDB.getDAO().insertFurnizor(f1);
            facturiDB.getDAO().insertFurnizor(f2);
            facturiDB.getDAO().insertFurnizor(f3);
            facturiDB.getDAO().insertFurnizor(f4);
            facturiDB.getDAO().insertFurnizor(f5);
            facturiDB.getDAO().insertFurnizor(f6);
            facturiDB.getDAO().insertFurnizor(f7);
            facturiDB.getDAO().insertFurnizor(f8);
            facturiDB.getDAO().insertFurnizor(f9);
            facturiDB.getDAO().insertFurnizor(f10);
            facturiDB.getDAO().insertFurnizor(f11);
            facturiDB.getDAO().insertFurnizor(f12);
            facturiDB.getDAO().insertFurnizor(f13);
            facturiDB.getDAO().insertFurnizor(f14);
            facturiDB.getDAO().insertFurnizor(f15);
            facturiDB.getDAO().insertFurnizor(f16);


        }

        ///----setam un flag pentru a evita inserarea furnizorilor de mai multe ori la deschiderea aplicatiei-----///
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("inserareFurnizori",true);
        editor.apply();


        //----------setare adapter pe listView-ul nostru----////
        facturaAdapter=new FacturaAdapter(getApplicationContext(),R.layout.factura_view,facturi);
        facturi.clear();
        lvFacturi.setAdapter(facturaAdapter);
        facturaAdapter.notifyDataSetChanged();

        //------adaugare facturi existene din baza de date ROOM----/////
        if(getIntent().getExtras() == null) {


            facturiNationaleDB = MainActivity.getFacturiDB().getDAO().getListaFacturiNationale();

            for (int i = 0; i < facturiNationaleDB.size(); i++) {
                FacturaNationala fact = facturiNationaleDB.get(i);
                String denFurnizor = MainActivity.getFacturiDB().getDAO().getDenumireFurnizor(fact.getIdFurnizor());
                facturi.add(new Factura(fact.getDenumireFactura(), denFurnizor, fact.getPret(),
                        fact.getSerie(), fact.getDataScadenta(), fact.getTipFactura(), fact.getMoneda()));
            }

            facturaAdapter.notifyDataSetChanged();
        }


        //----tratam evenimentul de click la apasarea butonului de plus---////////
        FloatingActionButton addButton = (FloatingActionButton)findViewById(R.id.adaugaFacturaBtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Formular.class);
                it.putExtra("tip_factura","national");
                startActivityForResult(it,200);
            }
        });


        //---tratam evenimentul de click la apasarea butonului "Evalueaza-ne aplicatia"----
        Button btnRating = findViewById(R.id.btnRating);
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it3 = new Intent(getApplicationContext(), Feedback.class);
                startActivity(it3);
            }
        });


        //----parsare XML furnizori construit de noi si pus intr-un url de tip paste bin

        ExtrageFurnizoriXML xmlExtras = new ExtrageFurnizoriXML(){
            @Override
            protected void onPostExecute(InputStream inputStream) {
                super.onPostExecute(inputStream);


            }
        };
        try{
            xmlExtras.execute(new URL("https://pastebin.com/raw/HYtgrdFS"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }



    //----gestionam facturile trimise inapoi din formulat----////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==200) //codul 200 pt adaugare
        {
            if(resultCode==RESULT_OK)
            {
                Bundle extras=data.getExtras();
                Factura factura=extras.getParcelable("factura");
                adaugaFactura(factura);
                facturaAdapter.notifyDataSetChanged();
            }
        }

        if(requestCode==205) //codul 205 pt editare
        {
            if(resultCode==RESULT_OK)
            {
                facturiNationaleDB.clear();
                facturi.clear();
                facturaAdapter.notifyDataSetChanged();

                facturiNationaleDB = MainActivity.getFacturiDB().getDAO().getListaFacturiNationale();

                for (int i = 0; i < facturiNationaleDB.size(); i++) {
                    FacturaNationala fact = facturiNationaleDB.get(i);
                    String denFurnizor = MainActivity.getFacturiDB().getDAO().getDenumireFurnizor(fact.getIdFurnizor());
                    facturi.add(new Factura(fact.getDenumireFactura(), denFurnizor, fact.getPret(),
                            fact.getSerie(), fact.getDataScadenta(), fact.getTipFactura(), fact.getMoneda()));
                }

                facturaAdapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    //---atasam meniul contextul---////
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.long_click_menu, menu);

    }

    //--tratam optiunile meniului-/////
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextMenuOp1:
                //editare factura
                Intent it4 = new Intent(getApplicationContext(),Formular.class);
                it4.putExtra("factura_editata_nat",facturi.get(FacturaAdapter.getPosition()));
                startActivityForResult(it4,205);
                return false;
            case R.id.contextMenuOp2:
                //stergere factura

                Factura factura=facturi.get(FacturaAdapter.getPosition());
                 int idFactura=MainActivity.getFacturiDB().getDAO().getIdFactNat(factura.getSerieFactura());
                 MainActivity.getFacturiDB().getDAO().deleteFactNat(idFactura);
                 MainActivity.facturi.remove(FacturaAdapter.getPosition());
                 MainActivity.getFacturaAdapter().notifyDataSetChanged();
                 return false;
            case R.id.contextMenuOp3:
                //informatii furnizori
                //extragem furnizorul facturii respectiva
                String furnizor=facturi.get(FacturaAdapter.getPosition()).getFurnizorFactura();

                FurnizorInfo furnizorInfo = new FurnizorInfo();
                if(furnizor.equals("RCS&RDS")){
                    furnizorInfo = ExtrageFurnizoriXML.dictionarFurnizori.get("RCSRDS");
                }
                else {
                    furnizorInfo = ExtrageFurnizoriXML.dictionarFurnizori.get(furnizor);

                }

                //------construim alert dialog-ul unde afisam informatiile despre furnizorul facturii selectate
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

    public static DataBaseFacturi getFacturiDB() {
        return facturiDB;
    }

    public static void setFacturiDB(DataBaseFacturi facturiDB) {
        MainActivity.facturiDB = facturiDB;
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
        finish();
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
    }
    public void clickStatistici(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Statistici.class);
        startActivity(intent);
    }

    //get-eri si sett-eri pentru lista mea statica de facturi
    public static List<Factura> getFacturi() {
        return facturi;
    }

    public static void setFacturi(List<Factura> facturi) {
        MainActivity.facturi = facturi;
    }

    //metoda statica de adaugarea a unei facturi pentru a o apela atunci cand dau click pe butonul de adauga factura
    public static void adaugaFactura(Factura factura)
    {
        List<Factura> facturaList=MainActivity.getFacturi();
        facturaList.add(factura);
    }

    public static FacturaAdapter getFacturaAdapter() {
        return facturaAdapter;
    }

    public static void setFacturaAdapter(FacturaAdapter facturaAdapter) {
        MainActivity.facturaAdapter = facturaAdapter;
    }


}
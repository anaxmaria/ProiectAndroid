package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Feedback extends AppCompatActivity {
    RatingBar ratingBar;
    float feedback;
    Button buttonSubmit;
    Button btnRecenzii;
    DrawerLayout drawerLayout;
    List<String> listaIdNote = new ArrayList<>();
    List<Recenzie> listaRecenzii = new ArrayList<>();

    FrameLayout frame;
    LinearLayout feedbackLayout;
    LinearLayout fragmentPozitiv;
    LinearLayout fragmentNegativ;
    LinearLayout header;
    LinearLayout menu;
    LinearLayout layoutOpt1;
    LinearLayout layoutOpt2;
    LinearLayout layoutOpt3;
    LinearLayout layoutOpt4;
    LinearLayout layoutOpt5;
    LinearLayout layoutOpt6;
    LinearLayout layoutOpt7;
    Typeface typeface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        layoutOpt1=findViewById(R.id.optiuniMenu1);
        layoutOpt2=findViewById(R.id.optiuniMenu2);
        layoutOpt3=findViewById(R.id.optiuniMenu3);
        layoutOpt4=findViewById(R.id.optiuniMenu4);
        layoutOpt5=findViewById(R.id.optiuniMenu5);
        layoutOpt6=findViewById(R.id.optiuniMenu6);
        layoutOpt7=findViewById(R.id.optiuniMenu7);

        ///------SHARED PREFERENCES-------------////
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

        frame = findViewById(R.id.fragment_container);
        feedbackLayout = findViewById(R.id.feedbackLayout);
        header = findViewById(R.id.headerId);
        menu = findViewById(R.id.menuId);


        for(int i=0; i< feedbackLayout.getChildCount(); i++){
            if(feedbackLayout.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) feedbackLayout.getChildAt(i);
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
            frame.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            feedbackLayout.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            header.setBackgroundColor(getResources().getColor(R.color.menuDarker));
            menu.setBackgroundColor(getResources().getColor(R.color.menuDarker));
        }
        ///------SHARED PREFERENCES-------------////


        ratingBar=findViewById(R.id.ratingBar);
        buttonSubmit=findViewById(R.id.btnSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //--------CONECTARE FIREBASE------------
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Note");

                //---preluare nota
                feedback=ratingBar.getRating();
                ratingBar.setIsIndicator(true);

                ////----daca nota e mai mica decat 2.5 ,
                //ne construim un obiect de tip FragmentNegativ si il atasam
                if(feedback<2.5)
                {
                    FragmentNegativ fragmentNegativ1 = new FragmentNegativ();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragmentNegativ1).commit();
                }
                else
                {
                    FramgentPozitiv fragmentPozitiv1 = new FramgentPozitiv();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragmentPozitiv1).commit();
                }

                //stocare nota in firebase
                //firstNode.push().).setValue("AA");
                //metoda push genereaza o valoare unica prin care poate fii identificat un sub element al unei refereinte si insereaza o valoare
                myRef.push().setValue(feedback);
            }
        });

        //-------conectare firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database.getReference("Recenzii");

        //----preluare date din firebase----////
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaRecenzii.clear();

                Iterable<DataSnapshot> recenzii = snapshot.getChildren();

                for(DataSnapshot ds:recenzii){

                    Recenzie recenzie1 = ds.getValue(Recenzie.class);
                    listaRecenzii.add(recenzie1);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //-----tratarea evenimentului de click la apsarea butonului de trimiteRecenzii-----
        btnRecenzii = findViewById(R.id.btnRegasesteRecenzii);
        btnRecenzii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //afisare recenzii
                AlertDialog.Builder builder = new AlertDialog.Builder(Feedback.this);
                //facem inflate la layout
                View view=getLayoutInflater().inflate(R.layout.recenzii_utilizatori,null);

                ListView lvRecenzii = view.findViewById(R.id.listaRecenzii);
                RecenzieAdapter adapterRecenzii = new RecenzieAdapter(Feedback.this,listaRecenzii, R.layout.recenzie_view);
                lvRecenzii.setAdapter(adapterRecenzii);

                builder.setView(view);

                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setLayout(300, 200); //Controlling width and height.
                alertDialog.show();

            }
        });

        drawerLayout=findViewById(R.id.drawer_layout);

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
        finish();
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
    }
    public void clickStatistici(View view)
    {
        Intent intent=new Intent(getApplicationContext(), Statistici.class);
        startActivity(intent);
    }
}

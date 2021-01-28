package com.example.proiectandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class FragmentNegativ extends Fragment {
    Button trimiteSugestii;
    EditText editTextSugestieNeg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // facem inflate la layout-ul corespunzator gramentului negativ
        final View view= inflater.inflate(R.layout.fragment_negativ, container, false);

        ///------SHARED PREFERENCEs---------/////
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        Settings.theme = sharedPreferences.getBoolean("darkTheme", false);
        Settings.color = sharedPreferences.getString("culoare", "black");


        if(Settings.theme == true){
            LinearLayout layout = view.findViewById(R.id.fragmentNegativ);
            layout.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));
            ScrollView scrollView=view.findViewById(R.id.scrollFragNegativ);
            scrollView.setBackgroundColor(getResources().getColor(R.color.backgroundColorDark));

        }
        LinearLayout layout=view.findViewById(R.id.fragmentNegativ);
        for(int i=0; i< layout.getChildCount(); i++){
            if(layout.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) layout.getChildAt(i);
                if(Settings.color.equals("Negru")){
                    tv.setTextColor(Color.BLACK);
                }
                if(Settings.color.equals("Alb")){
                    tv.setTextColor(Color.WHITE);
                }
                if(Settings.color.equals("Gri")){
                    tv.setTextColor(Color.GRAY);
                }
                if(Settings.color.equals("Rosu")){
                    tv.setTextColor(Color.RED);
                }
            }
        }

        ///------SHARED PREFERENCEs---------/////
        ///---tratarea evenimentul de click a butonului Trimite Sugestie
        trimiteSugestii=view.findViewById(R.id.btnTrimiteSugestii);
        trimiteSugestii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent it = new Intent(getContext(), MainActivity.class);
//                startActivity(it);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Recenzii");

                editTextSugestieNeg = view.findViewById(R.id.editTextNegativ);
                String sugestie = editTextSugestieNeg.getText().toString();
                
                if(!sugestie.equals("")) {
                    Recenzie recenzie = new Recenzie();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    recenzie.setData(currentDateandTime);
                    recenzie.setRecenzieText(sugestie);

                    myRef.push().setValue(recenzie);
                    editTextSugestieNeg.setText("");
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(), R.string.toastFragmentFeedback, Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        return view;
    }
}
package com.example.proiectandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//adapter pentru introducerea unei facturi
public class FacturaAdapter extends BaseAdapter {
    private Context context;
    private List<Factura> facturaList;
    private int resource;//layout-ul dupa care se va construi adapterul
    private static int position;

    //constructorul adapterului
    public FacturaAdapter(Context context,int resource,List<Factura> facturi) {
        this.context=context;
        facturaList=facturi;
        this.resource=resource;
    }

    //intoarce atributul pozitiei
    public static int getPosition() {
        return position;
    }

    //ne ofera acces sa setam atributul pozitie
    public static void setPosition(int position) {
        FacturaAdapter.position = position;
    }

    //intoarce numarul de facturi
    @Override
    public int getCount() {
        return this.facturaList.size();
    }

    //intoarce o factura pe baza pozitiei
    @Override
    public Object getItem(int position) {
        if(position>=0 && position<this.getCount())
        {
            return this.facturaList.get(position);
        }
        else
        {
            throw new IllegalArgumentException("Parametru incorect");
        }
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    //construim view-ul pt o factura
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        //cu ajutorul unui layoutInflater injectam layout-ul primit in variabila view
        View view=layoutInflater.inflate(resource,parent,false);

        //aplicam setarile din shared preferences asupra view-ului construit
        LinearLayout linearLayout=view.findViewById(R.id.linearLayoutViewAdapater);

        for(int i=0; i< linearLayout.getChildCount(); i++){
            if(linearLayout.getChildAt(i) instanceof TextView){
                TextView tv = (TextView) linearLayout.getChildAt(i);
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

        //populam view-ul construit cu datele corespunzatoare
        final Factura factura=(Factura)this.getItem(position);//regasim factura pentru care construim


        ImageView imageView=view.findViewById(R.id.iconFurnizor);

        LinearLayout layout=view.findViewById(R.id.linearLayoutViewAdapater);
        //in functie de pozitia facturii in lista,vom seta culoarea background-ului view-ului nostru diferit
        if(position%2==0)
        {
            layout.setBackgroundColor(this.context.getResources().getColor(R.color.row_par));
        }
        else
        {
            layout.setBackgroundColor(this.context.getResources().getColor(R.color.row_impar));
        }
        //setam sursa imageView-ului din view-ul nostru in functie de furnizorul facturii respective la momentul curent

        switch (factura.getFurnizorFactura())
        {

            case "EON":
                imageView.setImageResource(R.drawable.eon);
                break;
            case "ENGIE":
                imageView.setImageResource(R.drawable.engie);
                break;
            case "DIGI":
                imageView.setImageResource(R.drawable.digi);
                break;
            case "VODAFONE":
                imageView.setImageResource(R.drawable.vodafone);
                break;
            case "ORANGE":
                imageView.setImageResource(R.drawable.orange);
                break;
            case "UPC":
                imageView.setImageResource(R.drawable.upc);
                break;
            case "AQUA NOVA":
                imageView.setImageResource(R.drawable.aquanova);
                break;
            case "SAMEDAY":
                imageView.setImageResource(R.drawable.sameday);
                break;
            case"FAN COURIER":
                imageView.setImageResource(R.drawable.fancurier);
                break;
            case "ENEL":
                imageView.setImageResource(R.drawable.enelll);
                break;
            case "RCS&RDS":
                imageView.setImageResource(R.drawable.rcs_rds);
                break;
            case "TELEKOM":
                imageView.setImageResource(R.drawable.telekom);
                break;
            case "EBAY":
                imageView.setImageResource(R.drawable.ebay);

                break;
            case "AMAZON":
                imageView.setImageResource(R.drawable.amazon);
                break;
            case "ALIEXPRESS":
                imageView.setImageResource(R.drawable.aliexpress);
                break;

        }
        //setam pretul facturii
        TextView tvPret=view.findViewById(R.id.tvPretAdapter);
        tvPret.setText(factura.getPretFactura()+"");

        //populam textView-ul datei scadente
        final TextView tvDataScadenta=view.findViewById(R.id.tvDataScadentaAdapater);
        tvDataScadenta.setText(factura.getDataScadentaFactura());

        //populam textView-ul denumirii facturii
        TextView tvDenumire=view.findViewById(R.id.tvAdapterDenumireFactura);
        tvDenumire.setText(factura.getDenumireFactura());



        CheckBox checkBoxPlatit=view.findViewById(R.id.cbPlatitAdapater);
        if(checkBoxPlatit!=null)//daca nu avem checkbox,inseamna ca suntem in actvitatea de istoric facturi,unde avem un layout fara check_box
        {
            //tratam evenimentul de click pe checkbox
            checkBoxPlatit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //anunta utilizatorul ca a platit factura
                    Toast.makeText(context,R.string.atiPlatitFactura, Toast.LENGTH_LONG).show();

                    //regasim factura platita si o punem in variabila factura_bifata
                    Factura factura_bifata=facturaList.get(position);

                    //data scadenta o sa devina data curenta in care s a platit
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    factura_bifata.setDataScadentaFactura(currentDateandTime);
                    factura_bifata.setPlatita(true);

                    //luam id-ul furnizorului  corespunzator facturii platite din baza de date
                    int idFurnizor = MainActivity.getFacturiDB().getDAO().getFurnizor(factura_bifata.getFurnizorFactura());

                    //pentru inserarea facturii extrase in baza de date,trebuie sa o facem de tip Factura Platita
                    //ne construim un obiect de tip FacturaPlatita pe baza facturii extrasa
                    FacturaPlatita factura_platita = new FacturaPlatita(factura_bifata.getDenumireFactura(),idFurnizor,
                            factura_bifata.getPretFactura(),factura_bifata.getSerieFactura(), factura_bifata.getDataScadentaFactura(),
                            factura_bifata.getTipFactura(),factura_bifata.getMoneda());

                    //inseram noua obiect de tip FacturaPlatita in tabela Istoric_Facturi
                    MainActivity.getFacturiDB().getDAO().insertFacturaPlatita(factura_platita);

                    //stergere factura din tabela respectiva
                    //verifcam daca factura platita e de tip nationala sau internationala in functie de tipul monedei
                    if(factura_bifata.getMoneda().equals("RON")){
                        //daca e factura nationala,stergem factura din tabela Factura_Nationala
                        int idFacturaNat = MainActivity.getFacturiDB().getDAO().getIdFactNat(factura_bifata.getSerieFactura());
                        MainActivity.getFacturiDB().getDAO().deleteFactNat(idFacturaNat);
                    }
                    else{
                        //daca e factura internationala,stergem factura din tabela Factura_Internationala
                        int idFacturaInt = MainActivity.getFacturiDB().getDAO().getIdFactInt(factura_bifata.getSerieFactura());
                        MainActivity.getFacturiDB().getDAO().deleteFactInt(idFacturaInt);
                    }

                    //trimitem factura platita catre activitatea de istoric Facturi si in acelasi timp o deschidem
                    //modificam adapterul din istoric
                    Intent intent=new Intent(context,IstoricFacturi.class);
                    intent.putExtra("Factura_Platita",factura_bifata);
                    context.startActivity(intent);

                    //stergem factura si din lista noastra de facturi pentru a notifica adapterul
                    facturaList.remove(position);
                    MainActivity.getFacturaAdapter().notifyDataSetChanged();
                }
            });
        }

        //setam atributul static position pentru a retine pozitia pentru care s a dat click lung
        //il folosim in meniul contextul
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(position);

                return false;
            }
        });

        return view;
    }

}

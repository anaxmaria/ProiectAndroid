package com.example.proiectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
//adapter pentru afisarea recenziilor regasite
public class RecenzieAdapter extends BaseAdapter {
    private Context context;
    private List<Recenzie> recenzies;
    private int resource;
    private static int position;

    public RecenzieAdapter(Context context, List<Recenzie> recenzies, int resource) {
        this.context = context;
        this.recenzies = recenzies;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return recenzies.size();
    }

    @Override
    public Object getItem(int position) {
        if(position>=0 && position<this.getCount())
        {
            return this.recenzies.get(position);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.recenzie_view,parent,false);
        Recenzie recenzie=recenzies.get(position);
        TextView textRecezie=view.findViewById(R.id.textRecenzie);
        textRecezie.setText(recenzie.getRecenzieText());
        TextView dataRecenzie = view.findViewById(R.id.tvDataRecenzie);
        dataRecenzie.setText(recenzie.getData());

        return view;
    }
}

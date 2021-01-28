package com.example.proiectandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PieChart extends View {

    //construirea grafic pe baza facturilor nationale neplatite,nationale neplatite,si platite
    int nrTotalFacturiNationale;
    int nrTotalFacturiInternationale;
    int nrTotalFacturiPlatite;
    List<Integer> dateFacturi = new ArrayList<>();
    static int suma;

    static double start;
    static double sweep;

    public PieChart(Context context) {
        super(context);

        suma = 0;

        dateFacturi.clear();

        nrTotalFacturiNationale = MainActivity.getFacturiDB().getDAO().getNrTotalFacturiNationale();
        nrTotalFacturiInternationale = MainActivity.getFacturiDB().getDAO().getNrTotalFacturiInternationale();
        nrTotalFacturiPlatite = MainActivity.getFacturiDB().getDAO().getNrTotalFacturiPlatite();

        dateFacturi.add(nrTotalFacturiNationale);
        dateFacturi.add(nrTotalFacturiInternationale);
        dateFacturi.add(nrTotalFacturiPlatite);

        for(int i=0; i<dateFacturi.size(); i++){
            suma += dateFacturi.get(i);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint instrument = new Paint();
        instrument.setStyle(Paint.Style.FILL);
        instrument.setStrokeWidth(15);

//        algoritm pie chart
//        suma(V)............ 360
//        v[i]  ............  x
//                ----------------------------
//        x = v[i] * 360 / suma(V)F


        double startAngle = 0;
        double sweepAngle = 0;
        start = startAngle;
        sweep = sweepAngle;
        List<Double> sweepAngles=new ArrayList<>();
        if(suma!=0) {
            for (int i = 0; i < dateFacturi.size()-1; i++) {
                sweepAngle = Math.round(dateFacturi.get(i) * 360 / suma);
                sweepAngles.add(sweepAngle);
                if (i == 0) {
                    instrument.setColor(Color.rgb(83, 206, 219));
                }
                if (i == 1) {
                    instrument.setColor(Color.rgb(25, 220, 250));
                }

                canvas.drawArc(300, 100, 900, 700, (float) startAngle, (float) sweepAngle, true, instrument);

                startAngle = startAngle + sweepAngle;
            }

            double  SumaSweepAngles=0;
            for(int i=0;i<sweepAngles.size();i++)
            {
                SumaSweepAngles+=sweepAngles.get(i);
            }
            //-------desenz ultimul unghi,va ocupa suprafata din cerc nedesenata----
            double sweepAngle3=360-SumaSweepAngles;
            instrument.setColor(Color.rgb(116, 219, 211));
            canvas.drawArc(300, 100, 900, 700, (float) startAngle, (float) sweepAngle3, true, instrument);

            int culoareNat = Color.rgb(83, 206, 219);
            int culoareInt = Color.rgb(25, 220, 250);

            int culoarePlatite = Color.rgb(116, 219, 211);

            Paint instrument2 = new Paint();
            instrument2.setStyle(Paint.Style.FILL);
           
            instrument2.setColor(culoareNat);

            canvas.drawRect(200, 800, 250, 850, instrument2);
            instrument2.setTextAlign(Paint.Align.LEFT);
            instrument2.setTextSize(50);
            canvas.drawText("Facturi Naționale Neplătite", 270, 850, instrument2);

            instrument2.setColor(culoareInt);
            canvas.drawRect(200, 870, 250, 920, instrument2);
            instrument2.setTextAlign(Paint.Align.LEFT);
            instrument2.setTextSize(50);
            canvas.drawText("Facturi Internaționale Neplătite", 270, 920, instrument2);

            instrument2.setColor(culoarePlatite);
            canvas.drawRect(200, 940, 250, 990, instrument2);
            instrument2.setTextAlign(Paint.Align.LEFT);
            instrument2.setTextSize(50);
            canvas.drawText("Facturi Plătite", 270, 990, instrument2);
        }
    }





}

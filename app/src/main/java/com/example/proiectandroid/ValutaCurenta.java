package com.example.proiectandroid;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//----clasa care extrage cursul BNR la momentul curent
public class ValutaCurenta extends AsyncTask<URL,Void, InputStream> {
    InputStream inputStream = null;

    public static String nodeEur;
    public static Moneda moneda=new Moneda();

    public static String sbuf;
    @Override
    protected InputStream doInBackground(URL... urls) {
        HttpURLConnection connection=null;
        try {
            connection= (HttpURLConnection) urls[0].openConnection();
            inputStream=connection.getInputStream();
            //parsam xml ul pentru a obtine valorile ce trebuie
            parsareXML(inputStream);

            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String linie = "";
            while((linie = bufferedReader.readLine())!=null)
            {
                sbuf+=linie + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null)
                connection.disconnect();
        }
        return inputStream;

    }
    public Node getNode(String numeNodCautat,Node parentNode)
    {
        if(parentNode.getNodeName().equals(numeNodCautat))
        {
            return parentNode;
        }
        NodeList listaCopii=parentNode.getChildNodes();
        for(int i=0;i<listaCopii.getLength();i++)
        {
            //folosim recursivitatea pentru a cauta printre copiilor nodurilor copiilor,printre descendenti
            Node nodeCautat=getNode(numeNodCautat,listaCopii.item(i));
            if(nodeCautat!=null)
            {
                return nodeCautat;
            }


        }
        return null;
    }
    //facem aici o metoda deoarece noi parsam si prin copii copiilor lui cube
    //pana cand ajungem la un textNode verificand daca fiecare copil al copilului lui cube are atributul currency
    //  atunci cand ajungem la textNode inseamna ca nu mai accesa valoarea atributului currency,deoarece text nodurile nu au atirbute
    //si ca vom prelua continutul,adica textContexnt
    public static String getAttributeValue(Node nodeCopil, String atributCautat) {
        try {
            return ((Element)nodeCopil).getAttribute(atributCautat);
        }
        catch (Exception e) {
            return "";
        }
    }
    public void parsareXML(InputStream inputStream)
    {
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            //obtinem DOM-ul
            Document document=documentBuilder.parse(inputStream);
            //structuram fisierul prin punerea textelor de tip nod sub nodul corespunzator


            document.getDocumentElement().normalize();
              moneda =new Moneda();
              //preluare nod radacina ce contine cursurile valutare curent-nodecube

            //nod parinte
            Node parentNode=document.getDocumentElement();
            Node nodeCube=getNode("Cube",parentNode);
            if(nodeCube!=null)
            {
                nodeEur="Am gasit nodecube";
                //parcugerea copiilor
                NodeList listaCopii=nodeCube.getChildNodes();
                for(int i=0;i<listaCopii.getLength();i++)
                {
                    Node nodeCopil=listaCopii.item(i);
                    nodeEur=nodeCopil.getTextContent();
                    String tip_moneda=getAttributeValue(nodeCopil,"currency");

                    if(tip_moneda.equals("EUR"))
                    {
                        moneda.setEUR(Float.parseFloat(nodeCopil.getTextContent()));

                    }
                    if(tip_moneda.equals("GBP"))
                    {
                        moneda.setGBP(Float.parseFloat(nodeCopil.getTextContent()));
                    }
                    if(tip_moneda.equals("USD"))
                    {
                        moneda.setUSD(Float.parseFloat(nodeCopil.getTextContent()));
                    }


                }
            }




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

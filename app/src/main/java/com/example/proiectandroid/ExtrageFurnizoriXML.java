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
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//extragem informatiile suplimentare ale furnizorilor dintr -un XML construit de noi si pus intr-un URL
public class ExtrageFurnizoriXML extends AsyncTask<URL, Void, InputStream> {

    static HashMap<String,FurnizorInfo> dictionarFurnizori = new HashMap<>();
    InputStream inputStream;
    String adresa;

    @Override
    protected InputStream doInBackground(URL... urls) {
        HttpURLConnection conexiune = null;
        try {
            //deschidem conexiune
            conexiune = (HttpURLConnection) urls[0].openConnection();
            inputStream = conexiune.getInputStream();


            parsing(inputStream);

            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String linie = "";
            while ((linie = br.readLine()) != null) {
                String sbuf = linie + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        finally{
            if(conexiune!=null){
                conexiune.disconnect();
            }
        }

        return inputStream;
    }

    public void parsing(InputStream is) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = document.newDocumentBuilder();
        Document doc = docBuilder.parse(is);
        doc.getDocumentElement().normalize();

        Node furnizori = getNode("furnizori", doc.getDocumentElement());
        NodeList listaCopii = furnizori.getChildNodes();

        for(int i=0; i<listaCopii.getLength();i++){
            Node copil = listaCopii.item(i);

            if(copil!=null && copil.getNodeName().equals("furnizor")){
                FurnizorInfo furnizor = new FurnizorInfo();
                adresa = "";

                String atributCategorie = getValoareAtribut("categorie",copil);
                if(!atributCategorie.equals("")){
                    furnizor.setCategorie(atributCategorie);
                }

                String atributDenumire = getValoareAtribut("denumire",copil);
                if(!atributDenumire.equals("")){
                    furnizor.setDenumire(atributDenumire);
                }

                String atributUtilitate = getValoareAtribut("utilitate",copil);
                if(!atributUtilitate.equals("")){
                    furnizor.setUtilitate(atributUtilitate);
                }

                NodeList copiiFurnizor = copil.getChildNodes();

                for(int j=0; j<copiiFurnizor.getLength();j++){
                    Node copilFurnizor = copiiFurnizor.item(j);

                    String atributTelefon = getValoareAtribut("telefon",copilFurnizor);
                    if(!atributTelefon.equals("")){
                        furnizor.setTelefon(atributTelefon);
                    }

                    String atributFax = getValoareAtribut("fax",copilFurnizor);
                    if(!atributFax.equals("")){
                        furnizor.setFax(atributFax);
                    }

                    String atributEmail = getValoareAtribut("email",copilFurnizor);
                    if(!atributEmail.equals("")){
                        furnizor.setEmail(atributEmail);
                    }

                    NodeList copiiContact = copilFurnizor.getChildNodes();

                    for(int m=0; m<copiiContact.getLength();m++){
                        Node copilContact = copiiContact.item(m);

                        String atributOras = getValoareAtribut("oras", copilContact);
                        if(!atributOras.equals("")){
                            furnizor.setOras(atributOras);
                        }

                        String atributCodPostal = getValoareAtribut("cod_postal", copilContact);
                        if(!atributCodPostal.equals("")){
                            furnizor.setCodPostal(atributCodPostal);
                        }

                        String atributJudet = getValoareAtribut("judet", copilContact);
                        if(!atributJudet.equals("")){
                            furnizor.setJudet(atributJudet);
                        }

                        NodeList copiiAdresa = copilContact.getChildNodes();

                        for(int n=0; n<copiiAdresa.getLength(); n++){
                            Node copilAdresa = copiiAdresa.item(n);

                            if(copilAdresa.getNodeName().equals("strada")){
                                NodeList copiiStrada = copilAdresa.getChildNodes();

                                for(int o=0; o<copiiStrada.getLength();o++){
                                    Node copilStrada = copiiStrada.item(o);

                                    if(copilStrada.getNodeName().equals("numeStrada")){
                                        String numeStrada = copilStrada.getTextContent();
                                        adresa += "Strada: ";
                                        adresa += numeStrada;
                                    }
                                    if(copilStrada.getNodeName().equals("nr")){
                                        String nr = copilStrada.getTextContent();
                                        adresa += ", nr: ";
                                        adresa += nr;
                                    }
                                    if(copilStrada.getNodeName().equals("bloc")){
                                        String bloc = copilStrada.getTextContent();
                                        adresa += ", bloc: ";
                                        adresa += bloc;
                                    }
                                }
                            }
                        }
                    }
                }
                furnizor.setAdresa(adresa);
                dictionarFurnizori.put(furnizor.getDenumire(),furnizor);
            }
        }
    }

    public static Node getNode(String numeNod, Node nodParinte){
        if(nodParinte.getNodeName().equals(numeNod)){
            return nodParinte;
        }

        NodeList listaNoduri = nodParinte.getChildNodes();
        for(int i=0; i<listaNoduri.getLength();i++){
            Node nodCopil = getNode(numeNod, listaNoduri.item(i));

            if(nodCopil != null){
                return nodCopil;
            }
        }
        return null;
    }

    //metoda care returneaza valoarea unui atribut specific al unui nod specific daca exista
    public static String getValoareAtribut(String atribut, Node nod){
        try{
            return ((Element)nod).getAttribute(atribut);
        }
        catch(Exception e){
            return "";
        }
    }

}

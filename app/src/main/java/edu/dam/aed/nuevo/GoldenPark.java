package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GoldenPark {
    public void parseadorGolden (String casa,String liga,String url ){


        try {

            Document goldenPark = Jsoup.connect(url).get();
            Elements gp = goldenPark.select("div [class=snc-odds-odd nb-load]");
            Elements gps = goldenPark.select("div [class=snc-odds-title-event]");

            ArrayList<String> listaCuotaMarca = new ArrayList<>();
            for (Element element : gp) {
                String equipos = element.text();
                listaCuotaMarca.add(equipos);
            }

            ArrayList<String> listaPartidosMarca = new ArrayList<>();
            for (Element element : gps) {
                String equipos = element.text();
                listaPartidosMarca.add(equipos);
            }

            ArrayList<String> listaPartidosMarcas = new ArrayList<>();
            for (String  element : listaPartidosMarca) {
                int num = element.indexOf("/");
                String a = element.substring(0, num - 1);
                String b = element.substring(num + 2);
                listaPartidosMarcas.add(a);
                listaPartidosMarcas.add(b);
            }


            int aaa = 0;
            int bbb = 1;
            int ccc = 0;
            int ddd = 1;
            int eee = 2;
            int numeroidentificadordos = 1;

            BaseDatosFirebase bd = new BaseDatosFirebase();
            DatabaseReference dbreference = bd.getDbreference().child(casa).child(liga);


                if(listaPartidosMarca.size()!= 0) {
                    for (int i=0 ; i<=(listaPartidosMarcas.size() / 2) - 1; i++ ) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosMarcas.get(aaa));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosMarcas.get(bbb));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotaMarca.get(ccc));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotaMarca.get(eee));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotaMarca.get(ddd));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosMarcas.get(aaa), listaPartidosMarcas.get(bbb),listaCuotaMarca.get(ccc), listaCuotaMarca.get(ddd), listaCuotaMarca.get(eee),liga, casa);
                        SS.Monitor.aumentador1Identificador();
                        SS.Monitor.append(evento);

                        aaa += 2;
                        bbb += 2;
                        ccc += 3;
                        ddd += 3;
                        eee += 3;
                        numeroidentificadordos++;

                    }
                }

        } catch (Exception nn) {
            nn.printStackTrace();
        }
    }
}

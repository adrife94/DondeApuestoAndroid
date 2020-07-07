package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CasinoBarcelona {
    public void parseadorBarcelona(String casa,String liga,String url ) {

        try {

            Document barcelona = Jsoup.connect(url).get();  //Con Basino Barcelona el pequeño problema es que te devuelve en un mismo elemento FC Sevilla / Leganés, en vez de los equipos por separado
            //Cuota
            Elements elementosCuota = barcelona.select("div [class=snc-load uk-flex]");
            //Equipo
            Elements elementosEqipo = barcelona.select("div [class=snc-event]");

            ArrayList<String> listaCuotaBarcelona = new ArrayList<>();
            for (Element element : elementosCuota) {
                String equipos = element.text();
                listaCuotaBarcelona.add(equipos);
            }

            ArrayList<String> listaPartidosBetfairLigue1 = new ArrayList<>();
            for (Element element : elementosEqipo) {
                String equipos = element.text();
                listaPartidosBetfairLigue1.add(equipos);
            }
            ArrayList<String> listaPartidosBarcelona = new ArrayList<>();
            for (String  element : listaPartidosBetfairLigue1) {
                int num = element.indexOf("/");
                String a = element.substring(0,num - 1);
                String b = element.substring(num + 2);
                listaPartidosBarcelona.add(a);
                listaPartidosBarcelona.add(b);


            }

            int aaa = 0;
            int bbb = 1;
            int ccc = 0;
            int ddd = 1;
            int eee = 2;
            int numeroidentificadordos = 1;

            BaseDatosFirebase bd = new BaseDatosFirebase();
            DatabaseReference dbreference = bd.getDbreference().child(casa).child(liga);

                if (listaPartidosBetfairLigue1.size()!=0) {

                    for (int i=0;i<listaPartidosBetfairLigue1.size(); i++ ) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosBarcelona.get(aaa));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosBarcelona.get(bbb));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotaBarcelona.get(ccc));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotaBarcelona.get(eee));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotaBarcelona.get(ddd));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosBarcelona.get(aaa), listaPartidosBarcelona.get(bbb),listaCuotaBarcelona.get(ccc), listaCuotaBarcelona.get(ddd), listaCuotaBarcelona.get(eee), liga, casa);
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

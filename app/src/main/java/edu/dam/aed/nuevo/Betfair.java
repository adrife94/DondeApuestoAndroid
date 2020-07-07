package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Betfair {
    public void parseadorBetfair(String casa,String liga,String url ){

        try {

            Document betfairLaLiga = Jsoup.connect(url).get();
            //Cuotas
            Elements tabla3corredores = betfairLaLiga.getElementsByClass("details-market market-3-runners"); //con esto obtengo las cuotas de 1x2, porque en bwin tambien esta la tabla de +-2.5 goles
            Elements cuotasBetfairLaLiga = tabla3corredores.select("[class*='ui-runner-price ui']");
            //Nombre equipos
            Elements nombreEquiposBetfairLaLiga = betfairLaLiga.select("span[class=team-name]");

            ArrayList<String> listaPartidosBetfairLaLiga = new ArrayList<>();
            for (Element element : nombreEquiposBetfairLaLiga) {
                String equipos = element.text();
                listaPartidosBetfairLaLiga.add(equipos);
            }



            ArrayList<String> listaCuotasBetfairLaLiga = new ArrayList<>();
            for (Element element : cuotasBetfairLaLiga) {
                String cuotas = element.text();
                listaCuotasBetfairLaLiga.add(cuotas);
            }

            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int numeroidentificadordos = 1;


            BaseDatosFirebase bd = new BaseDatosFirebase();
            DatabaseReference dbreference = bd.getDbreference().child(casa).child(liga);



                if(listaPartidosBetfairLaLiga.size()!= 0)  {


                    for (int i = 0; i < (listaPartidosBetfairLaLiga.size() / 2); i++) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosBetfairLaLiga.get(a));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosBetfairLaLiga.get(b));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotasBetfairLaLiga.get(c));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotasBetfairLaLiga.get(e));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotasBetfairLaLiga.get(d));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosBetfairLaLiga.get(a), listaPartidosBetfairLaLiga.get(b),listaCuotasBetfairLaLiga.get(c), listaCuotasBetfairLaLiga.get(d), listaCuotasBetfairLaLiga.get(e),liga,casa);
                        SS.Monitor.aumentador1Identificador();
                        SS.Monitor.append(evento);

                        a += 2;
                        b += 2;
                        c += 3;
                        d += 3;
                        e += 3;
                        numeroidentificadordos++;
                    }

                }

        } catch (IOException e) {

        }

    }

}

package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Suertia {
    public void parseadorSuertia(String casa,String liga,String url ) {

        try {
            Document suertia = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements elementosEquip = suertia.select("div [class=snc-bets-item snc-bets-item-withoutactor]");//.not("span[class=top-selns]"); Si ponemos elements es para muchos, element para uno. Y con lo que esta entrecomillado filtramos.
            Elements elementosCuot = elementosEquip.select("div [class=snc-event]");
            Elements elementosCuotass = elementosEquip.select("div [class=odd-without-actor]");

            ArrayList<String> listaCuotaMarca = new ArrayList<>();
            for (Element element : elementosCuot) {
                String equipos = element.text();
                listaCuotaMarca.add(equipos);
            }

            ArrayList<String> listaPartidosMarca = new ArrayList<>();
            for (Element element : elementosCuotass) {
                String equipos = element.text();
                listaPartidosMarca.add(equipos);

            }


            ArrayList<String> listaPartidosMarcas = new ArrayList<>();
            for (String element : listaCuotaMarca) {
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


                if (listaPartidosMarca.size() != 0) {

                    for (int i = 0; i <= (listaPartidosMarcas.size() / 2) - 1; i++) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosMarcas.get(aaa));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosMarcas.get(bbb));
                        dbreference.child(numid).child("Cuota1").setValue(listaPartidosMarca.get(ccc));
                        dbreference.child(numid).child("CuotaX").setValue(listaPartidosMarca.get(eee));
                        dbreference.child(numid).child("Cuota2").setValue(listaPartidosMarca.get(ddd));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosMarcas.get(aaa), listaPartidosMarcas.get(bbb),listaPartidosMarca.get(ccc), listaPartidosMarca.get(ddd), listaPartidosMarca.get(eee), liga, casa);
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

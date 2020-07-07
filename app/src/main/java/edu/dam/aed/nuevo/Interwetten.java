package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Interwetten {
    public void parseadorInterwetten(String casa,String liga,String url ) {


        try {


            Document interwett = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements elementosEquip = interwett.select("table [class=bets border center]");//.not("span[class=top-selns]"); Si ponemos elements es para muchos, element para uno. Y con lo que esta entrecomillado filtramos.
            Elements elementosEquipdd = interwett.select("table [class=bets border center]");
            Elements elementosCuot = elementosEquip.select("td [itemprop=name]");
            Elements elementosCuotass = elementosEquip.select("p");
            Elements elementosCuotasssss = elementosCuotass.select("strong");


            ArrayList<String> listaCuotaMarca = new ArrayList<>();
            for (Element element : elementosCuotasssss) {
                String equipos = element.text();
                listaCuotaMarca.add(equipos);
            }

            ArrayList<String> listaPartidosMarca = new ArrayList<>();
            for (Element element : elementosCuot) {
                String equipos = element.text();
                listaPartidosMarca.add(equipos);
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

                    for (int i=0 ; i<=(listaPartidosMarca.size() / 2) - 1; i++ ) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosMarca.get(aaa));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosMarca.get(bbb));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotaMarca.get(ccc));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotaMarca.get(eee));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotaMarca.get(ddd));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosMarca.get(aaa), listaPartidosMarca.get(bbb),listaCuotaMarca.get(ccc), listaCuotaMarca.get(ddd), listaCuotaMarca.get(eee), liga, casa);
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

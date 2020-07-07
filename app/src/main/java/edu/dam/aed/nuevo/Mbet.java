package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Mbet {
    public void parseadorMbet (String casa,String liga, String container, String url ){


        try{

            Document mbet = Jsoup.connect(url).get();//Mbet distingue los partidos de hoy del resto de dias
            Elements gdtr = mbet.getElementsByClass("price height-column-with-price    first-in-main-row  coupone-width-3");
            Elements elementosEquip = mbet.select("div [id=container_" + container + "]");
            Elements elementosCuota = elementosEquip.select("div [class=today-member-name nowrap ]");
            Elements elementosCuot = elementosEquip.select("div [class=member-name nowrap]");
            Elements elementosCuota1 = elementosEquip.select("div [class=price height-column-with-price    first-in-main-row  coupone-width-3]");
            Elements elementosCuotaX2 = elementosEquip.select("div [class=price height-column-with-price    coupone-width-3]");


            ArrayList<String> listaEquipos = new ArrayList<>();
            for (Element element : elementosCuota) {
                String equipos = element.text();
                listaEquipos.add(equipos);
            }
            for (Element element : elementosCuot) {
                String equipos = element.text();
                listaEquipos.add(equipos);
            }
            ArrayList<String> listaEqu = new ArrayList<>();
            for (Element element : elementosCuota1) {
                String equipos = element.text();
                listaEqu.add(equipos);
            }
            ArrayList<String> listaE = new ArrayList<>();
            for (Element element : elementosCuotaX2) {
                String equipos = element.text();
                listaE.add(equipos);
            }


            int tamaño2array = elementosCuota1.size() + elementosCuotaX2.size();

            ArrayList<String> listaCuotas = new ArrayList<>();
            int a = 0;
            int c = 0;
            int b = 1;


            for(int i = 0; i<=(tamaño2array / 3) - 1;i++) {
                listaCuotas.add(listaEqu.get(a));
                listaCuotas.add(listaE.get(c));
                listaCuotas.add(listaE.get(b));
                a++;
                c+=2;
                b+=2;
            }


            int aaa = 0;
            int bbb = 1;
            int ccc = 0;
            int ddd = 1;
            int eee = 2;
            int numeroidentificadordos = 1;


            BaseDatosFirebase bd = new BaseDatosFirebase();
            DatabaseReference dbreference = bd.getDbreference().child(casa).child(liga);

                if (listaEquipos.size() != 0) {
                    for (int i = 0; i <= (listaEquipos.size() / 2) - 1; i++) {
                        String numid = Integer.toString(numeroidentificadordos);
                        dbreference.child(numid).child("Equipo1").setValue(listaEquipos.get(aaa));
                        dbreference.child(numid).child("Equipo2").setValue(listaEquipos.get(bbb));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotas.get(ccc));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotas.get(eee));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotas.get(ddd));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaEquipos.get(aaa), listaEquipos.get(bbb),listaCuotas.get(ccc), listaCuotas.get(ddd), listaCuotas.get(eee), liga, casa);
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

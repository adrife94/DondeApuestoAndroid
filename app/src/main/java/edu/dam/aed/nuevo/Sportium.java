package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Sportium {
    public void parseadorSportium(String casa,String liga,String url ){
              try {



            Document SportiumLaLiga = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements clasesSportiumLaLiga = SportiumLaLiga.getElementsByClass("coupon coupon-horizontal coupon-scoreboard video-enabled");
            Elements cuotasSportiumLaLiga = clasesSportiumLaLiga.select("span[class=price dec]");
            Elements nombreEquiposSportiumLaLiga =clasesSportiumLaLiga.select("span[class=seln-name]");
            Elements fechaEquiposSportium = SportiumLaLiga.select("span[class=date]");
            Elements horaEquiposSportium = clasesSportiumLaLiga.select("span[class=time]");


            ArrayList<String> listaPartidosSportiumLaLiga = new ArrayList<>();
            for (Element element : nombreEquiposSportiumLaLiga) {
                String equipos = element.text();
                listaPartidosSportiumLaLiga.add(equipos);
            }

            ArrayList<String> listaCuotasSportiumLaLiga = new ArrayList<>();
            for (Element element : cuotasSportiumLaLiga) {
                String equipos = element.text();
                listaCuotasSportiumLaLiga.add(equipos);
            }

            ArrayList<String> listaFechasSportiumLaLiga = new ArrayList<>();
            for (Element element : fechaEquiposSportium) {
                  String equipos = element.text();
                  listaFechasSportiumLaLiga.add(equipos);
            }

            ArrayList<String> listaHorasSportiumLaLiga = new ArrayList<>();
            for (Element element : horaEquiposSportium) {
                  String equipos = element.text();
                  listaHorasSportiumLaLiga.add(equipos);
            }



            int a = 0;
            int b = 1;
            int c = 0;
            int d = 1;
            int e = 2;
            int fechahora = 0;
            int numeroidentificador = 1;



                  BaseDatosFirebase bd = new BaseDatosFirebase();
                  DatabaseReference dbreference = bd.getDbreference().child(casa).child(liga);




                if(listaPartidosSportiumLaLiga.size()!= 0)  {


                    for (int i = 0; i < (listaPartidosSportiumLaLiga.size() / 2); i++) {

                        String numid = Integer.toString(numeroidentificador);
                        dbreference.child(numid).child("Equipo1").setValue(listaPartidosSportiumLaLiga.get(a));
                        dbreference.child(numid).child("Equipo2").setValue(listaPartidosSportiumLaLiga.get(b));
                        dbreference.child(numid).child("Cuota1").setValue(listaCuotasSportiumLaLiga.get(c));
                        dbreference.child(numid).child("CuotaX").setValue(listaCuotasSportiumLaLiga.get(e));
                        dbreference.child(numid).child("Cuota2").setValue(listaCuotasSportiumLaLiga.get(d));

                        Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosSportiumLaLiga.get(a), listaPartidosSportiumLaLiga.get(b),listaCuotasSportiumLaLiga.get(c), listaCuotasSportiumLaLiga.get(d), listaCuotasSportiumLaLiga.get(e), listaFechasSportiumLaLiga.get(fechahora), listaHorasSportiumLaLiga.get(fechahora), liga, casa);
                        SS.Monitor.aumentador1Identificador();
                        SS.Monitor.append(evento);

                        a += 2;
                        b += 2;
                        c += 3;
                        d += 3;
                        e += 3;
                        numeroidentificador++;
                        fechahora++;
                    }


                }


        } catch (IOException e) {

        }

    }



}

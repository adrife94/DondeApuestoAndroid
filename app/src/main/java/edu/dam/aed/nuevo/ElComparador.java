package edu.dam.aed.nuevo;

import com.google.firebase.database.DatabaseReference;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ElComparador {
    public void parseadorElComparador(String liga,String url ) {
        try {
            Document suertia = Jsoup.connect(url).get();  //obtenemos la informacion de la pagina que le decimos
            Elements elementosCuota = suertia.select("div [class=impar], div [class=par], div [class=par verde], div [class=impar verde]");
          //  Elements elementosCuot = elementosCuota.select("div [id=celda_cuotas]");


            Elements elementosEquip = suertia.select("div [class=equipo]");
          //  Elements elementosEquipos = elementosEquip.select("span [class=equipo]");

            System.out.println(elementosEquip.text());

            ArrayList<String> listaCuotasElComparador = new ArrayList<>();
            for (Element element : elementosCuota) {
                String cuotas = element.text();
                if (!cuotas.equals("")) {
                    listaCuotasElComparador.add(cuotas);
                } else if (cuotas.equals("-")) {
                    listaCuotasElComparador.add("null");
                }
                System.out.println(cuotas);
            }

            ArrayList<String> listaPartidosElComparador = new ArrayList<>();
            for (Element element : elementosEquip) {
                String equipos = element.text();
                listaPartidosElComparador.add(equipos);
                System.out.println(equipos);
            }

            int equipoLocalBet365 = 0;
            int equipoVisitanteBet365 = 1;
            int cuota1Bet365 = 0;
            int cuotaXBet365 = 12;
            int cuota2Bet365 = 24;

            int equipoLocalBwin = 0;
            int equipoVisitanteBwin = 1;
            int cuota1Bwin = 1;
            int cuotaXBwin = 13;
            int cuota2Bwin = 25;

            int equipoLocalMbet = 0;
            int equipoVisitanteMbet = 1;
            int cuota1Mbet = 2;
            int cuotaXMbet = 14;
            int cuota2Mbet = 26;

            int equipoLocalLuckia = 0;
            int equipoVisitanteLuckia = 1;
            int cuota1Luckia = 3;
            int cuotaXLuckia = 15;
            int cuota2Luckia = 27;

            int equipoLocalSportium = 0;
            int equipoVisitanteSportium = 1;
            int cuota1Sportium = 4;
            int cuotaXSportium = 16;
            int cuota2Sportium = 28;

            int equipoLocalBetway = 0;
            int equipoVisitanteBetway= 1;
            int cuota1Betway = 5;
            int cuotaXBetway = 17;
            int cuota2Betway = 29;

            int equipoLocalMarca = 0;
            int equipoVisitanteMarca = 1;
            int cuota1Marca = 6;
            int cuotaXMarca = 18;
            int cuota2Marca = 30;

            int equipoLocalWilliam = 0;
            int equipoVisitanteWilliam = 1;
            int cuota1William = 7;
            int cuotaXWilliam = 19;
            int cuota2William = 31;

            int equipoLocal888 = 0;
            int equipoVisitante888 = 1;
            int cuota1888 = 8;
            int cuotaX888 = 20;
            int cuota2888 = 32;

            int equipoLocalBetfair = 0;
            int equipoVisitanteBetfair = 1;
            int cuota1Betfair = 9;
            int cuotaXBetfair = 21;
            int cuota2Betfair = 33;

            int equipoLocalInterwetten = 0;
            int equipoVisitanteInterwetten = 1;
            int cuota1Interwetten = 10;
            int cuotaXInterwetten = 22;
            int cuota2Interwetten = 34;

            int equipoLocalLeovegas = 0;
            int equipoVisitanteLeovegas = 1;
            int cuota1Leovegas = 11;
            int cuotaXLeovegas = 23;
            int cuota2Leovegas = 35;


            int numeroidentificadordos = 1;

            BaseDatosFirebase bd = new BaseDatosFirebase();

            // Este es el orden de casas que aparece en elcomparador
            DatabaseReference dbreferenceBET365 = bd.getDbreference().child("ElComparador").child("Bet365").child(liga);
            DatabaseReference dbreferenceBWIN = bd.getDbreference().child("ElComparador").child("Bwin").child(liga);
            DatabaseReference dbreferenceMBET = bd.getDbreference().child("ElComparador").child("Mbet").child(liga);
            DatabaseReference dbreferenceLUCKIA = bd.getDbreference().child("ElComparador").child("Luckia").child(liga);
            DatabaseReference dbreferenceSPORTIUM = bd.getDbreference().child("ElComparador").child("Sportium").child(liga);
            DatabaseReference dbreferenceBETWAY = bd.getDbreference().child("ElComparador").child("Betway").child(liga);
            DatabaseReference dbreferenceMARCA = bd.getDbreference().child("ElComparador").child("Marca").child(liga);
            DatabaseReference dbreferenceWILLIAM = bd.getDbreference().child("ElComparador").child("WilliamHill").child(liga);
            DatabaseReference dbreference888SPORT = bd.getDbreference().child("ElComparador").child("888Sport").child(liga);
            DatabaseReference dbreferenceBETFAIR = bd.getDbreference().child("ElComparador").child("Betfair").child(liga);
            DatabaseReference dbreferenceINTERWETTEN = bd.getDbreference().child("ElComparador").child("Interwetten").child(liga);
            DatabaseReference dbreferenceLEOVEGAS = bd.getDbreference().child("ElComparador").child("Leovegas").child(liga);


            if(listaPartidosElComparador.size()!= 0) {

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceBET365.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalBet365));
                    dbreferenceBET365.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteBet365));
                    dbreferenceBET365.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Bet365));
                    dbreferenceBET365.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXBet365));
                    dbreferenceBET365.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Bet365));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalBet365),listaPartidosElComparador.get(equipoVisitanteBet365), listaCuotasElComparador.get(cuota1Bet365), listaCuotasElComparador.get(cuotaXBet365), listaCuotasElComparador.get(cuota2Bet365), liga, "Bet365EC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalBet365 += 2;
                    equipoVisitanteBet365 += 2;
                    cuota1Bet365 += 36;
                    cuotaXBet365 += 36;
                    cuota2Bet365 += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceBWIN.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalBwin));
                    dbreferenceBWIN.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteBwin));
                    dbreferenceBWIN.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Bwin));
                    dbreferenceBWIN.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXBwin));
                    dbreferenceBWIN.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Bwin));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalBwin),listaPartidosElComparador.get(equipoVisitanteBwin), listaCuotasElComparador.get(cuota1Bwin), listaCuotasElComparador.get(cuotaXBwin), listaCuotasElComparador.get(cuota2Bwin), liga, "BwinEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalBwin += 2;
                    equipoVisitanteBwin += 2;
                    cuota1Bwin += 36;
                    cuotaXBwin += 36;
                    cuota2Bwin += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceMBET.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalMbet));
                    dbreferenceMBET.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteMbet));
                    dbreferenceMBET.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Mbet));
                    dbreferenceMBET.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXMbet));
                    dbreferenceMBET.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Mbet));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalMbet),listaPartidosElComparador.get(equipoVisitanteMbet), listaCuotasElComparador.get(cuota1Mbet), listaCuotasElComparador.get(cuotaXMbet), listaCuotasElComparador.get(cuota2Mbet), liga, "MbetEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalMbet += 2;
                    equipoVisitanteMbet += 2;
                    cuota1Mbet += 36;
                    cuotaXMbet += 36;
                    cuota2Mbet += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceLUCKIA.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalLuckia));
                    dbreferenceLUCKIA.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteLuckia));
                    dbreferenceLUCKIA.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Luckia));
                    dbreferenceLUCKIA.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXLuckia));
                    dbreferenceLUCKIA.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Luckia));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalLuckia),listaPartidosElComparador.get(equipoVisitanteLuckia), listaCuotasElComparador.get(cuota1Luckia), listaCuotasElComparador.get(cuotaXLuckia), listaCuotasElComparador.get(cuota2Luckia), liga, "LuckiaEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalLuckia += 2;
                    equipoVisitanteLuckia += 2;
                    cuota1Luckia += 36;
                    cuotaXLuckia += 36;
                    cuota2Luckia += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceSPORTIUM.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalSportium));
                    dbreferenceSPORTIUM.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteSportium));
                    dbreferenceSPORTIUM.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Sportium));
                    dbreferenceSPORTIUM.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXSportium));
                    dbreferenceSPORTIUM.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Sportium));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalSportium),listaPartidosElComparador.get(equipoVisitanteSportium), listaCuotasElComparador.get(cuota1Sportium), listaCuotasElComparador.get(cuotaXSportium), listaCuotasElComparador.get(cuota2Sportium), liga, "SportiumEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalSportium += 2;
                    equipoVisitanteSportium += 2;
                    cuota1Sportium += 36;
                    cuotaXSportium += 36;
                    cuota2Sportium += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceBETWAY.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalBetway));
                    dbreferenceBETWAY.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteBetway));
                    dbreferenceBETWAY.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Betway));
                    dbreferenceBETWAY.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXBetway));
                    dbreferenceBETWAY.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Betway));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalBetway),listaPartidosElComparador.get(equipoVisitanteBetway), listaCuotasElComparador.get(cuota1Betway), listaCuotasElComparador.get(cuotaXBetway), listaCuotasElComparador.get(cuota2Betway), liga, "BetwayEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalBetway += 2;
                    equipoVisitanteBetway += 2;
                    cuota1Betway += 36;
                    cuotaXBetway += 36;
                    cuota2Betway += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceMARCA.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalMarca));
                    dbreferenceMARCA.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteMarca));
                    dbreferenceMARCA.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Marca));
                    dbreferenceMARCA.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXMarca));
                    dbreferenceMARCA.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Marca));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalMarca),listaPartidosElComparador.get(equipoVisitanteMarca), listaCuotasElComparador.get(cuota1Marca), listaCuotasElComparador.get(cuotaXMarca), listaCuotasElComparador.get(cuota2Marca), liga, "MarcaEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoVisitanteMarca += 2;
                    cuota1Marca += 36;
                    cuotaXMarca += 36;
                    cuota2Marca += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceWILLIAM.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalWilliam));
                    dbreferenceWILLIAM.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteWilliam));
                    dbreferenceWILLIAM.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1William));
                    dbreferenceWILLIAM.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXWilliam));
                    dbreferenceWILLIAM.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2William));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalWilliam),listaPartidosElComparador.get(equipoVisitanteWilliam), listaCuotasElComparador.get(cuota1William), listaCuotasElComparador.get(cuotaXWilliam), listaCuotasElComparador.get(cuota2William), liga, "WilliamEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalWilliam += 2;
                    equipoVisitanteWilliam += 2;
                    cuota1William += 36;
                    cuotaXWilliam += 36;
                    cuota2William += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreference888SPORT.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocal888));
                    dbreference888SPORT.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitante888));
                    dbreference888SPORT.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1888));
                    dbreference888SPORT.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaX888));
                    dbreference888SPORT.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2888));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocal888),listaPartidosElComparador.get(equipoVisitante888), listaCuotasElComparador.get(cuota1888), listaCuotasElComparador.get(cuotaX888), listaCuotasElComparador.get(cuota2888), liga, "888EC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocal888 += 2;
                    equipoVisitante888 += 2;
                    cuota1888 += 36;
                    cuotaX888 += 36;
                    cuota2888 += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceBETFAIR.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalBetfair));
                    dbreferenceBETFAIR.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteBetfair));
                    dbreferenceBETFAIR.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Betfair));
                    dbreferenceBETFAIR.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXBetfair));
                    dbreferenceBETFAIR.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Betfair));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalBetfair),listaPartidosElComparador.get(equipoVisitanteBetfair), listaCuotasElComparador.get(cuota1Betfair), listaCuotasElComparador.get(cuotaXBetfair), listaCuotasElComparador.get(cuota2Betfair), liga, "BetfairEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalBetfair += 2;
                    equipoVisitanteBetfair += 2;
                    cuota1Betfair += 36;
                    cuotaXBetfair += 36;
                    cuota2Betfair += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceINTERWETTEN.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalInterwetten));
                    dbreferenceINTERWETTEN.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteInterwetten));
                    dbreferenceINTERWETTEN.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Interwetten));
                    dbreferenceINTERWETTEN.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXInterwetten));
                    dbreferenceINTERWETTEN.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Interwetten));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalInterwetten),listaPartidosElComparador.get(equipoVisitanteInterwetten), listaCuotasElComparador.get(cuota1Interwetten), listaCuotasElComparador.get(cuotaXInterwetten), listaCuotasElComparador.get(cuota2Interwetten), liga, "InterwettenEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalInterwetten += 2;
                    equipoVisitanteInterwetten += 2;
                    cuota1Interwetten += 36;
                    cuotaXInterwetten += 36;
                    cuota2Interwetten += 36;
                    numeroidentificadordos++;

                }

                for (int i = 0; i <= (listaPartidosElComparador.size() / 2) - 1; i++) {
                    String numid = Integer.toString(numeroidentificadordos);
                    dbreferenceLEOVEGAS.child(numid).child("Equipo1").setValue(listaPartidosElComparador.get(equipoLocalLeovegas));
                    dbreferenceLEOVEGAS.child(numid).child("Equipo2").setValue(listaPartidosElComparador.get(equipoVisitanteLeovegas));
                    dbreferenceLEOVEGAS.child(numid).child("Cuota1").setValue(listaCuotasElComparador.get(cuota1Leovegas));
                    dbreferenceLEOVEGAS.child(numid).child("CuotaX").setValue(listaCuotasElComparador.get(cuotaXLeovegas));
                    dbreferenceLEOVEGAS.child(numid).child("Cuota2").setValue(listaCuotasElComparador.get(cuota2Leovegas));

                    Evento evento = new Evento(String.valueOf(SS.Monitor.getNumeroIdentificador()),listaPartidosElComparador.get(equipoLocalLeovegas),listaPartidosElComparador.get(equipoVisitanteLeovegas), listaCuotasElComparador.get(cuota1Leovegas), listaCuotasElComparador.get(cuotaXLeovegas), listaCuotasElComparador.get(cuota2Leovegas), liga, "LeovegasEC");
                    SS.Monitor.aumentador1Identificador();
                    SS.Monitor.append(evento);

                    equipoLocalLeovegas += 2;
                    equipoVisitanteLeovegas += 2;
                    cuota1Leovegas += 36;
                    cuotaXLeovegas += 36;
                    cuota2Leovegas += 36;
                    numeroidentificadordos++;

                }
            }


        } catch (Exception nn) {
            nn.printStackTrace();
        }
    }
}

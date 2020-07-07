package edu.dam.aed.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class SS extends AppCompatActivity {
    private TextView ss;
    private TextView tv;
    private Button btnvolver;
    String s= "hola";
    ProgressBar progressBar;
    Monitor monitor = new Monitor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);

      //  barraprogres = findViewById(R.id.barraprogres);

     /*   Intent i = getIntent();

        ss = (TextView) findViewById(R.id.ss);
        ss.setText( i.getStringExtra("s"));*/

        progressBar = findViewById(R.id.progressbar);
        progressBar.setMax(80);
        btnvolver = findViewById(R.id.btnvolver);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SS.this, MainActivity.class);
                startActivity(i);

            }
        });

       /* new Thread(new Runnable() { //El thread es el que ejecuta lo que digas de forma paralela
            @Override
            public void run() {

         *//*        progressBar.setProgress(0);
                final StringBuilder suer= new StringBuilder();

                Suertia suertia = new Suertia();
                suertia.parseadorSuertia("Suertia", "LaLiga", "https://apuestas.suertia.es/competicion/306-primera-division");
               suertia.parseadorSuertia("Suertia", "Premier", "https://apuestas.suertia.es/competicion/94-premier-league");
                suertia.parseadorSuertia("Suertia", "Ligue1", "https://apuestas.suertia.es/competicion/96-ligue-1");
                suertia.parseadorSuertia("Suertia", "Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga");
                suertia.parseadorSuertia("Suertia", "Calcio", "https://apuestas.suertia.es/competicion/305-serie-a");


                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });*//*
                Sportium sportium = new Sportium();
                sportium.parseadorSportium("Sportium","LaLiga", "https://sports.sportium.es/es/t/45211/La-Liga");
                sportium.parseadorSportium("Sportium","Premier", "https://sports.sportium.es/es/t/40527/Premier-League");
                sportium.parseadorSportium("Sportium","Calcio", "https://sports.sportium.es/es/t/44571/Serie-A");
                sportium.parseadorSportium("Sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga");
                sportium.parseadorSportium("Sportium","Ligue1", "https://sports.sportium.es/es/t/46074/Ligue-1");
            *//*    progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });
                Mbet mbet = new Mbet();
                mbet.parseadorMbet("Mbet", "LaLiga", "8736","https://www.marathonbet.es/es/popular/Football/Spain/Primera+Division");
                mbet.parseadorMbet("Mbet", "Bundesliga", "22436","https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga");
                mbet.parseadorMbet("Mbet", "Ligue1", "21533","https://www.marathonbet.es/es/popular/Football/France/Ligue+1");
                mbet.parseadorMbet("Mbet", "Premier", "21520","https://www.marathonbet.es/es/popular/Football/England/Premier+League");
                mbet.parseadorMbet("Mbet", "Calcio", "22434","https://www.marathonbet.es/es/popular/Football/Italy/Serie+A");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });

                Marcaapuestas marcaapuestas = new Marcaapuestas();
                marcaapuestas.parseadorMarca("Marcaapuestas", "LaLiga", "https://deportes.marcaapuestas.es/es/t/19160/LaLiga-Santander");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Bundesliga", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Premier", "https://deportes.marcaapuestas.es/es/t/19157/Inglaterra-Premier-League");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Calcio", "https://deportes.marcaapuestas.es/es/t/19159/Serie-A");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Ligue1", "https://deportes.marcaapuestas.es/es/t/19327/Ligue-1");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });

                Interwetten interwetten = new Interwetten();
                interwetten.parseadorInterwetten("Interwetten", "LaLiga", "https://www.interwetten.es/es/apuestas-deportivas/l/1030/espana-laliga");
                interwetten.parseadorInterwetten("Interwetten", "Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional");
                interwetten.parseadorInterwetten("Interwetten", "Premier", "https://www.interwetten.es/es/apuestas-deportivas/l/1021/inglaterra-liga-premier");
                interwetten.parseadorInterwetten("Interwetten", "Calcio", "https://www.interwetten.es/es/apuestas-deportivas/l/1029/italia-serie-a");
                interwetten.parseadorInterwetten("Interwetten", "Ligue1", "https://www.interwetten.es/es/apuestas-deportivas/l/1024/francia-1a-division");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                GoldenPark goldenPark = new GoldenPark();
                goldenPark.parseadorGolden("GoldenPark", "Laliga", "https://apuestas.goldenpark.es/es/competicion/306-primera-division");
                goldenPark.parseadorGolden("GoldenPark", "Premier", "https://apuestas.goldenpark.es/es/competicion/94-premier-league");
                goldenPark.parseadorGolden("GoldenPark", "Ligue1", "https://apuestas.goldenpark.es/es/competicion/96-ligue-1");
                goldenPark.parseadorGolden("GoldenPark", "Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga");
                goldenPark.parseadorGolden("GoldenPark", "Calcio", "https://apuestas.goldenpark.es/es/competicion/305-serie-a");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                CasinoBarcelona casinoBarcelona = new CasinoBarcelona();
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "LaLiga", "https://apuestas.casinobarcelona.es/competicion/306-primera-division");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Premier", "https://apuestas.casinobarcelona.es/competicion/94-premier-league");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Ligue1", "https://apuestas.casinobarcelona.es/competicion/96-ligue-1");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Calcio", "https://apuestas.casinobarcelona.es/competicion/305-serie-a");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                Betfair betfair = new Betfair();
                betfair.parseadorBetfair("Betfair", "LaLiga", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117");
                betfair.parseadorBetfair("Betfair", "Premier", "https://www.betfair.es/sport/football/premier-league-inglesa/10932509");
                betfair.parseadorBetfair("Betfair", "Bundesliga", "https://www.betfair.es/sport/football/bundesliga-alemana/59");
                betfair.parseadorBetfair("Betfair", "Ligue1", "https://www.betfair.es/sport/football/ligue-1-francesa/55");
                betfair.parseadorBetfair("Betfair", "Calcio", "https://www.betfair.es/sport/football/serie-a-italiana/81");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });*//*

            *//*      CasinoMadrid casinoMadrid = new CasinoMadrid();
                casinoMadrid.parseadorMadrid("CasinoMadrid", "LaLiga", "https://apuestas.casinogranmadridonline.es/competicion/306-primera-division");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Ligue1", "https://apuestas.casinogranmadridonline.es/competicion/96-ligue-1");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Premier", "https://apuestas.casinogranmadridonline.es/competicion/94-premier-league");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Bundesliga", "https://apuestas.casinogranmadridonline.es/competicion/268-bundesliga");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Calcio", "https://apuestas.casinogranmadridonline.es/competicion/305-serie-a");

                ElComparador elComparador = new ElComparador();
                elComparador.parseadorElComparador( "LaLiga", "http://www.elcomparador.com/futbol/espa%C3%B1a/primeradivision");
                elComparador.parseadorElComparador( "Ligue1", "http://www.elcomparador.com/futbol/francia/ligue1");
                elComparador.parseadorElComparador( "Premier", "http://www.elcomparador.com/futbol/inglaterra/premierleague");
                elComparador.parseadorElComparador("Bundesliga", "http://www.elcomparador.com/futbol/alemania/bundesliga1");
                elComparador.parseadorElComparador("Calcio", "http://www.elcomparador.com/futbol/italia/seriea");
                elComparador.parseadorElComparador("Champions",  "http://www.elcomparador.com/futbol/europa/championsleague");
                elComparador.parseadorElComparador("EuropaLeague",  "http://www.elcomparador.com/futbol/europa/europaleague");

*//*
            //    sendMail();
                //             Toast.makeText(SS.this, "mensaje enviado", Toast.LENGTH_SHORT).show();
*//*
                runOnUiThread(new Runnable() {  //Este conecta el run con la aplicacion
                    @Override
                    public void run() {
                        s = suer.toString();
                        //i.putExtra("s", s);
                        //startActivity(i);
                        tv.setText(suer.toString());
                        // Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                    }
                });*//*

         //   monitor.convertidorArrayString();

            }



        }).start();*/

        CargadorCasasApuestas cargadorCasasApuestas = new CargadorCasasApuestas();
        cargadorCasasApuestas.start();

        try {
            cargadorCasasApuestas.join();

        } catch (InterruptedException e) {

        }
            // Cada clase de casa de apuesta va a tener que guardar su json en monitor
        sendMail();

    }
    private void sendMail() {

        Monitor monitor = new Monitor();
        String mail = "enzocas888@gmail.com";
        monitor.convertidorArrayString();
        String mensajes = monitor.getSb().toString();
      //  String mensaje = String.valueOf(mensajes);


        String asunto = "fecha y hora";

        JavaMailAPI javaMailAPI = new JavaMailAPI(SS.this, mail,asunto,mensajes);
        javaMailAPI.execute();

    }

    public static class Monitor {
        private static ArrayList<Evento> listaeventos = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private static int numeroIdentificador;

        public Monitor(StringBuilder sb, int numeroIdentificador) {
            this.sb = sb;
            this.numeroIdentificador = 0;
        }

        public StringBuilder getSb() {
            return sb;
        }

        public void setSb(StringBuilder sb) {
            this.sb = sb;
        }


        public static int getNumeroIdentificador() {
            return numeroIdentificador;
        }

        public static void setNumeroIdentificador(int numeroIdentificador) {
            Monitor.numeroIdentificador = numeroIdentificador;
        }

        public static void aumentador1Identificador() {
            numeroIdentificador++;
        }

        public Monitor() {
            this.listaeventos = listaeventos;
        }

        public ArrayList<Evento> getListaeventos() {
            return listaeventos;
        }

        public void setListaeventos(ArrayList<Evento> listaeventos) {
            this.listaeventos = listaeventos;
        }

        public static synchronized void append(Evento evento) {
            listaeventos.add(evento);
        }

        public void convertidorArrayString() {
            final Gson gson = new Gson();
            for (Evento evento : listaeventos) {
                String string = gson.toJson(evento);
                sb.append(string);
                sb.append("\n");
            }
        }
    }

    private class CargadorCasasApuestas extends Thread{


        @Override
        public void run() {
            progressBar.setProgress(0);

           Suertia suertia = new Suertia();
            suertia.parseadorSuertia("Suertia", "LaLiga", "https://apuestas.suertia.es/competicion/306-primera-division");
            suertia.parseadorSuertia("Suertia", "Premier", "https://apuestas.suertia.es/competicion/94-premier-league");
            suertia.parseadorSuertia("Suertia", "Ligue1", "https://apuestas.suertia.es/competicion/96-ligue-1");
            suertia.parseadorSuertia("Suertia", "Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga");
            suertia.parseadorSuertia("Suertia", "Calcio", "https://apuestas.suertia.es/competicion/305-serie-a");


            progressBar.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.incrementProgressBy(10);
                }
            });
            Sportium sportium = new Sportium();
            sportium.parseadorSportium("Sportium","LaLiga", "https://sports.sportium.es/es/t/45211/La-Liga");
//            sportium.parseadorSportium("Sportium","Premier", "https://sports.sportium.es/es/t/40527/Premier-League");
    //        sportium.parseadorSportium("Sportium","Calcio", "https://sports.sportium.es/es/t/44571/Serie-A");
        //    sportium.parseadorSportium("Sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga");
       //     sportium.parseadorSportium("Sportium","Ligue1", "https://sports.sportium.es/es/t/46074/Ligue-1");
               progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });
                Mbet mbet = new Mbet();
                mbet.parseadorMbet("Mbet", "LaLiga", "8736","https://www.marathonbet.es/es/popular/Football/Spain/Primera+Division");
                mbet.parseadorMbet("Mbet", "Bundesliga", "22436","https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga");
                mbet.parseadorMbet("Mbet", "Ligue1", "21533","https://www.marathonbet.es/es/popular/Football/France/Ligue+1");
                mbet.parseadorMbet("Mbet", "Premier", "21520","https://www.marathonbet.es/es/popular/Football/England/Premier+League");
                mbet.parseadorMbet("Mbet", "Calcio", "22434","https://www.marathonbet.es/es/popular/Football/Italy/Serie+A");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });

                Marcaapuestas marcaapuestas = new Marcaapuestas();
                marcaapuestas.parseadorMarca("Marcaapuestas", "LaLiga", "https://deportes.marcaapuestas.es/es/t/19160/LaLiga-Santander");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Bundesliga", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Premier", "https://deportes.marcaapuestas.es/es/t/19157/Inglaterra-Premier-League");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Calcio", "https://deportes.marcaapuestas.es/es/t/19159/Serie-A");
                marcaapuestas.parseadorMarca("Marcaapuestas", "Ligue1", "https://deportes.marcaapuestas.es/es/t/19327/Ligue-1");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });

                Interwetten interwetten = new Interwetten();
                interwetten.parseadorInterwetten("Interwetten", "LaLiga", "https://www.interwetten.es/es/apuestas-deportivas/l/1030/espana-laliga");
                interwetten.parseadorInterwetten("Interwetten", "Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional");
                interwetten.parseadorInterwetten("Interwetten", "Premier", "https://www.interwetten.es/es/apuestas-deportivas/l/1021/inglaterra-liga-premier");
                interwetten.parseadorInterwetten("Interwetten", "Calcio", "https://www.interwetten.es/es/apuestas-deportivas/l/1029/italia-serie-a");
                interwetten.parseadorInterwetten("Interwetten", "Ligue1", "https://www.interwetten.es/es/apuestas-deportivas/l/1024/francia-1a-division");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                GoldenPark goldenPark = new GoldenPark();
                goldenPark.parseadorGolden("GoldenPark", "Laliga", "https://apuestas.goldenpark.es/es/competicion/306-primera-division");
                goldenPark.parseadorGolden("GoldenPark", "Premier", "https://apuestas.goldenpark.es/es/competicion/94-premier-league");
                goldenPark.parseadorGolden("GoldenPark", "Ligue1", "https://apuestas.goldenpark.es/es/competicion/96-ligue-1");
                goldenPark.parseadorGolden("GoldenPark", "Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga");
                goldenPark.parseadorGolden("GoldenPark", "Calcio", "https://apuestas.goldenpark.es/es/competicion/305-serie-a");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                CasinoBarcelona casinoBarcelona = new CasinoBarcelona();
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "LaLiga", "https://apuestas.casinobarcelona.es/competicion/306-primera-division");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Premier", "https://apuestas.casinobarcelona.es/competicion/94-premier-league");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Ligue1", "https://apuestas.casinobarcelona.es/competicion/96-ligue-1");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga");
                casinoBarcelona.parseadorBarcelona("CasinoBarcelona", "Calcio", "https://apuestas.casinobarcelona.es/competicion/305-serie-a");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });


                Betfair betfair = new Betfair();
                betfair.parseadorBetfair("Betfair", "LaLiga", "https://www.betfair.es/sport/football/la-liga-espa%C3%B1ola/117");
                betfair.parseadorBetfair("Betfair", "Premier", "https://www.betfair.es/sport/football/premier-league-inglesa/10932509");
                betfair.parseadorBetfair("Betfair", "Bundesliga", "https://www.betfair.es/sport/football/bundesliga-alemana/59");
                betfair.parseadorBetfair("Betfair", "Ligue1", "https://www.betfair.es/sport/football/ligue-1-francesa/55");
                betfair.parseadorBetfair("Betfair", "Calcio", "https://www.betfair.es/sport/football/serie-a-italiana/81");
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.incrementProgressBy(10);
                    }
                });

/*
                  CasinoMadrid casinoMadrid = new CasinoMadrid();
                casinoMadrid.parseadorMadrid("CasinoMadrid", "LaLiga", "https://apuestas.casinogranmadridonline.es/competicion/306-primera-division");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Ligue1", "https://apuestas.casinogranmadridonline.es/competicion/96-ligue-1");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Premier", "https://apuestas.casinogranmadridonline.es/competicion/94-premier-league");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Bundesliga", "https://apuestas.casinogranmadridonline.es/competicion/268-bundesliga");
                casinoMadrid.parseadorMadrid("CasinoMadrid", "Calcio", "https://apuestas.casinogranmadridonline.es/competicion/305-serie-a");
*/



                ElComparador elComparador = new ElComparador();
                elComparador.parseadorElComparador( "LaLiga", "http://www.elcomparador.com/futbol/espa%C3%B1a/primeradivision");
                elComparador.parseadorElComparador( "Ligue1", "http://www.elcomparador.com/futbol/francia/ligue1");
                elComparador.parseadorElComparador( "Premier", "http://www.elcomparador.com/futbol/inglaterra/premierleague");
                elComparador.parseadorElComparador("Bundesliga", "http://www.elcomparador.com/futbol/alemania/bundesliga1");
                elComparador.parseadorElComparador("Calcio", "http://www.elcomparador.com/futbol/italia/seriea");
                elComparador.parseadorElComparador("Champions",  "http://www.elcomparador.com/futbol/europa/championsleague");
                elComparador.parseadorElComparador("EuropaLeague",  "http://www.elcomparador.com/futbol/europa/europaleague");



        }
    }

}

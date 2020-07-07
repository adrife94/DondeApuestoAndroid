package edu.dam.aed.nuevo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class EleccionCasaSportiumActivity extends AppCompatActivity {
    private ListView lv;
    private Adaptador adaptadorliga, adaptadorpremier, adaptadorcalcio, adaptadorbundesliga, adaptadorligue1;
    private Button btnliga, btnpremier, btncalcio, btnbundesliga,btnligueone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_casa_sportium);

     /*   lv = findViewById(R.id.listaequi);




        final ArrayList<EventoListado> listasportiumliga = new ArrayList<>();
        final ArrayList<EventoListado> listasportiumpremier = new ArrayList<>();
        final ArrayList<EventoListado> listasportiumbundesliga = new ArrayList<>();
        final ArrayList<EventoListado> listasportiumcalcio = new ArrayList<>();
        final ArrayList<EventoListado> listasportiumligue1 = new ArrayList<>();

        adaptadorliga = new Adaptador(listasportiumliga,this);
        adaptadorligue1 = new Adaptador(listasportiumligue1,this);
        adaptadorcalcio = new Adaptador(listasportiumcalcio,this);
        adaptadorpremier = new Adaptador(listasportiumpremier,this);
        adaptadorbundesliga = new Adaptador(listasportiumbundesliga,this);

        lv.setAdapter(adaptadorliga);

        // adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);


        BaseDatosFirebase bd = new BaseDatosFirebase();
        DatabaseReference dbreference = bd.getDbreference().child("Sportium").child("LaLiga");
        dbreference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {  // me tengo que crear una clase (eventoListado)que ponga ATM MADRID y las cuotas, para inflarlas y que me aparezcan
                String nombre1 = dataSnapshot.child("Equipo1").getValue().toString();
                String nombre2 = dataSnapshot.child("Equipo2").getValue().toString();
                String mejorcuota1string = dataSnapshot.child("Cuota1").getValue().toString();
                Double mejorcuota1 = Double.parseDouble(mejorcuota1string);
                String mejorcuotaxstring = dataSnapshot.child("CuotaX").getValue().toString();
                Double mejorcuotax = Double.parseDouble(mejorcuotaxstring);
                String mejorcuota2string = dataSnapshot.child("Cuota2").getValue().toString();
                Double mejorcuota2 = Double.parseDouble(mejorcuota2string);

                EventoListado eventoListado = new EventoListado(nombre1, nombre2, mejorcuota1string,mejorcuotaxstring,mejorcuota2string);
                listasportiumliga.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorliga.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference dbpremier = bd.getDbreference().child("Sportium").child("Premier");
        dbpremier.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {  // me tengo que crear una clase (eventoListado)que ponga ATM MADRID y las cuotas, para inflarlas y que me aparezcan
                String nombre1 = dataSnapshot.child("Equipo1").getValue().toString();
                String nombre2 = dataSnapshot.child("Equipo2").getValue().toString();
                String mejorcuota1string = dataSnapshot.child("Cuota1").getValue().toString();
                Double mejorcuota1 = Double.parseDouble(mejorcuota1string);
                String mejorcuotaxstring = dataSnapshot.child("CuotaX").getValue().toString();
                Double mejorcuotax = Double.parseDouble(mejorcuotaxstring);
                String mejorcuota2string = dataSnapshot.child("Cuota2").getValue().toString();
                Double mejorcuota2 = Double.parseDouble(mejorcuota2string);

                EventoListado eventoListado = new EventoListado(nombre1, nombre2, mejorcuota1string,mejorcuotaxstring,mejorcuota2string);
                listasportiumpremier.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorpremier.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference dbcalcio = bd.getDbreference().child("Sportium").child("Calcio");
        dbcalcio.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {  // me tengo que crear una clase (eventoListado)que ponga ATM MADRID y las cuotas, para inflarlas y que me aparezcan
                String nombre1 = dataSnapshot.child("Equipo1").getValue().toString();
                String nombre2 = dataSnapshot.child("Equipo2").getValue().toString();
                String mejorcuota1string = dataSnapshot.child("Cuota1").getValue().toString();
                Double mejorcuota1 = Double.parseDouble(mejorcuota1string);
                String mejorcuotaxstring = dataSnapshot.child("CuotaX").getValue().toString();
                Double mejorcuotax = Double.parseDouble(mejorcuotaxstring);
                String mejorcuota2string = dataSnapshot.child("Cuota2").getValue().toString();
                Double mejorcuota2 = Double.parseDouble(mejorcuota2string);

                EventoListado eventoListado = new EventoListado(nombre1, nombre2, mejorcuota1string,mejorcuotaxstring,mejorcuota2string);
                listasportiumcalcio.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorcalcio.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference dbBundesliga = bd.getDbreference().child("Sportium").child("Bundesliga");
        dbBundesliga.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {  // me tengo que crear una clase (eventoListado)que ponga ATM MADRID y las cuotas, para inflarlas y que me aparezcan
                String nombre1 = dataSnapshot.child("Equipo1").getValue().toString();
                String nombre2 = dataSnapshot.child("Equipo2").getValue().toString();
                String mejorcuota1string = dataSnapshot.child("Cuota1").getValue().toString();
                Double mejorcuota1 = Double.parseDouble(mejorcuota1string);
                String mejorcuotaxstring = dataSnapshot.child("CuotaX").getValue().toString();
                Double mejorcuotax = Double.parseDouble(mejorcuotaxstring);
                String mejorcuota2string = dataSnapshot.child("Cuota2").getValue().toString();
                Double mejorcuota2 = Double.parseDouble(mejorcuota2string);

                EventoListado eventoListado = new EventoListado(nombre1, nombre2, mejorcuota1string,mejorcuotaxstring,mejorcuota2string);
                listasportiumbundesliga.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorbundesliga.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference dbligue1 = bd.getDbreference().child("Sportium").child("Ligue1");
        dbligue1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {  // me tengo que crear una clase (eventoListado)que ponga ATM MADRID y las cuotas, para inflarlas y que me aparezcan
                String nombre1 = dataSnapshot.child("Equipo1").getValue().toString();
                String nombre2 = dataSnapshot.child("Equipo2").getValue().toString();
                String mejorcuota1string = dataSnapshot.child("Cuota1").getValue().toString();
                Double mejorcuota1 = Double.parseDouble(mejorcuota1string);
                String mejorcuotaxstring = dataSnapshot.child("CuotaX").getValue().toString();
                Double mejorcuotax = Double.parseDouble(mejorcuotaxstring);
                String mejorcuota2string = dataSnapshot.child("Cuota2").getValue().toString();
                Double mejorcuota2 = Double.parseDouble(mejorcuota2string);

                EventoListado eventoListado = new EventoListado(nombre1, nombre2, mejorcuota1string,mejorcuotaxstring,mejorcuota2string);
                listasportiumligue1.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorligue1.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        btnliga = findViewById(R.id.btnliga);
        btnliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentoCuotasLiga fragmentoCuotasLiga = new FragmentoCuotasLiga();
                Bundle bundles = new Bundle();
                bundles.putString("Casa", "Sportium");
              //  bundle.putString("Liga", "LaLiga");
                fragmentoCuotasLiga.setArguments(bundles);

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new FragmentoCuotasLiga());
                ft.commit();

            }
        });
        btnpremier = findViewById(R.id.btnpremier);
        btnpremier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btncalcio = findViewById(R.id.btncalcio);
        btncalcio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnbundesliga = findViewById(R.id.btnbundesliga);
        btnbundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnligueone = findViewById(R.id.btnligueone);
        btnligueone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

package edu.dam.aed.nuevo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class EleccionLaLigaActivity extends AppCompatActivity {
    private ListView lv;
    private Adaptador adaptadorr;
   // private ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccionlaliga);

        lv = findViewById(R.id.lv);

        final ArrayList<EventoListado> lista = new ArrayList<>();

        adaptadorr = new Adaptador(lista,this);

       // adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptadorr);

        BaseDatosFirebase bd = new BaseDatosFirebase();
        DatabaseReference dbreference = bd.getDbreference().child("Betfair").child("LaLiga");
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
                lista.add(eventoListado);
                //lista.add(nombre1 + " - " + nombre2);
                adaptadorr.notifyDataSetChanged();
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



    }
}

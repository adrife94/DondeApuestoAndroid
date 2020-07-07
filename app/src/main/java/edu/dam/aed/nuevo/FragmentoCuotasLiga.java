package edu.dam.aed.nuevo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


public class FragmentoCuotasLiga extends Fragment {
    private ListView listView;
    private Adaptador adaptadorliga;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_cuotas_ligas, container, false);
        listView = view.findViewById(R.id.listaequi);

        Bundle bundles = getArguments();

        String casaSeleccionada = bundles.getString("Casa");


       // String ligaSeleccionada = bundle.getString("Liga");

        final ArrayList<EventoListado> listasportiumliga = new ArrayList<>();
        /*EventoListado eventoListado = new EventoListado("d", "das", "1.1","2.2","3.3");
        EventoListado eventoListado1 = new EventoListado("d", "das", "1.1","2.2","3.3");
        listasportiumliga.add(eventoListado);
        listasportiumliga.add(eventoListado1);*/

        adaptadorliga = new Adaptador(listasportiumliga, view.getContext());
        listView.setAdapter(adaptadorliga);


        BaseDatosFirebase bds = new BaseDatosFirebase();
        DatabaseReference dbreferencia = bds.getDbreference().child("Sportium").child("LaLiga");
        dbreferencia.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
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


        return view;

    }





    }


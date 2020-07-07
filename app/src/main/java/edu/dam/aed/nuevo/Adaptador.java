package edu.dam.aed.nuevo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<EventoListado> listaeventos;
    Context contexto;

    public Adaptador(ArrayList<EventoListado> listaeventos, Context contexto) {
        this.listaeventos = listaeventos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listaeventos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaeventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventoListado evento = (EventoListado) getItem(position);

        convertView = LayoutInflater.from(contexto).inflate(R.layout.activity_item, null);
        final TextView equipo1 = (TextView) convertView.findViewById(R.id.equipo1);
        final TextView equipo2 = (TextView) convertView.findViewById(R.id.equipo2);
        final TextView cuota1 = (TextView) convertView.findViewById(R.id.mejorcuota1);
        final TextView cuotax = (TextView) convertView.findViewById(R.id.mejorcuotax);
        final TextView cuota2 = (TextView) convertView.findViewById(R.id.mejorcuota2);

        equipo1.setText(evento.getEquipo1());
        equipo2.setText(evento.getEquipo2());
        cuota1.setText(evento.getCuota1string());
        cuotax.setText(evento.getCuotaxstring());
        cuota2.setText(evento.getCuota2string());

        return convertView;

    }
}

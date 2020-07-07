package edu.dam.aed.nuevo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {
    private Button btnligas, btnseleccioncasas, btncasas, btnavisame;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnligas = findViewById(R.id.btnligas);
        btnligas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              i = new Intent(Opciones.this, Eleccion.class);
              startActivity(i);
            }
        });

        btnseleccioncasas = findViewById(R.id.btnseleccioncasas);
        btnseleccioncasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Opciones.this, CasaSelecionada1.class);
                startActivity(i);
            }
        });

        btncasas = findViewById(R.id.btncasas);
        btncasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Opciones.this, Casas.class);
                startActivity(i);
            }
        });
    }
}

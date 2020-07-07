package edu.dam.aed.nuevo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Casas extends AppCompatActivity {
    private Button btnsportium, btnbetfair, btnmarca, btnbarcelona, btnsuertia, btngolden, btninterwetten, btnmbet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casas);

        btnbarcelona = findViewById(R.id.idbarcelona);
        btnbarcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnbetfair = findViewById(R.id.idbetfair);
        btnbetfair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnmarca = findViewById(R.id.idmarca);
        btnmarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btngolden = findViewById(R.id.idgolden);
        btngolden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnmbet = findViewById(R.id.idmbet);
        btnmbet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnsportium = findViewById(R.id.idsportium);
        btnsportium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Casas.this, EleccionCasaSportiumActivity.class);
            startActivity(i);

            }
        });

        btninterwetten = findViewById(R.id.idinterwetten);
        btninterwetten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnsuertia = findViewById(R.id.idsuertia);
        btnsuertia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

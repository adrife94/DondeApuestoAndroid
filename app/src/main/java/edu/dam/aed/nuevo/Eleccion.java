package edu.dam.aed.nuevo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eleccion extends AppCompatActivity {
    private Button btnlaliga;
    private Button btnpremier;
    private Button btncalcio;
    private Button btnbundesliga;
    private Button btnligue1;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);

       btnlaliga = findViewById(R.id.btnlaliga);
       btnlaliga.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              i = new Intent(Eleccion.this, EleccionLaLigaActivity.class);
              startActivity(i);
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

       btnligue1 = findViewById(R.id.btnligue1);




    }
}

package edu.dam.aed.nuevo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btncargar;
    private Button btncomparador;
    private Button btncalculadora;
    private TextView tv;
    String s= "hola";
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);

        btncargar = findViewById(R.id.btncargar);
        btncargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i= new Intent(MainActivity.this, SS.class);
                startActivity(i);
            }
        });

        btncomparador = findViewById(R.id.btncomparador);
        btncomparador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i= new Intent(MainActivity.this, Opciones.class);
                startActivity(i);
            }
        });

        btncalculadora = findViewById(R.id.btncalculadora);
        btncalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(i);
            }
        });

       // Toast.makeText(MainActivity.this,"frfeffe",Toast.LENGTH_SHORT).show();







    }
}

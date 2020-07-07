package edu.dam.aed.nuevo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {
    private EditText cuota1, cuota2, cuota3, cantidad;
    private TextView probabilidad1surebets, probabilidad2surebets, probabilidad3surebets, resultado1surebets, resultado2surebets, resultado3surebets;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        cuota1 = findViewById(R.id.cuota1surebets);
        cuota2 = findViewById(R.id.cuota2surebets);
        cuota3 = findViewById(R.id.cuota3surebets);
        cantidad = findViewById(R.id.cantidad);
        btnCalcular = findViewById(R.id.btnCalcular);
        probabilidad1surebets = findViewById(R.id.probabilidad1surebets);
        probabilidad2surebets = findViewById(R.id.probabilidad2surebets);
        probabilidad3surebets = findViewById(R.id.probabilidad3surebets);
        resultado1surebets = findViewById(R.id.resultado1surebets);
        resultado2surebets = findViewById(R.id.resultado2surebets);
        resultado3surebets = findViewById(R.id.resultado3surebets);




        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int contador = 0;

                String valorcuota1 = cuota1.getText().toString().trim();
                double valornumericuota1 = 0.0;
                if (!valorcuota1.equals("")) {
                    valornumericuota1 = Double.parseDouble(valorcuota1);
                    contador++;
                }

                String valorcuota2= cuota2.getText().toString().trim();
                double valornumericuota2 = 0.0;
                if (!valorcuota2.equals("")) {
                    valornumericuota2 = Double.parseDouble(valorcuota2);
                    contador++;
                }

                String valorcuota3 = cuota3.getText().toString().trim();
                double valornumericuota3 = 0.0;
                if (!valorcuota3.equals("")) {
                    valornumericuota3 = Double.parseDouble(valorcuota3);
                    contador++;
                }
                String cantidadstring = cantidad.getText().toString();
                double valornumericantidad = 0.0;
                if(!cantidadstring.equals("")){
                    valornumericantidad = Double.parseDouble(cantidadstring);
                }



            switch (contador) {
                case 1:
                    Toast.makeText(CalculadoraActivity.this, "Solo has introducido una cuota", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    probabilidad1surebets.setText(Double.toString((1/valornumericuota1)*100));
                    probabilidad2surebets.setText(Double.toString((1/valornumericuota2)*100));
                    double arbitraje = (1/valornumericuota1+1/valornumericuota2) * 100;
                    double pago = valornumericantidad/arbitraje;
                    resultado1surebets.setText(Double.toString(pago));
                    resultado2surebets.setText(Double.toString(pago));
                    break;
                case 3:
                    probabilidad1surebets.setText(Double.toString((1/valornumericuota1)*100));
                    probabilidad2surebets.setText(Double.toString((valornumericuota2/1)*100));
                    probabilidad3surebets.setText(Double.toString((1/valornumericuota3)*100));
                    break;
            }

            }
        });


        //mirar CalculadorApuestasGratis
        //Codigo para apuestas gratis
        /*if (maximo == valornumericuota1) {
            importe1.setText(valorAG);
        } else {
            importe1.setText(Integer.toString((valornumericoAG * valornumericuota1)- valornumericoAG));
        }

        if (maximo == valornumericuota2) {
            importe2.setText(valorAG);
        } else {
            importe2.setText(Integer.toString((valornumericoAG * valornumericuota2)- valornumericoAG));
        }

        if (maximo == valornumericuota3) {
            importe3.setText(valorAG);
        } else {
            importe3.setText(Integer.toString((valornumericoAG * valornumericuota3)- valornumericoAG));
        }*/


    }
}

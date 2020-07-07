package edu.dam.aed.nuevo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CasaSelecionada3 extends AppCompatActivity {
    private Button btnterminar,btnsiguiente;
    private RadioGroup radiogroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_selecionada3);

        btnsiguiente = findViewById(R.id.btnsiguiente);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioid = radiogroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                Toast.makeText(CasaSelecionada3.this, "Esta es la opcion selecionada: " + radioButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });


        btnterminar = findViewById(R.id.btnterminar);
        btnterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CasaSelecionada3.this, Opciones.class);
                startActivity(i);
            }
        });
    }
    public void checkbuton(View v) {
        int radioid = radiogroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioid);
        // Toast.makeText(this, "Esta es la opcion selecionada: " + radioButton.getText(), )

    }
}

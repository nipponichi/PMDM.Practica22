package com.pmdm.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {

    private Button btnGuardar;

    private Switch swCelsius, swFahrenheit;

    private boolean celsius, fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        setVariables();
    }

    private void setVariables(){
        swCelsius = findViewById(R.id.swCelsius);
        swFahrenheit = findViewById(R.id.swFahrenheit);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(goToMenu);
        swFahrenheit.setOnClickListener(fahrenheitActivo);
        swCelsius.setOnClickListener(celsiusActivo);
    }

    //Volver al menu principal
    private final View.OnClickListener goToMenu = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Configuracion.this, MainActivity.class);
            startActivity(intent);
        }
    };

    //Al menos un switch debe estar en modo true
    private final View.OnClickListener celsiusActivo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(swCelsius.isChecked()){
                swFahrenheit.setChecked(false);
            }
            if(!swCelsius.isChecked()){
                swFahrenheit.setChecked(true);
            }
        }
    };

    //Al menos un switch debe estar en modo true
    private final View.OnClickListener fahrenheitActivo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(swFahrenheit.isChecked()){
                swCelsius.setChecked(false);
            }
            if(!swFahrenheit.isChecked()){
                swCelsius.setChecked(true);
            }
        }
    };

}
package com.pmdm.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button btnMedicionTemp, btnConversor, btnConfiguracion, btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setVariables();
        btnMedicionTemp.setOnClickListener(doTempChecking);
        btnConversor.setOnClickListener(doConversion);
        btnConfiguracion.setOnClickListener(doConfiguration);
        btnCerrarSesion.setOnClickListener(doCloseSesion);
    }
    private void setVariables(){
        btnMedicionTemp = findViewById(R.id.btnMedicionTemperatura);
        btnConversor = findViewById(R.id.btnConversor);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
    }

    Intent intent;

    //Va a MedicionTemperatura
   private final View.OnClickListener doTempChecking = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(Menu.this, MedicionTemperatura.class);
            startActivity(intent);
        }
    };

   //Va a Conversor
    private final View.OnClickListener doConversion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(Menu.this, Conversor.class);
            startActivity(intent);
        }
    };

    //Va a Configuracion
    private final View.OnClickListener doConfiguration = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(Menu.this, Configuracion.class);
            startActivity(intent);
        }
    };

    //Vuelve a login
    private final View.OnClickListener doCloseSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(Menu.this, MainActivity.class);
            startActivity(intent);
        }
    };

}
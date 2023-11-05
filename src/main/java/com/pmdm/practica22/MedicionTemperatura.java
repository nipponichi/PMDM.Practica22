package com.pmdm.practica22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MedicionTemperatura extends AppCompatActivity {

    private EditText etNombre, etApellidos, etTemperatura, etPoblacion, etProvincia;
    private Button btnFinalizar;
    private RadioButton rbCelsius, rbFahrenheit;

    private String nombre, apellidos, temperatura, poblacion, provincia;

    private boolean celsius, fahrenheit;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicion_temperatura);
        addVariables();
        btnFinalizar.setOnClickListener(doEnd);
    }

    private final View.OnClickListener doEnd = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            nombre = String.valueOf(etNombre.getText()).trim();
            apellidos= String.valueOf(etApellidos.getText()).trim();
            temperatura = String.valueOf(etTemperatura.getText()).trim();
            poblacion = String.valueOf(etPoblacion.getText()).trim();
            provincia = String.valueOf(etProvincia.getText()).trim();
            celsius = rbCelsius.isChecked();
            fahrenheit = rbFahrenheit.isChecked();

            if (checkForm(nombre, apellidos, temperatura, poblacion, provincia)){
                bundle = generateBundle(nombre, apellidos, temperatura, poblacion, provincia,celsius,fahrenheit);
                Intent intent = new Intent(MedicionTemperatura.this,Temperatura.class);
                startActivity(intent.putExtras(bundle));
            }
        }
    };

    private Bundle generateBundle(String nombre, String apellidos, String temperatura,
                                String poblacion, String provincia, Boolean celsius, Boolean fahrenheit){
        Bundle bundle = new Bundle();
        bundle.putString("nombre",nombre);
        bundle.putString("apellidos",apellidos);
        bundle.putString("temperatura",temperatura);
        bundle.putString("poblacion",poblacion);
        bundle.putString("provincia",provincia);
        bundle.putBoolean("celsius",celsius);
        bundle.putBoolean("fahrenheit",fahrenheit);
        return bundle;
    }
    private void addVariables(){
        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etTemperatura = findViewById(R.id.etTemperatura);
        etPoblacion = findViewById(R.id.etPoblacion);
        etProvincia = findViewById(R.id.etProvincia);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        rbCelsius = findViewById(R.id.rbCelsius);
        rbFahrenheit = findViewById(R.id.rbFahrenheit);
    }

    private boolean checkForm(String nombre, String apellidos, String temperatura,
                           String poblacion, String provincia) {
        if ("".equals(nombre) || "".equals(apellidos) || "".equals(temperatura)
                || "".equals(poblacion) || "".equals(provincia)){
            Toast.makeText(this,"Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!temperatura.matches(".*\\d.*")){
            etTemperatura.setError("Temperatura debe tener valor numérico");
            return false;
        }
        return true;
    }

}
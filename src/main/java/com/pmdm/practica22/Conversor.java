package com.pmdm.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Conversor extends AppCompatActivity {

    private Button btnCalcular1, btnCalcular2;

    private EditText etCelsius1, etCelsius2, etFahrenheit1, etFahrenheit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        setVariables();
    }


    private void setVariables(){
        btnCalcular1 = findViewById(R.id.btnCalcular1);
        btnCalcular2 = findViewById(R.id.btnCalcular2);
        etCelsius1 = findViewById(R.id.etCelsius1);
        etCelsius2 = findViewById(R.id.etCelsius2);
        etFahrenheit1 = findViewById(R.id.etFahrenheit1);
        etFahrenheit2 = findViewById(R.id.etFahrenheit2);

        btnCalcular1.setOnClickListener(calcularCF);
        btnCalcular2.setOnClickListener(calcularFC);
    }

    private final View.OnClickListener calcularCF = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String celsiusStr = String.valueOf(etCelsius1.getText()).trim();
            Double celsius = Double.parseDouble(celsiusStr);
            Double resultado = ((celsius * 9) / 5) + 32;
            etFahrenheit2.setText(String.valueOf(resultado));
        }
    };

    private final View.OnClickListener calcularFC = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String fahrenheitStr = String.valueOf(etFahrenheit1.getText()).trim();
            Double fahrenheit = Double.parseDouble(fahrenheitStr);
            Double resultado = ((fahrenheit - 32) * 5) / 9;
            etCelsius2.setText(String.valueOf(resultado));
        }
    };

}
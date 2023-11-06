package com.pmdm.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUser, etPassword;

    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.tiUser);
        etPassword = findViewById(R.id.tiPassword);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(doLogin);

    }

    private final View.OnClickListener doLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user = String.valueOf(etUser.getText()).trim();
            String password = String.valueOf(etPassword.getText()).trim();
            if (isValidUser(user,password)){
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
            }

        }

        //Login
        private boolean isValidUser(String user, String password){
            etUser.setError(null);
            etPassword.setError(null);
            if (user.equals("") || password.equals("")){
                Toast.makeText(MainActivity.this,"Usuario y contraseña deben estar rellenos", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (!user.equals("admin")) {
                etUser.setError("Usuario incorrecto");
                return false;
            }

            if (!password.equals("admin")){
                etPassword.setError("Contraseña incorrecta");
                return false;
            }

            return true;

        }
    };


}
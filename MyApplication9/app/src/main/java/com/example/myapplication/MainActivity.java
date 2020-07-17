package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUser, edPass;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);

        btRegister = findViewById(R.id.btnRegister);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Los string son para recuperar los datos ingresados por el usuario
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();

                //Se puede comprobar el espacio vacio con cualquiera de las dos condicionales
                //if (user.length() == 0)
                if (TextUtils.isEmpty(user)){
                    Toast.makeText(MainActivity.this,"El espacio de usuiario no puede quedar vacio",Toast.LENGTH_LONG).show();
                }if (TextUtils.isEmpty(pass)){
                    Toast.makeText(MainActivity.this,"El espacio de contraseña no puede quedar vacio",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Registro en proceso...",Toast.LENGTH_LONG).show();
                    limpiarCajas();
                }
            }
        });
    }
    public void  limpiarCajas(){
        edUser.setText("");
        edPass.setText("");
    }
}
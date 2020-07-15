package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNum1, edNum2;
    TextView tvResultado;
    Button btnSumar;

    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tvResultado = findViewById(R.id.tvResultado);

        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);

        btnSumar = findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se comprueba que el editex no este vacio
                num1 = edNum1.getText().toString();
                num2 = edNum2.getText().toString();
                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)){
                    Toast.makeText(MainActivity.this,"Todos los espacios", Toast.LENGTH_LONG).show();
                }else {
                    Sumar();
                    limpiarCajas();
                }
            }
        });
    }
    public void Sumar (){
        //Este es pa obtener los datos igresados por el usuario
        String valor1 = edNum1.getText().toString();
        String valor2 = edNum2.getText().toString();
        //Este es para parsear los datos de String a entero ingresados por el usuario
        int n1 = Integer.parseInt(valor1);
        int n2 = Integer.parseInt(valor2);
        //Esta es la operacion que se desea realizar
        int suma = n1 + n2;
        //Este metodo e para parsear el resultado de entero a string para poder mostralo en el textView
        String resultado = String.valueOf(suma);
        //Este es para mostralar el resulta el el textView Tambien se puede cambiar por un Toast
        tvResultado.setText(resultado);
    }
    private void limpiarCajas(){
        edNum1.setText("");
        edNum2.setText("");
    }
}
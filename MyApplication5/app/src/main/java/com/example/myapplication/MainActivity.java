package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ;EditText edNum1, edNum2;
    CheckBox cbSumar, cbRestar, cbMulti, cbDivi;
    Button btnOperar;
    TextView tvResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        cbSumar = findViewById(R.id.cbSumar);
        cbRestar = findViewById(R.id.cbRestar);
        cbMulti = findViewById(R.id.cbMulti);
        cbDivi = findViewById(R.id.cbDividir);
        tvResultado = findViewById(R.id.tvResultado);

        btnOperar = findViewById(R.id.btnOperar);
        btnOperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero1 = edNum1.getText().toString();
                String numero2 = edNum2.getText().toString();
                if (TextUtils.isEmpty(numero1) || TextUtils.isEmpty(numero2)){
                    Toast.makeText(MainActivity.this,"Llenar todos los espacios",Toast.LENGTH_LONG).show();
                }else {
                    calcular();
                }
            }
        });
    }
    public void calcular(){
        String numero1 = edNum1.getText().toString();
        String numero2 = edNum2.getText().toString();

        int num1I = Integer.parseInt(numero1);
        int num2I = Integer.parseInt(numero2);

        String resultado ="";

        if (cbSumar.isChecked() == true){
            int suma = num1I + num2I;
            resultado = resultado + "La suma es: " + suma +"/";

        }if (cbRestar.isChecked() == true){
            int resta = num1I - num2I;
            resultado = resultado + "La resta es: " + resta +"/";

        }if (cbMulti.isChecked() == true){
            int multiplicacion = num1I * num2I;
            resultado = resultado + "La multiplicacion es: " + multiplicacion +"/";

        }if (cbDivi.isChecked() == true){
            int division = num1I / num2I;
            resultado = resultado + "La division es: " + division +"/";
        }
        tvResultado.setText(resultado);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNum1, edNum2;
    TextView tvResult;
    Button btnCalcular;
    RadioButton rbSumar, rbRestar, rbMul, rbDiv;

    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        rbSumar = findViewById(R.id.rbSumar);
        rbRestar = findViewById(R.id.rbRestar);
        rbMul = findViewById(R.id.rbMul);
        rbDiv = findViewById(R.id.rbDiv);

        tvResult = findViewById(R.id.tvResult);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edNum1.getText().toString();
                num2 = edNum2.getText().toString();

                if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)){
                    Toast.makeText(MainActivity.this,"Todos los espacios por favor ", Toast.LENGTH_LONG).show();
                }else {
                    calcular();
                }

            }
        });
    }
    public void calcular(){
        String n1 = edNum1.getText().toString();
        String n2 = edNum2.getText().toString();

        int Num1 = Integer.parseInt(n1);
        int Num2 = Integer.parseInt(n2);

        //se hace una condiconal para saber si aprobo o no
        if (rbSumar.isChecked() == true){
            int suma = Num1 + Num2;
            String resultado = String.valueOf(suma);
            tvResult.setText(resultado);
            //Toast.makeText(MainActivity.this,"Reprobaste con" + suma,Toast.LENGTH_LONG).show();
        }else if(rbRestar.isChecked() == true){
            int restar = Num1 - Num2 ;
            String resultado = String.valueOf(restar);
            tvResult.setText(resultado);
            //Toast.makeText(MainActivity.this,"Aprovaste con " + restar,Toast.LENGTH_LONG).show();
        }else if(rbMul.isChecked() == true) {
            int restar = Num1 * Num2;
            String resultado = String.valueOf(restar);
            tvResult.setText(resultado);
        }else if(rbDiv.isChecked() == true) {
            int restar = Num1 / Num2;
            String resultado = String.valueOf(restar);
            tvResult.setText(resultado);
        }
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNum1, edNum2;
    Spinner Spinner1;
    Button btnOperar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        Spinner1 = findViewById(R.id.Spinner);
        tvResultado = findViewById(R.id.tvResultado);
        //esta es la imformacion que se va a incluir en el spinner
        String [] listado = {"Sumar","Restar","Multiplicar","Dividir"};
        //esta es la comunicacion con la parte grafica que vba a mostrar la informacion del array
        //En el contexto la R singnifica de la carpeta res iagula que layout y el simple item es creado en la carpeta layout y se crea
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_camilo, listado);
        Spinner1.setAdapter(adapter);

        btnOperar = findViewById(R.id.btnOperar);
        btnOperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operaciones();
            }
        });
    }
    public void Operaciones(){

        String num1S = edNum1.getText().toString();
        String num2S = edNum2.getText().toString();

        int valor1 = Integer.parseInt(num1S);
        int valor2 = Integer.parseInt(num2S);

        //Esto en pra guardar la seleccion del espiner
        String seleccion = Spinner1.getSelectedItem().toString();

        //esta condicional es para compara cadenas de texto por eso se utiliza equal
        if (seleccion.equals("Sumar")){
            int sum = valor1 + valor2;
            String result = String.valueOf(sum);
            tvResultado.setText(result);

        }else if (seleccion.equals("Restar")){
            int res = valor1 - valor2;
            String result = String.valueOf(res);
            tvResultado.setText(result);

        }else if (seleccion.equals("Multiplicar")){
            int mul = valor1 * valor2;
            String result = String.valueOf(mul);
            tvResultado.setText(result);

        }else if (seleccion.equals("Dividir")){

            if (valor2 != 0){
                int div = valor1 / valor2;
                String result = String.valueOf(div);
                tvResultado.setText(result);
            }else {
                Toast.makeText(MainActivity.this,"Nose puede dividir entre cero ( 0 )",Toast.LENGTH_LONG).show();
            }

        }
    }
}

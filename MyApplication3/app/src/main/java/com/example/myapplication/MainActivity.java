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

    EditText edMate, edFisi, edQuimi;
    TextView tvEstatus;
    Button btnEstatus;

    String mate, fis, qui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edMate = findViewById(R.id.edMate);
        edFisi = findViewById(R.id.edFisi);
        edQuimi = findViewById(R.id.edQuimi);
        tvEstatus = findViewById(R.id.tvEstatus);

        btnEstatus = findViewById(R.id.btnEstatus);
        btnEstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mate = edMate.getText().toString();
                fis = edFisi.getText().toString();
                qui = edQuimi.getText().toString();

                if (TextUtils.isEmpty(mate) || TextUtils.isEmpty(fis) || TextUtils.isEmpty(qui)){
                    Toast.makeText(MainActivity.this,"Todos los espacios por favor ", Toast.LENGTH_LONG).show();
                }else {
                    status();
                }

            }
        });
    }
    public void status(){
        String mateS = edMate.getText().toString();
        String fisS = edFisi.getText().toString();
        String quiS = edQuimi.getText().toString();

        int mateint = Integer.parseInt(mateS);
        int fisint = Integer.parseInt(fisS);
        int quiint = Integer.parseInt(quiS);

        int promedio = (fisint+quiint+mateint) / 3;//String.valueOf();
        //se hace una condiconal para saber si aprobo o no
        if (promedio >=6){
            tvEstatus.setText("Aprobado con: "+promedio);
            //Toast.makeText(MainActivity.this,"Reprobaste con" + promedio,Toast.LENGTH_LONG).show();
        }else if(promedio <=5){
            tvEstatus.setText("Reprobado con: "+promedio);
            //Toast.makeText(MainActivity.this,"Aprovaste con " + promedio,Toast.LENGTH_LONG).show();
        }
    }
}
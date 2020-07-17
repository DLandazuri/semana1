package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edtUser = findViewById(R.id.edtUser);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                if (TextUtils.isEmpty(user)){
                    Toast.makeText(MainActivity.this, "No hay informacion con que trabajar",Toast.LENGTH_LONG).show();
                }else {
                    //este es para que el inten se pase a la siguente activity y
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    //este es para que se llevar la informacion que este en el editext
                    intent.putExtra("datos", edtUser.getText().toString());
                    startActivity(intent);

                    limpiarCaja();
                }
            }
        });
    }
    public void limpiarCaja(){
        edtUser.setText("");
    }
}
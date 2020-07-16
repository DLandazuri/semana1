package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvComentario;
    ListView List1;
    // Esta es la lista que se va a mostrar en el listView, la misma cantida que se pogna en el vector nombre tiene que ir en edad
    private String nombres []  = {"Camilo","Deibis","Duban","Felipe","Andres","Edwar","Alexander","Daniel","Meme"};
    private String  edades [] = {"14","13","24","23","18","12","13","15","11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        List1 = findViewById(R.id.List1);
        tvComentario = findViewById(R.id.tvComentario);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_camilo, nombres);
        List1.setAdapter(adapter);

        List1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvComentario.setText("La edad de " + List1.getItemAtPosition(i) + " es de :" + edades[i] + " años");
            }
        });

    }
}
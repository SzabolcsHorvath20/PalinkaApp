package com.example.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper DatabaseHelper;
    private Button btnInsert, btnSearch, btnList;
    private TextView tvListazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        tvListazas.setMovementMethod(new ScrollingMovementMethod());
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdatFelvetelActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdatKeresesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void init()
    {
        btnInsert = findViewById(R.id.btnInsert);
        btnSearch = findViewById(R.id.btnSearch);
        btnList = findViewById(R.id.btnList);
        tvListazas = findViewById(R.id.tvListazas);
    }

    public void adatLekerdezes()
    {
        Cursor eredmeny = DatabaseHelper.adatLekerdezes();
        StringBuffer stringBuffer = new StringBuffer();
        if (eredmeny!= null && eredmeny.getCount() >0){
            while (eredmeny.moveToNext())
            {
                stringBuffer.append("ID: " + eredmeny.getString(0) + "\n");
                stringBuffer.append("Fozo: " + eredmeny.getString(1) + "\n");
                stringBuffer.append("Gyumolcs: " + eredmeny.getString(2) + "\n");
                stringBuffer.append("Alkohol: " + eredmeny.getString(3) + "\n");
            }
            tvListazas.setText(stringBuffer.toString());
            Toast.makeText(this, "Adat sikeresen lekérve", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nincs adat amit lekérjen!", Toast.LENGTH_SHORT).show();

        }
    }
}

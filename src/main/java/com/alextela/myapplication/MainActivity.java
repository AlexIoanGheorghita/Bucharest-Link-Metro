package com.alextela.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnJourney, btnPrices;
    ImageView imgRomanian, imgBritish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        btnJourney = (Button)findViewById(R.id.btnJourney);
        btnPrices = (Button)findViewById(R.id.btnPrices);
        imgRomanian = (ImageView)findViewById(R.id.imgRomanian);
        imgBritish = (ImageView)findViewById(R.id.imgBritish);

        imgBritish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnJourney.setText("Set Journey");
                btnPrices.setText("Check Prices");
            }
        });

        imgRomanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnJourney.setText("Seteaza Ruta");
                btnPrices.setText("Verifica Preturi");
            }
        });

        btnJourney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnJourney.getText().equals("Seteaza Ruta")) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("mykey", "Selectati punctul de plecare");
                    i.putExtra("mykey2", "Selectati punctul de sosire");
                    i.putExtra("mykey3", "Arata");
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("mykey","Choose starting point");
                    i.putExtra("mykey2", "Choose finish point");
                    i.putExtra("mykey3", "Show");
                    startActivity(i);
                };
            }
        });

        btnPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnPrices.getText().equals("Verifica Preturi")) {
                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    i.putExtra("mykey3", "As dori:");
                    i.putExtra("radio1", "Calatorii");
                    i.putExtra("radio2", "Abonament");
                    i.putExtra("priceText", "Pretul va fi afisat aici");
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    i.putExtra("mykey3", "I would like:");
                    i.putExtra("radio1", "Journeys");
                    i.putExtra("radio2", "Subscription");
                    i.putExtra("priceText", "Price will be displayed here");
                    startActivity(i);
                }
            }
        });
    }
}

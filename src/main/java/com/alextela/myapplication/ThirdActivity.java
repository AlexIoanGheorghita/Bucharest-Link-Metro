package com.alextela.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView t3, price;
    String[] tickets = {"1 journey", "2 journeys", "10 journeys"};
    String[] subscriptions = {"1 day", "1 week", "1 month", "1 month (students)", "1 year"};
    String[] ticketsRomanian = {"1 calatorie", "2 calatorii", "10 calatorii"};
    String[] subscriptionsRomanian = {"1 zi", "1 saptamana", "1 luna", "1 luna (studenti)", "1 an"};
    String[] radioEnglish = {"Journeys", "Subscription"};
    String[] radioRomanian = {"Calatorii", "Abonament"};
    Spinner spinner1;
    RadioGroup radioGroup;
    RadioButton radioButtonOption;
    //AdView banner2;
    ArrayAdapter a1;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_third);

        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        banner2 = (AdView)findViewById(R.id.banner2);
        AdRequest adrequest = new AdRequest.Builder().build();
        banner2.loadAd(adrequest);*/

        price = (TextView)findViewById(R.id.price);
        t3 = (TextView)findViewById(R.id.t3);
        Intent i = getIntent();
        final String value = i.getStringExtra("mykey3");
        t3.setText(value);

        final String valueRadio1 = i.getStringExtra("radio1");
        final String valueRadio2 = i.getStringExtra("radio2");
        String valueText = i.getStringExtra("priceText");
        price.setText(valueText);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
        radioButtonOption = (RadioButton)findViewById(selectedRadioButton);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        if (value.equals("I would like:")) {
            for (counter = 0; counter < radioGroup.getChildCount(); counter++) {
                ((RadioButton) radioGroup.getChildAt(counter)).setText(radioEnglish[counter]);
            }
        } else if (value.equals("As dori:")) {
            for (counter = 0; counter < radioGroup.getChildCount(); counter++) {
                ((RadioButton) radioGroup.getChildAt(counter)).setText(radioRomanian[counter]);
            }
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (value.equals("I would like:")) {
                    switch (checkedId) {
                        case R.id.radioTicket:
                            a1 = new ArrayAdapter<String>(ThirdActivity.this, R.layout.spinner_item, tickets);
                            spinner1.setAdapter(a1);
                            break;
                        case R.id.radioSub:
                            a1 = new ArrayAdapter<String>(ThirdActivity.this, R.layout.spinner_item, subscriptions);
                            spinner1.setAdapter(a1);
                            break;
                    }
                } else if (value.equals("As dori:")){
                    switch (checkedId) {
                        case R.id.radioTicket:
                            a1 = new ArrayAdapter<String>(ThirdActivity.this, R.layout.spinner_item, ticketsRomanian);
                            spinner1.setAdapter(a1);
                            break;
                        case R.id.radioSub:
                            a1 = new ArrayAdapter<String>(ThirdActivity.this, R.layout.spinner_item, subscriptionsRomanian);
                            spinner1.setAdapter(a1);
                            break;
                    }
                }
                a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            }
        });

        spinner1.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner1 = (Spinner)parent;

        if (spinner1.getId() == R.id.spinner1) {
            if (spinner1.getSelectedItem().toString().equals("1 journey")) {
                price.setText("Price: 2.5 RON");
            } else if (spinner1.getSelectedItem().toString().equals("2 journeys")) {
                price.setText("Price: 5 RON");
            } else if (spinner1.getSelectedItem().toString().equals("10 journeys")) {
                price.setText("Price: 20 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 day")) {
                price.setText("Price: 8 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 week")) {
                price.setText("Price: 25 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 month")) {
                price.setText("Price: 70 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 month (students)")) {
                price.setText("Price: 35 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 year")) {
                price.setText("Price: 720 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 calatorie")) {
                price.setText("Pret: 2.5 RON");
            } else if (spinner1.getSelectedItem().toString().equals("2 calatorii")) {
                price.setText("Pret: 5 RON");
            } else if (spinner1.getSelectedItem().toString().equals("10 calatorii")) {
                price.setText("Pret: 20 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 zi")) {
                price.setText("Pret: 8 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 saptamana")) {
                price.setText("Pret: 25 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 luna")) {
                price.setText("Pret: 70 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 luna (studenti)")) {
                price.setText("Pret: 35 RON");
            } else if (spinner1.getSelectedItem().toString().equals("1 an")) {
                price.setText("Pret: 720 RON");
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

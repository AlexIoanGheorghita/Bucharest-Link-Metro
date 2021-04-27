package com.alextela.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] initialStations = {"1 Decembrie 1918", "1 Mai", "Anghel Saligny", "Aparatorii Patriei", "Aurel Vlaicu",
            "Aviatorilor", "Basarab (M1)", "Basarab (M4)", "Berceni", "Constantin Brancoveanu", "Costin Georgian", "Crangasi",
            "Dimitrie Leonida", "Dristor 1 (M1)", "Dristor 1 (M3)", "Dristor 2", "Eroii Revolutiei", "Eroilor (M1)", "Eroilor (M3)", "Gara de Nord 1", "Gara de Nord 2",
            "Gorjului", "Grivita", "Grozavesti", "Izvor (M1)", "Izvor (M3)", "Jiului", "Laminorului", "Lujerului", "Mihai Bravu (M1)", "Mihai Bravu (M3)",
            "Nicolae Grigorescu (M1)", "Nicolae Grigorescu (M3)", "Nicolae Teclu", "Obor", "Pacii", "Pantelimon", "Parc Bazilescu", "Petrache Poenaru", "Piata Iancului",
            "Piata Muncii", "Piata Romana", "Piata Sudului", "Piata Unirii 1", "Piata Unirii 2", "Piata Unirii (M3)", "Piata Victoriei 1",
            "Piata Victoriei 2", "Pipera", "Politehnica", "Preciziei", "Republica", "Stefan cel Mare", "Straulesti",
            "Timpuri Noi (M1)", "Timpuri Noi (M3)", "Tineretului", "Titan", "Universitate"};

    String[] finalStations = {"1 Decembrie 1918", "1 Mai", "Anghel Saligny", "Aparatorii Patriei", "Aurel Vlaicu",
            "Aviatorilor", "Basarab (M1)", "Basarab (M4)", "Berceni", "Constantin Brancoveanu", "Costin Georgian", "Crangasi",
            "Dimitrie Leonida", "Dristor 1 (M1)", "Dristor 1 (M3)", "Dristor 2", "Eroii Revolutiei", "Eroilor (M1)", "Eroilor (M3)", "Gara de Nord 1", "Gara de Nord 2",
            "Gorjului", "Grivita", "Grozavesti", "Izvor (M1)", "Izvor (M3)", "Jiului", "Laminorului", "Lujerului", "Mihai Bravu (M1)", "Mihai Bravu (M3)",
            "Nicolae Grigorescu (M1)", "Nicolae Grigorescu (M3)", "Nicolae Teclu", "Obor", "Pacii", "Pantelimon", "Parc Bazilescu", "Petrache Poenaru", "Piata Iancului",
            "Piata Muncii", "Piata Romana", "Piata Sudului", "Piata Unirii 1", "Piata Unirii 2", "Piata Unirii (M3)", "Piata Victoriei 1",
            "Piata Victoriei 2", "Pipera", "Politehnica", "Preciziei", "Republica", "Stefan cel Mare", "Straulesti",
            "Timpuri Noi (M1)", "Timpuri Noi (M3)", "Tineretului", "Titan", "Universitate"};

    Spinner initialSpin, finalSpin;
    TextView t1, t2;
    Button button;
    //AdView banner1;
    String magistrala1, magistrala2, startingStation, finishStation;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_second);

        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        banner1 = (AdView)findViewById(R.id.banner1);
        AdRequest adrequest = new AdRequest.Builder().build();
        banner1.loadAd(adrequest);*/

        initialSpin = (Spinner)findViewById(R.id.initialSpin);
        finalSpin = (Spinner)findViewById(R.id.finalSpin);

        initialSpin.setOnItemSelectedListener(this);
        ArrayAdapter a1 = new ArrayAdapter(this,R.layout.spinner_item,initialStations);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initialSpin.setAdapter(a1);
        initialSpin.setOnItemSelectedListener(this);

        finalSpin.setOnItemSelectedListener(this);
        ArrayAdapter a2 = new ArrayAdapter(this,R.layout.spinner_item,finalStations);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        finalSpin.setAdapter(a2);
        finalSpin.setOnItemSelectedListener(this);

        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        Intent i = getIntent();
        String value = i.getStringExtra("mykey");
        t1.setText(value);
        String value2 = i.getStringExtra("mykey2");
        t2.setText(value2);

        builder = new AlertDialog.Builder(this);

        button = (Button)findViewById(R.id.button);

        String value3 = i.getStringExtra("mykey3");
        button.setText(value3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startingStation == finishStation || (startingStation.equals("Basarab (M1)") && finishStation.equals("Basarab (M4)")) ||
                        (startingStation.equals("Basarab (M4)") && finishStation.equals("Basarab (M1)")) || (startingStation.equals("Piata Victoriei 1") && finishStation.equals("Piata Victoriei 2")) ||
                        (startingStation.equals("Piata Victoriei 2") && finishStation.equals("Piata Victoriei 1")) || (startingStation.equals("Piata Unirii 1") && finishStation.equals("Piata Unirii 2")) ||
                        (startingStation.equals("Piata Unirii 2") && finishStation.equals("Piata Unirii 1")) || (startingStation.equals("Piata Unirii 1") && finishStation.equals("Piata Unirii (M3)")) ||
                        (startingStation.equals("Piata Unirii (M3)") && finishStation.equals("Piata Unirii 1")) || (startingStation.equals("Piata Unirii 2") && finishStation.equals("Piata Unirii (M3)")) ||
                        (startingStation.equals("Piata Unirii (M3)") && finishStation.equals("Piata Unirii 2")) || (startingStation.equals("Eroilor (M1)") && finishStation.equals("Eroilor (M3)")) ||
                        (startingStation.equals("Eroilor (M3)") && finishStation.equals("Eroilor (M1)")) || (startingStation.equals("Izvor (M1)") && finishStation.equals("Izvor (M3)")) ||
                        (startingStation.equals("Izvor (M3)") && finishStation.equals("Izvor (M1)")) || (startingStation.equals("Timpuri Noi (M1)") && finishStation.equals("Timpuri Noi (M3)")) ||
                        (startingStation.equals("Timpuri Noi (M3)") && finishStation.equals("Timpuri Noi (M1)")) || (startingStation.equals("Mihai Bravu (M1)") && finishStation.equals("Mihai Bravu (M3)")) ||
                        (startingStation.equals("Mihai Bravu (M3)") && finishStation.equals("Mihai Bravu (M1)")) || (startingStation.equals("Dristor 1 (M1)") && finishStation.equals("Dristor 1 (M3)")) ||
                        (startingStation.equals("Dristor 1 (M3)") && finishStation.equals("Dristor 1 (M1)")) || (startingStation.equals("Nicolae Grigorescu (M1)") && finishStation.equals("Nicolae Grigorescu (M3)")) ||
                        (startingStation.equals("Nicolae Grigorescu (M3)") && finishStation.equals("Nicolae Grigorescu (M1)")))
                {
                    if (t1.getText().equals("Choose starting point")) {
                        builder.setMessage("You need to choose different stations. The stations you chose are the same station.").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.setTitle("Choose different stations");
                        alert.show();
                    } else if (t1.getText().equals("Selectati punctul de plecare")) {
                        builder.setMessage("Trebuie sa alegeti statii diferite. Statiile alese sunt aceeasi statie.").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.setTitle("Alegeti statii diferite");
                        alert.show();
                    }
                } else {
                    Intent i = new Intent(SecondActivity.this, FourthActivity.class);
                    i.putExtra("value1", magistrala1);
                    i.putExtra("value2", magistrala2);
                    i.putExtra("start", startingStation);
                    i.putExtra("finish", finishStation);
                    if (t1.getText().equals("Choose starting point")) {
                        i.putExtra("mykeyLang1", "Line");
                        i.putExtra("mykeyLang2", "Station");
                        i.putExtra("myApproxWait", "Approx. time to wait: ");
                        i.putExtra("myApproxTime", "Approx. time of journey: ");
                        startActivity(i);
                    } else if (t1.getText().equals("Selectati punctul de plecare")) {
                        i.putExtra("mykeyLang1", "Linie");
                        i.putExtra("mykeyLang2", "Statie");
                        i.putExtra("myApproxWait", "Timp aprox. de asteptare: ");
                        i.putExtra("myApproxTime", "Timp aprox. pt. calatorie: ");
                        startActivity(i);
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        initialSpin = (Spinner)parent;
        finalSpin = (Spinner)parent;

        if(initialSpin.getId() == R.id.initialSpin) {
            switch (initialSpin.getSelectedItem().toString()) {
                case "Piata Victoriei 1":
                case "Gara de Nord 1":
                case "Basarab (M1)":
                case "Crangasi":
                case "Petrache Poenaru":
                case "Grozavesti":
                case "Eroilor (M1)":
                case "Izvor (M1)":
                case "Piata Unirii 1":
                case "Timpuri Noi (M1)":
                case "Mihai Bravu (M1)":
                case "Dristor 1 (M1)":
                case "Dristor 2":
                case "Piata Muncii":
                case "Piata Iancului":
                case "Obor":
                case "Stefan cel Mare":
                case "Nicolae Grigorescu (M1)":
                case "Titan":
                case "Costin Georgian":
                case "Republica":
                case "Pantelimon":
                    magistrala1 = "M1";
                    break;
                case "Pipera":
                case "Aurel Vlaicu":
                case "Aviatorilor":
                case "Piata Victoriei 2":
                case "Piata Romana":
                case "Universitate":
                case "Piata Unirii 2":
                case "Tineretului":
                case "Eroii Revolutiei":
                case "Constantin Brancoveanu":
                case "Piata Sudului":
                case "Aparatorii Patriei":
                case "Dimitrie Leonida":
                case "Berceni":
                    magistrala1 = "M2";
                    break;
                case "Preciziei":
                case "Pacii":
                case "Gorjului":
                case "Lujerului":
                case "Politehnica":
                case "Eroilor (M3)":
                case "Izvor (M3)":
                case "Piata Unirii (M3)":
                case "Timpuri Noi (M3)":
                case "Mihai Bravu (M3)":
                case "Dristor 1 (M3)":
                case "Nicolae Grigorescu (M3)":
                case "1 Decembrie 1918":
                case "Nicolae Teclu":
                case "Anghel Saligny":
                    magistrala1 = "M3";
                    break;
                case "Straulesti":
                case "Laminorului":
                case "Parc Bazilescu":
                case "Jiului":
                case "1 Mai":
                case "Grivita":
                case "Basarab (M4)":
                case "Gara de Nord 2":
                    magistrala1 = "M4";
                    break;
            }
            startingStation = initialSpin.getSelectedItem().toString();
        }

        if(finalSpin.getId() == R.id.finalSpin) {
            switch (finalSpin.getSelectedItem().toString()) {
                case "Piata Victoriei 1":
                case "Gara de Nord 1":
                case "Basarab (M1)":
                case "Crangasi":
                case "Petrache Poenaru":
                case "Grozavesti":
                case "Eroilor (M1)":
                case "Izvor (M1)":
                case "Piata Unirii 1":
                case "Timpuri Noi (M1)":
                case "Mihai Bravu (M1)":
                case "Dristor 1 (M1)":
                case "Dristor 2":
                case "Piata Muncii":
                case "Piata Iancului":
                case "Obor":
                case "Stefan cel Mare":
                case "Nicolae Grigorescu (M1)":
                case "Titan":
                case "Costin Georgian":
                case "Republica":
                case "Pantelimon":
                    magistrala2 = "M1";
                    break;
                case "Pipera":
                case "Aurel Vlaicu":
                case "Aviatorilor":
                case "Piata Victoriei 2":
                case "Piata Romana":
                case "Universitate":
                case "Piata Unirii 2":
                case "Tineretului":
                case "Eroii Revolutiei":
                case "Constantin Brancoveanu":
                case "Piata Sudului":
                case "Aparatorii Patriei":
                case "Dimitrie Leonida":
                case "Berceni":
                    magistrala2 = "M2";
                    break;
                case "Preciziei":
                case "Pacii":
                case "Gorjului":
                case "Lujerului":
                case "Politehnica":
                case "Eroilor (M3)":
                case "Izvor (M3)":
                case "Piata Unirii (M3)":
                case "Timpuri Noi (M3)":
                case "Mihai Bravu (M3)":
                case "Dristor 1 (M3)":
                case "Nicolae Grigorescu (M3)":
                case "1 Decembrie 1918":
                case "Nicolae Teclu":
                case "Anghel Saligny":
                    magistrala2 = "M3";
                    break;
                case "Straulesti":
                case "Laminorului":
                case "Parc Bazilescu":
                case "Jiului":
                case "1 Mai":
                case "Grivita":
                case "Basarab (M4)":
                case "Gara de Nord 2":
                    magistrala2 = "M4";
                    break;
            }
            finishStation = finalSpin.getSelectedItem().toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

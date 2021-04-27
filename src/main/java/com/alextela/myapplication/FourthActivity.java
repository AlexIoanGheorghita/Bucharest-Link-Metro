package com.alextela.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FourthActivity extends AppCompatActivity {
    ListView myList;
    TextView txtLine, txtStation, txtApproxTime, txtWaitingTime;
    ArrayList<String> list1;
    ArrayList<String> list2;
    String[] green = {"Straulesti", "Laminorului", "Parc Bazilescu", "Jiului", "1 Mai", "Grivita", "Basarab (M4)", "Gara de Nord 2"};
    String[] yellow = {"Piata Victoriei 1", "Gara de Nord 1", "Basarab (M1)", "Crangasi", "Petrache Poenaru",
            "Grozavesti", "Eroilor (M1)", "Izvor (M1)", "Piata Unirii 1", "Timpuri Noi (M1)", "Mihai Bravu (M1)", "Dristor 1 (M1)", "Dristor 2",
            "Piata Muncii", "Piata Iancului", "Obor", "Stefan cel Mare"};
    String[] yellow2 = {"Pantelimon", "Republica", "Costin Georgian", "Titan", "Nicolae Grigorescu (M1)"};
    String[] red = {"Preciziei", "Pacii", "Gorjului", "Lujerului", "Politehnica", "Eroilor (M3)", "Izvor (M3)", "Piata Unirii (M3)",
            "Timpuri Noi (M3)", "Mihai Bravu (M3)", "Dristor 1 (M3)", "Nicolae Grigorescu (M3)", "1 Decembrie 1918", "Nicolae Teclu",
            "Anghel Saligny"};
    String[] blue = {"Pipera", "Aurel Vlaicu", "Aviatorilor", "Piata Victoriei 2", "Piata Romana", "Universitate", "Piata Unirii 2",
            "Tineretului", "Eroii Revolutiei", "Constantin Brancoveanu", "Piata Sudului", "Aparatorii Patriei", "Dimitrie Leonida",
            "Berceni"};

    //AdView myAd;
    int i, x, startPoint, finishPoint;
    double timeM1, timeM2, timeM3, timeM4, totalTime, timeToWait;
    int NrStations, StationsM1, StationsM2, StationsM3, StationsM4;
    String changeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_fourth);

        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        myAd = (AdView)findViewById(R.id.banner3);
        AdRequest myadRequest = new AdRequest.Builder().build();
        myAd.loadAd(myadRequest);*/

        Date currentDay = Calendar.getInstance().getTime();
        Date currentHour = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("EEE");
        SimpleDateFormat hf = new SimpleDateFormat("HH");

        String formattedDay = df.format(currentDay);
        String formattedHour = hf.format(currentHour);

        switch (formattedDay) {
            case "Mon":
            case "Tue":
            case "Wed":
            case "Thu":
            case "Fri":
                if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("16") || formattedHour.equals("17") ||
                        formattedHour.equals("18") || formattedHour.equals("19")) {
                    timeM1 = 2.80;
                    timeM2 = 2.25;
                    timeM3 = 2.60;
                    timeM4 = 2.50;
                } else if (formattedHour.equals("23") || formattedHour.equals("00") || formattedHour.equals("01") || formattedHour.equals("02") || formattedHour.equals("03") ||
                        formattedHour.equals("04")) {
                    timeM1 = 0.00;
                    timeM2 = 0.00;
                    timeM3 = 0.00;
                    timeM4 = 0.00;
                } else {
                    timeM1 = 2.15;
                    timeM2 = 1.85;
                    timeM3 = 2.15;
                    timeM4 = 2.00;
                }
            case "Sat":
            case "Sun":
                if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("16") || formattedHour.equals("17") ||
                        formattedHour.equals("18") || formattedHour.equals("19")) {
                    timeM1 = 2.90;
                    timeM2 = 2.35;
                    timeM3 = 2.70;
                    timeM4 = 2.60;
                } else if (formattedHour.equals("23") || formattedHour.equals("00") || formattedHour.equals("01") || formattedHour.equals("02") || formattedHour.equals("03") ||
                        formattedHour.equals("04")) {
                    timeM1 = 0.00;
                    timeM2 = 0.00;
                    timeM3 = 0.00;
                    timeM4 = 0.00;
                } else {
                    timeM1 = 2.25;
                    timeM2 = 1.95;
                    timeM3 = 2.25;
                    timeM4 = 2.10;
                }
        }


        final Intent intent = getIntent();
        String myvalue1 = intent.getStringExtra("value1");
        String myvalue2 = intent.getStringExtra("value2");
        String mystart = intent.getStringExtra("start");
        String myfinish = intent.getStringExtra("finish");

        String value1 = intent.getStringExtra("mykeyLang1");
        final String value2 = intent.getStringExtra("mykeyLang2");
        String value3 = intent.getStringExtra("myApproxWait");
        String value4 = intent.getStringExtra("myApproxTime");

        txtLine = (TextView)findViewById(R.id.txtLine);
        txtStation = (TextView)findViewById(R.id.txtStation);
        txtApproxTime = (TextView)findViewById(R.id.txtApproxTime);
        txtWaitingTime = (TextView)findViewById(R.id.txtWaitingTime);

        txtLine.setText(value1);
        txtStation.setText(value2);
        txtApproxTime.setText(value4);
        txtWaitingTime.setText(value3);

        if (value1.equals("Line")) {
            changeValue = " - CHANGE";
        } else if (value1.equals("Linie")) {
            changeValue = " - SCHIMBA";
        }

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        if (myvalue1.equals(myvalue2)) {
            if (myvalue1.equals("M1") && myvalue2.equals("M1")) {
                if ((!mystart.equals("Pantelimon")) && (!mystart.equals("Republica")) && (!mystart.equals("Costin Georgian")) && (!mystart.equals("Titan")) && (!mystart.equals("Nicolae Grigorescu (M1)")) &&
                        (!myfinish.equals("Pantelimon")) && (!myfinish.equals("Republica")) && (!myfinish.equals("Costin Georgian")) && (!myfinish.equals("Titan")) && (!myfinish.equals("Nicolae Grigorescu (M1)"))) {
                    for (i = 0; i <= (yellow.length) - 1; i++) {
                        if (mystart.equals(yellow[i])) {
                            startPoint = i;
                        }
                        if (myfinish.equals(yellow[i])) {
                            finishPoint = i;
                        }
                    }
                    if (startPoint < finishPoint && (startPoint <= 4 && finishPoint >= 11)) {
                        for (x = startPoint; x >= 0; x--) {
                            list1.add(yellow[x]);
                            list2.add("M1");
                        }
                        for (x = 16; x >= finishPoint; x--) {
                            list1.add(yellow[x]);
                            list2.add("M1");
                        }
                    } else {
                        if (startPoint > finishPoint && (startPoint >= 11 && finishPoint <= 4)) {
                            for (x = startPoint; x <= 16; x++) {
                                list1.add(yellow[x]);
                                list2.add("M1");
                            }
                            for (x = 0; x <= finishPoint; x++) {
                                list1.add(yellow[x]);
                                list2.add("M1");
                            }
                        } else {
                            if (startPoint == finishPoint) {
                                list1.add(yellow[startPoint]);
                                list2.add("M1");
                            } else {
                                if (startPoint < finishPoint) {
                                    for (x = startPoint; x <= finishPoint; x++) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                } else {
                                    for (x = startPoint; x >= finishPoint; x--) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (((mystart.equals("Pantelimon")) || (mystart.equals("Republica")) || (mystart.equals("Costin Georgian")) || (mystart.equals("Titan")) || (mystart.equals("Nicolae Grigorescu (M1)"))) &&
                            ((myfinish.equals("Pantelimon")) || (myfinish.equals("Republica")) || (myfinish.equals("Costin Georgian")) || (myfinish.equals("Titan")) || (myfinish.equals("Nicolae Grigorescu (M1)")))) {
                        for (i = 0; i <= (yellow2.length) - 1; i++) {
                            if (mystart.equals(yellow2[i])) {
                                startPoint = i;
                            }
                            if (myfinish.equals(yellow2[i])) {
                                finishPoint = i;
                            }
                        }
                        if (startPoint < finishPoint) {
                            for (x = startPoint; x <= finishPoint; x++) {
                                list1.add(yellow2[x]);
                                list2.add("M1");
                            }
                        } else {
                            if (startPoint > finishPoint) {
                                for (x = startPoint; x >= finishPoint; x--) {
                                    list1.add(yellow2[x]);
                                    list2.add("M1");
                                }
                            } else {
                                list1.add(yellow2[startPoint]);
                                list2.add("M1");
                            }
                        }
                    } else {
                        if (mystart.equals("Pantelimon") || mystart.equals("Republica") || mystart.equals("Costin Georgian") || mystart.equals("Titan") || mystart.equals("Nicolae Grigorescu (M1)")) {
                            for (i = 0; i <= yellow2.length - 1; i++) {
                                if (mystart.equals(yellow2[i])) {
                                    startPoint = i;
                                }
                            }
                            for (i = 0; i <= yellow.length - 1; i++) {
                                if (myfinish.equals(yellow[i])) {
                                    finishPoint = i;
                                }
                            }
                            for (x = startPoint; x <= yellow2.length - 1; x++) {
                                list1.add(yellow2[x]);
                                list2.add("M1");
                            }
                            if (finishPoint <= 2) {
                                for (x = 11; x <= yellow.length - 1; x++) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                                for (x = 0; x <= finishPoint; x++) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                            }
                            if (finishPoint >= 11) {
                                for (x = 11; x <= finishPoint; x++) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                            }
                            if (finishPoint > 2 && finishPoint < 11) {
                                for (x = 11; x >= finishPoint; x--) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                            }
                        } else {
                            if (myfinish.equals("Pantelimon") || myfinish.equals("Republica") || myfinish.equals("Costin Georgian") || myfinish.equals("Titan") || myfinish.equals("Nicolae Grigorescu (M1)")) {
                                for (i = 0; i <= yellow.length - 1; i++) {
                                    if (mystart.equals(yellow[i])) {
                                        startPoint = i;
                                    }
                                }
                                for (i = 0; i <= yellow2.length - 1; i++) {
                                    if (myfinish.equals(yellow2[i])) {
                                        finishPoint = i;
                                    }
                                }
                                if (startPoint <= 2) {
                                    for (x = startPoint; x >= 0; x--) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x = 16; x >= 11; x--) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x = 4; x >= finishPoint; x--) {
                                        list1.add(yellow2[x]);
                                        list2.add("M1");
                                    }
                                }
                                if (startPoint > 2 && startPoint <= 11) {
                                    for (x = startPoint; x <= 11; x++) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x = 4; x >= finishPoint; x--) {
                                        list1.add(yellow2[x]);
                                        list2.add("M1");
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (myvalue1.equals("M2") && myvalue2.equals("M2")) {
                    for (i = 0; i <= (blue.length) - 1; i++) {
                        if (mystart.equals(blue[i])) {
                            startPoint = i;
                        }
                        if (myfinish.equals(blue[i])) {
                            finishPoint = i;
                        }
                    }
                    if (startPoint < finishPoint) {
                        for (x = startPoint; x <= finishPoint; x++) {
                            list1.add(blue[x]);
                            list2.add("M2");
                        }
                    } else {
                        if (startPoint > finishPoint) {
                            for (x = startPoint; x >= finishPoint; x--) {
                                list1.add(blue[x]);
                                list2.add("M2");
                            }
                        } else {
                            if (startPoint == finishPoint) {
                                list1.add(blue[startPoint]);
                                list2.add("M2");
                            }
                        }
                    }
                } else {
                    if (myvalue1.equals("M3") && myvalue2.equals("M3")) {
                        for (i = 0; i <= red.length - 1; i++) {
                            if (mystart.equals(red[i])) {
                                startPoint = i;
                            }
                            if (myfinish.equals(red[i])) {
                                finishPoint = i;
                            }
                        }
                        if (startPoint < finishPoint) {
                            for (x = startPoint; x <= finishPoint; x++) {
                                list1.add(red[x]);
                                list2.add("M3");
                            }
                        } else {
                            if (startPoint > finishPoint) {
                                for (x = startPoint; x >= finishPoint; x--) {
                                    list1.add(red[x]);
                                    list2.add("M3");
                                }
                            } else {
                                if (startPoint == finishPoint) {
                                    list1.add(red[startPoint]);
                                    list2.add("M3");
                                }
                            }
                        }
                    } else {
                        if (myvalue1.equals("M4") && myvalue2.equals("M4")) {
                            for (i = 0; i <= (green.length) - 1; i++) {
                                if (mystart.equals(green[i])) {
                                    startPoint = i;
                                }
                                if (myfinish.equals(green[i])) {
                                    finishPoint = i;
                                }
                            }
                            if (startPoint < finishPoint) {
                                for (x = startPoint; x <= finishPoint; x++) {
                                    list1.add(green[x]);
                                    list2.add("M4");
                                }
                            } else {
                                if (startPoint > finishPoint) {
                                    for (x = startPoint; x >= finishPoint; x--) {
                                        list1.add(green[x]);
                                        list2.add("M4");
                                    }
                                } else {
                                    if (startPoint == finishPoint) {
                                        list1.add(green[startPoint]);
                                        list2.add("M4");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (myvalue1 != myvalue2) {
                if (myvalue1.equals("M1") && myvalue2.equals("M2")) {
                    if (mystart.equals("Piata Victoriei 1") || mystart.equals("Gara de Nord 1") || mystart.equals("Basarab (M1)") || mystart.equals("Crangasi") || mystart.equals("Petrache Poenaru")) {
                        if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2")) {
                            for (i = 0; i <= yellow.length - 1; i++) {
                                if (mystart.equals(yellow[i])) {
                                    startPoint = i;
                                }
                            }
                            for (i = 0; i <= blue.length - 1; i++) {
                                if (myfinish.equals(blue[i])) {
                                    finishPoint = i;
                                }
                            }
                            for (x = startPoint; x >= 0; x--) {
                                list1.add(yellow[x]);
                                list2.add("M1");
                            }
                            for (x = 3; x >= finishPoint; x--) {
                                list1.add(blue[x]);
                                list2.add("M2");
                            }
                        } else {
                            if (myfinish.equals("Piata Romana") || myfinish.equals("Universitate") || myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") ||
                                    myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") || myfinish.equals("Piata Sudului") ||
                                    myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                for (i = 0; i <= yellow.length - 1; i++) {
                                    if (mystart.equals(yellow[i])) {
                                        startPoint = i;
                                    }
                                }
                                for (i = 0; i <= blue.length - 1; i++) {
                                    if (myfinish.equals(blue[i])) {
                                        finishPoint = i;
                                    }
                                }
                                for (x = startPoint; x >= 0; x--) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                                for (x=3; x<= finishPoint; x++) {
                                    list1.add(blue[x]);
                                    list2.add("M2");
                                }
                            }
                        }
                    } else {
                        if (mystart.equals("Grozavesti") || mystart.equals("Eroilor (M1)") || mystart.equals("Izvor (M1)") || mystart.equals("Piata Unirii 1")) {
                            if (myfinish.equals("Piata Unirii 2") || myfinish.equals("Universitate") || myfinish.equals("Piata Romana") || myfinish.equals("Piata Victoriei 2") || myfinish.equals("Aviatorilor") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Pipera")) {
                                for (i = 0; i <= yellow.length - 1; i++) {
                                    if (mystart.equals(yellow[i])) {
                                        startPoint = i;
                                    }
                                }
                                for (i = 0; i <= blue.length - 1; i++) {
                                    if (myfinish.equals(blue[i])) {
                                        finishPoint = i;
                                    }
                                }
                                for (x = startPoint; x <= 8; x++) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                                for (x = 6; x>=finishPoint; x--) {
                                    list1.add(blue[x]);
                                    list2.add("M2");
                                }
                            } else {
                                if (myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") ||
                                        myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                    for (i = 0; i <= yellow.length - 1; i++) {
                                        if (mystart.equals(yellow[i])) {
                                            startPoint = i;
                                        }
                                    }
                                    for (i = 0; i <= blue.length - 1; i++) {
                                        if (myfinish.equals(blue[i])) {
                                            finishPoint = i;
                                        }
                                    }
                                    for (x = startPoint; x <= 8; x++) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x = 6; x <= finishPoint; x++) {
                                        list1.add(blue[x]);
                                        list2.add("M2");
                                    }
                                }
                            }
                        } else {
                            if (mystart.equals("Timpuri Noi (M1)") || mystart.equals("Mihai Bravu (M1)") || mystart.equals("Dristor 1 (M1)") || mystart.equals("Dristor 2")) {
                                if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2") || myfinish.equals("Piata Romana") || myfinish.equals("Universitate")) {
                                    for (i = 0; i <= yellow.length - 1; i++) {
                                        if (mystart.equals(yellow[i])) {
                                            startPoint = i;
                                        }
                                    }
                                    for (i = 0; i <= blue.length - 1; i++) {
                                        if (myfinish.equals(blue[i])) {
                                            finishPoint = i;
                                        }
                                    }
                                    for (x = startPoint; x >= 8; x--) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x = 6; x >= finishPoint; x--) {
                                        list1.add(blue[x]);
                                        list2.add("M2");
                                    }
                                } else {
                                    if (myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") ||
                                            myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (mystart.equals(yellow[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= blue.length - 1; i++) {
                                            if (myfinish.equals(blue[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x = startPoint; x >= 8; x--) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                        for (x=6; x<= finishPoint; x++) {
                                            list1.add(blue[x]);
                                            list2.add("M2");
                                        }
                                    }
                                }
                            } else {
                                if (mystart.equals("Piata Muncii") || mystart.equals("Piata Iancului") || mystart.equals("Obor") || mystart.equals("Stefan cel Mare")) {
                                    if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2")) {
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (mystart.equals(yellow[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= blue.length - 1; i++) {
                                            if (myfinish.equals(blue[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint; x<=16; x++) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                        list1.add("Piata Victoriei 1");
                                        list1.add("M1");
                                        for (x=3; x>= finishPoint; x--) {
                                            list1.add(blue[x]);
                                            list2.add("M2");
                                        }
                                    } else {
                                        if (myfinish.equals("Universitate") || myfinish.equals("Piata Romana") || myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") ||
                                                myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (mystart.equals(yellow[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= blue.length - 1; i++) {
                                                if (myfinish.equals(blue[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x<=16; x++) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                            list1.add("Piata Victoriei 1");
                                            list2.add("M1");
                                            for (x=3; x<=finishPoint; x++) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                        }
                                    }
                                } else {
                                    if (mystart.equals("Nicolae Grigorescu (M1)") || mystart.equals("Titan") || mystart.equals("Costin Georgian") || mystart.equals("Republica") || mystart.equals("Pantelimon")) {
                                        if (myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") ||
                                                myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                            for (i = 0; i <= yellow2.length - 1; i++) {
                                                if (mystart.equals(yellow2[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= blue.length - 1; i++) {
                                                if (myfinish.equals(blue[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x<= yellow2.length - 1; x++) {
                                                list1.add(yellow2[x]);
                                                list2.add("M1");
                                            }
                                            for (x=11; x>=8; x--) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                            for (x=6; x<=finishPoint; x++) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                        } else {
                                            if (myfinish.equals("Universitate") || myfinish.equals("Piata Romana")) {
                                                for (i = 0; i <= yellow2.length - 1; i++) {
                                                    if (mystart.equals(yellow2[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= blue.length - 1; i++) {
                                                    if (myfinish.equals(blue[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x<= yellow2.length - 1; x++) {
                                                    list1.add(yellow2[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=11; x>=8; x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=6; x>= finishPoint; x--) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                            } else {
                                                if (myfinish.equals("Piata Victoriei 2") || myfinish.equals("Aviatorilor") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Pipera")) {
                                                    for (i = 0; i <= yellow2.length - 1; i++) {
                                                        if (mystart.equals(yellow2[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= blue.length - 1; i++) {
                                                        if (myfinish.equals(blue[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x<= yellow2.length - 1; x++) {
                                                        list1.add(yellow2[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=11; x<=16; x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    list1.add("Piata Victoriei 1");
                                                    list2.add("M1");
                                                    for (x=3; x>= finishPoint; x--) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (myvalue1.equals("M2") && myvalue2.equals("M1")) {
                        if (mystart.equals("Pipera") || mystart.equals("Aurel Vlaicu") || mystart.equals("Aviatorilor") || mystart.equals("Piata Victoriei 2")) {
                            if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1") || myfinish.equals("Basarab (M1)") || myfinish.equals("Crangasi") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Grozavesti")) {
                                for (i = 0; i <= blue.length - 1; i++) {
                                    if (mystart.equals(blue[i])) {
                                        startPoint = i;
                                    }
                                }
                                for (i = 0; i <= yellow.length - 1; i++) {
                                    if (myfinish.equals(yellow[i])) {
                                        finishPoint = i;
                                    }
                                }
                                for (x=startPoint;x<=3;x++) {
                                    list1.add(blue[x]);
                                    list2.add("M2");
                                }
                                for (x=0; x<=finishPoint;x++) {
                                    list1.add(yellow[x]);
                                    list2.add("M1");
                                }
                            } else {
                                if (myfinish.equals("Eroilor (M1)") || myfinish.equals("Izvor (M1)")) {
                                    for (i = 0; i <= blue.length - 1; i++) {
                                        if (mystart.equals(blue[i])) {
                                            startPoint = i;
                                        }
                                    }
                                    for (i = 0; i <= yellow.length - 1; i++) {
                                        if (myfinish.equals(yellow[i])) {
                                            finishPoint = i;
                                        }
                                    }
                                    for (x=startPoint;x<=6;x++) {
                                        list1.add(blue[x]);
                                        list2.add("M2");
                                    }
                                    for (x=8; x>=finishPoint;x--) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                } else {
                                    if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor") || myfinish.equals("Piata Iancului") || myfinish.equals("Piata Muncii") || myfinish.equals("Dristor 2") || myfinish.equals("Dristor 1 (M1)")) {
                                        for (i = 0; i <= blue.length - 1; i++) {
                                            if (mystart.equals(blue[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (myfinish.equals(yellow[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint;x<=3;x++) {
                                            list1.add(blue[x]);
                                            list2.add("M2");
                                        }
                                        list1.add("Piata Victoriei 1");
                                        list2.add("M1");
                                        for (x=15; x>=finishPoint;x--) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                    } else {
                                        if (myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)")) {
                                            for (i = 0; i <= blue.length - 1; i++) {
                                                if (mystart.equals(blue[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (myfinish.equals(yellow[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint;x<=6;x++) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                            for (x=8; x<=finishPoint;x++) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                        } else {
                                            if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                for (i = 0; i <= blue.length - 1; i++) {
                                                    if (mystart.equals(blue[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow2.length - 1; i++) {
                                                    if (myfinish.equals(yellow2[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint;x<=3;x++) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                                list1.add("Piata Victoriei 1");
                                                list2.add("M1");
                                                for (x=15; x>=11;x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=4; x>= finishPoint; x--) {
                                                    list1.add(yellow2[x]);
                                                    list2.add("M1");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (mystart.equals("Piata Romana") || mystart.equals("Universitate") || mystart.equals("Piata Unirii 2")) {
                                if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1") || myfinish.equals("Basarab (M1)") || myfinish.equals("Crangasi") || myfinish.equals("Petrache Poenaru")) {
                                    for (i = 0; i <= blue.length - 1; i++) {
                                        if (mystart.equals(blue[i])) {
                                            startPoint = i;
                                        }
                                    }
                                    for (i = 0; i <= yellow.length - 1; i++) {
                                        if (myfinish.equals(yellow[i])) {
                                            finishPoint = i;
                                        }
                                    }
                                    for (x=startPoint;x>=3;x--) {
                                        list1.add(blue[x]);
                                        list2.add("M2");
                                    }
                                    for (x=0; x<=finishPoint;x++) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                } else {
                                    if (myfinish.equals("Grozavesti") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Izvor (M1)") || myfinish.equals("Piata Unirii 1")) {
                                        for (i = 0; i <= blue.length - 1; i++) {
                                            if (mystart.equals(blue[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (myfinish.equals(yellow[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint;x<=6;x++) {
                                            list1.add(blue[x]);
                                            list2.add("M2");
                                        }
                                        for (x=8; x>=finishPoint;x--) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                    } else {
                                        if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor") || myfinish.equals("Piata Iancului") || myfinish.equals("Piata Muncii") || myfinish.equals("Dristor 2")) {
                                            for (i = 0; i <= blue.length - 1; i++) {
                                                if (mystart.equals(blue[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (myfinish.equals(yellow[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint;x>=3;x--) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                            list1.add("Piata Victoriei 1");
                                            list2.add("M1");
                                            for (x=15; x>=finishPoint;x--) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                        } else {
                                            if (myfinish.equals("Dristor 1 (M1)") || myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Timpuri Noi (M1)")) {
                                                for (i = 0; i <= blue.length - 1; i++) {
                                                    if (mystart.equals(blue[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint;x<=6;x++) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                                for (x=8; x<=finishPoint;x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                    for (i = 0; i <= blue.length - 1; i++) {
                                                        if (mystart.equals(blue[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow2.length - 1; i++) {
                                                        if (myfinish.equals(yellow2[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint;x<=6;x++) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                    for (x=8; x<=11;x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=4; x>= finishPoint; x--) {
                                                        list1.add(yellow2[x]);
                                                        list2.add("M1");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (mystart.equals("Tineretului") || mystart.equals("Eroii Revolutiei") || mystart.equals("Constantin Brancoveanu") || mystart.equals("Piata Sudului") || mystart.equals("Aparatorii Patriei") || mystart.equals("Dimitrie Leonida") || mystart.equals("Berceni")) {
                                    if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1") || myfinish.equals("Basarab (M1)")) {
                                        for (i = 0; i <= blue.length - 1; i++) {
                                            if (mystart.equals(blue[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (myfinish.equals(yellow[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint;x>=3;x--) {
                                            list1.add(blue[x]);
                                            list2.add("M2");
                                        }
                                        for (x=0; x<=finishPoint;x++) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                    } else {
                                        if (myfinish.equals("Crangasi") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Grozavesti") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Izvor (M1)")) {
                                            for (i = 0; i <= blue.length - 1; i++) {
                                                if (mystart.equals(blue[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (myfinish.equals(yellow[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint;x>=6;x--) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                            for (x=8; x>=finishPoint;x--) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                        } else {
                                            if (myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Dristor 1 (M1)") || myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului")) {
                                                for (i = 0; i <= blue.length - 1; i++) {
                                                    if (mystart.equals(blue[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint;x>=6;x--) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                                for (x=8; x<=finishPoint;x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor")) {
                                                    for (i = 0; i <= blue.length - 1; i++) {
                                                        if (mystart.equals(blue[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint;x>=3;x--) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                    list1.add("Piata Victoriei 1");
                                                    list2.add("M1");
                                                    for (x=15; x>=finishPoint;x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                        for (i = 0; i <= blue.length - 1; i++) {
                                                            if (mystart.equals(blue[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow2.length - 1; i++) {
                                                            if (myfinish.equals(yellow2[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint;x>=6;x--) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                        for (x=8; x<=11;x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=4; x>= finishPoint; x--) {
                                                            list1.add(yellow2[x]);
                                                            list2.add("M1");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (myvalue1.equals("M1") && myvalue2.equals("M3")) {
                            if (mystart.equals("Crangasi") || mystart.equals("Petrache Poenaru") || mystart.equals("Grozavesti") || mystart.equals("Eroilor (M1)")) {
                                if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") || myfinish.equals("Eroilor (M3)")) {
                                    for (i = 0; i <= yellow.length - 1; i++) {
                                        if (mystart.equals(yellow[i])) {
                                            startPoint = i;
                                        }
                                    }
                                    for (i = 0; i <= red.length - 1; i++) {
                                        if (myfinish.equals(red[i])) {
                                            finishPoint = i;
                                        }
                                    }
                                    for (x=3; x<=startPoint;x++) {
                                        list1.add(yellow[x]);
                                        list2.add("M1");
                                    }
                                    for (x=5;x>=finishPoint;x--) {
                                        list1.add(red[x]);
                                        list2.add("M3");
                                    }
                                } else {
                                    if (myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)") ||
                                            myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (mystart.equals(yellow[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= red.length - 1; i++) {
                                            if (myfinish.equals(red[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint;x<=6;x++) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                        for (x=5; x<=finishPoint; x++) {
                                            list1.add(red[x]);
                                            list2.add("M3");
                                        }
                                    }
                                }
                            } else {
                                if (mystart.equals("Basarab (M1)") || mystart.equals("Gara de Nord 1") || mystart.equals("Piata Victoriei 1")) {
                                    if (myfinish.equals("Eroilor (M3)") || myfinish.equals("Politehnica") || myfinish.equals("Lujerului") || myfinish.equals("Gorjului") ||
                                            myfinish.equals("Pacii") || myfinish.equals("Preciziei")) {
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (mystart.equals(yellow[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= red.length - 1; i++) {
                                            if (myfinish.equals(red[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint; x<=6; x++) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                        for (x=5; x>= finishPoint; x--) {
                                            list1.add(red[x]);
                                            list2.add("M3");
                                        }
                                    } else {
                                        if (myfinish.equals("Izvor")) {
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (mystart.equals(yellow[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= red.length - 1; i++) {
                                                if (myfinish.equals(red[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x<=6; x++) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                            for (x=5; x<=finishPoint; x++) {
                                                list1.add(red[x]);
                                                list2.add("M3");
                                            }
                                        } else {
                                            if (myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)")) {
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (mystart.equals(yellow[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (myfinish.equals(red[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x>=0; x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=3; x<=6; x++) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                                for (x=7; x<= finishPoint; x++) {
                                                    list1.add(red[x]);
                                                    list2.add("M3");
                                                }
                                            } else {
                                                if (myfinish.equals("Dristor 1 (M3)") || myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (myfinish.equals(red[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x>=0; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=16; x>=11; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=10; x<=finishPoint; x++) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (mystart.equals("Stefan cel Mare") || mystart.equals("Obor")) {
                                        if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") ||
                                                myfinish.equals("Eroilor (M3)") || myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)")) {
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (mystart.equals(yellow[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= red.length - 1; i++) {
                                                if (myfinish.equals(red[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x<=16; x++) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                            list1.add("Piata Victoriei 1");
                                            list2.add("M1");
                                            for (x=3; x<=6; x++) {
                                                list1.add(blue[x]);
                                                list2.add("M2");
                                            }
                                            for (x=7; x>=finishPoint; x--) {
                                                list1.add(red[x]);
                                                list2.add("M3");
                                            }
                                        } else {
                                            if (myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)")) {
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (mystart.equals(yellow[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (myfinish.equals(red[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x>=11; x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=10; x>= finishPoint; x--) {
                                                    list1.add(red[x]);
                                                    list2.add("M3");
                                                }
                                            } else {
                                                if (myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (myfinish.equals(red[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x>=11; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=10; x<=finishPoint; x++) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (mystart.equals("Piata Iancului") || mystart.equals("Piata Muncii") || mystart.equals("Dristor 2")) {
                                            if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") ||
                                                    myfinish.equals("Eroilor (M3)") || myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") ||
                                                    myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)")) {
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (mystart.equals(yellow[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (myfinish.equals(red[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x>=11; x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=10; x>=finishPoint; x--) {
                                                    list1.add(red[x]);
                                                    list2.add("M3");
                                                }
                                            } else {
                                                if (myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (myfinish.equals(red[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x>=11; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=10; x<=finishPoint; x++) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                }
                                            }
                                        } else {
                                            if (mystart.equals("Izvor (M1)") || mystart.equals("Piata Unirii 1") || mystart.equals("Timpuri Noi (M1)") || mystart.equals("Mihai Bravu (M1)") || mystart.equals("Dristor 1 (M1)")) {
                                                if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Lujerului") || myfinish.equals("Gorjului") || myfinish.equals("Politehnica") || myfinish.equals("Eroilor (M3)")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (myfinish.equals(red[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x>=6; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=5; x>=finishPoint; x--) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)")) {
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (mystart.equals(yellow[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (myfinish.equals(red[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        if (finishPoint>=startPoint-1) {
                                                            for (x=startPoint; x<=finishPoint+1; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            list1.add(red[finishPoint]);
                                                            list2.add("M3");
                                                        } else {
                                                            if (finishPoint<startPoint-1) {
                                                                for (x=startPoint; x>finishPoint; x--) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                list1.add(red[finishPoint]);
                                                                list2.add("M3");
                                                            }
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (mystart.equals(yellow[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (myfinish.equals(red[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint;x<=11; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=10; x<=finishPoint; x++) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (mystart.equals("Nicolae Grigorescu (M1)") || mystart.equals("Titan") || mystart.equals("Costin Georgian") || mystart.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                    if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") || myfinish.equals("Eroilor (M3)") ||
                                                            myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)") ||
                                                            myfinish.equals("Nicolae Grigorescu (M3)")) {
                                                        for (i = 0; i <= yellow2.length - 1; i++) {
                                                            if (mystart.equals(yellow2[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (myfinish.equals(red[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=4; x++) {
                                                            list1.add(yellow2[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=11; x>=finishPoint; x--) {
                                                            list1.add(red[x]);
                                                            list2.add("M3");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                            for (i = 0; i <= yellow2.length - 1; i++) {
                                                                if (mystart.equals(yellow2[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (myfinish.equals(red[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x<=4; x++) {
                                                                list1.add(yellow2[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=11; x<=finishPoint;x++) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (myvalue1.equals("M3") && myvalue2.equals("M1")) {
                                if (mystart.equals("Preciziei") || mystart.equals("Pacii") || mystart.equals("Gorjului") || mystart.equals("Lujerului") || mystart.equals("Politehnica") || mystart.equals("Eroilor (M3)")) {
                                    if (myfinish.equals("Eroilor (M1)") || myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi") || myfinish.equals("Basarab (M1)") || myfinish.equals("Gara de Nord 1") ||
                                            myfinish.equals("Piata Victoriei 1")) {
                                        for (i = 0; i <= red.length - 1; i++) {
                                            if (mystart.equals(red[i])) {
                                                startPoint = i;
                                            }
                                        }
                                        for (i = 0; i <= yellow.length - 1; i++) {
                                            if (myfinish.equals(yellow[i])) {
                                                finishPoint = i;
                                            }
                                        }
                                        for (x=startPoint;x<=5;x++) {
                                            list1.add(red[x]);
                                            list2.add("M3");
                                        }
                                        for (x=6; x>=finishPoint; x--) {
                                            list1.add(yellow[x]);
                                            list2.add("M1");
                                        }
                                    } else {
                                        if (myfinish.equals("Izvor (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Dristor 1 (M1)") ||
                                                myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii")) {
                                            for (i = 0; i <= red.length - 1; i++) {
                                                if (mystart.equals(red[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (myfinish.equals(yellow[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x<=5; x++) {
                                                list1.add(red[x]);
                                                list2.add("M3");
                                            }
                                            for (x=6; x<=finishPoint; x++) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                        } else {
                                            if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (mystart.equals(red[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x<=5; x++) {
                                                    list1.add(red[x]);
                                                    list2.add("M3");
                                                }
                                                for (x=6; x<=11; x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=4; x>=finishPoint;x--) {
                                                    list1.add(yellow2[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor")) {
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (mystart.equals(red[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint;x<=5;x++) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                    for (x=6; x>=0; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=16; x>=finishPoint; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (mystart.equals("Izvor (M3)")) {
                                        if (myfinish.equals("Eroilor (M1)") || myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi") || myfinish.equals("Basarab (M1)") || myfinish.equals("Gara de Nord 1")) {
                                            for (i = 0; i <= red.length - 1; i++) {
                                                if (mystart.equals(red[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (myfinish.equals(yellow[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            list1.add("Izvor (M3)");
                                            list2.add("M3");
                                            for (x=7; x>=finishPoint;x--) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                        } else {
                                            if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor")) {
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (mystart.equals(red[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                list1.add("Izvor (M3)");
                                                list2.add("M3");
                                                list1.add("Piata Unirii (M3)");
                                                list2.add("M3");
                                                for (x=6; x>=3; x--) {
                                                    list1.add(blue[x]);
                                                    list2.add("M2");
                                                }
                                                list1.add("Piata Victoriei 1");
                                                list2.add("M1");
                                                for (x=16; x>=finishPoint;x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Piata Victoriei 1")) {
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (mystart.equals(red[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    list1.add("Izvor (M3)");
                                                    list2.add("M3");
                                                    list1.add("Piata Unirii (M3)");
                                                    list2.add("M3");
                                                    for (x=6; x>=3; x--) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                    list1.add("Piata Victoriei 1");
                                                    list2.add("M1");
                                                } else {
                                                    if (myfinish.equals("Izvor (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Dristor 1 (M1)") ||
                                                            myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului")) {
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (mystart.equals(red[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        list1.add("Izvor (M3)");
                                                        list2.add("M3");
                                                        for (x=7; x<=finishPoint; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            list1.add("Izvor (M3)");
                                                            list2.add("M3");
                                                            for (x=7; x<=11; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=4; x>=finishPoint;x--) {
                                                                list1.add(yellow2[x]);
                                                                list2.add("M1");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (mystart.equals("Piata Unirii (M3)")) {
                                            if (myfinish.equals("Izvor (M1)") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi") || myfinish.equals("Basarab (M1)")) {
                                                for (i = 0; i <= red.length - 1; i++) {
                                                    if (mystart.equals(red[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                list1.add("Piata Unirii (M3)");
                                                list2.add("M3");
                                                for (x=8; x>=finishPoint;x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor")) {
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (mystart.equals(red[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    list1.add("Piata Unirii (M3)");
                                                    list2.add("M3");
                                                    for (x=6; x>=3; x--) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                    list1.add("Piata Victoriei 1");
                                                    list2.add("M1");
                                                    for (x=16; x>=finishPoint;x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1")) {
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (mystart.equals(red[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        list1.add("Piata Unirii (M3)");
                                                        list2.add("M3");
                                                        for (x=6; x>=3; x--) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                        for (x=0; x<=finishPoint; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Dristor 1 (M1)") ||
                                                                myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului")) {
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            list1.add("Piata Unirii (M3)");
                                                            list2.add("M3");
                                                            for (x=8; x<=finishPoint; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                for (i = 0; i <= red.length - 1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                list1.add("Piata Unirii (M3)");
                                                                list2.add("M3");
                                                                for (x=8; x<=11; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=4; x>=finishPoint;x--) {
                                                                    list1.add(yellow2[x]);
                                                                    list2.add("M1");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (mystart.equals("Timpuri Noi (M3)")) {
                                                if (myfinish.equals("Izvor (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi") || myfinish.equals("Basarab (M1)")) {
                                                    for (i = 0; i <= red.length - 1; i++) {
                                                        if (mystart.equals(red[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    list1.add("Timpuri Noi (M3)");
                                                    list2.add("M3");
                                                    for (x=9; x>=finishPoint;x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1")) {
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (mystart.equals(red[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x>=8; x--) {
                                                            list1.add(red[x]);
                                                            list2.add("M3");
                                                        }
                                                        for (x=6; x>=3; x--) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                        for (x=0; x<= finishPoint; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Dristor 1 (M1)") ||
                                                                myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului") || myfinish.equals("Obor") || myfinish.equals("Stefan cel Mare")) {
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            list1.add("Timpuri Noi (M3)");
                                                            list2.add("M3");
                                                            for (x=9; x<=finishPoint; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                for (i = 0; i <= red.length - 1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                list1.add("Timpuri Noi (M3)");
                                                                list2.add("M3");
                                                                for (x=9; x<=11; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=4; x>=finishPoint;x--) {
                                                                    list1.add(yellow2[x]);
                                                                    list2.add("M1");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (mystart.equals("Mihai Bravu (M3)")) {
                                                    if (myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Izvor (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi") || myfinish.equals("Basarab (M1)")) {
                                                        for (i = 0; i <= red.length - 1; i++) {
                                                            if (mystart.equals(red[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        list1.add("Mihai Bravu (M3)");
                                                        list2.add("M3");
                                                        for (x=10; x>=finishPoint;x--) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1")) {
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x>=8; x--) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                            for (x=6; x>=3; x--) {
                                                                list1.add(blue[x]);
                                                                list2.add("M2");
                                                            }
                                                            for (x=0; x<= finishPoint; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Dristor 1 (M1)") ||
                                                                    myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului") || myfinish.equals("Obor") || myfinish.equals("Stefan cel Mare")) {
                                                                for (i = 0; i <= red.length - 1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                list1.add("Mihai Bravu (M3)");
                                                                list2.add("M3");
                                                                for (x=10; x<=finishPoint; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                            } else {
                                                                if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                    for (i = 0; i <= red.length - 1; i++) {
                                                                        if (mystart.equals(red[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                                        if (myfinish.equals(yellow[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    list1.add("Mihai Bravu (M3)");
                                                                    list2.add("M3");
                                                                    for (x=10; x<=11; x++) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                    for (x=4; x>=finishPoint;x--) {
                                                                        list1.add(yellow2[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (mystart.equals("Dristor 1 (M3)")) {
                                                        if (myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Izvor (M1)") || myfinish.equals("Eroilor (M1)") ||
                                                                myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi")) {
                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            list1.add("Dristor 1 (M3)");
                                                            list2.add("M3");
                                                            for (x=11; x>=finishPoint; x--) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Dristor 1 (M1)") || myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului") || myfinish.equals("Obor") || myfinish.equals("Stefan cel Mare")) {
                                                                for (i = 0; i <= red.length - 1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                list1.add("Dristor 1 (M3)");
                                                                list2.add("M3");
                                                                for (x=11; x<=finishPoint; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                            } else {
                                                                if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                    for (i = 0; i <= red.length - 1; i++) {
                                                                        if (mystart.equals(red[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                                        if (myfinish.equals(yellow[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    list1.add("Dristor 1 (M3)");
                                                                    list2.add("M3");
                                                                    list1.add("Dristor 1 (M1)");
                                                                    list2.add("M1");
                                                                    for (x=4; x>=finishPoint; x--) {
                                                                        list1.add(yellow2[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                } else {
                                                                    if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1") || myfinish.equals("Basarab (M1)")) {
                                                                        for (i = 0; i <= red.length - 1; i++) {
                                                                            if (mystart.equals(red[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                                            if (myfinish.equals(yellow[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        list1.add("Dristor 1 (M3)");
                                                                        list2.add("M3");
                                                                        for (x=11; x<=16; x++) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=0; x<=finishPoint;x++) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (mystart.equals("Nicolae Grigorescu (M3)") || mystart.equals("1 Decembrie 1918") || mystart.equals("Nicolae Teclu") || mystart.equals("Anghel Saligny")) {
                                                            if (myfinish.equals("Mihai Bravu (M1)") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Piata Unirii 1") || myfinish.equals("Izvor (M1)") || myfinish.equals("Eroilor (M1)") ||
                                                                    myfinish.equals("Grozavesti") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Crangasi")) {
                                                                for (i = 0; i <= red.length - 1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x>=10; x--) {
                                                                    list1.add(red[x]);
                                                                    list2.add("M3");
                                                                }
                                                                for (x=11; x>= finishPoint; x--) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                            } else {
                                                                if (myfinish.equals("Dristor 1 (M1)") || myfinish.equals("Dristor 2") || myfinish.equals("Piata Muncii") || myfinish.equals("Piata Iancului") || myfinish.equals("Obor") || myfinish.equals("Stefan cel Mare")) {
                                                                    for (i = 0; i <= red.length - 1; i++) {
                                                                        if (mystart.equals(red[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                                        if (myfinish.equals(yellow[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    for (x=startPoint; x>=10; x--) {
                                                                        list1.add(red[x]);
                                                                        list2.add("M3");
                                                                    }
                                                                    for (x=11; x<=finishPoint; x++) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                } else {
                                                                    if (myfinish.equals("Piata Victoriei 1") || myfinish.equals("Gara de Nord 1") || myfinish.equals("Basarab (M1)")) {
                                                                        for (i = 0; i <= red.length - 1; i++) {
                                                                            if (mystart.equals(red[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                                            if (myfinish.equals(yellow[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        for (x=startPoint; x>=10; x--) {
                                                                            list1.add(red[x]);
                                                                            list2.add("M3");
                                                                        }
                                                                        for (x=11; x<=16; x++) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=0; x<=finishPoint; x++) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                    } else {
                                                                        if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                            for (i = 0; i <= red.length - 1; i++) {
                                                                                if (mystart.equals(red[i])) {
                                                                                    startPoint = i;
                                                                                }
                                                                            }
                                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                                if (myfinish.equals(yellow[i])) {
                                                                                    finishPoint = i;
                                                                                }
                                                                            }
                                                                            for (x=startPoint; x>=11; x--) {
                                                                                list1.add(red[x]);
                                                                                list2.add("M3");
                                                                            }
                                                                            for (x=4; x>=finishPoint; x--) {
                                                                                list1.add(yellow2[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (myvalue1.equals("M1") && myvalue2.equals("M4")) {
                                    if (mystart.equals("Mihai Bravu (M1)") || mystart.equals("Timpuri Noi (M1)") || mystart.equals("Piata Unirii 1") || mystart.equals("Izvor (M1)") || mystart.equals("Eroilor (M1)") || mystart.equals("Grozavesti") ||
                                            mystart.equals("Petrache Poenaru") || mystart.equals("Crangasi") || mystart.equals("Basarab (M1)")) {
                                        if (myfinish.equals("Gara de Nord 2") || myfinish.equals("Basarab (M4)")) {
                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                if (mystart.equals(yellow[i])) {
                                                    startPoint = i;
                                                }
                                            }
                                            for (i = 0; i <= green.length - 1; i++) {
                                                if (myfinish.equals(green[i])) {
                                                    finishPoint = i;
                                                }
                                            }
                                            for (x=startPoint; x>=2; x--) {
                                                list1.add(yellow[x]);
                                                list2.add("M1");
                                            }
                                            for (x=6; x<=finishPoint; x++) {
                                                list1.add(green[x]);
                                                list2.add("M4");
                                            }
                                        } else {
                                            if (myfinish.equals("Grivita") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Laminorului") || myfinish.equals("Straulesti")) {
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (mystart.equals(yellow[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= green.length - 1; i++) {
                                                    if (myfinish.equals(green[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x>=2; x--) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x=6; x>=finishPoint; x--) {
                                                    list1.add(green[x]);
                                                    list2.add("M4");
                                                }
                                            }
                                        }
                                    } else {
                                        if (mystart.equals("Dristor 1 (M1)") || mystart.equals("Dristor 2") || mystart.equals("Piata Muncii") || mystart.equals("Piata Iancului") || mystart.equals("Obor") || mystart.equals("Stefan cel Mare")) {
                                            if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (mystart.equals(yellow[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= green.length - 1; i++) {
                                                    if (myfinish.equals(green[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x = startPoint; x <= 16; x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x = 0; x <= 2; x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                                for (x = 6; x <= finishPoint; x++) {
                                                    list1.add(green[x]);
                                                    list2.add("M4");
                                                }
                                            } else {
                                                if (myfinish.equals("Grivita") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Laminorului") || myfinish.equals("Straulesti")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= green.length - 1; i++) {
                                                        if (myfinish.equals(green[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x<=16; x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=0; x<=2; x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=6; x>=finishPoint; x--) {
                                                        list1.add(green[x]);
                                                        list2.add("M4");
                                                    }
                                                }
                                            }
                                        } else {
                                            if (mystart.equals("Piata Victoriei 1") || mystart.equals("Gara de Nord 1")) {
                                                if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (mystart.equals(yellow[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= green.length - 1; i++) {
                                                        if (myfinish.equals(green[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x<=2; x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                    for (x=6; x<=finishPoint; x++) {
                                                        list1.add(green[x]);
                                                        list2.add("M4");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Grivita") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Laminorului") ||
                                                            myfinish.equals("Straulesti")) {
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (mystart.equals(yellow[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= green.length - 1; i++) {
                                                            if (myfinish.equals(green[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=2; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=6; x>=finishPoint; x--) {
                                                            list1.add(green[x]);
                                                            list2.add("M4");
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (mystart.equals("Nicolae Grigorescu (M1)") || mystart.equals("Titan") || mystart.equals("Costin Georgian") || mystart.equals("Republica") || mystart.equals("Pantelimon")) {
                                                    if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                        for (i = 0; i <= yellow2.length - 1; i++) {
                                                            if (mystart.equals(yellow2[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= green.length - 1; i++) {
                                                            if (myfinish.equals(green[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=4; x++) {
                                                            list1.add(yellow2[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=11; x<=16; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=0; x<=2; x++) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=6; x<=finishPoint; x++) {
                                                            list1.add(green[x]);
                                                            list2.add("M4");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Grivita") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Laminorului") || myfinish.equals("Straulesti")) {
                                                            for (i = 0; i <= yellow2.length - 1; i++) {
                                                                if (mystart.equals(yellow2[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= green.length - 1; i++) {
                                                                if (myfinish.equals(green[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x<=4; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=11; x<=16; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=0; x<=2; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=6; x>=finishPoint; x--) {
                                                                list1.add(green[x]);
                                                                list2.add("M4");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (myvalue1.equals("M4") && myvalue2.equals("M1")) {
                                        if (mystart.equals("Straulesti") || mystart.equals("Laminorului") || mystart.equals("Parc Bazilescu") || mystart.equals("Jiului") || mystart.equals("1 Mai") || mystart.equals("Grivita")) {
                                            if (myfinish.equals("Basarab (M1)") || myfinish.equals("Crangasi") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Grozavesti") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Izvor (M1)") ||
                                                    myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)")) {
                                                for (i = 0; i <= green.length - 1; i++) {
                                                    if (mystart.equals(green[i])) {
                                                        startPoint = i;
                                                    }
                                                }
                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                    if (myfinish.equals(yellow[i])) {
                                                        finishPoint = i;
                                                    }
                                                }
                                                for (x=startPoint; x<=6; x++) {
                                                    list1.add(green[x]);
                                                    list2.add("M4");
                                                }
                                                for (x=2; x<=finishPoint; x++) {
                                                    list1.add(yellow[x]);
                                                    list2.add("M1");
                                                }
                                            } else {
                                                if (myfinish.equals("Gara de Nord 1") || myfinish.equals("Piata Victoriei 1")) {
                                                    for (i = 0; i <= green.length - 1; i++) {
                                                        if (mystart.equals(green[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x<=6; x++) {
                                                        list1.add(green[x]);
                                                        list2.add("M4");
                                                    }
                                                    for (x=2; x>= finishPoint; x--) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor") || myfinish.equals("Piata Iancului") || myfinish.equals("Piata Muncii") || myfinish.equals("Dristor 2") || myfinish.equals("Dristor 1 (M1)")) {
                                                        for (i = 0; i <= green.length - 1; i++) {
                                                            if (mystart.equals(green[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=6; x++) {
                                                            list1.add(green[x]);
                                                            list2.add("M4");
                                                        }
                                                        for (x=2; x>=0; x--) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                        for (x=16; x>=finishPoint; x--) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                            for (i = 0; i <= green.length - 1; i++) {
                                                                if (mystart.equals(green[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x<=6; x++) {
                                                                list1.add(green[x]);
                                                                list2.add("M4");
                                                            }
                                                            for (x=2; x>=0; x--) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=16; x>=11; x--) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=4; x>=finishPoint; x--) {
                                                                list1.add(yellow2[x]);
                                                                list2.add("M1");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (mystart.equals("Gara de Nord 2") || mystart.equals("Basarab (M4)")) {
                                                if (myfinish.equals("Basarab (M1)") || myfinish.equals("Crangasi") || myfinish.equals("Petrache Poenaru") || myfinish.equals("Grozavesti") || myfinish.equals("Eroilor (M1)") || myfinish.equals("Izvor (M1)") ||
                                                        myfinish.equals("Piata Unirii 1") || myfinish.equals("Timpuri Noi (M1)") || myfinish.equals("Mihai Bravu (M1)")) {
                                                    for (i = 0; i <= green.length - 1; i++) {
                                                        if (mystart.equals(green[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i = 0; i <= yellow.length - 1; i++) {
                                                        if (myfinish.equals(yellow[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x>=6; x--) {
                                                        list1.add(green[x]);
                                                        list2.add("M4");
                                                    }
                                                    for (x=2; x<=finishPoint; x++) {
                                                        list1.add(yellow[x]);
                                                        list2.add("M1");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Gara de Nord 1") || myfinish.equals("Piata Victoriei 1")) {
                                                        for (i = 0; i <= green.length - 1; i++) {
                                                            if (mystart.equals(green[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i = 0; i <= yellow.length - 1; i++) {
                                                            if (myfinish.equals(yellow[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x>=6; x--) {
                                                            list1.add(green[x]);
                                                            list2.add("M4");
                                                        }
                                                        for (x=2; x>= finishPoint; x--) {
                                                            list1.add(yellow[x]);
                                                            list2.add("M1");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Stefan cel Mare") || myfinish.equals("Obor") || myfinish.equals("Piata Iancului") || myfinish.equals("Piata Muncii") || myfinish.equals("Dristor 2") || myfinish.equals("Dristor 1 (M1)")) {
                                                            for (i = 0; i <= green.length - 1; i++) {
                                                                if (mystart.equals(green[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i = 0; i <= yellow.length - 1; i++) {
                                                                if (myfinish.equals(yellow[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x>=6; x--) {
                                                                list1.add(green[x]);
                                                                list2.add("M4");
                                                            }
                                                            for (x=2; x>=0; x--) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=16; x>=finishPoint; x--) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Nicolae Grigorescu (M1)") || myfinish.equals("Titan") || myfinish.equals("Costin Georgian") || myfinish.equals("Republica") || myfinish.equals("Pantelimon")) {
                                                                for (i = 0; i <= green.length - 1; i++) {
                                                                    if (mystart.equals(green[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i = 0; i <= yellow.length - 1; i++) {
                                                                    if (myfinish.equals(yellow[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x>=6; x--) {
                                                                    list1.add(green[x]);
                                                                    list2.add("M4");
                                                                }
                                                                for (x=2; x>=0; x--) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=16; x>=11; x--) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=4; x>=finishPoint; x--) {
                                                                    list1.add(yellow2[x]);
                                                                    list2.add("M1");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (myvalue1.equals("M2") && myvalue2.equals("M3")) {
                                            if (mystart.equals("Pipera") || mystart.equals("Aurel Vlaicu") || mystart.equals("Aviatorilor") || mystart.equals("Piata Victoriei 2") ||
                                                    mystart.equals("Piata Romana") || mystart.equals("Universitate") || mystart.equals("Piata Unirii 2")) {
                                                if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Lujerului") || myfinish.equals("Gorjului") || myfinish.equals("Politehnica") ||
                                                        myfinish.equals("Eroilor (M3)") || myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)")) {
                                                    for (i=0; i<=blue.length-1; i++) {
                                                        if (mystart.equals(blue[i])) {
                                                            startPoint = i;
                                                        }
                                                    }
                                                    for (i=0; i<=red.length-1; i++) {
                                                        if (myfinish.equals(red[i])) {
                                                            finishPoint = i;
                                                        }
                                                    }
                                                    for (x=startPoint; x<=6; x++) {
                                                        list1.add(blue[x]);
                                                        list2.add("M2");
                                                    }
                                                    for (x=7; x>=finishPoint; x--) {
                                                        list1.add(red[x]);
                                                        list2.add("M3");
                                                    }
                                                } else {
                                                    if (myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)") || myfinish.equals("Nicolae Grigorescu (M3)") ||
                                                            myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                        for (i=0; i<=blue.length-1; i++) {
                                                            if (mystart.equals(blue[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i=0; i<=red.length-1; i++) {
                                                            if (myfinish.equals(red[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=6; x++) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                        for (x=7; x<=finishPoint; x++) {
                                                            list1.add(red[x]);
                                                            list2.add("M3");
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (mystart.equals("Tineretului") || mystart.equals("Eroii Revolutiei") || mystart.equals("Constantin Brancoveanu") || mystart.equals("Piata Sudului") ||
                                                        mystart.equals("Aparatorii Patriei") || mystart.equals("Dimitrie Leonida") || mystart.equals("Berceni")) {
                                                    if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Lujerului") || myfinish.equals("Gorjului") || myfinish.equals("Politehnica") ||
                                                            myfinish.equals("Eroilor (M3)") || myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)")) {
                                                        for (i=0; i<=blue.length-1; i++) {
                                                            if (mystart.equals(blue[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i=0; i<=red.length-1; i++) {
                                                            if (myfinish.equals(red[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x>=6; x--) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                        for (x=7; x>=finishPoint; x--) {
                                                            list1.add(red[x]);
                                                            list2.add("M3");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)") || myfinish.equals("Dristor 1 (M3)") || myfinish.equals("Nicolae Grigorescu (M3)") ||
                                                                myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                            for (i=0; i<=blue.length-1; i++) {
                                                                if (mystart.equals(blue[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i=0; i<=red.length-1; i++) {
                                                                if (myfinish.equals(red[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x>=6; x--) {
                                                                list1.add(blue[x]);
                                                                list2.add("M2");
                                                            }
                                                            for (x=7; x<=finishPoint; x++) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (myvalue1.equals("M3") && myvalue2.equals("M2")) {
                                                if (mystart.equals("Preciziei") || mystart.equals("Pacii") || mystart.equals("Gorjului") || mystart.equals("Lujerului") || mystart.equals("Politehnica") ||
                                                        mystart.equals("Eroilor (M3)") || mystart.equals("Izvor (M3)") || mystart.equals("Piata Unirii (M3)")) {
                                                    if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2") || myfinish.equals("Piata Romana") ||
                                                            myfinish.equals("Universitate") || myfinish.equals("Piata Unirii 2")) {
                                                        for (i=0; i<=red.length-1; i++) {
                                                            if (mystart.equals(red[i])) {
                                                                startPoint = i;
                                                            }
                                                        }
                                                        for (i=0; i<=blue.length-1; i++) {
                                                            if (myfinish.equals(blue[i])) {
                                                                finishPoint = i;
                                                            }
                                                        }
                                                        for (x=startPoint; x<=7; x++) {
                                                            list1.add(red[x]);
                                                            list2.add("M3");
                                                        }
                                                        for (x=6; x>=finishPoint; x--) {
                                                            list1.add(blue[x]);
                                                            list2.add("M2");
                                                        }
                                                    } else {
                                                        if (myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") || myfinish.equals("Piata Sudului") ||
                                                                myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                                            for (i=0; i<=red.length-1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i=0; i<=blue.length-1; i++) {
                                                                if (myfinish.equals(blue[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x<=7; x++) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                            for (x=6; x<=finishPoint; x++) {
                                                                list1.add(blue[x]);
                                                                list2.add("M2");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (mystart.equals("Timpuri Noi (M3)") || mystart.equals("Mihai Bravu (M3)") || mystart.equals("Dristor 1 (M3)") || mystart.equals("Nicolae Grigorescu (M3)") || mystart.equals("1 Decembrie 1918") ||
                                                            mystart.equals("Nicolae Teclu") || mystart.equals("Anghel Saligny")) {
                                                        if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2") || myfinish.equals("Piata Romana") ||
                                                                myfinish.equals("Universitate") || myfinish.equals("Piata Unirii 2")) {
                                                            for (i=0; i<=red.length-1; i++) {
                                                                if (mystart.equals(red[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i=0; i<=blue.length-1; i++) {
                                                                if (myfinish.equals(blue[i])) {
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x>=7; x--) {
                                                                list1.add(red[x]);
                                                                list2.add("M3");
                                                            }
                                                            for (x=6; x>=finishPoint; x--) {
                                                                list1.add(blue[x]);
                                                                list2.add("M2");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") || myfinish.equals("Constantin Brancoveanu") || myfinish.equals("Piata Sudului") ||
                                                                    myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                                                for (i=0; i<=red.length-1; i++) {
                                                                    if (mystart.equals(red[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i=0; i<=blue.length-1; i++) {
                                                                    if (myfinish.equals(blue[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x>=7; x--) {
                                                                    list1.add(red[x]);
                                                                    list2.add("M3");
                                                                }
                                                                for (x=6; x<=finishPoint; x++) {
                                                                    list1.add(blue[x]);
                                                                    list2.add("M2");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (myvalue1.equals("M2") && myvalue2.equals("M4")) {
                                                    if (mystart.equals("Pipera") || mystart.equals("Aurel Vlaicu") || mystart.equals("Aviatorilor") || mystart.equals("Piata Victoriei 2")) {
                                                        if (myfinish.equals("Straulesti") || myfinish.equals("Laminorului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Jiului") || myfinish.equals("1 Mai") ||
                                                                myfinish.equals("Grivita")) {
                                                            for (i=0; i<=blue.length-1; i++) {
                                                                if (mystart.equals(blue[i])) {
                                                                    startPoint = i;
                                                                }
                                                            }
                                                            for (i=0; i<=green.length-1; i++) {
                                                                if (myfinish.equals(green[i])){
                                                                    finishPoint = i;
                                                                }
                                                            }
                                                            for (x=startPoint; x<=3; x++) {
                                                                list1.add(blue[x]);
                                                                list2.add("M2");
                                                            }
                                                            for (x=0; x<=2; x++) {
                                                                list1.add(yellow[x]);
                                                                list2.add("M1");
                                                            }
                                                            for (x=6; x>=finishPoint; x--) {
                                                                list1.add(green[x]);
                                                                list2.add("M4");
                                                            }
                                                        } else {
                                                            if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                                for (i=0; i<=blue.length-1; i++) {
                                                                    if (mystart.equals(blue[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i=0; i<=green.length-1; i++) {
                                                                    if (myfinish.equals(green[i])){
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x<=3; x++) {
                                                                    list1.add(blue[x]);
                                                                    list2.add("M2");
                                                                }
                                                                for (x=0; x<=2; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=6; x<=finishPoint; x++) {
                                                                    list1.add(green[x]);
                                                                    list2.add("M4");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (mystart.equals("Piata Romana") || mystart.equals("Universitate") || mystart.equals("Piata Unirii 2") || mystart.equals("Tineretului") ||
                                                                mystart.equals("Eroii Revolutiei") || mystart.equals("Aparatorii Patriei") || mystart.equals("Constantin Brancoveanu") || mystart.equals("Piata Sudului") ||
                                                                mystart.equals("Dimitrie Leonida") || mystart.equals("Berceni")) {
                                                            if (myfinish.equals("Straulesti") || myfinish.equals("Laminorului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("Jiului") || myfinish.equals("1 Mai") ||
                                                                    myfinish.equals("Grivita")) {
                                                                for (i=0; i<=blue.length-1; i++) {
                                                                    if (mystart.equals(blue[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i=0; i<=green.length-1; i++) {
                                                                    if (myfinish.equals(green[i])){
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x>=3; x--) {
                                                                    list1.add(blue[x]);
                                                                    list2.add("M2");
                                                                }
                                                                for (x=0; x<=2; x++) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=6; x>=finishPoint; x--) {
                                                                    list1.add(green[x]);
                                                                    list2.add("M4");
                                                                }
                                                            } else {
                                                                if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                                    for (i=0; i<=blue.length-1; i++) {
                                                                        if (mystart.equals(blue[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i=0; i<=green.length-1; i++) {
                                                                        if (myfinish.equals(green[i])){
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    for (x=startPoint; x>=3; x--) {
                                                                        list1.add(blue[x]);
                                                                        list2.add("M2");
                                                                    }
                                                                    for (x=0; x<=2; x++) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                    for (x=6; x<=finishPoint; x++) {
                                                                        list1.add(green[x]);
                                                                        list2.add("M4");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (myvalue1.equals("M4") && myvalue2.equals("M2")) {
                                                        if (mystart.equals("Straulesti") || mystart.equals("Laminorului") || mystart.equals("Parc Bazilescu") || mystart.equals("Jiului") ||
                                                                mystart.equals("1 Mai") || mystart.equals("Grivita")) {
                                                            if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2")) {
                                                                for (i=0; i<=green.length-1; i++) {
                                                                    if (mystart.equals(green[i])) {
                                                                        startPoint = i;
                                                                    }
                                                                }
                                                                for (i=0; i<=blue.length-1; i++) {
                                                                    if (myfinish.equals(blue[i])) {
                                                                        finishPoint = i;
                                                                    }
                                                                }
                                                                for (x=startPoint; x<=6; x++) {
                                                                    list1.add(green[x]);
                                                                    list2.add("M4");
                                                                }
                                                                for (x=2; x>=0; x--) {
                                                                    list1.add(yellow[x]);
                                                                    list2.add("M1");
                                                                }
                                                                for (x=3; x>=finishPoint; x--) {
                                                                    list1.add(blue[x]);
                                                                    list2.add("M2");
                                                                }
                                                            } else {
                                                                if (myfinish.equals("Piata Romana") || myfinish.equals("Universitate") || myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") ||
                                                                        myfinish.equals("Constantin Brancoveanu") || myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                                                    for (i=0; i<=green.length-1; i++) {
                                                                        if (mystart.equals(green[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i=0; i<=blue.length-1; i++) {
                                                                        if (myfinish.equals(blue[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    for (x=startPoint; x<=6; x++) {
                                                                        list1.add(green[x]);
                                                                        list2.add("M4");
                                                                    }
                                                                    for (x=2; x>=0; x--) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                    for (x=3; x<=finishPoint; x++) {
                                                                        list1.add(blue[x]);
                                                                        list2.add("M2");
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (mystart.equals("Basarab (M4)") || mystart.equals("Gara de Nord 2")) {
                                                                if (myfinish.equals("Pipera") || myfinish.equals("Aurel Vlaicu") || myfinish.equals("Aviatorilor") || myfinish.equals("Piata Victoriei 2")) {
                                                                    for (i=0; i<=green.length-1; i++) {
                                                                        if (mystart.equals(green[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i=0; i<=blue.length-1; i++) {
                                                                        if (myfinish.equals(blue[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    for (x=startPoint; x>=6; x--) {
                                                                        list1.add(green[x]);
                                                                        list2.add("M4");
                                                                    }
                                                                    for (x=2; x>=0; x--) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                    for (x=3; x>=finishPoint; x--) {
                                                                        list1.add(blue[x]);
                                                                        list2.add("M2");
                                                                    }
                                                                } else {
                                                                    if (myfinish.equals("Piata Romana") || myfinish.equals("Universitate") || myfinish.equals("Piata Unirii 2") || myfinish.equals("Tineretului") || myfinish.equals("Eroii Revolutiei") ||
                                                                            myfinish.equals("Constantin Brancoveanu") || myfinish.equals("Piata Sudului") || myfinish.equals("Aparatorii Patriei") || myfinish.equals("Dimitrie Leonida") || myfinish.equals("Berceni")) {
                                                                        for (i=0; i<=green.length-1; i++) {
                                                                            if (mystart.equals(green[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i=0; i<=blue.length-1; i++) {
                                                                            if (myfinish.equals(blue[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        for (x=startPoint; x>=6; x--) {
                                                                            list1.add(green[x]);
                                                                            list2.add("M4");
                                                                        }
                                                                        for (x=2; x>=0; x--) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=3; x<=finishPoint; x++) {
                                                                            list1.add(blue[x]);
                                                                            list2.add("M2");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (myvalue1.equals("M3") && myvalue2.equals("M4")) {
                                                            if (mystart.equals("Preciziei") || mystart.equals("Pacii") || mystart.equals("Gorjului") || mystart.equals("Lujerului") || mystart.equals("Politehnica") ||
                                                                    mystart.equals("Eroilor (M3)")) {
                                                                if (myfinish.equals("Straulesti") || myfinish.equals("Laminorului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") ||
                                                                        myfinish.equals("Grivita")) {
                                                                    for (i=0; i<=red.length-1; i++) {
                                                                        if (mystart.equals(red[i])) {
                                                                            startPoint = i;
                                                                        }
                                                                    }
                                                                    for (i=0; i<=green.length -1; i++) {
                                                                        if (myfinish.equals(green[i])) {
                                                                            finishPoint = i;
                                                                        }
                                                                    }
                                                                    for (x=startPoint; x<=5; x++) {
                                                                        list1.add(red[x]);
                                                                        list2.add("M3");
                                                                    }
                                                                    for (x=6; x>=2; x--) {
                                                                        list1.add(yellow[x]);
                                                                        list2.add("M1");
                                                                    }
                                                                    for (x=6; x>=finishPoint; x--) {
                                                                        list1.add(green[x]);
                                                                        list2.add("M4");
                                                                    }
                                                                } else {
                                                                    if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                                        for (i=0; i<=red.length-1; i++) {
                                                                            if (mystart.equals(red[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i=0; i<=green.length -1; i++) {
                                                                            if (myfinish.equals(green[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        for (x=startPoint; x<=5; x++) {
                                                                            list1.add(red[x]);
                                                                            list2.add("M3");
                                                                        }
                                                                        for (x=6; x>=2; x--) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=6; x<=finishPoint; x++) {
                                                                            list1.add(green[x]);
                                                                            list2.add("M4");
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (mystart.equals("Izvor (M3)") || mystart.equals("Piata Unirii (M3)") || mystart.equals("Timpuri Noi (M3)") || mystart.equals("Mihai Bravu (M3)")) {
                                                                    if (myfinish.equals("Straulesti") || myfinish.equals("Laminorului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") ||
                                                                            myfinish.equals("Grivita")) {
                                                                        for (i=0; i<=red.length-1; i++) {
                                                                            if (mystart.equals(red[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i=0; i<=green.length -1; i++) {
                                                                            if (myfinish.equals(green[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        for (x=startPoint; x>=5; x--) {
                                                                            list1.add(red[x]);
                                                                            list2.add("M3");
                                                                        }
                                                                        for (x=6; x>=2; x--) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=6; x>=finishPoint; x--) {
                                                                            list1.add(green[x]);
                                                                            list2.add("M4");
                                                                        }
                                                                    } else {
                                                                        if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                                            for (i=0; i<=red.length-1; i++) {
                                                                                if (mystart.equals(red[i])) {
                                                                                    startPoint = i;
                                                                                }
                                                                            }
                                                                            for (i=0; i<=green.length -1; i++) {
                                                                                if (myfinish.equals(green[i])) {
                                                                                    finishPoint = i;
                                                                                }
                                                                            }
                                                                            for (x=startPoint; x>=5; x--) {
                                                                                list1.add(red[x]);
                                                                                list2.add("M3");
                                                                            }
                                                                            for (x=6; x>=2; x--) {
                                                                                list1.add(yellow[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                            for (x=6; x<=finishPoint; x++) {
                                                                                list1.add(green[x]);
                                                                                list2.add("M4");
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (mystart.equals("Dristor 1 (M3)") || mystart.equals("Nicolae Grigorescu (M3)") || mystart.equals("1 Decembrie 1918") || mystart.equals("Nicolae Teclu") || mystart.equals("Anghel Saligny")) {
                                                                        if (myfinish.equals("Straulesti") || myfinish.equals("Laminorului") || myfinish.equals("Parc Bazilescu") || myfinish.equals("1 Mai") || myfinish.equals("Jiului") ||
                                                                                myfinish.equals("Grivita")) {
                                                                            for (i=0; i<=red.length-1; i++) {
                                                                                if (mystart.equals(red[i])) {
                                                                                    startPoint = i;
                                                                                }
                                                                            }
                                                                            for (i=0; i<=green.length -1; i++) {
                                                                                if (myfinish.equals(green[i])) {
                                                                                    finishPoint = i;
                                                                                }
                                                                            }
                                                                            for (x=startPoint; x>=10; x--) {
                                                                                list1.add(red[x]);
                                                                                list2.add("M3");
                                                                            }
                                                                            for (x=11; x<=16; x++) {
                                                                                list1.add(yellow[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                            for (x=0; x<=2; x++) {
                                                                                list1.add(yellow[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                            for (x=6; x>=finishPoint; x--) {
                                                                                list1.add(green[x]);
                                                                                list2.add("M4");
                                                                            }
                                                                        } else {
                                                                            if (myfinish.equals("Basarab (M4)") || myfinish.equals("Gara de Nord 2")) {
                                                                                for (i=0; i<=red.length-1; i++) {
                                                                                    if (mystart.equals(red[i])) {
                                                                                        startPoint = i;
                                                                                    }
                                                                                }
                                                                                for (i=0; i<=green.length - 1; i++) {
                                                                                    if (myfinish.equals(green[i])) {
                                                                                        finishPoint = i;
                                                                                    }
                                                                                }
                                                                                for (x=startPoint; x>=10; x--) {
                                                                                    list1.add(red[x]);
                                                                                    list2.add("M3");
                                                                                }
                                                                                for (x=11; x<=16; x++) {
                                                                                    list1.add(yellow[x]);
                                                                                    list2.add("M1");
                                                                                }
                                                                                for (x=0; x<=2; x++) {
                                                                                    list1.add(yellow[x]);
                                                                                    list2.add("M1");
                                                                                }
                                                                                for (x=6; x<=finishPoint; x++) {
                                                                                    list1.add(green[x]);
                                                                                    list2.add("M4");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (myvalue1.equals("M4") && myvalue2.equals("M3")) {
                                                                if (mystart.equals("Straulesti") || mystart.equals("Laminorului") || mystart.equals("Parc Bazilescu") || mystart.equals("Jiului") || mystart.equals("1 Mai") || mystart.equals("Grivita")) {
                                                                    if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") || myfinish.equals("Eroilor (M3)")) {
                                                                        for (i=0; i<=green.length-1; i++) {
                                                                            if (mystart.equals(green[i])) {
                                                                                startPoint = i;
                                                                            }
                                                                        }
                                                                        for (i=0; i<=red.length-1; i++) {
                                                                            if (myfinish.equals(red[i])) {
                                                                                finishPoint = i;
                                                                            }
                                                                        }
                                                                        for (x=startPoint; x<=6; x++) {
                                                                            list1.add(green[x]);
                                                                            list2.add("M4");
                                                                        }
                                                                        for (x=2; x<=6; x++) {
                                                                            list1.add(yellow[x]);
                                                                            list2.add("M1");
                                                                        }
                                                                        for (x=5; x>=finishPoint; x--) {
                                                                            list1.add(red[x]);
                                                                            list2.add("M3");
                                                                        }
                                                                    } else {
                                                                        if (myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)")) {
                                                                            for (i=0; i<=green.length-1; i++) {
                                                                                if (mystart.equals(green[i])) {
                                                                                    startPoint = i;
                                                                                }
                                                                            }
                                                                            for (i=0; i<=red.length-1; i++) {
                                                                                if (myfinish.equals(red[i])) {
                                                                                    finishPoint = i;
                                                                                }
                                                                            }
                                                                            for (x=startPoint; x<=6; x++) {
                                                                                list1.add(green[x]);
                                                                                list2.add("M4");
                                                                            }
                                                                            for (x=2; x<=6; x++) {
                                                                                list1.add(yellow[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                            for (x=5; x<=finishPoint; x++) {
                                                                                list1.add(red[x]);
                                                                                list2.add("M3");
                                                                            }
                                                                        } else {
                                                                            if (myfinish.equals("Dristor 1 (M3)") || myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                                                for (i=0; i<=green.length-1; i++) {
                                                                                    if (mystart.equals(green[i])) {
                                                                                        startPoint = i;
                                                                                    }
                                                                                }
                                                                                for (i=0; i<=red.length-1; i++) {
                                                                                    if (myfinish.equals(red[i])) {
                                                                                        finishPoint = i;
                                                                                    }
                                                                                }
                                                                                for (x=startPoint; x<=6; x++) {
                                                                                    list1.add(green[x]);
                                                                                    list2.add("M4");
                                                                                }
                                                                                for (x=2; x>=0; x--) {
                                                                                    list1.add(yellow[x]);
                                                                                    list2.add("M1");
                                                                                }
                                                                                for (x=16; x>=11; x--) {
                                                                                    list1.add(yellow[x]);
                                                                                    list2.add("M1");
                                                                                }
                                                                                for (x=10; x>=finishPoint; x--) {
                                                                                    list1.add(red[x]);
                                                                                    list2.add("M3");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (mystart.equals("Basarab (M4)") || mystart.equals("Gara de Nord 2")) {
                                                                        if (myfinish.equals("Preciziei") || myfinish.equals("Pacii") || myfinish.equals("Gorjului") || myfinish.equals("Lujerului") || myfinish.equals("Politehnica") || myfinish.equals("Eroilor (M3)")) {
                                                                            for (i=0; i<=green.length-1; i++) {
                                                                                if (mystart.equals(green[i])) {
                                                                                    startPoint = i;
                                                                                }
                                                                            }
                                                                            for (i=0; i<=red.length-1; i++) {
                                                                                if (myfinish.equals(red[i])) {
                                                                                    finishPoint = i;
                                                                                }
                                                                            }
                                                                            for (x=startPoint; x>=6; x--) {
                                                                                list1.add(green[x]);
                                                                                list2.add("M4");
                                                                            }
                                                                            for (x=2; x<=6; x++) {
                                                                                list1.add(yellow[x]);
                                                                                list2.add("M1");
                                                                            }
                                                                            for (x=5; x>=finishPoint; x--) {
                                                                                list1.add(red[x]);
                                                                                list2.add("M3");
                                                                            }
                                                                        } else {
                                                                            if (myfinish.equals("Izvor (M3)") || myfinish.equals("Piata Unirii (M3)") || myfinish.equals("Timpuri Noi (M3)") || myfinish.equals("Mihai Bravu (M3)")) {
                                                                                for (i=0; i<=green.length-1; i++) {
                                                                                    if (mystart.equals(green[i])) {
                                                                                        startPoint = i;
                                                                                    }
                                                                                }
                                                                                for (i=0; i<=red.length-1; i++) {
                                                                                    if (myfinish.equals(red[i])) {
                                                                                        finishPoint = i;
                                                                                    }
                                                                                }
                                                                                for (x=startPoint; x>=6; x--) {
                                                                                    list1.add(green[x]);
                                                                                    list2.add("M4");
                                                                                }
                                                                                for (x=2; x<=6; x++) {
                                                                                    list1.add(yellow[x]);
                                                                                    list2.add("M1");
                                                                                }
                                                                                for (x=5; x<=finishPoint; x++) {
                                                                                    list1.add(red[x]);
                                                                                    list2.add("M3");
                                                                                }
                                                                            } else {
                                                                                if (myfinish.equals("Dristor 1 (M3)") || myfinish.equals("Nicolae Grigorescu (M3)") || myfinish.equals("1 Decembrie 1918") || myfinish.equals("Nicolae Teclu") || myfinish.equals("Anghel Saligny")) {
                                                                                    for (i=0; i<=green.length-1; i++) {
                                                                                        if (mystart.equals(green[i])) {
                                                                                            startPoint = i;
                                                                                        }
                                                                                    }
                                                                                    for (i=0; i<=red.length-1; i++) {
                                                                                        if (myfinish.equals(red[i])) {
                                                                                            finishPoint = i;
                                                                                        }
                                                                                    }
                                                                                    for (x=startPoint; x>=6; x--) {
                                                                                        list1.add(green[x]);
                                                                                        list2.add("M4");
                                                                                    }
                                                                                    for (x=2; x>=0; x--) {
                                                                                        list1.add(yellow[x]);
                                                                                        list2.add("M1");
                                                                                    }
                                                                                    for (x=16; x>=11; x--) {
                                                                                        list1.add(yellow[x]);
                                                                                        list2.add("M1");
                                                                                    }
                                                                                    for (x=10; x>=finishPoint; x--) {
                                                                                        list1.add(red[x]);
                                                                                        list2.add("M3");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (value1.equals("Line")) {
            Toast.makeText(getApplicationContext(), "Scroll down the list to see all stations", Toast.LENGTH_LONG).show();
        } else if (value1.equals("Linie")) {
            Toast.makeText(getApplicationContext(), "Miscati lista in jos pentru a vedea toate statiile", Toast.LENGTH_LONG).show();
        }

        for (x = 0; x<=list1.size()-1; x++) {
            if (list1.get(x).equals("Basarab (M4)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Basarab (M1)")) {
                        int a = list1.indexOf("Basarab (M4)");
                        list1.set(a, "Basarab (M4)" + changeValue);
                    }
                } else {
                    continue;
                }
            }
            if (list1.get(x).equals("Basarab (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Basarab (M4)")) {
                        int a = list1.indexOf("Basarab (M1)");
                        list1.set(a, "Basarab (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Dristor 2")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Dristor 1 (M1)")) {
                        int a = list1.indexOf("Dristor 2");
                        list1.set(a, "Dristor 2" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Dristor 1 (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Dristor 1 (M3)")) {
                        int a = list1.indexOf("Dristor 1 (M1)");
                        list1.set(a, "Dristor 1 (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Dristor 1 (M1)")) {
                if (x+1 <=list1.size()-1) {
                    if (list1.get(x+1).equals("Dristor 2")) {
                        int a = list1.indexOf("Dristor 1 (M1)");
                        list1.set(a, "Dristor 1 (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Dristor 1 (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Dristor 1 (M1)")) {
                        int a = list1.indexOf("Dristor 1 (M3)");
                        list1.set(a, "Dristor 1 (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Victoriei 1")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Victoriei 2")) {
                        int a = list1.indexOf("Piata Victoriei 1");
                        list1.set(a, "Piata Victoriei 1" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Victoriei 2")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Victoriei 1")) {
                        int a = list1.indexOf("Piata Victoriei 2");
                        list1.set(a, "Piata Victoriei 2" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Eroilor (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Eroilor (M3)")) {
                        int a = list1.indexOf("Eroilor (M1)");
                        list1.set(a, "Eroilor (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Eroilor (M3)")) {
                if (x+1 <=list1.size()-1) {
                    if (list1.get(x+1).equals("Eroilor (M1)")) {
                        int a = list1.indexOf("Eroilor (M3)");
                        list1.set(a, "Eroilor (M3)" + changeValue);
                    }
                } else {
                    continue;
                }
            }
            if (list1.get(x).equals("Piata Unirii 1")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii 2")) {
                        int a = list1.indexOf("Piata Unirii 1");
                        list1.set(a, "Piata Unirii 1" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Unirii 2")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii 1")) {
                        int a = list1.indexOf("Piata Unirii 2");
                        list1.set(a, "Piata Unirii 2" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Unirii 1")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii (M3)")) {
                        int a = list1.indexOf("Piata Unirii 1");
                        list1.set(a, "Piata Unirii 1" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Unirii (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii 1")) {
                        int a = list1.indexOf("Piata Unirii (M3)");
                        list1.set(a, "Piata Unirii (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Unirii 2")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii (M3)")) {
                        int a = list1.indexOf("Piata Unirii 2");
                        list1.set(a, "Piata Unirii 2" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Piata Unirii (M3)")) {
                if (x+1 <=list1.size()-1) {
                    if (list1.get(x+1).equals("Piata Unirii 2")) {
                        int a = list1.indexOf("Piata Unirii (M3)");
                        list1.set(a, "Piata Unirii (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Nicolae Grigorescu (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Nicolae Grigorescu (M3)")) {
                        int a = list1.indexOf("Nicolae Grigorescu (M1)");
                        list1.set(a, "Nicolae Grigorescu (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Nicolae Grigorescu (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Nicolae Grigorescu (M1)")) {
                        int a = list1.indexOf("Nicolae Grigorescu (M3)");
                        list1.set(a, "Nicolae Grigorescu (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Izvor (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Izvor (M3)")) {
                        int a = list1.indexOf("Izvor (M1)");
                        list1.set(a, "Izvor (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Izvor (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Izvor (M1)")) {
                        int a = list1.indexOf("Izvor (M3)");
                        list1.set(a, "Izvor (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Timpuri Noi (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Timpuri Noi (M3)")) {
                        int a = list1.indexOf("Timpuri Noi (M1)");
                        list1.set(a, "Timpuri Noi (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Timpuri Noi (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Timpuri Noi (M1)")) {
                        int a = list1.indexOf("Timpuri Noi (M3)");
                        list1.set(a, "Timpuri Noi (M3)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Mihai Bravu (M1)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Mihai Bravu (M3)")) {
                        int a = list1.indexOf("Mihai Bravu (M1)");
                        list1.set(a, "Mihai Bravu (M1)" + changeValue);
                    }
                }
            }
            if (list1.get(x).equals("Mihai Bravu (M3)")) {
                if (x+1 <= list1.size()-1) {
                    if (list1.get(x+1).equals("Mihai Bravu (M1)")) {
                        int a = list1.indexOf("Mihai Bravu (M3)");
                        list1.set(a, "Mihai Bravu (M3)" + changeValue);
                    }
                }
            }
        }

        StationsM1 = 0;
        StationsM2 = 0;
        StationsM3 = 0;
        StationsM4 = 0;

        for (i=0; i<=list2.size() - 1; i++) {
            if (list2.get(i).equals("M1")) {
                StationsM1 = StationsM1 + 1;
            } else if (list2.get(i).equals("M2")) {
                StationsM2 = StationsM2 + 1;
            } else if (list2.get(i).equals("M3")) {
                StationsM3 = StationsM3 + 1;
            } else if (list2.get(i).equals("M4")) {
                StationsM4 = StationsM4 + 1;
            }
        }

        totalTime = ((StationsM1)*timeM1) + ((StationsM2)*timeM2) + ((StationsM3)*timeM3) + ((StationsM4)*timeM4);

        if (value4.equals("Approx. time of journey: ")) {
            txtApproxTime.setText(String.format("Approx. time of journey: %s min.", String.format("%.1f", totalTime)));
        } else if (value4.equals("Timp aprox. pt. calatorie: ")) {
            txtApproxTime.setText(String.format("Timp aprox. pt. calatorie: %s min.", String.format("%.1f", totalTime)));
        }

        switch (formattedDay) {
            case "Mon":
            case "Tue":
            case "Wed":
            case "Thu":
            case "Fri":
                if (mystart.equals("Republica") || mystart.equals("Costin Georgian") || mystart.equals("Titan") || mystart.equals("Nicolae Grigorescu (M1)") || mystart.equals("Dristor 1 (M1)") ||
                        mystart.equals("Mihai Bravu (M1)") || mystart.equals("Timpuri Noi (M1)") || mystart.equals("Piata Unirii 1") || mystart.equals("Izvor (M1)") || mystart.equals("Eroilor (M1)") ||
                        mystart.equals("Grozavesti") || mystart.equals("Petrache Poenaru") || mystart.equals("Crangasi") || mystart.equals("Basarab (M1)") || mystart.equals("Gara de Nord 1") ||
                        mystart.equals("Piata Victoriei 1") || mystart.equals("Stefan cel Mare") || mystart.equals("Obor") || mystart.equals("Piata Iancului") || mystart.equals("Piata Muncii") ||
                        mystart.equals("Dristor 2")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("10") || formattedHour.equals("14") ||
                            formattedHour.equals("15") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 9.00;
                    } else if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") || formattedHour.equals("19")) {
                        timeToWait = 6.00;
                    } else if (formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13")) {
                        timeToWait = 10.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 12.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Pantelimon")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20")) {
                        timeToWait = 10.00;
                    } else if (formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") || formattedHour.equals("21") || formattedHour.equals("22")) {
                        timeToWait = 12.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Pipera") || mystart.equals("Aurel Vlaicu") || mystart.equals("Aviatorilor") || mystart.equals("Piata Victoriei 2") || mystart.equals("Piata Romana") || mystart.equals("Universitate") ||
                        mystart.equals("Piata Unirii 2") || mystart.equals("Tineretului") || mystart.equals("Eroii Revolutiei") || mystart.equals("Constantin Brancoveanu") || mystart.equals("Piata Sudului") ||
                        mystart.equals("Aparatorii Patriei") || mystart.equals("Dimitrie Leonida") || mystart.equals("Berceni")) {
                    if (formattedHour.equals("05") || formattedHour.equals("21")) {
                        timeToWait = 10.00;
                    } else if (formattedHour.equals("06") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12")) {
                        timeToWait = 8.00;
                    } else if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18")) {
                        timeToWait = 3.00;
                    } else if (formattedHour.equals("09") || formattedHour.equals("15") || formattedHour.equals("19")) {
                        timeToWait = 4.00;
                    } else if (formattedHour.equals("13") || formattedHour.equals("14") || formattedHour.equals("20")) {
                        timeToWait = 6.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 11.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Preciziei") || mystart.equals("Pacii") || mystart.equals("Gorjului") || mystart.equals("Lujerului") || mystart.equals("Politehnica") || mystart.equals("Nicolae Grigorescu (M3)") ||
                        mystart.equals("1 Decembrie 1918") || mystart.equals("Nicolae Teclu") || mystart.equals("Anghel Saligny")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("10") || formattedHour.equals("14") ||
                            formattedHour.equals("15") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 9.00;
                    } else if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") || formattedHour.equals("19")) {
                        timeToWait = 6.00;
                    } else if (formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13")) {
                        timeToWait = 10.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 12.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Eroilor (M3)") || mystart.equals("Izvor (M3)") || mystart.equals("Piata Unirii (M3)") || mystart.equals("Timpuri Noi (M3)") || mystart.equals("Mihai Bravu (M3)") ||
                        mystart.equals("Dristor 1 (M3)")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("10") || formattedHour.equals("14") ||
                            formattedHour.equals("15") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 4.50;
                    } else if (formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") || formattedHour.equals("19")) {
                        timeToWait = 3.00;
                    } else if (formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13")) {
                        timeToWait = 5.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 6.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Straulesti") || mystart.equals("Laminorului") || mystart.equals("Jiului") || mystart.equals("Parc Bazilescu") || mystart.equals("1 Mai") || mystart.equals("Basarab (M4)") || mystart.equals("Grivita") ||
                        mystart.equals("Gara de Nord 2")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("10") ||
                            formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") || formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") ||
                            formattedHour.equals("17") || formattedHour.equals("18") || formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21") || formattedHour.equals("22")) {
                        timeToWait = 11.50;
                    } else {
                        timeToWait = 0.00;
                    }
                }
            case "Sat":
            case "Sun":
                if (mystart.equals("Republica") || mystart.equals("Costin Georgian") || mystart.equals("Titan") || mystart.equals("Nicolae Grigorescu (M1)") || mystart.equals("Dristor 1 (M1)") ||
                        mystart.equals("Mihai Bravu (M1)") || mystart.equals("Timpuri Noi (M1)") || mystart.equals("Piata Unirii 1") || mystart.equals("Izvor (M1)") || mystart.equals("Eroilor (M1)") ||
                        mystart.equals("Grozavesti") || mystart.equals("Petrache Poenaru") || mystart.equals("Crangasi") || mystart.equals("Basarab (M1)") || mystart.equals("Gara de Nord 1") ||
                        mystart.equals("Piata Victoriei 1") || mystart.equals("Stefan cel Mare") || mystart.equals("Obor") || mystart.equals("Piata Iancului") || mystart.equals("Piata Muncii") ||
                        mystart.equals("Dristor 2")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") ||
                            formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 9.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 10.50;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Pantelimon")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") ||
                            formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 10.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 12.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Pipera") || mystart.equals("Aurel Vlaicu") || mystart.equals("Aviatorilor") || mystart.equals("Piata Victoriei 2") || mystart.equals("Piata Romana") || mystart.equals("Universitate") ||
                        mystart.equals("Piata Unirii 2") || mystart.equals("Tineretului") || mystart.equals("Eroii Revolutiei") || mystart.equals("Constantin Brancoveanu") || mystart.equals("Piata Sudului") ||
                        mystart.equals("Aparatorii Patriei") || mystart.equals("Dimitrie Leonida") || mystart.equals("Berceni")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") ||
                            formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 9.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 10.00;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Preciziei") || mystart.equals("Pacii") || mystart.equals("Gorjului") || mystart.equals("Lujerului") || mystart.equals("Politehnica") || mystart.equals("Nicolae Grigorescu (M3)") ||
                        mystart.equals("1 Decembrie 1918") || mystart.equals("Nicolae Teclu") || mystart.equals("Anghel Saligny")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") ||
                            formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 9.00;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 10.50;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Eroilor (M3)") || mystart.equals("Izvor (M3)") || mystart.equals("Piata Unirii (M3)") || mystart.equals("Timpuri Noi (M3)") || mystart.equals("Mihai Bravu (M3)") ||
                        mystart.equals("Dristor 1 (M3)")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") ||
                            formattedHour.equals("09") || formattedHour.equals("10") || formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") ||
                            formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") || formattedHour.equals("17") || formattedHour.equals("18") ||
                            formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21")) {
                        timeToWait = 4.50;
                    } else if (formattedHour.equals("22")) {
                        timeToWait = 5.50;
                    } else {
                        timeToWait = 0.00;
                    }
                } else if (mystart.equals("Straulesti") || mystart.equals("Laminorului") || mystart.equals("Jiului") || mystart.equals("Parc Bazilescu") || mystart.equals("1 Mai") || mystart.equals("Basarab (M4)") || mystart.equals("Grivita") ||
                        mystart.equals("Gara de Nord 2")) {
                    if (formattedHour.equals("05") || formattedHour.equals("06") || formattedHour.equals("07") || formattedHour.equals("08") || formattedHour.equals("09") || formattedHour.equals("10") ||
                            formattedHour.equals("11") || formattedHour.equals("12") || formattedHour.equals("13") || formattedHour.equals("14") || formattedHour.equals("15") || formattedHour.equals("16") ||
                            formattedHour.equals("17") || formattedHour.equals("18") || formattedHour.equals("19") || formattedHour.equals("20") || formattedHour.equals("21") || formattedHour.equals("22")) {
                        timeToWait = 11.50;
                    } else {
                        timeToWait = 0.00;
                    }
                }
        }

        if (value3.equals("Approx. time to wait: ")) {
            txtWaitingTime.setText(String.format("Approx. time to wait: %s min.", String.format("%.1f", timeToWait)));
        } else if (value3.equals("Timp aprox. de asteptare: ")) {
            txtWaitingTime.setText(String.format("Timp aprox. de asteptare: %s min.", String.format("%.1f", timeToWait)));
        }

        MyListAdapter adapter = new MyListAdapter(this, list1, list2);
        myList = (ListView) findViewById(R.id.myList);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object selectedItem = parent.getItemAtPosition(position);
                Intent intent2 = new Intent(FourthActivity.this, InfoActivity.class);
                intent2.putExtra("stationName", (String)selectedItem);
                intent2.putExtra("langValue", value2);
                startActivity(intent2);
            }
        });
    }
}



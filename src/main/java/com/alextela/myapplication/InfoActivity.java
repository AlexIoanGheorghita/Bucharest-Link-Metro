package com.alextela.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView name, txtBus, txtTram, txtLoc, txt1, txt2, txt3, txtButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_info);

        name = (TextView)findViewById(R.id.name);
        txtBus = (TextView)findViewById(R.id.txtBus);
        txtTram = (TextView)findViewById(R.id.txtTram);
        txtLoc = (TextView)findViewById(R.id.txtLoc);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txtButton = (Button)findViewById(R.id.txtButton);

        final Intent intent = getIntent();
        final String value = intent.getStringExtra("stationName");
        String valueLang = intent.getStringExtra("langValue");
        name.setText(value);

        if (valueLang.equals("Station")) {
            txt1.setText("Bus connections:");
            txt2.setText("Tram Connections:");
            txt3.setText("Key Locations nearby:");
            txtButton.setText("Location");
        } else if (valueLang.equals("Statie")) {
            txt1.setText("Conectii autobuz:");
            txt2.setText("Conectii tramvai:");
            txt3.setText("Locatii cheie din apropiere:");
            txtButton.setText("Locatie");
        }

        if (valueLang.equals("Station")) {
            if (value.equals("Aviatorilor")) {
                txtBus.setText("131, 282, 301, 330, 331, 335");
                txtTram.setText("No connections");
                txtLoc.setText("Park Herastrau, Uni Credit Bank, BRD, Alpha Bank");
            } else if (value.equals("Pipera")) {
                txtBus.setText("N125");
                txtTram.setText("16, 36");
                txtLoc.setText("National Museum of Romanian Aviation, BCR, Banca Romaneasca, GarantiBank, Banca Transilvania (ATM), Euronet (ATM), Mega Image");
            } else if (value.equals("Aurel Vlaicu")) {
                txtBus.setText("N119, N123, N125, 112, 135, 605");
                txtTram.setText("No connections");
                txtLoc.setText("Promenada Mall, ING, GarantiBank, BCR, VegUp (Vegetarian Restaurant), Mega Image");
            } else if (value.equals("Piata Victoriei 2")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Kiseleff Park, Romanian Government, Antipa Museum, National Geology Museum, Romanian Peasant's Museum, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Piata Romana")) {
                txtBus.setText("N117, N119, 133, 300, 381, 783");
                txtTram.setText("No connections");
                txtLoc.setText("Academy of Economic Studies from Bucharest, Sheraton, ING Bank, Alpha Bank, MoneyGram, UniCredit Bank, Banca Transilvania");
            } else if (value.equals("Universitate")) {
                txtBus.setText("N102, N108, N117, N119, 122, 137, 138, 268, 336, 381, 601, 783 \nTrolleybuses: 61, 66, 69, 70, 85, 90, 91");
                txtTram.setText("No connections");
                txtLoc.setText("University of Bucharest, National Theatre, InterContinental Bucharest, BCR, Banca Transilvania, UniCredit Bank, Mega Image");
            } else if (value.equals("Piata Unirii 2")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Tineretului")) {
                txtBus.setText("N105, N106, N112, 116, 312, 313, 323, 381 \nTrolleybuses: 73, 74, 76");
                txtTram.setText("19");
                txtLoc.setText("Tineretului Park, Carol Park, BCR, Banca Transilvania, UniCredit Bank, Mega Image");
            } else if (value.equals("Eroii Revolutiei")) {
                txtBus.setText("N103, N107, N112, 116, 141, 232, 323,");
                txtTram.setText("1, 7, 11, 19, 25, 34");
                txtLoc.setText("Tineretului Park, BRD, Mega Image");
            } else if (value.equals("Constantin Brancoveanu")) {
                txtBus.setText("N106, N112, N124, 116, 141, 232");
                txtTram.setText("1, 10, 34");
                txtLoc.setText("Tineretului Park, BRD, Alpha Bank, ING Bank, Credit Europe, Mega Image");
            } else if (value.equals("Piata Sudului")) {
                txtBus.setText("N103, N105, N106, N112, N124, 232, 312, 313, 381, 402, 414, 418 \nTrolleybuses: 73, 74, 76");
                txtTram.setText("No connections");
                txtLoc.setText("Sun Plaza Mall, Vacaresti Natural Park, Tudor Arghezi Memorial House");
            } else if (value.equals("Aparatorii Patriei")) {
                txtBus.setText("N103, N106, N124, 102, 125, 202, 232, 402, 414, 418");
                txtTram.setText("No connections");
                txtLoc.setText("Spiru Haret University, CEC Bank, Alpha Bank, BCR, GarantiBank, Mega Image Shop&Go");
            } else if (value.equals("Dimitrie Leonida")) {
                txtBus.setText("125, 418");
                txtTram.setText("No connections");
                txtLoc.setText("BRD (ATM), Mega Image Shop&Go");
            } else if (value.equals("Berceni")) {
                txtBus.setText("125, 418");
                txtTram.setText("No connections");
                txtLoc.setText("Mega Image Shop&Go");
            } else if (value.equals("Piata Victoriei 1")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Kiseleff Park, Romanian Government, Antipa Museum, National Geology Museum, Romanian Peasant's Museum, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Gara de Nord 1")) {
                txtBus.setText("N117, N118, 105, 282, 696, 780 \nTrollebuses: 62, 79, 85, 93, 96");
                txtTram.setText("42, 44, 45, 46");
                txtLoc.setText("Gara de Nord Train Station, Gara de Nord Park, CEC Bank, BCR, ING, Kaufland, Mega Image");
            } else if (value.equals("Basarab (M1)")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTrolleybuses: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord Train Station, CEC Bank, Kaufland");
            } else if (value.equals("Crangasi")) {
                txtBus.setText("162, 163, 178, 601");
                txtTram.setText("41");
                txtLoc.setText("Crangasi Park, CEC Bank, ING, UniCredit Bank, Carrefour Market, LIDL");
            } else if (value.equals("Petrache Poenaru")) {
                txtBus.setText("601");
                txtTram.setText("No connections");
                txtLoc.setText("Politehnica University of Bucharest, Banca Transilvania, First Bank (ATM), Mega Image");
            } else if (value.equals("Grozavesti")) {
                txtBus.setText("105 ,601");
                txtTram.setText("1, 11, 35");
                txtLoc.setText("Orhideea Comercial Center, Dimitrie Brandza Botanical Garden");
            } else if (value.equals("Eroilor (M1)")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("No connections");
                txtLoc.setText("Eroilor Park, Opera Park, National Opera of Bucharest, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Izvor (M1)")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("No connections");
                txtLoc.setText("Izvor Park, Cismigiu Gardens, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Piata Unirii 1")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Timpuri Noi (M1)")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("No connections");
                txtLoc.setText("Timpuri Noi Park, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Mihai Bravu (M1)")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Vacaresti Natural Park, Tineretului Park, LIDL");
            } else if (value.equals("Dristor 1 (M1)")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Dristor 2")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Piata Muncii")) {
                txtBus.setText("N109, 104");
                txtTram.setText("10, 34, 40, 56");
                txtLoc.setText("National Park, National Arena, Alpha Bank, Banca Transilvania, BCR, ING");
            } else if (value.equals("Piata Iancului")) {
                txtBus.setText("N102, 135, 311, 330, 335");
                txtTram.setText("10, 34, 46, 55");
                txtLoc.setText("Raiffeisen Bank, ING, OTP Bank, Mega Image, Carrefour Express");
            } else if (value.equals("Obor")) {
                txtBus.setText("N108, 101, 330, 335");
                txtTram.setText("1, 34, 46");
                txtLoc.setText("Obor Park, Bucur Obor, BRD, OTP Bank, CEC Bank, Raiffeisen Bank, Mega Image");
            } else if (value.equals("Stefan cel Mare")) {
                txtBus.setText("135, 330, 335, 605");
                txtTram.setText("10, 34, 46");
                txtLoc.setText("Ciclului Park, Dinamo Sports Park, Raiffeisen Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M1)")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Titan")) {
                txtBus.setText("101, 102, 311, 330");
                txtTram.setText("19, 23");
                txtLoc.setText("Alexandru Ioan Cuza Park, BCR, ING Bank, Banca Transilvania, LIDL, Mega Image");
            } else if (value.equals("Costin Georgian")) {
                txtBus.setText("102, 253 \nTrolleybuses: 70, 79");
                txtTram.setText("14, 36, 40, 46, 56");
                txtLoc.setText("Morarilor Park, BRD, CEC Bank, Banca Transilvania, Banca Romaneasca, ING");
            } else if (value.equals("Republica")) {
                txtBus.setText("N109, 400");
                txtTram.setText("36, 46, 56");
                txtLoc.setText("Titan Sud Train Station, Esplanada Comercial Center");
            } else if (value.equals("Pantelimon")) {
                txtBus.setText("N101, 104, 243, 246");
                txtTram.setText("No connections");
                txtLoc.setText("Pantelimon Park, Esplanada Comercial Center");
            } else if (value.equals("Anghel Saligny")) {
                txtBus.setText("246");
                txtTram.setText("No connections");
                txtLoc.setText("IKEA, Decathlon Pallady, Auchan, Raiffeisen Bank, BCR");
            } else if (value.equals("Nicolae Teclu")) {
                txtBus.setText("N111");
                txtTram.setText("19, 27, 40");
                txtLoc.setText("UniCredit, GarantiBank, BRD");
            } else if (value.equals("1 Decembrie 1918")) {
                txtBus.setText("N103, N111, N113");
                txtTram.setText("19, 27, 40");
                txtLoc.setText("Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M3)")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Dristor 1 (M3)")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Mihai Bravu (M3)")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Vacaresti Natural Park, Tineretului Park, LIDL");
            } else if (value.equals("Timpuri Noi (M3)")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("No connections");
                txtLoc.setText("Timpuri Noi Park, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii (M3)")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Izvor (M3)")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("No connections");
                txtLoc.setText("Izvor Park, Cismigiu Gardens, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Eroilor (M3)")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("No connections");
                txtLoc.setText("Eroilor Park, Opera Park, National Opera of Bucharest, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Politehnica")) {
                txtBus.setText("N115, 136, 236, 336, 105, 139 \nTrolleybuses: 61, 62, 69, 90, 91, 93, 96");
                txtTram.setText("1, 11, 35");
                txtLoc.setText("Grozavesti Park, Dimitrie Brandza Botanical Garden, Politehnica University of Bucharest, AFI Cotroceni Mall, BCR, UniCredit Bank");
            } else if (value.equals("Lujerului")) {
                txtBus.setText("N110, 106, 406");
                txtTram.setText("No connections");
                txtLoc.setText("Plaza Romania, Banca Transilvania, Raiffeisen Bank");
            } else if (value.equals("Pacii")) {
                txtBus.setText("137, 138, 178, 236 \nTrolleybuses: 61, 62");
                txtTram.setText("No connections");
                txtLoc.setText("Pacii Park, GarantiBank, CEC Bank");
            } else if (value.equals("Preciziei")) {
                txtBus.setText("No connections");
                txtTram.setText("8, 25, 35");
                txtLoc.setText("Militari Commercial Complex, BCR");
            } else if (value.equals("Gara de Nord 2")) {
                txtBus.setText("N117, N118, 105, 282, 696, 780 \nTrollebuses: 62, 79, 85, 93, 96");
                txtTram.setText("42, 44, 45, 46");
                txtLoc.setText("Gara de Nord Train Station, Gara de Nord Park, CEC Bank, BCR, ING, Kaufland, Mega Image");
            } else if (value.equals("Basarab (M4)")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTrolleybuses: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord Train Station, CEC Bank, Kaufland");
            } else if (value.equals("Grivita")) {
                txtBus.setText("N117, 105 \nTrolleybuses: 65, 86");
                txtTram.setText("No connections");
                txtLoc.setText("BRD, BCR, Mega Image");
            } else if (value.equals("1 Mai")) {
                txtBus.setText("N117 \nTrolleybuses: 65, 86");
                txtTram.setText("24, 45");
                txtLoc.setText("ING, Banca Transilvania, BCR, Alpha Bank, BRD, OTP Bank, Mega Image");
            } else if (value.equals("Jiului")) {
                txtBus.setText("N113, N117, 697");
                txtTram.setText("24");
                txtLoc.setText("Raiffeisen Bank, CEC Bank");
            } else if (value.equals("Parc Bazilescu")) {
                txtBus.setText("N117, 112, 460, 461, 697");
                txtTram.setText("No connections");
                txtLoc.setText("Bazilescu Park, Credit Europe Bank, LIDL");
            } else if (value.equals("Laminorului")) {
                txtBus.setText("N117, 112, 205, 304, 460, 461, 697");
                txtTram.setText("No connections");
                txtLoc.setText("No key locations");
            } else if (value.equals("Straulesti")) {
                txtBus.setText("N117, N118, 205, 461, 697");
                txtTram.setText("No connections");
                txtLoc.setText("No key locations");
            } else if (value.equals("Piata Victoriei 1 - CHANGE")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Kiseleff Park, Romanian Government, Antipa Museum, National Geology Museum, Romanian Peasant's Museum, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Piata Victoriei 2 - CHANGE")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Kiseleff Park, Romanian Government, Antipa Museum, National Geology Museum, Romanian Peasant's Museum, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Basarab (M1) - CHANGE")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTrolleybuses: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord Train Station, CEC Bank, Kaufland");
            } else if (value.equals("Basarab (M4) - CHANGE")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTrolleybuses: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord Train Station, CEC Bank, Kaufland");
            } else if (value.equals("Piata Unirii 1 - CHANGE")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii 2 - CHANGE")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii (M3) - CHANGE")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Unirii Park, Old Town, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Eroilor (M1) - CHANGE")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("No connections");
                txtLoc.setText("Eroilor Park, Opera Park, National Opera of Bucharest, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Eroilor (M3) - CHANGE")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("No connections");
                txtLoc.setText("Eroilor Park, Opera Park, National Opera of Bucharest, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Izvor (M1) - CHANGE")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("No connections");
                txtLoc.setText("Izvor Park, Cismigiu Gardens, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Izvor (M3) - CHANGE")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("No connections");
                txtLoc.setText("Izvor Park, Cismigiu Gardens, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Timpuri Noi (M1) - CHANGE")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("No connections");
                txtLoc.setText("Timpuri Noi Park, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Timpuri Noi (M3) - CHANGE")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("No connections");
                txtLoc.setText("Timpuri Noi Park, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Mihai Bravu (M1) - CHANGE")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Vacaresti Natural Park, Tineretului Park, LIDL");
            } else if (value.equals("Mihai Bravu (M3) - CHANGE")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Vacaresti Natural Park, Tineretului Park, LIDL");
            } else if (value.equals("Dristor 1 (M1) - CHANGE")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Dristor 1 (M3) - CHANGE")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M1) - CHANGE")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Nicolae Grigorescu (M3) - CHANGE")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Dristor 2 - CHANGE")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("ParkLake Mall, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            }
        } else if (valueLang.equals("Statie")) {
            if (value.equals("Aviatorilor")) {
                txtBus.setText("131, 282, 301, 330, 331, 335");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Herastrau, Uni Credit Bank, BRD, Alpha Bank");
            } else if (value.equals("Pipera")) {
                txtBus.setText("N125");
                txtTram.setText("16, 36");
                txtLoc.setText("Muzeul National de Aviatie al Romaniei, BCR, Banca Romaneasca, GarantiBank, Banca Transilvania (ATM), Euronet (ATM), Mega Image");
            } else if (value.equals("Aurel Vlaicu")) {
                txtBus.setText("N119, N123, N125, 112, 135, 605");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Mall Promenada, ING, GarantiBank, BCR, VegUp (Restaurant Vegetarian), Mega Image");
            } else if (value.equals("Piata Victoriei 2")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Parcul Kiseleff, Guvernul Romaniei, Muzeul Antipa, Muzeul National de Geologie, Muzeul Taranului Roman, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Piata Romana")) {
                txtBus.setText("N117, N119, 133, 300, 381, 783");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Academia de Studii Economice din Bucuresti, Sheraton, ING Bank, Alpha Bank, MoneyGram, UniCredit Bank, Banca Transilvania");
            } else if (value.equals("Universitate")) {
                txtBus.setText("N102, N108, N117, N119, 122, 137, 138, 268, 336, 381, 601, 783 \nTroleibuze: 61, 66, 69, 70, 85, 90, 91");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Universitatea Bucuresti, Teatrul National, InterContinental Bucuresti, BCR, Banca Transilvania, UniCredit Bank, Mega Image");
            } else if (value.equals("Piata Unirii 2")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Tineretului")) {
                txtBus.setText("N105, N106, N112, 116, 312, 313, 323, 381 \nTroleibuze: 73, 74, 76");
                txtTram.setText("19");
                txtLoc.setText("Parcul Tineretului, Parcul Carol, BCR, Banca Transilvania, UniCredit Bank, Mega Image");
            } else if (value.equals("Eroii Revolutiei")) {
                txtBus.setText("N103, N107, N112, 116, 141, 232, 323,");
                txtTram.setText("1, 7, 11, 19, 25, 34");
                txtLoc.setText("Parcul Tineretului, BRD, Mega Image");
            } else if (value.equals("Constantin Brancoveanu")) {
                txtBus.setText("N106, N112, N124, 116, 141, 232");
                txtTram.setText("1, 10, 34");
                txtLoc.setText("Parcul Tineretului, BRD, Alpha Bank, ING Bank, Credit Europe, Mega Image");
            } else if (value.equals("Piata Sudului")) {
                txtBus.setText("N103, N105, N106, N112, N124, 232, 312, 313, 381, 402, 414, 418 \nTroleibuze: 73, 74, 76");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Mall Sun Plaza , Parcul Natural Vacaresti, Casa Memoriala Tudor Arghezi");
            } else if (value.equals("Aparatorii Patriei")) {
                txtBus.setText("N103, N106, N124, 102, 125, 202, 232, 402, 414, 418");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Universitatea Spiru Haret, CEC Bank, Alpha Bank, BCR, GarantiBank, Mega Image Shop&Go");
            } else if (value.equals("Dimitrie Leonida")) {
                txtBus.setText("125, 418");
                txtTram.setText("Fara conectii");
                txtLoc.setText("BRD (ATM), Mega Image Shop&Go");
            } else if (value.equals("Berceni")) {
                txtBus.setText("125, 418");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Mega Image Shop&Go");
            } else if (value.equals("Piata Victoriei 1")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Parcul Kiseleff, Guvernul Romaniei, Muzeul Antipa, Muzeul National de Geologie, Muzeul Taranului Roman, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Gara de Nord 1")) {
                txtBus.setText("N117, N118, 105, 282, 696, 780 \nTroleibuze: 62, 79, 85, 93, 96");
                txtTram.setText("42, 44, 45, 46");
                txtLoc.setText("Gara de Nord, Parcul Gara de Nord, CEC Bank, BCR, ING, Kaufland, Mega Image");
            } else if (value.equals("Basarab (M1)")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTroleibuze: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord, CEC Bank, Kaufland");
            } else if (value.equals("Crangasi")) {
                txtBus.setText("162, 163, 178, 601");
                txtTram.setText("41");
                txtLoc.setText("Parcul Crangasi, CEC Bank, ING, UniCredit Bank, Carrefour Market, LIDL");
            } else if (value.equals("Petrache Poenaru")) {
                txtBus.setText("601");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Universitatea Politehnica din Bucuresti, Banca Transilvania, First Bank (ATM), Mega Image");
            } else if (value.equals("Grozavesti")) {
                txtBus.setText("105 ,601");
                txtTram.setText("1, 11, 35");
                txtLoc.setText("Centrul Comercial Orhideea, Gradina Botanica Dimitrie Brandza");
            } else if (value.equals("Eroilor (M1)")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Eroilor, Parcul Operei, Opera Nationala din Bucuresti, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Izvor (M1)")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Izvor, Gradinile Cismigiu, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Piata Unirii 1")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Timpuri Noi (M1)")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Timpuri Noi, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Mihai Bravu (M1)")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Parcul Natural Vacaresti, Parcul Tineretului, LIDL");
            } else if (value.equals("Dristor 1 (M1)")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Dristor 2")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Piata Muncii")) {
                txtBus.setText("N109, 104");
                txtTram.setText("10, 34, 40, 56");
                txtLoc.setText("Parcul National, Arena Nationala, Alpha Bank, Banca Transilvania, BCR, ING");
            } else if (value.equals("Piata Iancului")) {
                txtBus.setText("N102, 135, 311, 330, 335");
                txtTram.setText("10, 34, 46, 55");
                txtLoc.setText("Raiffeisen Bank, ING, OTP Bank, Mega Image, Carrefour Express");
            } else if (value.equals("Obor")) {
                txtBus.setText("N108, 101, 330, 335");
                txtTram.setText("1, 34, 46");
                txtLoc.setText("Parcul Obor, Bucur Obor, BRD, OTP Bank, CEC Bank, Raiffeisen Bank, Mega Image");
            } else if (value.equals("Stefan cel Mare")) {
                txtBus.setText("135, 330, 335, 605");
                txtTram.setText("10, 34, 46");
                txtLoc.setText("Parcul Ciclului, Parcul Sportiv Dinamo, Raiffeisen Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M1)")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Titan")) {
                txtBus.setText("101, 102, 311, 330");
                txtTram.setText("19, 23");
                txtLoc.setText("Parcul Alexandru Ioan Cuza, BCR, ING Bank, Banca Transilvania, LIDL, Mega Image");
            } else if (value.equals("Costin Georgian")) {
                txtBus.setText("102, 253 \nTroleibuze: 70, 79");
                txtTram.setText("14, 36, 40, 46, 56");
                txtLoc.setText("Parcul Morarilor, BRD, CEC Bank, Banca Transilvania, Banca Romaneasca, ING");
            } else if (value.equals("Republica")) {
                txtBus.setText("N109, 400");
                txtTram.setText("36, 46, 56");
                txtLoc.setText("Statia de Tren Titan Sud, Centrul Comercial Esplanada");
            } else if (value.equals("Pantelimon")) {
                txtBus.setText("N101, 104, 243, 246");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Pantelimon, Centrul Comercial Esplanada");
            } else if (value.equals("Anghel Saligny")) {
                txtBus.setText("246");
                txtTram.setText("Fara conectii");
                txtLoc.setText("IKEA, Decathlon Pallady, Auchan, Raiffeisen Bank, BCR");
            } else if (value.equals("Nicolae Teclu")) {
                txtBus.setText("N111");
                txtTram.setText("19, 27, 40");
                txtLoc.setText("UniCredit, GarantiBank, BRD");
            } else if (value.equals("1 Decembrie 1918")) {
                txtBus.setText("N103, N111, N113");
                txtTram.setText("19, 27, 40");
                txtLoc.setText("Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M3)")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Dristor 1 (M3)")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Mihai Bravu (M3)")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Parcul Natural Vacaresti, Parcul Tineretului, LIDL");
            } else if (value.equals("Timpuri Noi (M3)")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Timpuri Noi, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii (M3)")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Izvor (M3)")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Izvor, Gradinile Cismigiu, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Eroilor (M3)")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Eroilor, Parcul Operei, Opera Nationala din Bucuresti, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Politehnica")) {
                txtBus.setText("N115, 136, 236, 336, 105, 139 \nTroleibuze: 61, 62, 69, 90, 91, 93, 96");
                txtTram.setText("1, 11, 35");
                txtLoc.setText("Parcul Grozavesti, Gradina Botanica Dimitrie Brandza, Universitatea Politehnica din Bucuresti, Mall AFI Cotroceni, BCR, UniCredit Bank");
            } else if (value.equals("Lujerului")) {
                txtBus.setText("N110, 106, 406");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Plaza Romania, Banca Transilvania, Raiffeisen Bank");
            } else if (value.equals("Pacii")) {
                txtBus.setText("137, 138, 178, 236 \nTroleibuze: 61, 62");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Pacii, GarantiBank, CEC Bank");
            } else if (value.equals("Preciziei")) {
                txtBus.setText("Fara conectii");
                txtTram.setText("8, 25, 35");
                txtLoc.setText("Complexul Comercial Militari, BCR");
            } else if (value.equals("Gara de Nord 2")) {
                txtBus.setText("N117, N118, 105, 282, 696, 780 \nTroleibuze: 62, 79, 85, 93, 96");
                txtTram.setText("42, 44, 45, 46");
                txtLoc.setText("Gara de Nord, Parcul Gara de Nord, CEC Bank, BCR, ING, Kaufland, Mega Image");
            } else if (value.equals("Basarab (M4)")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTroleibuze: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord, CEC Bank, Kaufland");
            } else if (value.equals("Grivita")) {
                txtBus.setText("N117, 105 \nTroleibuze: 65, 86");
                txtTram.setText("Fara conectii");
                txtLoc.setText("BRD, BCR, Mega Image");
            } else if (value.equals("1 Mai")) {
                txtBus.setText("N117 \nTroleibuze: 65, 86");
                txtTram.setText("24, 45");
                txtLoc.setText("ING, Banca Transilvania, BCR, Alpha Bank, BRD, OTP Bank, Mega Image");
            } else if (value.equals("Jiului")) {
                txtBus.setText("N113, N117, 697");
                txtTram.setText("24");
                txtLoc.setText("Raiffeisen Bank, CEC Bank");
            } else if (value.equals("Parc Bazilescu")) {
                txtBus.setText("N117, 112, 460, 461, 697");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Bazilescu, Credit Europe Bank, LIDL");
            } else if (value.equals("Laminorului")) {
                txtBus.setText("N117, 112, 205, 304, 460, 461, 697");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Fara locatii cheie");
            } else if (value.equals("Straulesti")) {
                txtBus.setText("N117, N118, 205, 461, 697");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Fara locatii cheie");
            } else if (value.equals("Piata Victoriei 1 - SCHIMBA")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Parcul Kiseleff, Guvernul Romaniei, Muzeul Antipa, Muzeul National de Geologie, Muzeul Taranului Roman, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Piata Victoriei 2 - SCHIMBA")) {
                txtBus.setText("N119, 300, 381, 783, 784");
                txtTram.setText("1, 24, 34, 42, 45, 46");
                txtLoc.setText("Parcul Kiseleff, Guvernul Romaniei, Muzeul Antipa, Muzeul National de Geologie, Muzeul Taranului Roman, Banca Transilvania, CEC Bank, BCR, Mega Image");
            } else if (value.equals("Basarab (M1) - SCHIMBA")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTroleibuze: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord, CEC Bank, Kaufland");
            } else if (value.equals("Basarab (M4) - SCHIMBA")) {
                txtBus.setText("N117, 105, 133, 162, 182, 282 \nTroleibuze: 65, 86");
                txtTram.setText("10, 35, 44");
                txtLoc.setText("Gara de Nord, CEC Bank, Kaufland");
            } else if (value.equals("Piata Unirii 1 - SCHIMBA")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii 2 - SCHIMBA")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Piata Unirii (M3) - SCHIMBA")) {
                txtBus.setText("N102, N104, N105, N106, N107, N108, N109, N110, N111, N112, N114, N115, N116, N117, N119, N121, 104, 116, 117, 123, 124, 313, 783");
                txtTram.setText("7, 27, 32, 47");
                txtLoc.setText("Parcul Unirii, Centrul Vechi, Unirea Shopping Center, ING, UniCredit Bank, Mega Image Shop&Go");
            } else if (value.equals("Eroilor (M1) - SCHIMBA")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Eroilor, Parcul Operei, Opera Nationala din Bucuresti, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Eroilor (M3) - SCHIMBA")) {
                txtBus.setText("N110, N115, N116, 104, 122, 123, 124, 126, 137, 138, 168, 226, 268, 336, 368, 601, 668, 696");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Eroilor, Parcul Operei, Opera Nationala din Bucuresti, ING Bank, CEC Bank, Mega Image");
            } else if (value.equals("Izvor (M1) - SCHIMBA")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Izvor, Gradinile Cismigiu, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Izvor (M3) - SCHIMBA")) {
                txtBus.setText("N110, N115, 104, 123, 124, 136, 385");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Izvor, Gradinile Cismigiu, BCR, UniCredit Bank, Alpha Bank, Bancpost");
            } else if (value.equals("Timpuri Noi (M1) - SCHIMBA")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Timpuri Noi, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Timpuri Noi (M3) - SCHIMBA")) {
                txtBus.setText("133, 312, 323");
                txtTram.setText("Fara conectii");
                txtLoc.setText("Parcul Timpuri Noi, Penny Market, Mega Image Shop&Go");
            } else if (value.equals("Mihai Bravu (M1) - SCHIMBA")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Parcul Natural Vacaresti, Parcul Tineretului, LIDL");
            } else if (value.equals("Mihai Bravu (M3) - SCHIMBA")) {
                txtBus.setText("124, 223");
                txtTram.setText("1, 34");
                txtLoc.setText("Parcul Natural Vacaresti, Parcul Tineretului, LIDL");
            } else if (value.equals("Dristor 1 (M1) - SCHIMBA")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Dristor 1 (M3) - SCHIMBA")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            } else if (value.equals("Nicolae Grigorescu (M1) - SCHIMBA")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Nicolae Grigorescu (M3) - SCHIMBA")) {
                txtBus.setText("N111, 102");
                txtTram.setText("27");
                txtLoc.setText("BCR, Mega Image Shop&Go");
            } else if (value.equals("Dristor 2 - SCHIMBA")) {
                txtBus.setText("N103, N113, 330");
                txtTram.setText("19, 23, 27");
                txtLoc.setText("Mall ParkLake, BRD, UniCredit Bank, Alpha Bank, Banca Transilvania, Mega Image");
            }
        }

        txtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGoogle = new Intent(InfoActivity.this, MapsActivity.class);
                intGoogle.putExtra("position", value);
                startActivity(intGoogle);
            }
        });
    }
}

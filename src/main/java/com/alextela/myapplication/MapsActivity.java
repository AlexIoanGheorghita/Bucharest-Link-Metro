package com.alextela.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        String pos = intent.getStringExtra("position");

        if (pos.equals("Aviatorilor")) {
            LatLng Aviatorilor = new LatLng(44.466200, 26.086449);
            mMap.addMarker(new MarkerOptions().position(Aviatorilor).title("Aviatorilor"));
            mMap.addCircle(new CircleOptions().center(Aviatorilor).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Aviatorilor, 16));
        } else if (pos.equals("Pipera")) {
            LatLng Pipera = new LatLng(44.480604, 26.116544);
            mMap.addMarker(new MarkerOptions().position(Pipera).title("Pipera"));
            mMap.addCircle(new CircleOptions().center(Pipera).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pipera, 16));
        } else if (pos.equals("Aurel Vlaicu")) {
            LatLng AurelVlaicu = new LatLng(44.479190, 26.100274);
            mMap.addMarker(new MarkerOptions().position(AurelVlaicu).title("Aurel Vlaicu"));
            mMap.addCircle(new CircleOptions().center(AurelVlaicu).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AurelVlaicu, 16));
        } else if (pos.equals("Piata Victoriei 2")) {
            LatLng PiataVictoriei2 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei2).title("Piata Victoriei 2"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei2, 16));
        } else if (pos.equals("Piata Romana")) {
            LatLng PiataRomana = new LatLng(44.445538, 26.097630);
            mMap.addMarker(new MarkerOptions().position(PiataRomana).title("Piata Romana"));
            mMap.addCircle(new CircleOptions().center(PiataRomana).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataRomana, 16));
        } else if (pos.equals("Universitate")) {
            LatLng Universitate = new LatLng(44.435864, 26.102773);
            mMap.addMarker(new MarkerOptions().position(Universitate).title("Universitate"));
            mMap.addCircle(new CircleOptions().center(Universitate).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Universitate, 16));
        } else if (pos.equals("Piata Unirii 2")) {
            LatLng PiataUnirii2 = new LatLng(44.428147, 26.100979);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii2).title("Piata Unirii 2"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii2, 16));
        } else if (pos.equals("Tineretului")) {
            LatLng Tineretului = new LatLng(44.414770, 26.104671);
            mMap.addMarker(new MarkerOptions().position(Tineretului).title("Tineretului"));
            mMap.addCircle(new CircleOptions().center(Tineretului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tineretului, 16));
        } else if (pos.equals("Eroii Revolutiei")) {
            LatLng EroiiRevolutiei = new LatLng(44.404272, 26.096352);
            mMap.addMarker(new MarkerOptions().position(EroiiRevolutiei).title("Eroii Revolutiei"));
            mMap.addCircle(new CircleOptions().center(EroiiRevolutiei).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(EroiiRevolutiei, 16));
        } else if (pos.equals("Constantin Brancoveanu")) {
            LatLng ConstantinBrancoveanu = new LatLng(44.398754, 26.109094);
            mMap.addMarker(new MarkerOptions().position(ConstantinBrancoveanu).title("Constantin Brancoveanu"));
            mMap.addCircle(new CircleOptions().center(ConstantinBrancoveanu).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ConstantinBrancoveanu, 16));
        } else if (pos.equals("Piata Sudului")) {
            LatLng PiataSudului = new LatLng(44.392872, 26.122179);
            mMap.addMarker(new MarkerOptions().position(PiataSudului).title("Piata Sudului"));
            mMap.addCircle(new CircleOptions().center(PiataSudului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataSudului, 16));
        } else if (pos.equals("Aparatorii Patriei")) {
            LatLng AparatoriiPatriei = new LatLng(44.379605, 26.135379);
            mMap.addMarker(new MarkerOptions().position(AparatoriiPatriei).title("Aparatorii Patriei"));
            mMap.addCircle(new CircleOptions().center(AparatoriiPatriei).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AparatoriiPatriei, 16));
        } else if (pos.equals("Dimitrie Leonida")) {
            LatLng DimitrieLeonida = new LatLng(44.368918, 26.143663);
            mMap.addMarker(new MarkerOptions().position(DimitrieLeonida).title("Dimitrie Leonida"));
            mMap.addCircle(new CircleOptions().center(DimitrieLeonida).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DimitrieLeonida, 16));
        } else if (pos.equals("Berceni")) {
            LatLng Berceni = new LatLng(44.361204, 26.149214);
            mMap.addMarker(new MarkerOptions().position(Berceni).title("Berceni"));
            mMap.addCircle(new CircleOptions().center(Berceni).radius(350.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Berceni, 15));
        } else if (pos.equals("Piata Victoriei 1")) {
            LatLng PiataVictoriei1 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei1).title("Piata Victoriei 1"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei1, 16));
        } else if (pos.equals("Gara de Nord 1")) {
            LatLng GaradeNord1 = new LatLng(44.447968, 26.074661);
            mMap.addMarker(new MarkerOptions().position(GaradeNord1).title("Gara de Nord 1"));
            mMap.addCircle(new CircleOptions().center(GaradeNord1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GaradeNord1, 16));
        } else if (pos.equals("Basarab (M1)")) {
            LatLng Basarab1 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab1).title("Basarab (M1)"));
            mMap.addCircle(new CircleOptions().center(Basarab1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab1, 16));
        } else if (pos.equals("Crangasi")) {
            LatLng Crangasi = new LatLng(44.451856, 26.047720);
            mMap.addMarker(new MarkerOptions().position(Crangasi).title("Crangasi"));
            mMap.addCircle(new CircleOptions().center(Crangasi).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Crangasi, 16));
        } else if (pos.equals("Petrache Poenaru")) {
            LatLng PetrachePoenaru = new LatLng(44.445310, 26.046713);
            mMap.addMarker(new MarkerOptions().position(PetrachePoenaru).title("Petrache Poenaru"));
            mMap.addCircle(new CircleOptions().center(PetrachePoenaru).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PetrachePoenaru, 16));
        } else if (pos.equals("Grozavesti")) {
            LatLng Grozavesti = new LatLng(44.442744, 26.060482);
            mMap.addMarker(new MarkerOptions().position(Grozavesti).title("Grozavesti"));
            mMap.addCircle(new CircleOptions().center(Grozavesti).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Grozavesti, 16));
        } else if (pos.equals("Eroilor (M1)")) {
            LatLng Eroilor1 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor1).title("Eroilor (M1)"));
            mMap.addCircle(new CircleOptions().center(Eroilor1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor1, 16));
        } else if (pos.equals("Izvor (M1)")) {
            LatLng Izvor1 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor1).title("Izvor (M1)"));
            mMap.addCircle(new CircleOptions().center(Izvor1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor1, 16));
        } else if (pos.equals("Piata Unirii 1")) {
            LatLng PiataUnirii1 = new LatLng(44.428147, 26.100979);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii1).title("Piata Unirii 1"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii1, 16));
        } else if (pos.equals("Timpuri Noi (M1)")) {
            LatLng TimpuriNoi1 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi1).title("Timpuri Noi (M1)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi1, 16));
        } else if (pos.equals("Mihai Bravu (M1)")) {
            LatLng MihaiBravu1 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu1).title("Mihai Bravu (M1)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu1, 16));
        } else if (pos.equals("Dristor 1 (M1)")) {
            LatLng Dristor1 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor1).title("Dristor 1 (M1)"));
            mMap.addCircle(new CircleOptions().center(Dristor1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor1, 16));
        } else if (pos.equals("Dristor 2")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 2"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Piata Muncii")) {
            LatLng PiataMuncii = new LatLng(44.432492, 26.138431);
            mMap.addMarker(new MarkerOptions().position(PiataMuncii).title("Piata Muncii"));
            mMap.addCircle(new CircleOptions().center(PiataMuncii).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataMuncii, 16));
        } else if (pos.equals("Piata Iancului")) {
            LatLng PiataIancului = new LatLng(44.440935, 26.133147);
            mMap.addMarker(new MarkerOptions().position(PiataIancului).title("Piata Iancului"));
            mMap.addCircle(new CircleOptions().center(PiataIancului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataIancului, 16));
        } else if (pos.equals("Obor")) {
            LatLng Obor = new LatLng(44.449935, 26.124118);
            mMap.addMarker(new MarkerOptions().position(Obor).title("Obor"));
            mMap.addCircle(new CircleOptions().center(Obor).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Obor, 16));
        } else if (pos.equals("Stefan cel Mare")) {
            LatLng StefancelMare = new LatLng(44.453256, 26.104848);
            mMap.addMarker(new MarkerOptions().position(StefancelMare).title("Stefan cel Mare"));
            mMap.addCircle(new CircleOptions().center(StefancelMare).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(StefancelMare, 16));
        } else if (pos.equals("Nicolae Grigorescu (M1)")) {
            LatLng NicolaeGrigorescu1 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu1).title("Nicolae Grigorescu (M1)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu1, 16));
        } else if (pos.equals("Titan")) {
            LatLng Titan = new LatLng(44.425024, 26.162692);
            mMap.addMarker(new MarkerOptions().position(Titan).title("Titan"));
            mMap.addCircle(new CircleOptions().center(Titan).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Titan, 16));
        } else if (pos.equals("Costin Georgian")) {
            LatLng CostinGeorgian = new LatLng(44.435532, 26.169490);
            mMap.addMarker(new MarkerOptions().position(CostinGeorgian).title("Costin Georgian"));
            mMap.addCircle(new CircleOptions().center(CostinGeorgian).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CostinGeorgian, 16));
        } else if (pos.equals("Republica")) {
            LatLng Republica = new LatLng(44.434398, 26.185834);
            mMap.addMarker(new MarkerOptions().position(Republica).title("Republica"));
            mMap.addCircle(new CircleOptions().center(Republica).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Republica, 16));
        } else if (pos.equals("Pantelimon")) {
            LatLng Pantelimon = new LatLng(44.440645, 26.192466);
            mMap.addMarker(new MarkerOptions().position(Pantelimon).title("Pantelimon"));
            mMap.addCircle(new CircleOptions().center(Pantelimon).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pantelimon, 16));
        } else if (pos.equals("Preciziei")) {
            LatLng Preciziei = new LatLng(44.430403, 25.990050);
            mMap.addMarker(new MarkerOptions().position(Preciziei).title("Preciziei"));
            mMap.addCircle(new CircleOptions().center(Preciziei).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Preciziei, 16));
        } else if (pos.equals("Pacii")) {
            LatLng Pacii = new LatLng(44.434026, 26.004120);
            mMap.addMarker(new MarkerOptions().position(Pacii).title("Pacii"));
            mMap.addCircle(new CircleOptions().center(Pacii).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pacii, 16));
        } else if (pos.equals("Gorjului")) {
            LatLng Gorjului = new LatLng(44.434082, 26.021349);
            mMap.addMarker(new MarkerOptions().position(Gorjului).title("Gorjului"));
            mMap.addCircle(new CircleOptions().center(Gorjului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gorjului, 16));
        } else if (pos.equals("Lujerului")) {
            LatLng Lujerului = new LatLng(44.434519, 26.033628);
            mMap.addMarker(new MarkerOptions().position(Lujerului).title("Lujerului"));
            mMap.addCircle(new CircleOptions().center(Lujerului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Lujerului, 16));
        } else if (pos.equals("Politehnica")) {
            LatLng Politehnica = new LatLng(44.434770, 26.054959);
            mMap.addMarker(new MarkerOptions().position(Politehnica).title("Politehnica"));
            mMap.addCircle(new CircleOptions().center(Politehnica).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Politehnica, 16));
        } else if (pos.equals("Eroilor (M3)")) {
            LatLng Eroilor2 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor2).title("Eroilor (M3)"));
            mMap.addCircle(new CircleOptions().center(Eroilor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor2, 16));
        } else if (pos.equals("Izvor (M3)")) {
            LatLng Izvor2 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor2).title("Izvor (M3)"));
            mMap.addCircle(new CircleOptions().center(Izvor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor2, 16));
        } else if (pos.equals("Piata Unirii (M3)")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii (M3)"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Timpuri Noi (M3)")) {
            LatLng TimpuriNoi2 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi2).title("Timpuri Noi (M3)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi2, 16));
        } else if (pos.equals("Mihai Bravu (M3)")) {
            LatLng MihaiBravu2 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu2).title("Mihai Bravu (M3)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu2, 16));
        } else if (pos.equals("Dristor 1 (M3)")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 1 (M3)"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Nicolae Grigorescu (M3)")) {
            LatLng NicolaeGrigorescu2 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu2).title("Nicolae Grigorescu (M3)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu2, 16));
        } else if (pos.equals("1 Decembrie 1918")) {
            LatLng Decembrie = new LatLng(44.410264, 26.175493);
            mMap.addMarker(new MarkerOptions().position(Decembrie).title("1 Decembrie 1918"));
            mMap.addCircle(new CircleOptions().center(Decembrie).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Decembrie, 16));
        } else if (pos.equals("Nicolae Teclu")) {
            LatLng NicolaeTeclu = new LatLng(44.407743, 26.194107);
            mMap.addMarker(new MarkerOptions().position(NicolaeTeclu).title("Nicolae Teclu"));
            mMap.addCircle(new CircleOptions().center(NicolaeTeclu).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeTeclu, 16));
        } else if (pos.equals("Anghel Saligny")) {
            LatLng AnghelSaligny = new LatLng(44.405633, 26.208440);
            mMap.addMarker(new MarkerOptions().position(AnghelSaligny).title("Anghel Saligny"));
            mMap.addCircle(new CircleOptions().center(AnghelSaligny).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AnghelSaligny, 16));
        } else if (pos.equals("Gara de Nord 2")) {
            LatLng GaradeNord2 = new LatLng(44.447968, 26.074661);
            mMap.addMarker(new MarkerOptions().position(GaradeNord2).title("Gara de Nord 2"));
            mMap.addCircle(new CircleOptions().center(GaradeNord2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GaradeNord2, 16));
        } else if (pos.equals("Basarab (M4)")) {
            LatLng Basarab2 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab2).title("Basarab (M4)"));
            mMap.addCircle(new CircleOptions().center(Basarab2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab2, 16));
        } else if (pos.equals("Grivita")) {
            LatLng Grivita = new LatLng(44.461161, 26.058057);
            mMap.addMarker(new MarkerOptions().position(Grivita).title("Grivita"));
            mMap.addCircle(new CircleOptions().center(Grivita).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Grivita, 16));
        } else if (pos.equals("1 Mai")) {
            LatLng Mai = new LatLng(44.471067, 26.050292);
            mMap.addMarker(new MarkerOptions().position(Mai).title("1 Mai"));
            mMap.addCircle(new CircleOptions().center(Mai).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mai, 16));
        } else if (pos.equals("Jiului")) {
            LatLng Jiului = new LatLng(44.482596, 26.040835);
            mMap.addMarker(new MarkerOptions().position(Jiului).title("Jiului"));
            mMap.addCircle(new CircleOptions().center(Jiului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Jiului, 16));
        } else if (pos.equals("Parc Bazilescu")) {
            LatLng ParcBazilescu = new LatLng(44.487282, 26.037190);
            mMap.addMarker(new MarkerOptions().position(ParcBazilescu).title("Parc Bazilescu"));
            mMap.addCircle(new CircleOptions().center(ParcBazilescu).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ParcBazilescu, 16));
        } else if (pos.equals("Laminorului")) {
            LatLng Laminorului = new LatLng(44.494550, 26.031792);
            mMap.addMarker(new MarkerOptions().position(Laminorului).title("Laminorului"));
            mMap.addCircle(new CircleOptions().center(Laminorului).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Laminorului, 16));
        } else if (pos.equals("Straulesti")) {
            LatLng Straulesti = new LatLng(44.502994, 26.024748);
            mMap.addMarker(new MarkerOptions().position(Straulesti).title("Straulesti"));
            mMap.addCircle(new CircleOptions().center(Straulesti).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Straulesti, 16));
        } else if (pos.equals("Piata Victoriei 1 - CHANGE")) {
            LatLng PiataVictoriei1 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei1).title("Piata Victoriei 1"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei1, 16));
        } else if (pos.equals("Piata Victoriei 2 - CHANGE")) {
            LatLng PiataVictoriei1 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei1).title("Piata Victoriei 2"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei1, 16));
        } else if (pos.equals("Piata Victoriei 1 - SCHIMBA")) {
            LatLng PiataVictoriei1 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei1).title("Piata Victoriei 1"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei1, 16));
        } else if (pos.equals("Piata Victoriei 2 - SCHIMBA")) {
            LatLng PiataVictoriei1 = new LatLng(44.453708, 26.086256);
            mMap.addMarker(new MarkerOptions().position(PiataVictoriei1).title("Piata Victoriei 2"));
            mMap.addCircle(new CircleOptions().center(PiataVictoriei1).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataVictoriei1, 16));
        } else if (pos.equals("Basarab (M1) - CHANGE")) {
            LatLng Basarab2 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab2).title("Basarab (M1)"));
            mMap.addCircle(new CircleOptions().center(Basarab2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab2, 16));
        } else if (pos.equals("Basarab (M4) - CHANGE")) {
            LatLng Basarab2 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab2).title("Basarab (M4)"));
            mMap.addCircle(new CircleOptions().center(Basarab2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab2, 16));
        } else if (pos.equals("Basarab (M1) - SCHIMBA")) {
            LatLng Basarab2 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab2).title("Basarab (M1)"));
            mMap.addCircle(new CircleOptions().center(Basarab2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab2, 16));
        } else if (pos.equals("Basarab (M4) - SCHIMBA")) {
            LatLng Basarab2 = new LatLng(44.450384, 26.068939);
            mMap.addMarker(new MarkerOptions().position(Basarab2).title("Basarab (M4)"));
            mMap.addCircle(new CircleOptions().center(Basarab2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70, 100, 100, 100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Basarab2, 16));
        } else if (pos.equals("Piata Unirii 1 - CHANGE")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii 1"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Piata Unirii 1 - SCHIMBA")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii 1"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Piata Unirii 2 - CHANGE")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii 2"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Piata Unirii 2 - SCHIMBA")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii 2"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Piata Unirii (M3) - CHANGE")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii (M3)"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Piata Unirii (M3) - SCHIMBA")) {
            LatLng PiataUnirii3 = new LatLng(44.428148, 26.100984);
            mMap.addMarker(new MarkerOptions().position(PiataUnirii3).title("Piata Unirii (M3)"));
            mMap.addCircle(new CircleOptions().center(PiataUnirii3).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PiataUnirii3, 16));
        } else if (pos.equals("Eroilor (M1) - CHANGE")) {
            LatLng Eroilor2 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor2).title("Eroilor (M1)"));
            mMap.addCircle(new CircleOptions().center(Eroilor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor2, 16));
        } else if (pos.equals("Eroilor (M1) - SCHIMBA")) {
            LatLng Eroilor2 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor2).title("Eroilor (M1)"));
            mMap.addCircle(new CircleOptions().center(Eroilor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor2, 16));
        } else if (pos.equals("Eroilor (M3) - CHANGE")) {
            LatLng Eroilor2 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor2).title("Eroilor (M3)"));
            mMap.addCircle(new CircleOptions().center(Eroilor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor2, 16));
        } else if (pos.equals("Eroilor (M3) - SCHIMBA")) {
            LatLng Eroilor2 = new LatLng(44.435008, 26.075640);
            mMap.addMarker(new MarkerOptions().position(Eroilor2).title("Eroilor (M3)"));
            mMap.addCircle(new CircleOptions().center(Eroilor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Eroilor2, 16));
        } else if (pos.equals("Izvor (M1) - CHANGE")) {
            LatLng Izvor2 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor2).title("Izvor (M1)"));
            mMap.addCircle(new CircleOptions().center(Izvor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor2, 16));
        } else if (pos.equals("Izvor (M1) - SCHIMBA")) {
            LatLng Izvor2 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor2).title("Izvor (M1)"));
            mMap.addCircle(new CircleOptions().center(Izvor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor2, 16));
        } else if (pos.equals("Izvor (M3) - CHANGE")) {
            LatLng Izvor2 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor2).title("Izvor (M3)"));
            mMap.addCircle(new CircleOptions().center(Izvor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor2, 16));
        } else if (pos.equals("Izvor (M3) - SCHIMBA")) {
            LatLng Izvor2 = new LatLng(44.432922, 26.089971);
            mMap.addMarker(new MarkerOptions().position(Izvor2).title("Izvor (M3)"));
            mMap.addCircle(new CircleOptions().center(Izvor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Izvor2, 16));
        } else if (pos.equals("Timpuri Noi (M1) - CHANGE")) {
            LatLng TimpuriNoi2 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi2).title("Timpuri Noi (M1)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi2, 16));
        } else if (pos.equals("Timpuri Noi (M1) - SCHIMBA")) {
            LatLng TimpuriNoi2 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi2).title("Timpuri Noi (M1)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi2, 16));
        } else if (pos.equals("Timpuri Noi (M3) - CHANGE")) {
            LatLng TimpuriNoi2 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi2).title("Timpuri Noi (M3)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi2, 16));
        } else if (pos.equals("Timpuri Noi (M3) - SCHIMBA")) {
            LatLng TimpuriNoi2 = new LatLng(44.416686, 26.113367);
            mMap.addMarker(new MarkerOptions().position(TimpuriNoi2).title("Timpuri Noi (M3)"));
            mMap.addCircle(new CircleOptions().center(TimpuriNoi2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TimpuriNoi2, 16));
        } else if (pos.equals("Mihai Bravu (M1) - CHANGE")) {
            LatLng MihaiBravu2 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu2).title("Mihai Bravu (M1)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu2, 16));
        } else if (pos.equals("Mihai Bravu (M1) - SCHIMBA")) {
            LatLng MihaiBravu2 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu2).title("Mihai Bravu (M1)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu2, 16));
        } else if (pos.equals("Mihai Bravu (M3) - CHANGE")) {
            LatLng MihaiBravu2 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu2).title("Mihai Bravu (M3)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu2, 16));
        } else if (pos.equals("Mihai Bravu (M3) - SCHIMBA")) {
            LatLng MihaiBravu2 = new LatLng(44.411445, 26.126241);
            mMap.addMarker(new MarkerOptions().position(MihaiBravu2).title("Mihai Bravu (M3)"));
            mMap.addCircle(new CircleOptions().center(MihaiBravu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MihaiBravu2, 16));
        } else if (pos.equals("Dristor 1 (M1) - CHANGE")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 1 (M1)"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Dristor 1 (M1) - SCHIMBA")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 1 (M1)"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Dristor 1 (M3) - CHANGE")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 1 (M3)"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Dristor 1 (M3) - SCHIMBA")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 1 (M3)"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Nicolae Grigorescu (M1) - CHANGE")) {
            LatLng NicolaeGrigorescu2 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu2).title("Nicolae Grigorescu (M1)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu2, 16));
        } else if (pos.equals("Nicolae Grigorescu (M1) - SCHIMBA")) {
            LatLng NicolaeGrigorescu2 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu2).title("Nicolae Grigorescu (M1)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu2, 16));
        } else if (pos.equals("Nicolae Grigorescu (M3) - CHANGE")) {
            LatLng NicolaeGrigorescu2 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu2).title("Nicolae Grigorescu (M3)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu2, 16));
        } else if (pos.equals("Nicolae Grigorescu (M3) - SCHIMBA")) {
            LatLng NicolaeGrigorescu2 = new LatLng(44.413756, 26.158417);
            mMap.addMarker(new MarkerOptions().position(NicolaeGrigorescu2).title("Nicolae Grigorescu (M3)"));
            mMap.addCircle(new CircleOptions().center(NicolaeGrigorescu2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NicolaeGrigorescu2, 16));
        } else if (pos.equals("Dristor 2 - CHANGE")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 2"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        } else if (pos.equals("Dristor 2 - SCHIMBA")) {
            LatLng Dristor2 = new LatLng(44.419571, 26.140653);
            mMap.addMarker(new MarkerOptions().position(Dristor2).title("Dristor 2"));
            mMap.addCircle(new CircleOptions().center(Dristor2).radius(250.0).strokeWidth(4).strokeColor(Color.RED).fillColor(Color.argb(70,100,100,100)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dristor2, 16));
        }
    }
}

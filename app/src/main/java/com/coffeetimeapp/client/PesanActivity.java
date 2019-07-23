package com.coffeetimeapp.client;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coffeetimeapp.R;
import com.coffeetimeapp.adapter.PesananClientAdapter;
import com.coffeetimeapp.model.PesananClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class PesanActivity extends Activity {

    private RecyclerView recyclerView;
    private PesananClientAdapter adapter;
    private ArrayList<PesananClient> pesananClientArrayList;

    private Button btnPickAlamat;
    private TextView textAlamat;
    // konstanta untuk mendeteksi hasil balikan dari place picker
    private int PLACE_PICKER_REQUEST = 1;
    private Place place_picker;
    private DatabaseReference DataPerusahaan;
    private static int MY_PERMISSION_FINE_LOCATION = 1;
    LatLng latLng ;
    LatLng latLng2;
    float lat;
    float longitude;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        recyclerView = findViewById(R.id.recyclerview);

        addData();

        adapter = new PesananClientAdapter(pesananClientArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PesanActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnPickAlamat = findViewById(R.id.btn_pick_alamat);
        textAlamat = findViewById(R.id.text_alamat);

        btnPickAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
                    /*Intent intent = intentBuilder.build(getActivity());*/
                    // Start the Intent by requesting a result, identified by a request code.
                    startActivityForResult(intentBuilder.build(PesanActivity.this),5);

                    // Hide the pick option in the UI to prevent users from starting the picker
                    // multiple times.


                } catch (GooglePlayServicesRepairableException e) {
                    GooglePlayServicesUtil
                            .getErrorDialog(e.getConnectionStatusCode(), PesanActivity.this, 0);
                } catch (GooglePlayServicesNotAvailableException e) {
                    Toast.makeText(PesanActivity.this, "Google Play Services is not available.",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(
                        "Place: %s \n" +
                                "Alamat: %s \n" +
                                "Latlng %s \n", place.getName(), place.getAddress(), place.getLatLng().latitude+" "+place.getLatLng().longitude);
                textAlamat.setText(toastMsg);
            }
        }
    }*/

    void addData(){
        pesananClientArrayList = new ArrayList<>();
        pesananClientArrayList.add(new PesananClient("Wisa", "Sanger", "Kopi jadi", "x 2", "10.000"));
        pesananClientArrayList.add(new PesananClient("Nanda", "Arabica Gayo", "Bubuk", "x 1", "30.000"));
        pesananClientArrayList.add(new PesananClient("Wisa", "Sanger", "Kopi jadi", "x 2", "10.000"));
        pesananClientArrayList.add(new PesananClient("Nanda", "Arabica Gayo", "Bubuk", "x 1", "30.000"));

    }

}

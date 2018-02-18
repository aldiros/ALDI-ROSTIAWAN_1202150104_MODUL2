package com.example.aldiros.modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.aldiros.modul2.R.array.labels_array;

public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = DineIn.class.getSimpleName();;
    private String mSpinnerLabel = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        // membuat spinner
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // membuat ArrayAdapter menggunakan string array dan default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // menerapkan adapter pada spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
    public void displayToast(String message) {
//        Toast.makeText(this, mSpinnerLabel + getString(R.string.pilih_dinein), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(getApplicationContext(), R.array.labels_array, Toast.LENGTH_SHORT).show();
//        displayToast(getStringArray(R.array.labels_array) + getString(R.string.pilih_dinein));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }


    //perpindahan screen ke class MenuMakan
    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, MenuMakan.class);
        startActivity(intent);
    }
}

package com.example.aldiros.modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {
    private static final String TAG_ACTIVITY = homeActivity.class.getSimpleName();
    private RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        Toast.makeText(getApplicationContext(), "ALDI ROSTIAWAN_1202150104", Toast.LENGTH_SHORT).show();    //Menampilkan Toast Nama_1202150104
    }

    public void displayToast(String message) {              //method untuk toast radio button
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }




    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {                                  //membuat kondisi jika radiobutton dipilih akan memunculkan toast
            case R.id.dinein:
                if (checked)
                    displayToast(getString(R.string.pilih) +
                            getString(R.string.dine_in));
                break;
            case R.id.takeaway:
                if (checked)
                    displayToast(getString(R.string.pilih) +
                            getString(R.string.take_away));
                break;

            default:
                Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked));
                break;
        }
    }


    public void onButtonClicked(View view) {                        //membuat kondisi saat button diklik, perpindahan screen sesuai dengan radio button yang dipilih
        Intent intent;
        int pilihjenis = radiogroup.getCheckedRadioButtonId();
        switch (pilihjenis){
            case R.id.dinein:
                intent = new Intent(this, DineIn.class);
                startActivity(intent);
                break;
            case R.id.takeaway:
                intent = new Intent(this, TakeAway.class);
                startActivity(intent);
                break;
        }
    }
}


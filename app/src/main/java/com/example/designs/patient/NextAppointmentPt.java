package com.example.designs.patient;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.example.designs.BaseActivity;
import com.example.designs.R;

public class NextAppointmentPt extends BaseActivity {
    String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next_appointment_pt);
        menus();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

    }
}
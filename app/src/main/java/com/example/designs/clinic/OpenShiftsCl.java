package com.example.designs.clinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.designs.BaseActivity;
import com.example.designs.R;
import com.example.designs.patient.AppointmentPt;
import com.example.designs.patient.CalendarPt;
import com.example.designs.patient.Main_Page;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OpenShiftsCl extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open_shifts_cl);
        Cmenus();
    }
}
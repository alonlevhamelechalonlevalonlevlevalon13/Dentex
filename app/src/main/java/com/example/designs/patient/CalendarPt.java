package com.example.designs.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.designs.BaseActivity;
import com.example.designs.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CalendarPt extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar_pt);
        menus();
    }
}

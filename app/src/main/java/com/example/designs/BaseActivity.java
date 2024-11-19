package com.example.designs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.designs.FireBase.FBAuthHelper;
import com.example.designs.clinic.OfficeCalendar;
import com.example.designs.clinic.OpenShiftsCl;
import com.example.designs.doctor.CalendarDr;
import com.example.designs.doctor.DrShifts;
import com.example.designs.doctor.ShiftsRequests;
import com.example.designs.patient.AppointmentPt;
import com.example.designs.patient.CalendarPt;
import com.example.designs.patient.Main_Page;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {
    private FBAuthHelper fbAuthHelper;

    void BaseActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bNav);
        // Set the menu items to the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "כל התורים":
                        startActivity(new Intent(getBaseContext(), CalendarPt.class));
                        return true;
                    case "תור חדש":
                        startActivity(new Intent(getBaseContext(),AppointmentPt.class));
                        return true;
                    case "דף הבית":
                        startActivity(new Intent(getBaseContext(), Main_Page.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    public void Dmenus(){
        BottomNavigationView bNav = findViewById(R.id.bNav);
        bNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "משמרות":
                        startActivity(new Intent(getBaseContext(),CalendarDr.class));
                        return true;
                    case "":
                        startActivity(new Intent(getBaseContext(), DrShifts.class));
                        return true;
                    case "שינויים":
                        startActivity(new Intent(getBaseContext(), ShiftsRequests.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    public void Cmenus(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bNav);

        // Set the menu items to the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "בניית משמרות":
                        startActivity(new Intent(getBaseContext(), OpenShiftsCl.class));
                        return true;
                    case "כל המשמרות":
                        startActivity(new Intent(getBaseContext(),OfficeCalendar.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
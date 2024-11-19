package com.example.designs.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;

import com.example.designs.BaseActivity;
import com.example.designs.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppointmentPt extends BaseActivity {
    private String s1 = "All";
    private String sI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment_pt);
        BottomNavigationView bnav = findViewById(R.id.bNav);
        bnav.setSelectedItemId(R.id.page_2);
        Button buttonDoc = findViewById(R.id.buttonDoc);
        buttonDoc.setEnabled(false);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.buttonSubmit);
        button1.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppointmentPt.this,NextAppointmentPt.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(AppointmentPt.this, v);

                // Inflate the menu (from a resource file)
                popupMenu.getMenuInflater().inflate(R.menu.select_treatment, popupMenu.getMenu());

                // Set item click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        button.setText(item.getTitle());
                        s1 = item.getTitle().toString();
                        buttonDoc.setEnabled(true);
                        return true;
                    }
                });

                // Show the PopupMenu
                popupMenu.show();
            }
        });
        buttonDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(AppointmentPt.this, v);

                // Inflate the menu (from a resource file)
                popupMenu.getMenuInflater().inflate(R.menu.select_doc, popupMenu.getMenu());
                MenuItem dor = popupMenu.getMenu().findItem(R.id.option1);
                MenuItem guy = popupMenu.getMenu().findItem(R.id.option2);
                MenuItem gal = popupMenu.getMenu().findItem(R.id.option3);
                MenuItem sivan = popupMenu.getMenu().findItem(R.id.option4);
                MenuItem nofar = popupMenu.getMenu().findItem(R.id.option5);
                dor.setEnabled(false);
                guy.setEnabled(false);
                gal.setEnabled(false);
                sivan.setEnabled(false);
                nofar.setEnabled(false);
                invalidateOptionsMenu();
                if (s1.equals("All")){
                    dor.setEnabled(true);
                    guy.setEnabled(true);
                    gal.setEnabled(true);
                    sivan.setEnabled(true);
                    nofar.setEnabled(true);
                }
                if (s1.equals("בדיקה")){
                    dor.setEnabled(true);
                    sivan.setEnabled(true);
                } else if (s1.equals("עקירה")) {
                    gal.setEnabled(true);
                } else if (s1.equals("סתימה")) {
                    dor.setEnabled(true);
                    sivan.setEnabled(true);
                } else if (s1.equals("ניקוי")) {
                    nofar.setEnabled(true);
                } else if (s1.equals("טיפול שורש")) {
                    guy.setEnabled(true);
                }
                // Set item click listener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        buttonDoc.setText(item.getTitle());
                        button1.setEnabled(true);
                        sI = item.getTitle().toString();
                        return true;
                    }
                });

                // Show the PopupMenu
                popupMenu.show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppointmentPt.this,NextAppointmentPt.class);
                intent.putExtra("DOC_NAME",sI);
                startActivity(intent);
            }
        });
    }


}
package com.example.designs.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designs.BaseActivity;
import com.example.designs.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CalendarPt extends BaseActivity implements PtAppointmentAdapter.ItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar_pt);
        menus();
        ArrayList<String> TreatmentType = new ArrayList<>();
        TreatmentType.add("תור קבוע🤪");
        TreatmentType.add("תור קבוע🤪");
        TreatmentType.add("תור קבוע🤪");
        TreatmentType.add("תור קבוע🤪");
        TreatmentType.add("תור קבוע🤪");
        RecyclerView recyclerView = findViewById(R.id.yourApp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PtAppointmentAdapter adapter = new PtAppointmentAdapter(this, TreatmentType);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}

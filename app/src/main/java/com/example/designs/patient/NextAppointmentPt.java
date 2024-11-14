package com.example.designs.patient;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designs.BaseActivity;
import com.example.designs.R;

import java.util.ArrayList;

public class NextAppointmentPt extends BaseActivity implements PtAppointmentAdapter.ItemClickListener {
    String newString;
    PtAppointmentAdapter adapter;
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
                newString= extras.getString("DOC_NAME");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("DOC_NAME");
        }
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("עקירה");
        animalNames.add("סתימה");
        animalNames.add("ניקוי");
        animalNames.add("טיפול שורש");
        animalNames.add("המשחק");
        RecyclerView recyclerView = findViewById(R.id.Appointments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PtAppointmentAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
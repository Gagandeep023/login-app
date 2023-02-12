package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private String[] options = {"Notification", "Expenses Management", "Attendance", "Performance Dashboard",
            "Roles Reassignment", "Helpdesk Tickets", "Visit your Plan", "Audit Requirement", "Record Lifting Order",
            "Process Lifting Order", "Mark Lots", "Reverse Data Entry", "Chicks Dispatch", "Open Day Rate",
            "Credit Limit Extension", "Sales Target" };
    private HashMap<String, String> detailsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        spinner = (Spinner) findViewById(R.id.spinnerOptions);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        // Initialize the detailsMap with the relevant details for each option
        detailsMap.put("Notification", "FM Notifications, Lots Notifications");
        detailsMap.put("Expenses Management", "Claim Expenses, Approve Expenses");
        detailsMap.put("Attendance", "View Attendance");
        detailsMap.put("Performance Dashboard", "Dashboard view, Detailed View");
        detailsMap.put("Roles Reassignment", "LS Role");
        detailsMap.put("Helpdesk Tickets", "View, take action");
        detailsMap.put("Visit your Plan", "Automatic Visit Plan, Manual Visit Plan, Sales Visit Plan");
        detailsMap.put("Audit Requirement", "Automatic Audit Requirement, Create Audit Requirement, Display Audit Requirement");
        detailsMap.put("Record Lifting Order", "Record Lifting Order, Update Lifting order, Display Lifting Order, Confirm Lifting Order");
        detailsMap.put("Process Lifting Order", "Start Lifting");
        detailsMap.put("Mark Lots", "Ready for Lifting, Ready for Thinning");
        detailsMap.put("Reverse Data Entry", "Reverse Data Entry");
        detailsMap.put("Chicks Dispatch", "Display Dispatch, Dispatch chicks");
        detailsMap.put("Open Day Rate", "Create Day Rate, Display Day Rates");
        detailsMap.put("Credit Limit Extension", "Request Credit Limit Extension, Approve Credit Limit Extension");
        detailsMap.put("Sales Target", "View Sales Target");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedOption = options[position];
        String details = detailsMap.get(selectedOption);
        DetailsDialog detailsDialog = DetailsDialog.newInstance(details);
        detailsDialog.show(getSupportFragmentManager(), "DetailsDialog");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
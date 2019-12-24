package com.pawan.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDeleteActivity extends AppCompatActivity {
    private EditText etEmployeeNo,etUpdateName,etUpdateSalary,etUpdateAge;
    private Button btnSearchUpdate,btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        etEmployeeNo=findViewById(R.id.etEmployeeNo);
        etUpdateName=findViewById(R.id.etUpdateName);
        etUpdateSalary=findViewById(R.id.etUpdateSalary);
        etUpdateAge=findViewById(R.id.etUpdateAge);
        btnSearchUpdate=findViewById(R.id.btnSearchUpdate);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);

        btnSearchUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

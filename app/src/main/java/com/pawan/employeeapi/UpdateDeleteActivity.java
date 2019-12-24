package com.pawan.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pawan.employeeapi.api.EmployeeAPI;
import com.pawan.employeeapi.model.Employee;
import com.pawan.employeeapi.model.EmployeeCUD;
import com.pawan.employeeapi.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDeleteActivity extends AppCompatActivity {
    private final static String Base_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etEmployeeNo,etUpdateName,etUpdateSalary,etUpdateAge;
    private Button btnSearchUpdate,btnUpdate,btnDelete;
     Retrofit retrofit;
     EmployeeAPI employeeAPI;
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
                loadData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               updateEmployee();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               deleteEmployee();
            }
        });
    }

    private void loadData(){
        EmployeeAPI employeeAPI = URL.createInstance().create(EmployeeAPI.class);
        Call<Employee> ListCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEmployeeNo.getText().toString()));

        ListCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                etUpdateName.setText(response.body().getEmployee_name());
                etUpdateAge.setText(response.body().getEmployee_age());
                etUpdateSalary.setText(response.body().getEmployee_salary());

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(UpdateDeleteActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void updateEmployee(){
        EmployeeAPI employeeAPI = URL.createInstance().create(EmployeeAPI.class);
        EmployeeCUD employeeCUD = new EmployeeCUD(
                etUpdateName.getText().toString(),
                Float.parseFloat(etUpdateSalary.getText().toString()),
                Integer.parseInt(etUpdateAge.getText().toString())
        );
Call<Void> voidCall = employeeAPI.updateEmployee(Integer.parseInt(etEmployeeNo.getText().toString()),employeeCUD);

voidCall.enqueue(new Callback<Void>() {
    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        Toast.makeText(UpdateDeleteActivity.this, "Updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Toast.makeText(UpdateDeleteActivity.this, "Error"+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
});

    }
     private void  deleteEmployee(){
         EmployeeAPI employeeAPI = URL.createInstance().create(EmployeeAPI.class);
         Call<Void> voidCall = employeeAPI.deleteEmployee(Integer.parseInt(etEmployeeNo.getText().toString()));

         voidCall.enqueue(new Callback<Void>() {
             @Override
             public void onResponse(Call<Void> call, Response<Void> response) {
                 Toast.makeText(UpdateDeleteActivity.this, "Sucessfully Deleted", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onFailure(Call<Void> call, Throwable t) {
                 Toast.makeText(UpdateDeleteActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
             }
         });
     }
}

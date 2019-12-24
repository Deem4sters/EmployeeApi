package com.pawan.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pawan.employeeapi.api.EmployeeAPI;
import com.pawan.employeeapi.model.Employee;
import com.pawan.employeeapi.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {
    private final static String Base_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etEmployeeNo;
    private Button btnSearch;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etEmployeeNo = findViewById(R.id.etEmployeeNo);
        btnSearch = findViewById(R.id.btnSearch);
        tvData = findViewById(R.id.tvData);
        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                loadData();
            }


            private void loadData() {
                EmployeeAPI employeeAPI = URL.createInstance().create(EmployeeAPI.class);
                Call<Employee> employeeCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEmployeeNo.getText().toString()));

                employeeCall.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(SearchActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        String content = "";
                        content += "Id : " + response.body().getId() + "\n";
                        content += "Name : " + response.body().getEmployee_name() + "\n";
                        content += "Age : " + response.body().getEmployee_age() + "\n";
                        content += "Salary : " + response.body().getEmployee_salary() + "\n";

                        tvData.setText(content);
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}





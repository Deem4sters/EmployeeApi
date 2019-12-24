package com.pawan.employeeapi.api;

import com.pawan.employeeapi.model.Employee;
import com.pawan.employeeapi.model.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {

    //get all employee

    @GET("employees")
    Call<List<Employee>> getAllEmployees();
    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);


    //get employee according to search
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID")int empId);

    //update employee according to EMpID
    @PUT("update/{empID}")
    Call<Void> updateEmployee(@Path("empID")int empId, @Body EmployeeCUD emp);

    //Delete employee according to EMpID
    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path("empID")int empID );

}

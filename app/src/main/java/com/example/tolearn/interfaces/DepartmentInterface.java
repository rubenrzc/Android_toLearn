/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;



import com.example.tolearn.pojos.Department;
import com.example.tolearn.pojos.plural.Departments;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Yeray
 */
public interface DepartmentInterface {
    /**
     * @param entity
     */
    @POST(".")
    public  Call <Void> create(@Body Department entity);
    /**
     * @param entity
     */
    @PUT("{id}")
    public void edit(@Body Department entity);
    /**
     * @param id
     */
    @DELETE("{id}")
    public void remove(@Path("id") Integer id);
    /**
     * @return Department
     */
    @GET("department/")
    public Call<Departments> FindAllDepartment();
}

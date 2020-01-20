/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;

import com.example.tolearn.pojos.Company;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 *
 * @author Ruben
 */
public interface CompanyInterface {



    @POST
    public  Call <Void> create(@Body Company company);

    @PUT("{id}")
    public void edit(@Body Company company);

    @DELETE("{id}")
    public void remove(@Path("id") Integer id);

    @GET("{id}")
    public Call<Company> find(@Path("id") Integer id);

    @GET
    public Call<Collection<Company>> findAll();
}

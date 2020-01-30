/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;

import com.example.tolearn.pojos.Company;
import com.example.tolearn.pojos.plural.Companies;

import java.util.Collection;
import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 *
 * @author Andoni
 */
public interface CompanyInterface {

    /**
     * @param company
     **/
    @POST
    public  Call <Void> create(@Body Company company);
    /**
     * @param company
     */
    @PUT("{id}")
    public void edit(@Body Company company);

    /**
     * @param id
     */
    @DELETE("{id}")
    public void remove(@Path("id") Integer id);
    /**
     * @param id
     * @return Company
     */
    @GET("{id}")
    public Call<Company> find(@Path("id") Integer id);
    /**
     * @return Companies
     */
    @GET(".")
    public Call<Companies> findAll();
}

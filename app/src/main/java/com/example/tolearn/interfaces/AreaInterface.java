/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;


import com.example.tolearn.pojos.Area;
import com.example.tolearn.pojos.plural.Areas;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Andoni
 */
public interface AreaInterface {

    /**
     * @param entity
     */
    @POST(".")
    public Call <Void> create(@Body Area entity);
    /**
     * @param entity
     * @return
     */
    @PUT("{id}")
    public Call<Void> edit(@Body Area entity);
    /**
     * @param id
     */
    @DELETE("{id}")
    public Call<Void> remove(@Path("id") Integer id);
    /**
     * @return Areas
     */
    @GET(".")
    public Call<Areas> FindAllArea();
}

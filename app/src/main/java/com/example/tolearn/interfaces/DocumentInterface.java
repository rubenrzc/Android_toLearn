/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;

import com.example.tolearn.pojos.Document;

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
 * @author 2dam
 */

public interface DocumentInterface {

    @POST
    public  Call <Void> createNewDocument(@Body Document document);

    @PUT
    public void updateDocument(@Body Document document);

    @DELETE("{id}")
    public void remove(@Path("id") Integer id);

    @GET("{id}")
    public Call<Document> find(@Path("id") int id);

    @GET
    public Call<Collection<Document>> findAll();
    
}

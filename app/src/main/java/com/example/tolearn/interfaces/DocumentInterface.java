/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;

import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.plural.Documents;
import com.example.tolearn.pojos.plural.ListDocuments;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Ruben
 */
public interface DocumentInterface {
    /**
     * @param document
     */
    @POST(".")
    public  Call <Void> createNewDocument(@Body Document document);
    /**
     * @param document
     */
    @PUT
    public void updateDocument(@Body Document document);
    /**
     * @param id
     */
    @DELETE("{id}")
    public void remove(@Path("id") Integer id);
    /**
     * @param id
     * @return Document
     */
    @GET("{id}")
    public Call<Document> find(@Path("id") int id);
    /**
     * @return Documents
     */
    @GET(".")
    public Call<Documents> findAll();
    
}

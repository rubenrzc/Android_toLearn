/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;


import com.example.tolearn.pojos.User;

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
public interface UserInterface {

    
    @GET("{id}")
    public User find(@Path("id") int id);
    
    /**
     * 
     * @param login
     * @param password
     * @return 
     */
    @GET("{login}/{password}")
    Call <User> login(@Path("login") String login,@Path("password") String password);

    /**
     * 
     * @return 
     */
    @GET
    public Call<Collection<User>> findAll();

    /**
     *
     */
    @PUT("{email}")
    public void recoverPassword(@Body User user);
    
    /**
     * 
     * @param user 
     */
    @POST
    public  Call <Void> create(@Body User user);

    /**
     * 
     * @param user 
     */
    @PUT
    public void edit(@Body User user);

    @DELETE("{id}")
    public void remove(@Path("id")Integer id);
    
     
    
}

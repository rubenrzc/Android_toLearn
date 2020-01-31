/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.interfaces;


import com.example.tolearn.pojos.User;
import com.example.tolearn.pojos.plural.Users;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Fran
 */
public interface UserInterface {
    /**
     * @param id
     * @return user
     */
    @GET("{id}")
    public User find(@Path("id") int id);
    
    /**
     * @param login
     * @param password
     * @return 
     */
    @GET("{login}/{password}")
    Call <User> login(@Path("login") String login,@Path("password") String password);

    /**
     * @return users
     */
    @GET(".")
    public Call<Users> findAll();

    /**
     * @param user
     */
    @PUT("{email}")
    public Call <Void> recoverPassword(@Body User user);
    /**
     * @param user 
     */
    @POST
    public  Call <Void> create(@Body User user);

    /**
     * @param user 
     */
    @PUT("{user}")
    public Call <Void> edit(@Body User user);
    /**
     * @param id
     * @return id
     */
    @DELETE("{id}")
    public Call <Void> remove(@Path("id")Integer id);
    /**
     *
     * @return
     */
    @GET("getPublicKey/")
    public Call<String> getPublicKey();
    
     
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Ruben
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
   
    private String name;
    private String cif;

    private Collection<User> users;

    private Collection <Department> departments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the users
     */

    public Collection<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    /**
     * @return the departments
     */
    public Collection <Department> getDepartments() {
        return departments;
    }

    /**
     * @param departments the departments to set
     */
    public void setDepartments(Collection <Department> departments) {
        this.departments = departments;
    }
 
    
}
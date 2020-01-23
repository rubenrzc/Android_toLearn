/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Ruben
 */

public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
   
    private String name;
    private String cif;

    private Set<User> users;

    private Set<Department> departments;

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

    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * @return the departments
     */
    public Set<Department> getDepartments() {
        return departments;
    }

    /**
     * @param departments the departments to set
     */
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
 
    
}
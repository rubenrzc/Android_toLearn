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
 * @author Andoni
 */

public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    
    private String name;

    private Set<Department> departments;

    private Set<Document> documents;

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
    /**
     * @return the documents
     */
    
    public Set<Document> getDocuments() {
        return documents;
    }
    /**
     * @param documents the documents to set
     */
    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

}
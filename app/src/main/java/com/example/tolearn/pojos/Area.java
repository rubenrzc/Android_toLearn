/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import com.example.tolearn.pojos.plural.Departments;
import com.example.tolearn.pojos.plural.Documents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


/**
 *
 * @author Andoni
 */
//@Root(name="area")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    //@Element(name="id")
    private int id;
    //@Element(name="name")
    private String name;
    //@ElementList(name = "departments", inline = true)
    private Departments departments;
    //@ElementList(name = "documents", inline = true)
    private Documents documents;

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
    
    public Departments getDepartments() {
        return departments;
    }
    /**
     * @param departments the departments to set
     */
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
    /**
     * @return the documents
     */
    
    public Documents getDocuments() {
        return documents;
    }
    /**
     * @param documents the documents to set
     */
    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

}
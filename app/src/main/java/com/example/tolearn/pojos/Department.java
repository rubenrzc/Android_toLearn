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
 * @author Yeray
 */

public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    /**
     * Department name
     */

    private String name;

    /**
     * Companies collection
     */

    private Set<Company> companies;

    /**
     * Areas collection
     */
    private Set<Area> areas;

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
     * @return the companies
     */

    public Set<Company> getCompanies() {
        return companies;
    }

    /**
     * @param companies the companies to set
     */
    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    /**
     * @return the areas
     */

    public Collection<Area> getAreas() {
        return areas;
    }

    /**
     * @param areas the areas to set
     */
    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

}

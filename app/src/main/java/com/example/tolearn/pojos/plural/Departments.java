package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Department;

import org.simpleframework.xml.ElementList;

import java.util.Set;

public class Departments {
    @ElementList(name="department",inline = true)
    private Set<Department> departments;

    public Departments(){
    }
    public Departments(Set<Department>departments){
        this.departments = departments;
    }
    public Set<Department>getDepartments(){
        return departments;
    }
    public void setDepartments(Set<Department>departments){
        this.departments = departments;
    }
}

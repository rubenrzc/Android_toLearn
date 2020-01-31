package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Department;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;

/**
 * @Author Andoni
 */
@Root(name="departments")
public class Departments {
    @ElementList(name="department",inline = true)
    private Set<Department> departments;
    /**
     * @return departments
     */
    public Set<Department>getDepartments(){
        return departments;
    }

    /**
     * @param departments
     */
    public void setDepartments(Set<Department>departments){
        this.departments = departments;
    }
}

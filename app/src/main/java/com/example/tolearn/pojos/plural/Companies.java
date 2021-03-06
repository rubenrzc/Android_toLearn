package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Company;
import com.example.tolearn.pojos.User;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;

/**
 * @Author Andoni
 */
@Root(name = "companies")
public class Companies {
    @ElementList(name = "company", inline = true)
    private Set<Company> companies;

    /**
     * @return companies
     */
    public Set<Company> getCompanies() {
        return companies;
    }
    /**
     * @param companies
     */
    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}

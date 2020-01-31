/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import android.text.Editable;

import com.example.tolearn.utilities.Convertors;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author Francisco Romero Alonso
 */
//@Root(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    //@Element(name="id")
    private int id;
    //@Element(name="login")
    private String login;
    //@Element(name="email")
    private String email;
    //@Element(name="fullName")
    private String fullname;
    //@Element(name="status")
    private UserStatus status;
    //@Element(name="privilege")
    private UserPrivilege privilege;
    //@Element(name="password")
    private String password;
    //@ElementList(name = "photo", inline = true)
    //@ElementArray(name = "profilePicture",required = false)
    private String photo;
    //@Element(name="lastAcces")
    private String lastAccess;
    //@Element(name="lastPasswordChange")
    private String lastPassWordChange;
    //@Element(name="bDate")
    private String bDate;
    //@Element(name="company")
    private Company company;
    //@ElementList(name = "documents", inline = true)
    private Set<Document> documents;

    /**
     *
     */

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return
     */

    public Set<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents
     */
    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    /**
     * @return
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * @return
     */
    public UserPrivilege getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege
     */
    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public Date getLastAccess() {
        Date resultado=null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
            resultado= formatter.parse(lastAccess);
        }catch (Exception e){
            resultado=new Date();
        }
        return resultado;
    }

    /**
     * @param lastAccess
     */
    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess.toString();
    }

    /**
     * @return
     */
    public Date getLastPassWordChange() {
        Date resultado=null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
            resultado= formatter.parse(lastPassWordChange);
        }catch (Exception e){
            resultado=new Date();
        }
        return resultado;
    }

    /**
     * @param lastPassWordChange
     */
    public void setLastPassWordChange(Date lastPassWordChange) {
        this.lastPassWordChange = lastPassWordChange.toString();
    }

    public Date getbDate() {
        Date resultado=null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
            resultado= formatter.parse(bDate);
        }catch (Exception e){
            resultado=new Date();
        }
        return resultado;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate.toString();
    }

    /**
     * @return
     */
    public byte[] getPhoto() {
        Convertors con = new Convertors();
        byte[] photo = con.hexStringToByteArray(this.photo);
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
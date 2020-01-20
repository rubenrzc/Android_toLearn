/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Francisco Romero Alonso
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String login;
    private String email;

    private String fullname;

    private UserStatus status;

    private UserPrivilege privilege;

    private String password;

    private byte[] photo;

    private String lastAccess;

    private String lastPassWordChange;

    private String bDate;

    private Company company;

    private Collection<Document> documents;

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

    public Collection<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents
     */
    public void setDocuments(Collection<Document> documents) {
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
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}
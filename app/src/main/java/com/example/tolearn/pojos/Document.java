/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tolearn.pojos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author Ruben
 */
//@Root(name="document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    //@Element(name="id")
    private int id;
    //@Element(name="name")
    private String name;
    //@Element(name="description")
    private String description;
    //@Element(name="user")
    private User user;
    //@ElementList(name = "areas", inline = true)
    private Set<Area> areas;
    //@Element(name="uploadDate")
    private String uploadDate;
    //@Element(name="visibility")
    private Boolean visibility;
    //@ElementList(name = "documentContent", inline = true)
    private Byte[] documentContent;
    //@Element(name="status")
    private DocumentStatus status;

    public Document() {
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return user
     */
    public User getUser() {
        return user;
    }
    /**
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @return ares
     */
    public Set<Area> getAreas() {
        return areas;
    }
    /**
     * @param areas
     */
    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }
    /**
     * @return
     */
    public Date getbDate() {
        Date resultado=null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
            resultado= formatter.parse(uploadDate);
        }catch (Exception e){
            resultado=new Date();
        }
        return resultado;
    }

    /**
     * @param bDate
     */
    public void setbDate(Date bDate) {
        this.uploadDate = bDate.toString();
    }
    /**
     * @return visibility
     */
    public Boolean getVisibility() {
        return visibility;
    }
    /**
     * @param visibility
     */
    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }
    /**
     * @return documentContent
     */
    public Byte[] getDocumentContent() {
        return documentContent;
    }
    /**
     * @param documentContent
     */
    public void setDocumentContent(Byte[] documentContent) {
        this.documentContent = documentContent;
    }
    /**
     * @return id
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
     * @return status
     */
    public DocumentStatus getStatus() {
        return status;
    }
    /**
     * @param status
     */
    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

}

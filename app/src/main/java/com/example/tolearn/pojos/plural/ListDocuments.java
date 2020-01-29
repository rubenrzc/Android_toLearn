package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Area;
import com.example.tolearn.pojos.DocumentStatus;
import com.example.tolearn.pojos.User;

import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Root(name="documents")
public class ListDocuments implements Serializable {
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
    private Date uploadDate;
    //@Element(name="visibility")
    private Boolean visibility;
    //@ElementList(name = "documentContent", inline = true)
    private Byte[] documentContent;
    //@Element(name="status")
    private DocumentStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public Byte[] getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(Byte[] documentContent) {
        this.documentContent = documentContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }
}

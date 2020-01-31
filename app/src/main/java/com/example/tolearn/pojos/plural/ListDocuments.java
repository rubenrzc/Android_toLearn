package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Area;
import com.example.tolearn.pojos.DocumentStatus;
import com.example.tolearn.pojos.User;

import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Author Andoni
 */
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

    /**
     * @return name
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
     * @return Areas
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
     * @return uploadDatw
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    /**
     * @return visibilityu
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

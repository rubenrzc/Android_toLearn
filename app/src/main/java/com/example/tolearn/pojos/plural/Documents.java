package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Document;
import com.example.tolearn.pojos.User;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;
@Root(name = "documents")
public class Documents {
    //@ElementList(name = "document", required = false)
    private Set<Document> documents;

    public Set<Document> getDocuments() {
        return documents;
    }
    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}

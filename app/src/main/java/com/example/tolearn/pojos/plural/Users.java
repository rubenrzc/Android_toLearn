package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.User;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;

@Root(name="users")
public class Users {
    @ElementList(name = "user", inline = true)
    private Set<User>users;
    public Users(){}
    public Users(Set<User> users) {
        this.users = users;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.User;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;
/**
 * @Author Andoni
 */
@Root(name="users")
public class Users {
    @ElementList(name = "user", inline = true)
    private Set<User>users;

    /**
     * @return users
     */
    public Set<User> getUsers() {
        return users;
    }
    /**
     * @param users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

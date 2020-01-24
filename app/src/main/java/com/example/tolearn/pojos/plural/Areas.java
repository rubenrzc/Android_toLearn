package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Area;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;

@Root(name="areas")
public class Areas {
    @ElementList(name = "area", inline = true)
    private Set<Area> areas;
    public Areas(){}
    public Areas(Set<Area> areas) {
        this.areas = areas;
    }
    public Set<Area> getAreas() {
        return areas;
    }
    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }
}

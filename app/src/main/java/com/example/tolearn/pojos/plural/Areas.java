package com.example.tolearn.pojos.plural;

import com.example.tolearn.pojos.Area;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Set;

/**
 * @Author Andoni
 */
@Root(name="areas")
public class Areas {
    @ElementList(name = "area", inline = true)
    private Set<Area> areas;

    /**
     * @return areas
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
}

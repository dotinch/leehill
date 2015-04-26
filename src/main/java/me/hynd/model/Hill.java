package me.hynd.model;

import java.io.Serializable;

/**
 * Created by H on 2015/4/25.
 */
public class Hill implements Serializable{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

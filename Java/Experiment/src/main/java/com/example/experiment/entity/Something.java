package com.example.experiment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author lltt9
 * @date 2023-01-01 18:05
 */
public class Something {
    @JsonProperty("name")
    private String name;
    @JsonProperty("poplist")
    private List<Pop> poplist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pop> getPoplist() {
        return poplist;
    }

    public void setPoplist(List<Pop> poplist) {
        this.poplist = poplist;
    }

    public static class Pop {
        @JsonProperty("map")
        private String map;
    }
}

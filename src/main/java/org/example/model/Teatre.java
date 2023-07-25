package org.example.model;

public class Teatre {
    private  Long id;
    private  String name;
    private  String location;

    public Teatre() {
    }

    public Teatre(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Teatre(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\n name; " + name +
                " location; " + location ;
    }
}

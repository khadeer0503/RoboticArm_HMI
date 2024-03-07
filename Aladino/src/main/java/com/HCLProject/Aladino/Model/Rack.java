package com.HCLProject.Aladino.Model;

import jakarta.persistence.*;
// import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String name;
    private String side;

@OneToMany(mappedBy = "rack",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Shelf> shelfs= new ArrayList<>();

@OneToMany(mappedBy = "rack",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Positions> positions= new ArrayList<>();

    public Rack() {
    }

    public Rack(Long rid, String name, String side, List<Shelf> shelfs, List<Positions> positions) {
        this.rid = rid;
        this.name = name;
        this.side = side;
        this.shelfs = shelfs;
        this.positions = positions;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public List<Shelf> getShelfs() {
        return shelfs;
    }

    public void setShelfs(List<Shelf> shelfs) {
        this.shelfs = shelfs;
    }

    public List<Positions> getPositions() {
        return positions;
    }

    public void setPositions(List<Positions> positions) {
        this.positions = positions;
    }



}

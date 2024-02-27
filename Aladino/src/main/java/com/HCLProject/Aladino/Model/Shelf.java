package com.HCLProject.Aladino.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;
    private String level;
    @Column(name = "placement_on_a_Rack ")
    private String placement;
    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "rack_id")
    private Rack rack;


    public Shelf() {
    }

    public Shelf(Long sid, String level, String placement, Rack rack) {
        this.sid = sid;
        this.level = level;
        this.placement = placement;
        this.rack = rack;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    @Override
    public String toString() {
        return "Shelf [sid=" + sid + ", level=" + level + ", placement=" + placement + ", rack=" + rack + "]";
    }

}

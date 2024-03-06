package com.HCLProject.Aladino.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;
    private String level;
    private String ShelfNumber;
    @Column(name = "placement_on_a_Rack ")
    private String placement;
    @ManyToOne
    private Rack rack;
    @OneToMany(cascade = CascadeType.ALL,mappedBy= "shelf") //mappedBy should be here only
    private List<Boxes>  boxes= new ArrayList<>();

    public Shelf() {
    }

    public Shelf(Long sid, String level, String shelfNumber, String placement, Rack rack, List<Boxes> boxes) {
        this.sid = sid;
        this.level = level;
        ShelfNumber = shelfNumber;
        this.placement = placement;
        this.rack = rack;
        this.boxes = boxes;
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

    public String getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        ShelfNumber = shelfNumber;
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

    public List<Boxes> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Boxes> boxes) {
        this.boxes = boxes;
    }

    @Override
    public String toString() {
        return "Shelf [sid=" + sid + ", level=" + level + ", ShelfNumber=" + ShelfNumber + ", placement=" + placement
                + ", rack=" + rack + ", boxes=" + boxes + "]";
    }



}

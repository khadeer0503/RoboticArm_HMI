package com.HCLProject.Aladino.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import javax.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    @Max(value=5, message = "Shelf level should be less then then equal to 5")
    @Min(value = 1, message = "Shelf level should be at-least 1")
    private Integer level;
    private String ShelfNumber;
    @Column(name = "position on a Shelf ")
    @Max(value=5, message = "Shelf placement position should be less then then equal to 5")
    @Min(value = 1, message = "Shelf placement position should be at-least 1")
    private Integer placement;
@ManyToOne
    private Rack rack;
@OneToMany(mappedBy = "shelf",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Positions> positions= new ArrayList<>();
    // @OneToMany(cascade = CascadeType.ALL,mappedBy= "shelf") //mappedBy should be here only
    // private List<Boxes>  boxes= new ArrayList<>();

    public Shelf() {
    }

    public Shelf(Long sid, @Max(value = 5, message = "Shelf level should be less then then equal to 5") Integer level,
            String shelfNumber,
            @Max(value = 5, message = "Shelf placement should be less then then equal to 5") Integer placement,
            Rack rack, List<Positions> positions) {
        this.sid = sid;
        this.level = level;
        this.ShelfNumber = shelfNumber;
        this.placement = placement;
        this.rack = rack;
        this.positions = positions;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getShelfNumber() {
        return ShelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        ShelfNumber = shelfNumber;
    }

    public Integer getPlacement() {
        return placement;
    }

    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public List<Positions> getPositions() {
        return positions;
    }

    public void setPositions(List<Positions> positions) {
        this.positions = positions;
    }




}

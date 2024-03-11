package com.HCLProject.Aladino.Model;

import jakarta.persistence.*;
// import javax.persistence.*;



@Entity
@Table(name = "positions")
public class Positions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
@ManyToOne
	private Rack rack;

@ManyToOne
	private Shelf shelf;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "boxes_id", referencedColumnName = "id")
	private Boxes boxes;

public Positions() {
}

public Positions(Long id, Rack rack, Shelf shelf, Boxes boxes) {
	this.id = id;
	this.rack = rack;
	this.shelf = shelf;
	this.boxes = boxes;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Rack getRack() {
	return rack;
}

public void setRack(Rack rack) {
	this.rack = rack;
}

public Shelf getShelf() {
	return shelf;
}

public void setShelf(Shelf shelf) {
	this.shelf = shelf;
}

public Boxes getBoxes() {
	return boxes;
}

public void setBoxes(Boxes boxes) {
	this.boxes = boxes;
}


}

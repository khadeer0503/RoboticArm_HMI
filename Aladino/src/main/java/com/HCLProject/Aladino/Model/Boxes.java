package com.HCLProject.Aladino.Model;


//import javax.persistence.*;

import jakarta.persistence.*;




@Entity
public class Boxes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dimension;
	private String weight;
	@OneToOne(mappedBy = "boxes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Positions positions;

	public Boxes() {
		super();
	}

	public Boxes(Long id, String name, String dimension, String weight, Positions positions) {
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.weight = weight;
		this.positions = positions;
	}

	public Long getId() {		return id;	}
	public void setId(Long id) {		this.id = id;	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Positions getPositions() {return positions;	}
	public void setPositions(Positions positions) {	this.positions = positions;	}
}

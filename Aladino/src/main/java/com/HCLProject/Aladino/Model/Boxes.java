package com.HCLProject.Aladino.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Boxes")
public class Boxes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dimension;
	private String weight;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "position_point_id")
	//@JsonIgnore
	private PositionsPoints  positionsPoints;
	
	// private boolean isOccupied;
	 
	public Boxes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boxes(Long id, String dimension, String weight, String name, PositionsPoints positionsPoints) {
		super();
		this.id = id;
		this.dimension = dimension;
		this.weight = weight;
		this.name = name;
		this.positionsPoints = positionsPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionsPoints getpositionsPoints() {
		return positionsPoints;
	}

	public void setpositionsPoints(PositionsPoints positionsPoints) {
		this.positionsPoints = positionsPoints;
	}

	@Override
	public String toString() {
		return "Boxes [id=" + id + ", dimension=" + dimension + ", weight=" + weight + ", name=" + name
				+ ", positionsPoints=" + positionsPoints + "]";
	}


	
	
	
	
}

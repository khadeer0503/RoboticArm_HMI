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
	@ManyToOne
	@JoinColumn(name = "shelf_Id")
	private Shelf shelf;
	//private Positions positions;

	public Boxes() {
		super();
	}

	public Boxes(Long id, String name, String dimension, String weight, Shelf shelf) {
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.weight = weight;
		this.shelf = shelf;
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

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return "Boxes{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dimension='" + dimension + '\'' +
				", weight='" + weight + '\'' +
				", shelf=" + shelf +
				'}';
	}
}

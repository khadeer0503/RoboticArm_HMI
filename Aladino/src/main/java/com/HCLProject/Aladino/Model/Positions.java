package com.HCLProject.Aladino.Model;

import jakarta.persistence.*;
// import javax.persistence.*;



@Entity
@Table(name = "positions")
public class Positions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String side;
	private String level;
//	private Boolean isAvailable;
@Column(name = "placement_on_a_Rack ")
	private String placement;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxes_id", referencedColumnName = "id")
	private Boxes boxes;

	public Positions() {
		super();
	}

	public Positions(Long id, String side, String level, String placement, Boxes boxes) {
		this.id = id;
		this.side = side;
		this.level = level;
		this.placement = placement;
		this.boxes = boxes;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
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
	public Boxes getBoxes() {return boxes;	}
	public void setBoxes(Boxes boxes) {this.boxes = boxes;	}

	@Override
	public String toString() {
		return "Positions{" +
				"id=" + id +
				", side='" + side + '\'' +
				", level='" + level + '\'' +
				", placement='" + placement + '\'' +
				", boxes=" + boxes +
				'}';
	}
}

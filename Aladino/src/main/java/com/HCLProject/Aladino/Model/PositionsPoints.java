package com.HCLProject.Aladino.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="BoxPosition")
public class PositionsPoints  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="Available", nullable = false)
    private Boolean isAvailable = true;
    
    @Column(name="Side_Left_Right")
    private String side;
    
    @Column(name="Level")
    private String level;
    
//    @Column(name = "x")
//    private Double x;
//
//    @Column(name = "y")
//    private Double y;
//
//    @Column(name = "z")
//    private Double z;
    
    @Column(name = "position_on_rack")
    private String positionOnRack;
    
    @OneToOne(mappedBy = "positionsPoints",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private Boxes boxes; 
    
	public PositionsPoints() {
		super();
	}
// Getting the position on a rack system and also checking the position is available or not.
	public PositionsPoints(String positionOnRack)
	{
		this.positionOnRack = positionOnRack;
		this.isAvailable = false;
	}
public PositionsPoints(Long id, Boolean isAvailable, String side, String level, Double x, Double y, Double z,
		String positionOnRack, Boxes boxes)
	{
		super();
		this.id = id;
		this.isAvailable = isAvailable;
		this.side = side;
		this.level = level;
//		this.x = x;
//		this.y = y;
//		this.z = z;
		this.positionOnRack = positionOnRack;
		this.boxes = boxes;
	}
public Long getId()
	{
		return id;
	}
public void setId(Long id)
	{
		this.id = id;
	}
public Boolean getIsAvailable()
	{
		return isAvailable;
	}
public void setIsAvailable(Boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}
public String getSide()
	{
		return side;
	}
public void setSide(String side)
	{
		this.side = side;
	}
public String getLevel()
	{
		return level;
	}
public void setLevel(String level)
	{
		this.level = level;
	}
//public Double getX()
//	{
//		return x;
//	}
//public void setX(Double x)
//	{
//		this.x = x;
//	}
//public Double getY()
//	{
//		return y;
//	}
//public void setY(Double y)
//	{
//		this.y = y;
//	}
//public Double getZ()
//	{
//		return z;
//	}
//public void setZ(Double z)
//	{
//		this.z = z;
//	}
public String getPositionOnRack()
	{
		return positionOnRack;
	}
public void setPositionOnRack(String positionOnRack)
	{
		this.positionOnRack = positionOnRack;
	}
public Boxes getBoxes()
	{
		return boxes;
	}
public void setBoxes(Boxes boxes)
	{
		this.boxes = boxes;
	}

	@Override
	public String toString() {
		return "PositionsPoints{" +
				"id=" + id +
				", isAvailable=" + isAvailable +
				", side='" + side + '\'' +
				", level='" + level + '\'' +
				", positionOnRack='" + positionOnRack + '\'' +
				", boxes=" + boxes +
				'}';
	}
}

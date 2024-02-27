package com.HCLProject.Aladino.Service;

import java.util.List;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;


public interface BoxesService {
	public Boxes saveBox(Boxes boxes);
	public Boxes updateBoxes(Long id,Boxes boxes) throws BoxNotFoundException, PositionNotFoundException, PositionAlreadyFullException;
	public void deleteBoxesById(Long id);
	public Boxes findbyId(Long id) throws BoxNotFoundException;
	public List<Boxes> getAllBoxes();
	//public void pickBoxAndMoveToRobot(Long boxId);
}
	//    public List<Positions> getAvailablePositions();

//public String Dimension(String dimension);




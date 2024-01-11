package com.HCLProject.Aladino.Service;

import java.util.List;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.PositionsPoints;


public interface BoxesService {
	
	
    //Boxes getBoxById(Long id);
   // void updateBox(Boxes boxes);
	
	    public Boxes saveBox(Boxes boxes);
	    public void updateBoxes(Long id,Boxes boxes) throws BoxNotFoundException, PositionNotFoundException, PositionAlreadyFullException;
	    public void deleteBoxesById(Long id);
	    public Boxes findbyId(Long id) throws BoxNotFoundException;
	    public List<Boxes> getAllBoxes();
	//    public List<PositionsPoints> getAvailablePositions();
}	
	
//public String Dimension(String dimension);
	



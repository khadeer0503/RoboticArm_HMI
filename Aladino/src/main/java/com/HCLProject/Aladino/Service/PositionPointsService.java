package com.HCLProject.Aladino.Service;

import java.util.List;

import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.PositionsPoints;



public interface PositionPointsService {

	public PositionsPoints createPosition(PositionsPoints positionPoints);
	public void updateposition(String positionOnRack) throws PositionNotFoundException, PositionAlreadyFullException;
	public void deletePosition(Long id) throws PositionNotFoundException;
	public PositionsPoints getSinglePosition(Long id) throws PositionNotFoundException;
	public List<PositionsPoints> getAllPosition();
	public boolean isAvailable(Long id);
	public PositionsPoints updatePosition(PositionsPoints positionPoints, Long id) throws PositionNotFoundException, PositionAlreadyFullException;
	
	//public List<PositionsPoints> getAvailablePositions();
	/*public static PositionsPoints createPosition(PositionsPoints positionPoints)
	{
		return null;
	}*/
	//List<PositionsPoints> findByIsAvailable(boolean isAvailable);
	//public  List<PositionsPoints> existsById(List<Long> id);
	public static void updatePositionAvailability(Long id, boolean b)
		{
						
		}
	
    
}

package com.HCLProject.Aladino.Service;

import java.util.List;

import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Positions;


public interface PositionsService {

	public Positions createPosition(Positions positions);
	public void updateposition(String positionOnRack) throws PositionNotFoundException, PositionAlreadyFullException;
	public void deletePosition(Long id) throws PositionNotFoundException;
	public Positions getSinglePosition(Long id) throws PositionNotFoundException;
	public List<Positions> getAllPosition();
	//public Boolean isAvailable(Long id);
	public Positions updatePosition(Positions positions, Long id) throws PositionNotFoundException, PositionAlreadyFullException;
}




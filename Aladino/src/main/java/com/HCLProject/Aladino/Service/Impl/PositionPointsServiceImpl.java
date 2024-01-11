package com.HCLProject.Aladino.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.PositionsPoints;
import com.HCLProject.Aladino.Repo.PositionPointsRepo;
import com.HCLProject.Aladino.Service.PositionPointsService;




@Service
public class PositionPointsServiceImpl  implements PositionPointsService{
	@Autowired
	private PositionPointsRepo positionPointsRepo;

//create
	public PositionsPoints createPosition(PositionsPoints positionPoints) {
	
		return this.positionPointsRepo.save(positionPoints);
	}

//	delete
	public void deletePosition(Long id) throws PositionNotFoundException {
		if(positionPointsRepo.findById(id) != null) 
			{
		this.positionPointsRepo.deleteById(id);
			}else {
				throw new PositionNotFoundException(id);
			}
		
	}

//get single
	public PositionsPoints getSinglePosition(Long id) throws PositionNotFoundException {
	
		 Optional<PositionsPoints> findById = this.positionPointsRepo.findById(id);
		 if(findById.isPresent())
			 {
				 return findById.get();
			 }else {
				 throw new PositionNotFoundException(id);
				 //throw new PositionNotFoundException("Position with id " + id + " not found.");
			 }
	}

//get All
	public List<PositionsPoints> getAllPosition() {
		
		return this.positionPointsRepo.findAll();
	}

//isAvailable
	public boolean isAvailable(Long id)
		{
			Optional<PositionsPoints> findById = positionPointsRepo.findById(id);
			if(findById.isPresent()) {
				PositionsPoints positionsPoints = findById.get();
				boolean available = positionsPoints.getIsAvailable();
				//update the availability to the opposite value
				
				positionsPoints.setIsAvailable(!available);
				positionPointsRepo.save(positionsPoints);
				return !available;
			} else {
				throw new EntityNotFoundException("Box Position is not found wiht id: "+id);
			}
			
		}
	

	
//update

	public void updateposition(String positionOnRack) throws PositionNotFoundException,PositionAlreadyFullException
		{
			Optional<PositionsPoints> findBypositionOnRack = PositionPointsRepo.findBypositionOnRack(positionOnRack);
			if(findBypositionOnRack.isEmpty())
				{
					throw new PositionNotFoundException(" Position is Empty on Rack" + positionOnRack);
				}
			PositionsPoints positionsPoints = findBypositionOnRack.get();
			
			if(positionsPoints.getIsAvailable())
				{
					throw new  PositionAlreadyFullException("Position already full: " + positionOnRack);
				}
			
			positionsPoints.setIsAvailable(true);
			positionPointsRepo.save(positionsPoints);

		}

	@Override
	public PositionsPoints updatePosition(PositionsPoints positionPoints, Long id) throws PositionNotFoundException, PositionAlreadyFullException
		{
		 Optional<PositionsPoints> findById = positionPointsRepo.findById(id);
        if (findById.isPresent()) {
             PositionsPoints  existingPositionPoint = findById.get();
           	existingPositionPoint.setX(positionPoints.getX());
            existingPositionPoint.setY(positionPoints.getY());
            existingPositionPoint.setZ(positionPoints.getZ());
            existingPositionPoint=positionPoints;
            return positionPointsRepo.save(positionPoints);
        } else {
            throw new PositionNotFoundException(id);
        }
   }
}
		
	/*	//PositionsPoints update = this.positionPointsRepo.save(positionPoints);
		if(positionPoints.getIsAvailable())
			{
				throw new PositionNotFoundException(" Position is Empty on Rack" + positionPoints);
			}
		String positionOnRack = positionPoints.getPositionOnRack();
		if(positionOnRack.isEmpty())
			{
				throw new  PositionAlreadyFullException("Position already full: " + positionOnRack);
			}
		 positionPoints.setIsAvailable(true);
		 positionPointsRepo.save(positionPoints);
		
	}
	*/

	
	

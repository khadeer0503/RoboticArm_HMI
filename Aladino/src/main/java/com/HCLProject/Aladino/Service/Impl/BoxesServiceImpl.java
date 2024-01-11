package com.HCLProject.Aladino.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.PositionsPoints;
import com.HCLProject.Aladino.Repo.BoxesRepo;
import com.HCLProject.Aladino.Repo.PositionPointsRepo;
import com.HCLProject.Aladino.Service.BoxesService;
import com.HCLProject.Aladino.Service.PositionPointsService;



@Service
public class BoxesServiceImpl implements BoxesService {
	
	@Autowired
	private BoxesRepo boxesRepo;
	
	//getterBoxes
	public BoxesRepo getBoxesRepo() {
		return boxesRepo;
	}
	//setter Boxes
	public void setBoxesRepo(BoxesRepo boxesRepo) {
		this.boxesRepo = boxesRepo;
	}

//Create Box Method
	@Override
	public Boxes saveBox(Boxes boxes) {
		
		return this.boxesRepo.save(boxes);
	}
	
//Get single Box by Id method
		@Override
		public Boxes findbyId(Long id) throws BoxNotFoundException {
			Optional<Boxes> findById = this.boxesRepo.findById(id);
			if(findById.isPresent())
			{
				return findById.get();
			}
			throw new BoxNotFoundException("Could not found Box with id" + id);
			
		}
		
//Delete Box Method
		@Override
		public void deleteBoxesById(Long id) {
			this.boxesRepo.deleteById(id);;
			
		}
		
// Get All Boxes as a list method
		@Override
		public List<Boxes> getAllBoxes() {
			
			return this.boxesRepo.findAll();
		}
		
// Update Box method
	
	@Override
	public void updateBoxes(Long id,Boxes boxes) throws BoxNotFoundException, PositionNotFoundException, PositionAlreadyFullException {
	    Optional<Boxes> findById = boxesRepo.findById(id);
	    if(findById.isPresent()) {
	        Boxes updatedBox = findById.get();
	        updatedBox.setName(boxes.getName());
	        updatedBox.setWeight(boxes.getWeight());
	        updatedBox.setDimension(boxes.getDimension());
	     //   PositionsPoints currentPosition = 
	        		updatedBox.getpositionsPoints();
	    
	  /*      if(currentPosition != null) {
	            currentPosition.setAvailable(true);
	            PositionPointsService.updatePositionAvailability(currentPosition.getId(), true);
	            
	        }
	        PositionsPoints newPosition = boxes.getpositionsPoints();
	        if(newPosition != null) {
	            Optional<PositionsPoints> findByPositionOnRack = PositionPointsRepo.findBypositionOnRack(newPosition.getPositionOnRack());
	            if(findByPositionOnRack.isPresent()) {
	                PositionsPoints availablePosition = findByPositionOnRack.get();
	                if(availablePosition.isAvailable()) {
	                    updatedBox.setpositionsPoints(availablePosition);
	                    availablePosition.setAvailable(false);
	                    PositionPointsService.updatePositionAvailability(availablePosition.getId(), false);
	                } else {
	                    throw new PositionAlreadyFullException("Position already full: " + newPosition.getPositionOnRack());
	                }
	            } else {
	                newPosition.setAvailable(false);
	                updatedBox.setpositionsPoints(PositionPointsService.createPosition(newPosition));
	            }
	        }
	        */
	        boxesRepo.save(updatedBox);
	    } else {
	        throw new BoxNotFoundException("Could not find Box with id " + id);
	    }
	}

	
/*	@Override
	public void updateBoxes(Long id,Boxes boxes) {
		
		this.boxesRepo.save(boxes);
	}
	

	@Override
	public List<PositionsPoints> getAvailablePositions() {
		return this.boxesRepo.findAvailablePositions();
    }

*/
	
	
}

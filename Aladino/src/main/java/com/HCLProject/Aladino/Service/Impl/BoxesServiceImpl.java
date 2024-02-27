package com.HCLProject.Aladino.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Repo.BoxesRepo;
import com.HCLProject.Aladino.Service.BoxesService;


@Service
public class BoxesServiceImpl implements BoxesService {

@Autowired
private BoxesRepo boxesRepo;

public BoxesRepo getBoxesRepo() {		return boxesRepo;	}
public void setBoxesRepo(BoxesRepo boxesRepo) {		this.boxesRepo = boxesRepo;	}

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
			this.boxesRepo.deleteById(id);

		}

// Get All Boxes as a list method
		@Override
		public List<Boxes> getAllBoxes() {

			return this.boxesRepo.findAll();
		}

// Update Box method

	@Override
	public Boxes updateBoxes(Long id,Boxes boxes) throws BoxNotFoundException, PositionNotFoundException, PositionAlreadyFullException {
	    Optional<Boxes> findById = boxesRepo.findById(id);
	    if(findById.isPresent()) {
	        Boxes updatedBox = findById.get();
	        updatedBox.setName(boxes.getName());
	        updatedBox.setWeight(boxes.getWeight());
	        updatedBox.setDimension(boxes.getDimension());
	       // updatedBox.setpositionsPoints(boxes.getpositionsPoints());
		//	updatedBox.setRobotWithBox(boxes\	`.getRobotWithBox());

	    Boxes box=this.boxesRepo.save(updatedBox);
	    } else {
	    throw new BoxNotFoundException("Could not find Box with id " + id);
	    }
		return boxes;
	}

//pickBoxAndMoveToRobot
// 	@Override
// 	public void pickBoxAndMoveToRobot(Long boxId) {
// 	Boxes box=this.boxesRepo.findById(boxId).orElse(null);
// 	if(box !=null){
// 	// Update box status
// 		box.setStatus("With Robot");
// 		boxesRepo.save(box);
// 	// Create entry in RobotWithBox database
// 	RobotWithBox robotWithBox = new RobotWithBox();
// 	// set fields accordingly
// //	robotWithBox.setBox(box);
// 	robotWithBoxRepo.save(robotWithBox);
// 	}
// 	}
}

	//udpate
	  /*      if(currentPosition != null) {
	            currentPosition.setAvailable(true);
	            PositionPointsService.updatePositionAvailability(currentPosition.getId(), true);

	        }
	        Positions newPosition = boxes.getpositionsPoints();
	        if(newPosition != null) {
	            Optional<Positions> findByPositionOnRack = PositionPointsRepo.findBypositionOnRack(newPosition.getPositionOnRack());
	            if(findByPositionOnRack.isPresent()) {
	                Positions availablePosition = findByPositionOnRack.get();
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

/*	@Override
	public void updateBoxes(Long id,Boxes boxes) {

		this.boxesRepo.save(boxes);
	}

	@Override
	public List<Positions> getAvailablePositions() {
		return this.boxesRepo.findAvailablePositions();
    }

*/


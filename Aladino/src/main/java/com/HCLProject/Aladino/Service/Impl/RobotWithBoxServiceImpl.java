package com.HCLProject.Aladino.Service.Impl;

import com.HCLProject.Aladino.Exception.BoxNotFoundException;
import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.RobotWithBox;
import com.HCLProject.Aladino.Repo.RobotWithBoxRepo;
import com.HCLProject.Aladino.Service.BoxesService;
import com.HCLProject.Aladino.Service.RobotWithBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RobotWithBoxServiceImpl implements RobotWithBoxService {


    @Autowired
    private RobotWithBoxRepo robotWithBoxRepo;

    @Autowired
    private BoxesService boxesService;

    public RobotWithBoxRepo getRobotWithBoxRepo() {   return robotWithBoxRepo;    }

    public void setRobotWithBoxRepo(RobotWithBoxRepo robotWithBoxRepo) { this.robotWithBoxRepo = robotWithBoxRepo;  }

    public BoxesService getBoxesService() { return boxesService;   }

    public void setBoxesService(BoxesService boxesService) { this.boxesService = boxesService;   }




    @Override
    public Boolean isPresent(Long id) {
        Optional<RobotWithBox> robotWithBoxRepoById = this.robotWithBoxRepo.findById(id);
        return null;
    }


    // Assuming pickBox() method is called when the robot picks a box
    public void pickBox(Long id) throws BoxNotFoundException {
         // Get the box from the main database
        Boxes box = boxesService.findbyId(id);
        if (box != null) {
            // Save the box to the robot's database
            boxesService.saveBox(box);
            // Delete the box from the main database
            boxesService.deleteBoxesById(id);
        }
    }
}
/*
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

		*/
package com.HCLProject.Aladino.Service.Impl;

import com.HCLProject.Aladino.Exception.PositionAlreadyFullException;
import com.HCLProject.Aladino.Exception.PositionNotFoundException;
import com.HCLProject.Aladino.Model.Positions;
import com.HCLProject.Aladino.Repo.PositionsRepo;
import com.HCLProject.Aladino.Service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PositionsServiceImpl  implements PositionsService{
	@Autowired
	private PositionsRepo positionsRepo;

//create
	public Positions createPosition(Positions positions) {

		return this.positionsRepo.save(positions);
	}

//	delete
	public void deletePosition(Long id) throws PositionNotFoundException {
		if(positionsRepo.findById(id) != null)
			{
		this.positionsRepo.deleteById(id);
			}else {
				throw new PositionNotFoundException(id);
			}

	}

//get single
	public Positions getSinglePosition(Long id) throws PositionNotFoundException {

		Optional<Positions> findById = this.positionsRepo.findById(id);
		if(findById.isPresent())
			{
				return findById.get();
			}else {
				throw new PositionNotFoundException(id);
				 //throw new PositionNotFoundException("Position with id " + id + " not found.");
			}
	}

//get All
	public List<Positions> getAllPosition() {
		return this.positionsRepo.findAll();
	}

//update
	@Override
	public Positions updatePosition(Positions positions, Long id) throws PositionNotFoundException, PositionAlreadyFullException
		{
		Optional<Positions> findById = positionsRepo.findById(id);
        if (findById.isPresent()) {
            Positions existingPositionPoint = findById.get();
//           	existingPositionPoint.setX(positionPoints.getX());
//            existingPositionPoint.setY(positionPoints.getY());
//            existingPositionPoint.setZ(positionPoints.getZ());
            existingPositionPoint=positions;
            return positionsRepo.save(positions);
        } else {
            throw new PositionNotFoundException(id);
        }
}

	@Override
	public void updateposition(String positionOnRack) throws PositionNotFoundException, PositionAlreadyFullException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateposition'");
	}
}

	/*	//Positions update = this.positionPointsRepo.save(positionPoints);
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



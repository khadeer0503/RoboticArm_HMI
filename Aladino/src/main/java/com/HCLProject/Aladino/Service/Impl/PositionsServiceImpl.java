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
	@SuppressWarnings("null")
	public Positions createPosition(Positions positions) {

		return this.positionsRepo.save(positions);
	}

//	delete
	public void deletePosition(Long id) throws PositionNotFoundException {
		this.positionsRepo.deleteById(id);

	}

//get single
	public Positions getSinglePosition(Long id) throws PositionNotFoundException {

		@SuppressWarnings("null")
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
		@SuppressWarnings("null")
		Optional<Positions> findById = positionsRepo.findById(id);
        if (findById.isPresent()) {
            Positions existingPosition = findById.get();
            existingPosition=positions;
            return positionsRepo.save(positions);
        } else {
            throw new PositionNotFoundException(id);
        }
}

}




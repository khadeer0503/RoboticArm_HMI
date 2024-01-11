package com.HCLProject.Aladino.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HCLProject.Aladino.Model.PositionsPoints;


@Repository
public interface PositionPointsRepo extends JpaRepository<PositionsPoints, Long>{

	static Optional<PositionsPoints> findBypositionOnRack(String positionOnRack)
		{
			// TODO Auto-generated method stub
			return null;
		}

}	
	

//List<PositionsPoints> existsById(boolean isAvailable);//(boolean isAvailable);
	// findByIdIn(List<Long> ids);

	//PositionPointsService save(PositionPointsService positionPoints);



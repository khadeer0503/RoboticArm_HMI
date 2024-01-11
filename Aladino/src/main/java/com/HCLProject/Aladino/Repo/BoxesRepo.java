package com.HCLProject.Aladino.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HCLProject.Aladino.Model.Boxes;
import com.HCLProject.Aladino.Model.PositionsPoints;


@Repository
public interface BoxesRepo extends JpaRepository<Boxes, Long> {

/*	
	@Query("SELECT p FROM PositionsPoints p WHERE p NOT IN (SELECT b.positionsPoints FROM Boxes b)")
    List<PositionsPoints> findAvailablePositions();
    */
}

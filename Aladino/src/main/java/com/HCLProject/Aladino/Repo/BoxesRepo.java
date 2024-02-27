package com.HCLProject.Aladino.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HCLProject.Aladino.Model.Boxes;


@Repository
public interface BoxesRepo extends JpaRepository<Boxes, Long> {

/*	
	@Query("SELECT p FROM Positions p WHERE p NOT IN (SELECT b.positionsPoints FROM Boxes b)")
    List<Positions> findAvailablePositions();
    */
}

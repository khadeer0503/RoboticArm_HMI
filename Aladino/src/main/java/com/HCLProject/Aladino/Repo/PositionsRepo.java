package com.HCLProject.Aladino.Repo;
import com.HCLProject.Aladino.Model.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionsRepo extends JpaRepository<Positions, Long>{
}




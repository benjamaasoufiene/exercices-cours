package fr.orsys.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import fr.orsys.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long>{

	public Formation findByCode(String code);

}

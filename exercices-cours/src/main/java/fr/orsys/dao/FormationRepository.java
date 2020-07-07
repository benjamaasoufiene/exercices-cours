package fr.orsys.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.orsys.entities.Formation;
import fr.orsys.entities.Participant;


public interface FormationRepository extends JpaRepository<Formation, Long>{
	public Formation findByCode(String code);
/*	@Query("Select * from participant p, formation f WHERE code like :x")
	public Page<Participant> rechercheParticipant(String code, Pageable pageable);
*/
}

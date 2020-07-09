package fr.orsys.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.orsys.entities.Formation;
import fr.orsys.entities.Participant;


public interface FormationRepository extends JpaRepository<Formation, Long>{
	public Formation findByCode(String code);
	/*
	 * select distinct distributor 
from Distributor distributor  
join distributor.towns town 
join town.district district 
where district.name = :name
	 
	@Query("SELECT participant FROM  Formation f WHERE f.code like :x")
	public Page<Participant> findAllParticipantByCode(@Param("x")String code,Pageable pageable);
*/

	public Page<Participant> findParticipantByCode(String code, Pageable pageable);

	public Page<Participant> findByCode(String code, Pageable pageable);
}

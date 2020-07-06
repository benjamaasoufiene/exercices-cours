package fr.orsys.dao;


import java.awt.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


import fr.orsys.entities.Formation;
import fr.orsys.entities.Participant;


public interface FormationRepository extends JpaRepository<Formation, Long>{
	public Formation findByCode(String code);

	public Page<Participant> findAllParticipantByCode(String code, PageRequest of);

}

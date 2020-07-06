package fr.orsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}

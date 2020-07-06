package fr.orsys;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.orsys.dao.CentreRepository;
import fr.orsys.dao.ContactRepository;
import fr.orsys.dao.FormateurRepository;
import fr.orsys.dao.FormationRepository;
import fr.orsys.dao.ParticipantRepository;
import fr.orsys.entities.Centre;
import fr.orsys.entities.Contact;
import fr.orsys.entities.Formateur;
import fr.orsys.entities.Formation;
import fr.orsys.entities.FormationIntra;
import fr.orsys.entities.Participant;

@SpringBootApplication
public class ExercicesCoursApplication {
	public static void main(String[] args) {
		/*******************/
		ApplicationContext ctx = SpringApplication.run(ExercicesCoursApplication.class, args);
		ContactRepository contactsRepository = ctx.getBean(ContactRepository.class);
		Contact co1 = new Contact(null, "m1@orsys.fr", 123456, 123456);
		Contact co2 = new Contact(null, "m2@orsys.fr", 456789, 456789);
		contactsRepository.save(co1);
		contactsRepository.save(co2);
		FormateurRepository formateursRepository = ctx.getBean(FormateurRepository.class);
		Formateur fte1 = new Formateur(null, "BEN JAMAA", "Soufiene");
		Formateur fte2 = new Formateur(null, "ASSAS", "Anis");
		Formateur fte3 = new Formateur(null, "FRIAA", "Iskander");
		List<Formateur> formateurs = Arrays.asList(fte1, fte2, fte3);
		formateursRepository.saveAll(formateurs);
		ParticipantRepository participantRepository = ctx.getBean(ParticipantRepository.class);
		Participant pa1 = new Participant(null, "Lionel", "Messi", 33);
		Participant pa2 = new Participant(null, "Cristiano", "Ronaldo", 35);
		Participant pa3 = new Participant(null, "Kylian", "Mbappé", 22);
		List<Participant> participants = Arrays.asList(pa1, pa2, pa3);
		participantRepository.saveAll(participants);
		CentreRepository centresRepository = ctx.getBean(CentreRepository.class);
		Centre centParis = new Centre();
		centParis.setNom("orsys-paris");
		centParis.setDescription("orsys paris");
		centParis.setContact(co1);
		Centre centNantes = new Centre();
		centNantes.setNom("orsys-nantes");
		centNantes.setDescription("orsys nantes");
		centNantes.setContact(co2);
		List<Centre> centres = Arrays.asList(centParis, centNantes);
		centresRepository.saveAll(centres);
		FormationRepository formationsRepository = ctx.getBean(FormationRepository.class);
		Formation fmMere = new Formation();
		fmMere.setCode("SPG");
		fmMere.setCentre(centParis);
		fmMere.setFormateur(fte1);
		fmMere.setParticipant(participants);
		Formation fmIntra= new FormationIntra("Paris");
		fmIntra.setCode("RAC");
		fmIntra.setFormateur(fte2);
		fmIntra.setCentre(centNantes);
		fmIntra.setParticipant(participants);
		Formation fmInter= new FormationIntra("Nantes");
		fmInter.setCode("Java");
		fmInter.setFormateur(fte2);
		fmInter.setCentre(centNantes);
		fmInter.setParticipant(participants);
		List<Formation> formations = Arrays.asList(fmMere, fmIntra,fmInter);
		formationsRepository.saveAll(formations);
		centParis.setFormation(formations);
		centNantes.setFormation(formations);
		centresRepository.save(centParis);
		centresRepository.save(centNantes);
	}

}

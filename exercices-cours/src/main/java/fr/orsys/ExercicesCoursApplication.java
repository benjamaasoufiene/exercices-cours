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
import fr.orsys.entities.FormationInter;
import fr.orsys.entities.FormationIntra;
import fr.orsys.entities.Participant;

@SpringBootApplication
public class ExercicesCoursApplication {
	public static void main(String[] args) {
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
		Participant pa1 = new Participant();
		Participant pa2 = new Participant();
		Participant pa3 = new Participant();
		pa1.setAge(33);
		pa1.setNom("Lionel");
		pa1.setPrenom("Messi");
		pa2.setAge(35);
		pa2.setNom("Cristiano");
		pa2.setPrenom("Ronaldo");
		pa3.setAge(22);
		pa3.setNom("Kylian");
		pa3.setPrenom("Mbappé");
		List<Participant> participants = Arrays.asList(pa1, pa2, pa3);
		CentreRepository centresRepository = ctx.getBean(CentreRepository.class);
		Centre centParis = new Centre();centParis.setNom("orsys-paris");
		centParis.setDescription("orsys paris");centParis.setContact(co1);
		Centre centNantes = new Centre();centNantes.setNom("orsys-nantes");
		centNantes.setDescription("orsys nantes");centNantes.setContact(co2);
		List<Centre> centres = Arrays.asList(centParis, centNantes);
		centresRepository.saveAll(centres);
		FormationRepository formationsRepository = ctx.getBean(FormationRepository.class);
		Formation fmIntra1 = new FormationIntra("Paris");
		fmIntra1.setCode("SPG");fmIntra1.setTheme("Spring MVC");fmIntra1.setPrix(2890);
		fmIntra1.setCentre(centParis);fmIntra1.setFormateur(fte1);fmIntra1.setParticipant(participants);
		Formation fmIntra2= new FormationIntra("Paris");fmIntra2.setCode("RAC");fmIntra2.setTheme("React");
		fmIntra2.setPrix(2050);fmIntra2.setFormateur(fte2);
		fmIntra2.setCentre(centNantes);fmIntra2.setParticipant(participants);
		Formation fmInter= new FormationInter();
		fmInter.setCode("JVA");fmInter.setTheme("Java");fmInter.setPrix(2650);fmInter.setTheme("Java 8");
		fmInter.setPrix(2050);fmInter.setFormateur(fte2);fmInter.setCentre(centNantes);
		fmInter.setParticipant(participants);
		List<Formation> formations = Arrays.asList(fmIntra1, fmIntra2,fmInter);
		formationsRepository.saveAll(formations);
		pa1.setFormation(formations);
		pa2.setFormation(formations);
		pa3.setFormation(formations);
		participantRepository.saveAll(participants);
		centParis.setFormation(formations);
		centNantes.setFormation(formations);
		centresRepository.save(centParis);
		centresRepository.save(centNantes);
		}


}







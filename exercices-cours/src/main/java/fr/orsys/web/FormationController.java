package fr.orsys.web;
import java.text.DateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.orsys.dao.FormationRepository;

import fr.orsys.entities.Formation;
;

@Controller
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;

	@RequestMapping(value = "/consulterformation")
	public String consulterformation(Model model, @RequestParam(name = "code", defaultValue = "") String code) {
		System.out.println("Code de la formation: " + code);
		Formation f = formationRepository.findByCode(code);
		System.out.println("Theme de la formation: " + f.getTheme());
		System.out.println("Prix de la formation: " + f.getPrix());
		Date time = new Date();
		DateFormat d = DateFormat.getDateInstance(DateFormat.FULL);
		model.addAttribute("dateSys", d.format(time));
		model.addAttribute("formation", f);	
		model.addAttribute("listeParticipants",f.getParticipant());
		return "formations";
	}
	@RequestMapping(value = "/formations")
	public String formations() {
		return "formations";
	}
}

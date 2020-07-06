package fr.orsys.web;



import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import fr.orsys.dao.FormationRepository;
import fr.orsys.entities.Formation;


@Controller
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;
	@RequestMapping(value = "/formations")
	public String formations() {
		return "formations";
	}

	@RequestMapping(value = "/consulterformation")
	public String consulterformation(Model model, @RequestParam(name = "code", defaultValue = "") String code) {
		System.out.println("mot Clés: "+ code);
		Formation f= formationRepository.findByCode(code);
		model.addAttribute("formation", "Spring MVC");
		//model.addAttribute("formation", "Spring MVC");
	//	recherchePM
		return "formations";
	}
}


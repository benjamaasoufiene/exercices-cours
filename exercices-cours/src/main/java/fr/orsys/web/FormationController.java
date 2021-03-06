package fr.orsys.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import fr.orsys.dao.FormationRepository;

import fr.orsys.entities.Formation;
import fr.orsys.entities.Participant;


@Controller
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;

	@RequestMapping(value = "/admin/consulterformation")
	public String consulterformation(Model model, @RequestParam(name = "code", defaultValue = "") String code,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {
		try {
			Formation f = formationRepository.findByCode(code);
			Date time = new Date();
			DateFormat d = DateFormat.getDateInstance(DateFormat.FULL);
			model.addAttribute("dateSys", d.format(time));
			model.addAttribute("formation", f);
			PagedListHolder<Participant> page = new PagedListHolder<Participant>(
					(List<Participant>) f.getParticipant());
			page.setPageSize(s);
			page.setPage(p);
			model.addAttribute("listeParticipants", page.getPageList());
			model.addAttribute("activePage", p);
			model.addAttribute("taillePagination", IntStream.range(0, page.getPageCount()).toArray());
		} catch (Exception e) {
			model.addAttribute("error","Vous devez entrer un code au format correct!");
		}
		return "formations";
	}

	@RequestMapping(value = "/admin/modifierPrixformation", method = RequestMethod.POST)
	public String modifierPrixformation(Model model, @RequestParam(name = "code", defaultValue = "") String code,
	@RequestParam(name = "prix", defaultValue = "0") Double prix) {
	Formation f = formationRepository.findByCode(code);
	f.setPrix(prix);
	formationRepository.save(f);
	model.addAttribute("code", code);
	return "redirect:/consulterformation?code="+code;
	}

	

	@RequestMapping({ "/", "/admin/formations" })
	public String formations() {
		return "formations";
	}
	@RequestMapping(value="/403")
	public String accessDenid() {
		return "403";
	}
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}

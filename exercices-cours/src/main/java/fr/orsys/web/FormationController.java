package fr.orsys.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.orsys.dao.FormationRepository;

import fr.orsys.entities.Formation;
import fr.orsys.entities.Participant;
import javassist.expr.NewArray;;

@Controller
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;

	@RequestMapping(value = "/consulterformation")
	public String consulterformation(Model model, @RequestParam(name = "code", defaultValue = "") String code,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "2") int s) {
		System.out.println("Code de la formation: " + code);
		Formation f = formationRepository.findByCode(code);
		System.out.println("Theme de la formation: " + f.getTheme());
		System.out.println("Prix de la formation: " + f.getPrix());
		Date time = new Date();
		DateFormat d = DateFormat.getDateInstance(DateFormat.FULL);
		model.addAttribute("dateSys", d.format(time));
		model.addAttribute("formation", f);
		PagedListHolder<Participant> page = new PagedListHolder<Participant>((List<Participant>) f.getParticipant());
		page.setPageSize(s);
		page.setPage(p);
		model.addAttribute("listeParticipants", page.getPageList());
		model.addAttribute("taillePagination", IntStream.range(0, page.getPageCount()).toArray());
		return "formations";
	}

	@RequestMapping(value = "/formations")
	public String formations() {
		return "formations";
	}
}

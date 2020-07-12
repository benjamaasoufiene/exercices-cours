package fr.orsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormateurController {
	
	@RequestMapping(value = "/admin/formateurs")
	public String formateurs() {
		return "formateurs";
	}
}

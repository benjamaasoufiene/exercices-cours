package fr.orsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	 
	@RequestMapping(value = "/user/contacts")
	public String contacts() {
		return "contacts";
	}

}

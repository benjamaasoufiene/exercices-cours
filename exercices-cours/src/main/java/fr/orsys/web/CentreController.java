package fr.orsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CentreController {

	@RequestMapping(value = "/user/centres")
	public String centres() {
		return "centres";
	}

}

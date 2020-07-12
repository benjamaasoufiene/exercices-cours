package fr.orsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParticipantController {

	@RequestMapping(value = "/user/participants")
	public String participants() {
		return "participants";
	}

}

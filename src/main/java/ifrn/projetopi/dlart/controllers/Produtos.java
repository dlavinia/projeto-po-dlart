package ifrn.projetopi.dlart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Produtos {
	
	@RequestMapping("/")
	public String GetEvents() {
		return "Home";
	}

}

package fr.sio.items.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.w3c.dom.Element;

@controller
@SessionAttributes("items")
public class MainController {
	@GetMapping
	public String index() {
		return "index";
	}

	@ModelAttribute("items")
	public List<Element> getItems() {
		return new ArrayList<>();
	}

	@GetMapping("add/{name}")
	public @ResponseBody String addItem(@PathVariable String name, @SessionAttribute List<Element> items) {
		items.add(new Element(name));
		return "Element ajouté";

	}

}

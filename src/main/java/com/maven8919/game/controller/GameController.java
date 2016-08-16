package com.maven8919.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maven8919.game.model.Participants;

@Controller
public class GameController {

	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String participants(Model model) {
		model.addAttribute("participants", new Participants());
		return "game";
	}
}

package app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Sport;
import app.services.SportService;


@RestController
@RequestMapping("/sport")
public class SportController {

	@Autowired
	private SportService sportService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createSport(@Validated @RequestBody Sport sport) {
		return sportService.create(sport);	
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Sport> getSports() {
		return sportService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{sportId}")
	public Sport getSportById(@PathVariable("sportId") String sportId) {
		return sportService.findById(sportId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{sportId}")
	public String removeSport(@PathVariable("sportId") String sportId) {
		return sportService.remove(sportId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> updateSport(@Validated @RequestBody Sport sport) {
		return sportService.edit(sport);	
	}

}

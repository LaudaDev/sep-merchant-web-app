package app.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Region;
import app.services.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	private RegionService regionService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createRegion(@RequestBody Region region) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();

		if (region != null) {
			regionService.create(region);
			response.put("message", "Region created successfully");
			response.put("region", region);
		} else {
			response.put("message", "Region is null");

		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Region> getRegions() {
		return (List<Region>) regionService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{regionId}")
	public Region getRegionById(@PathVariable("regionId") String regionId) {
		return regionService.findById(regionId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{regionId}")
	public String removeRegion(@PathVariable("regionId") String regionId) {
		regionService.remove(regionId);
		return "removed";
	}
	
}

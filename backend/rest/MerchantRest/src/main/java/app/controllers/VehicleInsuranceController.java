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

import app.model.Vehicle;
import app.services.VehicleInsuranceService;

@RestController
@RequestMapping("/vehicle")
public class VehicleInsuranceController {

	@Autowired
	private VehicleInsuranceService vehicleService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createVehicle(@Validated @RequestBody Vehicle vehicle) {
		
		return vehicleService.create(vehicle);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicle> getAll() {
		return (List<Vehicle>) vehicleService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{vehicleId}")
	public Vehicle getVehicleById(@PathVariable("vehicleId") String vehicleId) {
		return vehicleService.findById(vehicleId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{vehicleId}")
	public String removeVehicle(@PathVariable("vehicleId") String vehicleId) {
		return vehicleService.remove(vehicleId);
	}
	
}

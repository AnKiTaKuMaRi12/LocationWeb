package com.PresentationLayer.locationWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PresentationLayer.locationWeb.Entity.LocationEntity;
import com.PresentationLayer.locationWeb.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
	@Autowired
	LocationRepository locationrepository;
	
	@GetMapping
	public List<LocationEntity> getLocations(){
		return locationrepository.findAll();
		
	}
	@PostMapping
	public LocationEntity createLocation(@RequestBody LocationEntity location) {
		return locationrepository.save(location);
	}
	
	@PutMapping
	public LocationEntity updateLocation(@RequestBody LocationEntity location) {
		return locationrepository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationrepository.deleteById(id);
	}
}

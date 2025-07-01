package com.PresentationLayer.locationWeb.Controller;



import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PresentationLayer.locationWeb.Entity.LocationEntity;
import com.PresentationLayer.locationWeb.Service.LocationService;
import com.PresentationLayer.locationWeb.repos.LocationRepository;

import com.PresentationLayer.locationWeb.util.EmailUtil;
import com.PresentationLayer.locationWeb.util.ReportUtil;

import jakarta.servlet.ServletContext;



@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
//	@Autowired
//	locationRepository repository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	@Autowired
	ServletContext sc;
	
//	@Autowired
//	ReportUtil reportUtil;
//	
//	@Autowired
//	ServletContext sc;
	
	
	@GetMapping("/showCreate")
	String showCreate() {
		return "createLocation";
	}
	
	@PostMapping("/saveLoc")
	String saveLocation(@ModelAttribute LocationEntity location,ModelMap modelmap) {
		LocationEntity savedLocation=service.saveLocation(location);
		String msg="Location saved with id:"+savedLocation.getId();
		modelmap.addAttribute("msg",msg);
//		email address,subject,body of the email you sent
		emailUtil.sendEmail("AnkitaTiwary062021@gmail.com", "Location", "Location saved sucessfully");
		return "createLocation";
		}
	
	@GetMapping("/displayLocations")
	String dispalyLocations(ModelMap modelMap) {
		List<LocationEntity> location=service.getAlllocations();
//		locations are refer to the displayLocation.html page.this the reason list of the location are not displayed
		modelMap.addAttribute("locations",location);
		return "displayLocations";
	}
	@GetMapping("/deleteLocation")
	String deleteLocation(@RequestParam int id,ModelMap modelMap) {
		LocationEntity location=new LocationEntity();
		location.setId(id);
		service.deleteLocation(location);
		List<LocationEntity> locations=service.getAlllocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@GetMapping("/showUpdate")
	String showUpdate(@RequestParam int id,ModelMap modelMap) {
		LocationEntity location=service.getLocationById(id);
		modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	@PostMapping("/updateLoc")
	String updateLocation(@ModelAttribute LocationEntity location,ModelMap modelMap) {
		service.updateLocation(location);
		List<LocationEntity>locations=service.getAlllocations();
		modelMap.addAttribute("locations",location);
		return "displayLocations";
	}
//		@RequestMapping("/generateReport")
//		public String generateReport() {
//			String path = sc.getRealPath("/");
//			List<Object[]> data=repository.findTypeAndTypeCount();
//			reportUtil.generatePieChart(path, data);
//			return "report";
//		}
	
	@RequestMapping("/generateReport")
	public String generateReport() {

		String path = new File("src/main/resources/static/images").getAbsolutePath();
		File chartFile = new File(path, "chart.png");

//		String path = sc.getRealPath("/images");
		System.out.println("images are generted");
		
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		System.out.println("images are generted in pie chart");
		return "report";
		
	}
	}


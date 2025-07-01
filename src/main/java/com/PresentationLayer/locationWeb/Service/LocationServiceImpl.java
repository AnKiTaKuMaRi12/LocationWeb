package com.PresentationLayer.locationWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PresentationLayer.locationWeb.Entity.LocationEntity;
import com.PresentationLayer.locationWeb.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repository;
	@Override
	public LocationEntity saveLocation(LocationEntity location) {
		
		return repository.save(location);
	}

	@Override
	public LocationEntity updateLocation(LocationEntity location) {
		
		return repository.save(location);
	}

	@Override
	public void deleteLocation(LocationEntity location) {
		repository.delete(location);
	}

	@Override
	public LocationEntity getLocationById(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public List<LocationEntity> getAlllocations() {
		
		return repository.findAll();
	}

}

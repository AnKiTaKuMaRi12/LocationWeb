package com.PresentationLayer.locationWeb.Service;

import java.util.List;

import com.PresentationLayer.locationWeb.Entity.LocationEntity;

public interface LocationService {
//	where locationEntity is the name of the class
//	saveLocation is method name
	
	LocationEntity saveLocation(LocationEntity location);
	LocationEntity updateLocation(LocationEntity location);
	void deleteLocation(LocationEntity location);
	LocationEntity getLocationById(int id);
	List<LocationEntity> getAlllocations();
}

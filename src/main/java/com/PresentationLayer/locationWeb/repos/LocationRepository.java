package com.PresentationLayer.locationWeb.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PresentationLayer.locationWeb.Entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity,Integer> {
	
	@Query("SELECT l.type, COUNT(l.type) FROM LocationEntity l GROUP BY l.type")
	public List<Object[]> findTypeAndTypeCount();

}

//package com.PresentationLayer.locationWeb.repos;
//
////import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.Query;
//
//import com.PresentationLayer.locationWeb.Entity.LocationEntity;
//
//public interface locationRepository extends JpaRepository<LocationEntity, Integer> {
////	JPA or hibernate will execute this query
////	@Query("SELECT type, COUNT(*) FROM location GROUP BY type")
////	public List<Object[]> findTypeAndTypeCount();
//}
//

package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CityModel;
import org.techhub.Model.LocationModel;
import org.techhub.Repository.*;

public class LocationServiceImpl implements LocationService{

	LocationRepo lRepo=new LocationRepoImpl();

	@Override
	public boolean isAddLocation(LocationModel model) {
		// TODO Auto-generated method stub
		return lRepo.isAddLocation(model);
	}

	@Override
	public List<LocationModel> getAllLocationById(int cityId) {
		// TODO Auto-generated method stub
		return lRepo.getAllLocationById(cityId);
	}

	@Override
	public boolean isDeleteLocationById(int lid) {
		// TODO Auto-generated method stub
		return lRepo.isDeleteLocationById(lid);
	}

	@Override
	public boolean isUpdateLocation(LocationModel model) {
		// TODO Auto-generated method stub
		return lRepo.isUpdateLocation(model);
	}
	

}

package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CityModel;
import org.techhub.Model.StateModel;

public interface CityService {
	public boolean isAddCity(CityModel model);
	public List<CityModel> getAllCitiesById(int stateId);
	public boolean isDeleteCityById(int cid);
	public boolean isUpdateCity(CityModel model);
	
}

package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.CityModel;

public interface CityRepo {
	public boolean isAddCity(CityModel model);
	public List<CityModel> getAllCitiesById(int stateId);
	public boolean isDeleteCityById(int cid);
	public boolean isUpdateCity(CityModel model);

}

package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CityModel;
import org.techhub.Repository.*;

public class CityServiceImpl implements CityService {

	CityRepo cr=new CityRepoImpl();
	
	@Override
	public boolean isAddCity(CityModel model) {
		return cr.isAddCity(model);
	}

	@Override
	public List<CityModel> getAllCitiesById(int stateId) {
		// TODO Auto-generated method stub
		return cr.getAllCitiesById(stateId);
	}

	@Override
	public boolean isDeleteCityById(int cid) {
		// TODO Auto-generated method stub
		return cr.isDeleteCityById(cid);
	}

	@Override
	public boolean isUpdateCity(CityModel model) {
		// TODO Auto-generated method stub
		return cr.isUpdateCity(model);
	}
	

}

package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.CityModel;
import org.techhub.Model.LocationModel;

public interface LocationRepo  {
	public boolean isAddLocation(LocationModel model);
	public List<LocationModel> getAllLocationById(int cityId);
	public boolean isDeleteLocationById(int lid);
	public boolean isUpdateLocation(LocationModel model);
}

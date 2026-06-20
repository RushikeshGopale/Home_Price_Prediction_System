package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.LocationModel;
import org.techhub.Model.PropertyModel;

public interface PropertyRepo {
	public boolean isAddProperty(PropertyModel model);
	public List<PropertyModel> getAllPropertyById(int lId);
	public boolean isDeletePropertyById(int pid);
	public boolean isUpdateProperty(PropertyModel model);
}

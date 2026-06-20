package org.techhub.Service;

import java.util.List;

import org.techhub.Model.PropertyModel;
import org.techhub.Repository.PropertyRepo;
import org.techhub.Repository.PropertyRepoImpl;

public class PropertyServiceImpl implements PropertyService{

	PropertyRepo Prepo=new PropertyRepoImpl();
	@Override
	public boolean isAddProperty(PropertyModel model) {
		// TODO Auto-generated method stub
		return Prepo.isAddProperty(model);
	}

	@Override
	public List<PropertyModel> getAllPropertyById(int lId) {
		// TODO Auto-generated method stub
		return Prepo.getAllPropertyById(lId);
	}

	@Override
	public boolean isDeletePropertyById(int pid) {
		
		return Prepo.isDeletePropertyById(pid);
	}

	@Override
	public boolean isUpdateProperty(PropertyModel model) {
		
		return Prepo.isUpdateProperty(model);
	}

}

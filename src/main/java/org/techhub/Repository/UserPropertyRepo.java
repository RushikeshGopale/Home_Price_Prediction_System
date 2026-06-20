package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.PropertyModel;

public interface UserPropertyRepo {
	public List<Object[]> getPropertyDetailByLoc(int locId);
	public boolean isSelectProperty(PropertyModel model);
}

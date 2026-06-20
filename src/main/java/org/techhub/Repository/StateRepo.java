package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.StateModel;

public interface StateRepo {
	public boolean isAddState(StateModel model);
	public List<StateModel>getAllStates();
	public boolean isDeleteById(int id);
	public boolean isupdateState(StateModel model);
	public List<StateModel> getStateListByName(String name);

}

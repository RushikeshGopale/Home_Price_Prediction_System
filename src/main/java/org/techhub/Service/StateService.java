package org.techhub.Service;

import java.util.List;

import org.techhub.Model.StateModel;

public interface StateService {
	public boolean isAddState(StateModel model);
	public List<StateModel> getAllStates();
	public boolean isDeleteStateById(int stateId);
	public boolean isUpdateState(StateModel model);
	public List<StateModel> getAStateListByName(String name);
 
}

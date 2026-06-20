package org.techhub.Service;

import java.util.List;

import org.techhub.Model.StateModel;
import org.techhub.Repository.*;

public class StateServiceImpl implements StateService {
	StateRepo srepo=new StateRepoImpl();
	
	@Override
	public boolean isAddState(StateModel model) {
		
		
		return srepo.isAddState(model);
	}
	@Override
	public List<StateModel> getAllStates() {
	
		return srepo.getAllStates();
	}
	@Override
	public boolean isDeleteStateById(int stateId) {
		
		return srepo.isDeleteById(stateId);
	}
	@Override
	public boolean isUpdateState(StateModel model) {
		
		return srepo.isupdateState(model);
	}
	@Override
	public List<StateModel> getAStateListByName(String name) {
		// TODO Auto-generated method stub
		return srepo.getStateListByName(name);
	}

}

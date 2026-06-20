package org.techhub.Service;

import java.util.Optional;

import org.techhub.Model.RegisterModel;
import org.techhub.Repository.RegisterRepo;
import org.techhub.Repository.RegisterRepoImpl;

public class RegisterServiceImpl implements RegisterService {

	RegisterRepo rRepo=new RegisterRepoImpl();
	@Override
	public boolean isAddRegister(RegisterModel model) {
		
		return rRepo.isAddRegister(model);
	}
	@Override
	public boolean isUsernameExit(String username) {
		
		return rRepo.isUsernameExit(username);
	}
	@Override
	public Optional<RegisterModel> validateRegister(RegisterModel model) {
		
		return rRepo.validateRegister(model);
	}
	@Override
	public RegisterModel getProfile(int loginuserid) {
		
		return rRepo.getProfile(loginuserid);
	}
	@Override
	public boolean isUpdate(RegisterModel model) {
		
		return rRepo.isUpdate(model);
	}

}

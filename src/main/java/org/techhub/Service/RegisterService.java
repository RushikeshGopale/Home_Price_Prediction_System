package org.techhub.Service;

import java.util.Optional;

import org.techhub.Model.RegisterModel;
import org.techhub.Repository.*;

public interface RegisterService {
	public boolean isAddRegister(RegisterModel model);
	public boolean isUsernameExit(String username);
	public Optional<RegisterModel> validateRegister(RegisterModel model);
	public RegisterModel getProfile(int loginuserid);
	public boolean isUpdate(RegisterModel model) ;

}

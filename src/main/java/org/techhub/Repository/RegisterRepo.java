package org.techhub.Repository;

import java.util.Optional;

import org.techhub.Model.*;

public interface RegisterRepo {
	public boolean isAddRegister(RegisterModel model);
	public boolean isUsernameExit(String username);
	public Optional<RegisterModel> validateRegister(RegisterModel model);
	public RegisterModel getProfile(int loginuserid);
	public boolean isUpdate(RegisterModel model);
}

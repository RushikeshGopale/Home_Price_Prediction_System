package org.techhub.Service;

import java.util.Optional;

import org.techhub.Model.AdminLoginModel;

public interface ValidateAdminService {
	
	public Optional<AdminLoginModel> validateAdmin(AdminLoginModel model);
}

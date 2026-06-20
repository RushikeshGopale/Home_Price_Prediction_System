package org.techhub.Service;

import java.util.Optional;

import org.techhub.Model.AdminLoginModel;
import org.techhub.Repository.ValidateAdminRepo;
import org.techhub.Repository.ValidateAdminRepoImpl;

public class ValidateAdminServiceImpl implements  ValidateAdminService {

	ValidateAdminRepo validateAdminRepo;
	@Override
	public Optional<AdminLoginModel> validateAdmin(AdminLoginModel model) {
		validateAdminRepo=new ValidateAdminRepoImpl();
		return validateAdminRepo.validateAdmin(model);
	}

}

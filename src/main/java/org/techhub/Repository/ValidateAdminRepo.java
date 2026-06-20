package org.techhub.Repository;

import java.util.Optional;

import org.techhub.Model.AdminLoginModel;

public interface ValidateAdminRepo {
	public Optional<AdminLoginModel> validateAdmin(AdminLoginModel model);
}

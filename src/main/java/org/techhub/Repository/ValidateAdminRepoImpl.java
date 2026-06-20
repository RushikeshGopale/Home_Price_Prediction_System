package org.techhub.Repository;

import java.util.Optional;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.AdminLoginModel;

public class ValidateAdminRepoImpl extends DBConfig implements ValidateAdminRepo {

	@Override
	public Optional<AdminLoginModel> validateAdmin(AdminLoginModel model) {
		try {
			stmt=con.prepareStatement("select * from adminlogin where username=? and password=?");
			stmt.setString(1,model.getUsername());
			stmt.setString(2,model.getPassword());
			rs=stmt.executeQuery();
			Optional<AdminLoginModel> o;
			if(rs.next())
			{
				o=Optional.of(model);
			}
			else {
				o=Optional.empty();
			}
			return o;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is:"+e);
			return Optional.empty();
		}
		
		
	}

}

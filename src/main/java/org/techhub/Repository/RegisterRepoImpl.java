package org.techhub.Repository;

import java.util.Optional;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.AdminLoginModel;
import org.techhub.Model.RegisterModel;

public class RegisterRepoImpl extends DBConfig implements RegisterRepo {

	RegisterModel model=new RegisterModel();
	@Override
	public boolean isAddRegister(RegisterModel model) {
		try {
		stmt=con.prepareStatement("insert into register values('0',?,?,?,?,?)");
		stmt.setString(1,model.getRname());
		stmt.setString(2,model.getEmail());
		stmt.setString(3,model.getContact());
		stmt.setString(4,model.getUsername());
		stmt.setString(5,model.getPassword());
		
		int value=stmt.executeUpdate();
		if(value>0)
			return true;
		else
			return false;
		}
		
		catch(Exception e)
		{
			System.out.println("Error is :"+e);
			return false;
		}
		
	}
	public boolean isUsernameExit(String username) {
		try {
			stmt=con.prepareStatement("select * from register where username=?");
			stmt.setString(1,username);
			rs=stmt.executeQuery();
			if(rs.next())
				return true;
			else
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Error is :"+e);
			return false;
		}
		
	}
	@Override
	public Optional<RegisterModel> validateRegister(RegisterModel model) {
		try {
			stmt=con.prepareStatement("select * from register where username=? and password=?");
			stmt.setString(1,model.getUsername());
			stmt.setString(2,model.getPassword());
			rs=stmt.executeQuery();
			Optional<RegisterModel> o;
			if(rs.next())
			{
				RegisterModel m=new RegisterModel();

	            m.setRid(rs.getInt("rid"));
	            m.setRname(rs.getString("name"));
	            m.setEmail(rs.getString("email"));
	            m.setContact(rs.getString("contact"));
	            m.setUsername(rs.getString("username"));
	            m.setPassword(rs.getString("password"));
	            o=Optional.of(m);
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
	@Override
	public RegisterModel getProfile(int loginuserid) {
		try {
			stmt=con.prepareStatement("select * from register where rid=?");
			stmt.setInt(1,loginuserid);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				RegisterModel model=new RegisterModel();
				model.setRname(rs.getString("name"));
				model.setEmail(rs.getString("email"));
				model.setContact(rs.getString("contact"));
				model.setUsername(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				return model;
			}
			
			else
			{
				return null;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return null;
		}
	}
	@Override
	public boolean isUpdate(RegisterModel model) {
		try {
			stmt=con.prepareStatement("update register set name=?,email=?,contact=?,username=? ,password=? where rid=?");
			stmt.setString(1,model.getRname());
			stmt.setString(2,model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4,model.getUsername());
			stmt.setString(5,model.getPassword());
			stmt.setInt(6,model.getRid());

			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	}

}

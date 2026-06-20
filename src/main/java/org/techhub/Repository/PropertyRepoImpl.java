package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.LocationModel;
import org.techhub.Model.PropertyModel;

public class PropertyRepoImpl extends DBConfig implements PropertyRepo{

	PropertyModel model=new PropertyModel();
	List<PropertyModel>proplist;
	@Override
	public boolean isAddProperty(PropertyModel model) {
		try {
			stmt=con.prepareStatement("insert into property values('0',?,?,?,?)");
			stmt.setString(1, model.getPname());
			stmt.setInt(2,model.getSqfeet());
			stmt.setInt(3,model.getPrice());
			stmt.setInt(4,model.getLid());
			int value=stmt.executeUpdate();
			if(value>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			System.out.println("Error is:"+e);
			return false;
		}
	}

	@Override
	public List<PropertyModel> getAllPropertyById(int lId) {
		try {
			proplist=new ArrayList();
			stmt=con.prepareStatement("select * from property where lid=? and status='1'");
			stmt.setInt(1,lId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				PropertyModel model=new PropertyModel();
				model.setPid(rs.getInt(1));
				model.setPname(rs.getString(2));
				model.setSqfeet(rs.getInt(3));
				model.setPrice(rs.getInt(4));
				proplist.add(model);
				
			}
			return proplist;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}

	@Override
	public boolean isDeletePropertyById(int pid) {
		try {
			stmt=con.prepareStatement("update property set status=0 where pid=?");
			stmt.setInt(1,pid);
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
				System.out.println("Error is:"+e);
				return false;
			}
	}

	@Override
	public boolean isUpdateProperty(PropertyModel model) {
		try {
			stmt=con.prepareStatement("update property set pname=?  where pid=?");
			stmt.setString(1, model.getPname());
			stmt.setInt(2,model.getPid());
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

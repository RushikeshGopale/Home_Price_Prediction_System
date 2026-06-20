package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.LocationModel;

public class LocationRepoImpl extends DBConfig implements LocationRepo {

	private List<LocationModel>loclist;
	@Override
	public boolean isAddLocation(LocationModel model) {
		try {
			stmt=con.prepareStatement("insert into location values('0',?,?,'1')");
			stmt.setString(1, model.getLname());
			stmt.setInt(2,model.getCid());
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

	@Override
	public List<LocationModel> getAllLocationById(int cityId) {
		try {
			loclist=new ArrayList();
			stmt=con.prepareStatement("select * from location where cid=? and status='1'");
			stmt.setInt(1,cityId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				LocationModel model=new LocationModel();
				model.setLid(rs.getInt(1));
				model.setLname(rs.getString(2));
				loclist.add(model);
				
			}
			return loclist;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
	}

	@Override
	public boolean isDeleteLocationById(int lid) {
		try {
			stmt=con.prepareStatement("update location set status=0 where lid=?");
			stmt.setInt(1,lid);
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
	public boolean isUpdateLocation(LocationModel model) {
		try {
			stmt=con.prepareStatement("update location set lname=?  where lid=?");
			stmt.setString(1, model.getLname());
			stmt.setInt(2,model.getLid());
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

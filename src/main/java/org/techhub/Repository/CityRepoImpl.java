
package org.techhub.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.CityModel;

public class CityRepoImpl extends DBConfig implements CityRepo{

	List<CityModel> cityList;
	@Override
	public boolean isAddCity(CityModel model) {
		try {
			stmt=con.prepareStatement("insert into city values('0',?,?,?)");
			stmt.setString(1,model.getCname());
			stmt.setInt(2, model.getId());
			stmt.setInt(3,1);
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
	public List<CityModel> getAllCitiesById(int stateId) {
		cityList=new ArrayList<CityModel>();
		try {
			stmt=con.prepareStatement("select * from city where sid=? AND status=1");
			stmt.setInt(1,stateId);
			//stmt.setInt(1,1);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CityModel model=new CityModel();
				model.setCid(rs.getInt(1));
				model.setCname(rs.getString(2));
				cityList.add(model);
			}
			return cityList;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return null;
		}
	}
	@Override
	public boolean isDeleteCityById(int cid) {


		try {
		stmt=con.prepareStatement("update city set status=0 where cid=?");
		stmt.setInt(1,cid);
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
	public boolean isUpdateCity(CityModel model) {
		try {
			stmt=con.prepareStatement("update city set cityname=?  where cid=?");
			stmt.setString(1, model.getCname());
			stmt.setInt(2,model.getCid());
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

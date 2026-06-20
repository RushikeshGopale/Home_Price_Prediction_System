package org.techhub.Repository;
import org.techhub.Repository.*;
import java.sql.SQLException;
import java.util.*;

import org.techhub.DBConfig.*;
import org.techhub.Model.StateModel;

public class StateRepoImpl extends DBConfig implements StateRepo {

	List<StateModel> stateList;
	@Override
	public boolean isAddState(StateModel model) {

		try {
			stmt=con.prepareStatement("insert into state values('0',?,'1')");
			stmt.setString(1,model.getName());
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
	public List<StateModel> getAllStates() {
		try {
			stateList=new ArrayList<StateModel>();
			stmt=con.prepareStatement("select * from state where status=1 order by sid");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				StateModel sm=new StateModel();
				sm.setId(rs.getInt(1));
				sm.setName(rs.getString(2));
				stateList.add(sm);
				
			}
			return stateList;
		}
		catch(Exception e)
		{
			System.out.println("Error is:"+e);
			return null;
		}
	}
@Override
public boolean isDeleteById(int id) {

	try {
	stmt=con.prepareStatement("update state set status=0 where sid=?");
	stmt.setInt(1, id);
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
public boolean isupdateState(StateModel model) {
	
	try {
		stmt=con.prepareStatement("update state set statename=?  where sid=?");
		stmt.setString(1, model.getName());
		stmt.setInt(2,model.getId());
		int value=stmt.executeUpdate();
		if(value>0)
		{
			return true;
		}
		else
			return false;
		
	} catch (SQLException e)
	{
		System.out.println("Error is "+e);
		return false;
	}
}
@Override
public List<StateModel> getStateListByName(String name) {
	
	try {
		stateList=new ArrayList<StateModel>();
		stmt=con.prepareStatement("SELECT sid, statename FROM state WHERE statename LIKE ? AND status = 1 ORDER BY sid");
		stmt.setString(1, "%"+name+"%");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			StateModel sm=new StateModel();
			sm.setId(rs.getInt(1));
			sm.setName(rs.getString(2));
			stateList.add(sm);
		}
		return stateList;
	}
	catch(Exception e)
	{
		System.out.println("Error is:"+e);
		return null;
	}
}

}

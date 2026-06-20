package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.PropertyModel;

public class UserPropertyRepoImpl extends DBConfig implements UserPropertyRepo {

	List<Object[]> proplistByLoc;
	@Override
	public List<Object[]> getPropertyDetailByLoc(int locId) {
		try {
			
			proplistByLoc=new ArrayList<Object[]>();
			stmt=con.prepareStatement("select p.pid,p.pname,p.sqfeet,p.price,l.lname,s.statename,c.cityname from  property p inner join location l on l.lid=p.lid inner join city c on c.cid=l.cid inner join state s on s.sid=c.sid where l.lid=?");
			stmt.setInt(1, locId);
			rs=stmt.executeQuery();
			while(rs.next())
			{System.out.println(rs.getString(1));
				Object obj[]=new Object[] {
						
						rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)
				};
				this.proplistByLoc.add(obj);
			}
			return proplistByLoc;
		}
		catch(Exception e)
		{
			System.out.println("Error is :"+e);
			return null;
		}
	}
	@Override
	public boolean isSelectProperty(PropertyModel model) {
		
		return true;
	}

}

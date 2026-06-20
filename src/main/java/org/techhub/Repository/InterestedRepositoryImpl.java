package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.InterestedModel;

public class InterestedRepositoryImpl extends DBConfig implements InterestedRepository{

	List<Object[]> list;
	@Override
	public boolean isAddInterested(InterestedModel model) {
		try
		{
			stmt=con.prepareStatement("insert into interestedproperty values(0,?,?)");

			stmt.setInt(1,model.getRid());
			stmt.setInt(2,model.getPid());

			int value=stmt.executeUpdate();

			return value>0;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}

	}

	@Override
	public List<Object[]> getWishlist(int rid) {
		 list=new ArrayList<Object[]>();

		try
		{
			stmt=con.prepareStatement("select p.pname,p.sqfeet,p.price,l.lname,s.statename,c.cityname from interestedproperty i inner join property p on i.pid=p.pid inner join location l on p.lid=l.lid inner join city c on l.cid=c.cid inner join state s on c.sid=s.sid where i.rid=?");
			stmt.setInt(1,rid);
			rs=stmt.executeQuery();

			while(rs.next())
			{
				Object obj[]=new Object[]
				{
					rs.getString(1),
					rs.getInt(2),
					rs.getInt(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
				};

				list.add(obj);
			}
			return list;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

	}

	@Override
	public double predictPrice(int lid, double inputX) {
		List<int[]> list=new ArrayList<int[]>();

		try
		{
			stmt=con.prepareStatement("select sqfeet,price from property where lid=?");
			stmt.setInt(1,lid);

			rs=stmt.executeQuery();

			while(rs.next())
			{
				list.add(new int[]{rs.getInt(1),rs.getInt(2)});
			}

			int n=list.size();

			double sumX=0,sumY=0;

			for(int a[]:list)
			{
				sumX+=a[0];
				sumY+=a[1];
			}

			double meanX=sumX/n;
			double meanY=sumY/n;

			double numerator=0;
			double denominator=0;

			for(int a[]:list)
			{
				double dx=a[0]-meanX;
				double dy=a[1]-meanY;

				numerator+=dx*dy;
				denominator+=dx*dx;
			}

			double m=numerator/denominator;
			double b=meanY-(m*meanX);

			return (m*inputX)+b;
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
			return 0;
		}
	}
}

package org.techhub.Service;

import java.util.List;

import org.techhub.Model.InterestedModel;
import org.techhub.Repository.*;

public interface InterestedService {
	public boolean isAddInterested(InterestedModel model);
	public List<Object[]> getWishlist(int rid) ;
	 public double predictPrice(int lid,double inputX);
}

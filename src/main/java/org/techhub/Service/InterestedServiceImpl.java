package org.techhub.Service;

import java.util.List;

import org.techhub.Model.InterestedModel;
import org.techhub.Repository.*;

public class InterestedServiceImpl implements InterestedService {

	InterestedRepository rRepo=new InterestedRepositoryImpl();
	@Override
	public boolean isAddInterested(InterestedModel model) {
		// TODO Auto-generated method stub
		return rRepo.isAddInterested(model);
	}
	@Override
	public List<Object[]> getWishlist(int rid) {
		// TODO Auto-generated method stub
		return rRepo.getWishlist(rid);
	}
	@Override
	public double predictPrice(int lid, double inputX) {
		// TODO Auto-generated method stub
		return rRepo.predictPrice(lid, inputX);
	}

}

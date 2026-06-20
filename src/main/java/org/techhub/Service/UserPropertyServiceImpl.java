package org.techhub.Service;

import java.util.List;

import org.techhub.Repository.UserPropertyRepo;
import org.techhub.Repository.UserPropertyRepoImpl;

public class UserPropertyServiceImpl implements UserPropertyService{

	UserPropertyRepo uRepo=new UserPropertyRepoImpl();
	@Override
	public List<Object[]> getPropertyDetailByLoc(int locId) {
		// TODO Auto-generated method stub
		return uRepo.getPropertyDetailByLoc(locId);
	}

}


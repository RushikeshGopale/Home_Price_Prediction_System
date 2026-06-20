package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.InterestedModel;

public interface InterestedRepository {
  public boolean isAddInterested(InterestedModel model);
  public List<Object[]> getWishlist(int rid);
  public double predictPrice(int lid,double inputX);
}

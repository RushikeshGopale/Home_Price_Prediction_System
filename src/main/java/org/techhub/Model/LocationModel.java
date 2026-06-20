package org.techhub.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationModel extends CityModel{
	private int lid;
	private String lname;
}

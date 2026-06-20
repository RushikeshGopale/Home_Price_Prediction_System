package org.techhub.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyModel extends LocationModel {
	private int pid;
	private String pname;
	private int sqfeet;
	private int price;
}

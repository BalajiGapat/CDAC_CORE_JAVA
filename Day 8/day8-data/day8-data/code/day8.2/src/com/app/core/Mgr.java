package com.app.core;

public  class Mgr extends Emp {
	
	public Mgr(double basic) {
		super(basic);
		
	}

	@Override
	public double computeSalary() {
		
		return getBasic()+ 1000;
	}
}

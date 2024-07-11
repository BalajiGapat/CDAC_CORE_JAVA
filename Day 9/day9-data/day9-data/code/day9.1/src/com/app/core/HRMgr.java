package com.app.core;

public class HRMgr extends Mgr 
{

	public HRMgr(double basic) {
		super(basic);
			}

	@Override
	public double computeSalary() {
		
		return getBasic()+3000;
	}

}

package com.app.core;

public enum Color 
{
	WHITE(10000), SILVER(20000), BLACK(15000), BLUE(35000), RED(50000);
	private double colorCost; //state : Colorcost

	private Color(double colorCost) // private constructor
	{
		this.colorCost = colorCost;
	}
	
	//getter
	public double getColorCost()  
	{
		return colorCost;
	}
	
	@Override
	public String toString()
	{
		return name()+"@"+colorCost;
	}
	
}

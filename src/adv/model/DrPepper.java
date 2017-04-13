package adv.model;

import javax.swing.JOptionPane;


public class DrPepper implements Pizzable
{
	private int pepperoni;
	
	
	public DrPepper()
	{
		pepperoni = 0;
	}
	
	public boolean hasPineapple()
	{
		return false;
	}
	
	public void toss()
	{
		JOptionPane.showMessageDialog(null, "The DrPepper was tossed like a pizza!!!!!!");
	}
	
	public void setPepperoni(int pepperoni)
	{
		this.pepperoni = pepperoni;
	}
	
	public int getPepperoni()
	{
		return pepperoni;
	}

}
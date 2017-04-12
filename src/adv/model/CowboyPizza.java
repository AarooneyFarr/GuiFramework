package adv.model;

import javax.swing.JOptionPane;

/**
 * @author AaronFarr
 */
public class CowboyPizza implements Pizzable
	{
		private boolean hasPineapple;
		private int pepperoni;
		private String name;

		public CowboyPizza()
			{
				hasPineapple = false;
				pepperoni = 30;
				name = "Cowboy";
			}

		public boolean hasPineapple()
			{

				return hasPineapple;
			}

		public int getPepperoni()
			{
				return pepperoni;
			}

		public void setPepperoni(int pepperoni)
			{
				this.pepperoni = pepperoni;
			}

		public String getName()
			{
				return name;

			}

		public void setName(String name)
			{
				this.name = name;
			}

		public void toss()
			{
				JOptionPane.showMessageDialog(null, "Your Pizza has been Tossed!");
			}

	}

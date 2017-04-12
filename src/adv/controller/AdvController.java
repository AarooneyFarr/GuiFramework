package adv.controller;

import adv.view.*;
import adv.model.*;
import java.util.ArrayList;

public class AdvController
	{

		private AdvFrame appFrame;
		private ArrayList<CowboyPizza> myPizzas;
		
		public AdvController()
		{
			appFrame = new AdvFrame(this);
		}
		
		public void start()
		{
			
		}
		
		private void setupList()
		{
			myPizzas.add(new CowboyPizza());
			
		}
	}

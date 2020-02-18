import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.AnchorPane;

public class PirateShip implements Observer
{
	 static int X1;
	 static int Y1;
	
	   static int X2;
		static int Y2;
		
		int[] IslocX;
		int[] IslocY;
		int[][] oceanGrid;
	 Point currentLocation;
	 AnchorPane root;
	 public Point Shippos = new Point();
	 int ship;
	 public PirateShip(int x, int y,int Ship,int[][] oceangrid) {
		 ship = Ship;
if(ship == 0) //sets the first pirate ship
{
			X1 = x;
			Y1 = y;
}
else //sets the second pirate ship
{
			
			X2 = x;
			Y2 = y;
}
		oceanGrid = 	oceangrid;
		}
	 
	public PirateShip(OceanMap oceanMap) {
	
	}
	
	public static Point getShipLocation1() //returns first pirate ship location
	{
		return new Point(X1,Y1);
	}
	public static Point getShipLocation2() 
	{  //returns second pirate ship location
		return new Point(X2,Y2);
	}

	@Override
	public void update(Observable S, Object arg1) //overrides the super class update method
	{
		if(S instanceof Ship)
		{
			Shippos = ((Ship)S).getShipLocation();
			OceanExplorer ocean = new OceanExplorer();
			IslocX = ocean.islandlocationsX();
			IslocY =  ocean.islandlocationsY();
			Movement();
		}
		
	}
	
	
	public void Movement() //movement method for pirate Ships 
	{
		int X,Y;
		if(ship == 0)
		{
	
		  if (X1 - Shippos.x == 0) {
	       } else if (X1- Shippos.x < 0) {
	           // checks for boundaries AND for islands (can't go through islands)
	    	   
	           if (X1 < 9 && oceanGrid[X1 + 1][Y1] != 1)
	        	   X1++;
	       } else if (X1 > 0 && oceanGrid[X1 - 1][Y1] != 1)
	    	   X1--;

	       // y movement
	       if (Y1 - Shippos.y == 0) {
	       } else if (Y1 - Shippos.y < 0) {
	           // checks for boundaries AND for islands
	           if (Y1 < 9 && oceanGrid[X1][Y1 + 1] != 1)
	        	   Y1++;
	       } else if (Y1 > 0 && oceanGrid[X1][Y1 - 1] != 1)
	    	   Y1--;

		}
		else
		{
			  if (X2 - Shippos.x == 0) {
		       } else if (X2- Shippos.x < 0) {
		           // checks for boundaries and for islands 
		    	   
		           if (X2 < 9 && oceanGrid[X2 + 1][Y2] != 1)
		        	   X2++;
		       } else if (X2 > 0 && oceanGrid[X2 - 1][Y2] != 1)
		    	   X2--;

		       // y movement
		       if (Y2 - Shippos.y == 0) {
		       } else if (Y2 - Shippos.y < 0) {
		           // checks for boundaries AND for islands
		           if (Y2 < 9 && oceanGrid[X2][Y2 + 1] != 1)
		        	   Y2++;
		       } else if (Y2 > 0 && oceanGrid[X2][Y2 - 1] != 1)
		    	   Y2--;
		}
		
	}
		
	
	
	
	
	

}

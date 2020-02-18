import java.awt.Point;
import java.util.Observable;

import javafx.scene.layout.AnchorPane;

public class Ship extends Observable{
	 int X,Y;
	 Point currentLocation;
	 AnchorPane root;
	 public Ship(int x, int y) //get the ship coordinates
	 {

			X = x;
			Y = y;
			
		}
	 
	public Ship(OceanMap oceanMap) {
	
	}
	public void goWest(int[] IslocX,int[] IslocY) //method to move ship to right side
	{
	
		Boolean iscellempty = true;
	if (X != 0)
		{
		for(int i=0;i<IslocX.length;i++)
		{
			if(IslocX[i] != 0 && IslocY[i] != 0 && X-1 == IslocX[i] && Y == IslocY[i])
			{
				iscellempty =false;
				break;
			}
			
		}
		if(iscellempty)
		{
			X--;
			setChanged();
			notifyObservers();
		}
		}
	}
	public void goSouth(int[] IslocX,int[] IslocY) //method to move ship to  down side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (Y != 9)
		{
			for(int i=0;i<IslocY.length;i++)
			{
				if(IslocX[i] != 0 && IslocY[i] != 0 && X == IslocX[i] && Y+1 == IslocY[i])
				{
					iscellempty =false;
					break;
				}
			}
			if(iscellempty)
			{
			Y++;
			setChanged();
			notifyObservers();
			}
		}
	}
	public void goNorth(int[] IslocX,int[] IslocY) //method to move ship to  Up side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (Y != 0)
		{
			for(int i=0;i<IslocY.length;i++)
			{
				if(IslocX[i] != 0 && IslocY[i] != 0 && X == IslocX[i] && Y-1 == IslocY[i])
				{
					iscellempty =false;
					break;
				}
			}
			if(iscellempty)
			{
			Y--;
			setChanged();
			notifyObservers();
			}
		}
	}
	public void goEast(int[] IslocX,int[] IslocY) //method to move ship to  left side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (X != 9)
		{
			for(int i=0;i<IslocX.length;i++)
			{
				if(IslocX[i] != 0 && IslocY[i] != 0 && X+1 == IslocX[i] && Y == IslocY[i])
				{
					iscellempty =false;
					break;
				}
			}
			if(iscellempty)
			{
			X++;
			setChanged();
			notifyObservers();
			}
		}
	}
	public Point getShipLocation() //return the new ship coordinates
	{
		// TODO Auto-generated method stub
		return new Point(X,Y);
	}
	

}

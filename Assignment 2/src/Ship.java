import java.awt.Point;
import java.util.Observable;

import javafx.scene.layout.AnchorPane;

public class Ship extends Observable{
	 int X,Y;
	 Point currentLocation;
	 AnchorPane root;
	 public Ship(int x, int y) {

			X = x;
			Y = y;
			
		}
	 
	public Ship(OceanMap oceanMap) {
		// TODO Auto-generated constructor stub
	}
	public void goWest(int[] IslocX,int[] IslocY) 
	{
		// TODO Auto-generated method stub
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
	public void goSouth(int[] IslocX,int[] IslocY) {
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
	public void goNorth(int[] IslocX,int[] IslocY) {
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
	public void goEast(int[] IslocX,int[] IslocY) 
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
	public Point getShipLocation() {
		// TODO Auto-generated method stub
		return new Point(X,Y);
	}
	

}

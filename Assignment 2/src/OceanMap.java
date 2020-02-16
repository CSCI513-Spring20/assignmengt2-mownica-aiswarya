import java.awt.Point;
import java.util.Random;

public class OceanMap  {

	static int x,y;
	static int Isx,Isy;
	static Random r=new Random();
	boolean[][] oceanGrid=new boolean[10][10];
	public boolean[][] getMap()
	{
		return oceanGrid;
	}
	public static Point getShipLocation() {
			 x=r.nextInt(10);
			 y=r.nextInt(10);
		return new Point(x,y);
		
	 
	}
	
	public static Point getislandslocation() {
		 Isx=r.nextInt(10);
		 Isy=r.nextInt(10);
		 if(x != Isx || y != Isy)
		 {
		 return new Point(Isx,Isy);
		 }
		 else
		 {
			 return new Point(0,0);
		 }
		 
	}
}

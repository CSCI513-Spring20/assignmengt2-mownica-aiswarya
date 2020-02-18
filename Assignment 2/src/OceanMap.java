import java.awt.Point;
import java.util.Random;

public class OceanMap  {
     
	//declaring ship coordinates
	static int x,y;
	
	//initializing pirateship coordinates
	static int[] Px = new int[15];   
	static int[] Py = new int[15];
	static int countpx=0;
	//initializing island coordinates
	static int[] Isx =  new int[15];
	static int[] Isy =  new int[15];
	
	//initializing PirateIsland coordinates
	static int countIs=0;
	static int[] Psx =  new int[15];
	static int[] Psy  =  new int[15];
	static int countPs=0;
	
	static Random r=new Random();
	int[][] oceanGrid=new int[10][10];  //Initializing the OceanGrid
	public int[][] getMap()
	{
		return oceanGrid;
	}
	public static Point getShipLocation() //get the random location for ship
	{
		
			 x=r.nextInt(10);
			 y=r.nextInt(10);
		return new Point(x,y);
		
	 
	}
	
	public static Point getPShipLocation() //get the random location for PirateShip
	{
		 Px = new int[50];
		 Py = new int[50];
		 Px[countpx]=r.nextInt(10);
		 Py[countpx]=r.nextInt(10);
		 if(x != Px[countpx] || y != Py[countpx])
		 {
			 int dupx = Px[countpx];
			 int dupy = Py[countpx];
			 countpx++;
	    return new Point(dupx,dupy);
	    
		 }
		 else
		 {
			 return new Point(0,0); 
		 }
	
		
}
	
	public static Point getislandslocation()  //get the random location for Islands
	{
		 Isx =  new int[50];
		 Isy =  new int[50];
			Boolean exists = false;
		 Isx[countIs]=r.nextInt(10);
		 Isy[countIs]=r.nextInt(10);
		 if(x != Isx[countIs] || y != Isy[countIs] )
		 {
			 for(int i =0;i<Px.length;i++)
			 {
				 if(Px[i] == Isx[countIs] && Py[i] == Isy[countIs] )
				 {
					 exists = true;
					 break;
				 }
			 }
			 if(!exists)
			 {
			 int dupx =Isx[countIs];
			 int dupy =Isy[countIs];
		     countIs++;
		     return new Point(dupx,dupy);
			 }
			 else
			 {
				 return new Point(0,0);
			 }
		 }
		 else
		 {
			 return new Point(0,0);
		 }
		 
	}
	
	
	public static Point getPislandslocation()// method to get the get the random location for PirateShip
	{
		 Psx =  new int[15];
		 Psy  =  new int[15];
	     Boolean exists = false;
		 Psx[countPs]=r.nextInt(10);
		 Psy[countPs]=r.nextInt(10);
		 if(x != Psx[countPs] || y != Psy[countPs])
		 {
			 for(int i =0;i<Px.length;i++)
			 {
				 if(Px[i] ==  Psx[countPs] && Py[i] == Psy[countPs] )
				 {
					 exists = true;
					 break;
				 }
			 }
			 for(int i =0;i<Px.length;i++)
			 {
				 if(Isx[i] == Psx[countPs] && Isy[i] ==  Psy[countPs] )
				 {
					 exists = true;
					 break;
				 }
			 }
			 if(!exists)
			 {
			 int dupx =Psx[countPs];
			 int dupy =Psy[countPs];
			 countPs++; 
		     return new Point(dupx,dupy);
			 }
			 else
			 {
				 return new Point(0,0);
			 }
		 }
		 else
		 {
			 return new Point(0,0);
		 }
		 
	}
	
	
}

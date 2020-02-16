


import java.awt.Point;
import javafx.scene.layout.AnchorPane;

public class PirateShip {
	 int X,Y;
	 Point currentLocation;
	 AnchorPane root;
	 public PirateShip(int x, int y) {

			X = x;
			Y = y;
			
		}
	 
	public PirateShip(OceanMap oceanMap) {
	
	}
	
	public Point getShipLocation() {
		return new Point(X,Y);
	}
	

}

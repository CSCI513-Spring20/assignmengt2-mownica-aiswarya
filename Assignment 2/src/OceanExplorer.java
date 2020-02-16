import java.awt.Point;
import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class OceanExplorer extends Application
{
	 final int scale = 50;
	  final int dimension=10;
	  boolean[][] oceanGrid=new boolean[10][10];
	  AnchorPane root;
	  
	  Image shipImage;
	  ImageView shipImageView;
	  Image IslandImage;
	  ImageView IslandImageView;
	  OceanMap oceanMap=new OceanMap();
	  Scene scene;
	  Ship ship;
	  Point startPoint;
	  
	  int[] IslocX = new int[15];
	  int[] IslocY = new int[15];
	 
                        
     
	  public OceanExplorer() {
			oceanGrid = oceanMap.getMap();
		}

	public static void main(String[] args) 
	{
		launch(args);

	}

	@Override
	public void start(Stage oceanStage) throws Exception
	{
	int count =0;
		Point IsstartPoint = null;
	    root = new AnchorPane();
		Scene scene = new Scene(root,500,500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
		drawMap(root);
		startPoint = OceanMap.getShipLocation();
		ship = new Ship(startPoint.x,startPoint.y);
		oceanStage.setScene(scene);
		loadShipImage(root);
        for(int i =0 ;i <11 ;i++)
		{
        	
			IsstartPoint =  OceanMap.getislandslocation();
			if(IsstartPoint.x != 0 && IsstartPoint.y != 0)
			{
				IslocX[count] = IsstartPoint.x ;
				IslocY[count] = IsstartPoint.y ;
				loadIslandsImage(root,IsstartPoint);
				count++;
			}
		}
		startSailing(scene);
		
	}
	private void startSailing(Scene scene)
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent ke) 
			{
				switch (ke.getCode())
				{
				case RIGHT:
					ship.goEast(IslocX,IslocY);
					break;
				case LEFT:
					ship.goWest(IslocX,IslocY);
					break;
				case UP:
					ship.goNorth(IslocX,IslocY);
					break;
				case DOWN:
					ship.goSouth(IslocX,IslocY);
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
			}
		});

	}
	 
	public void drawMap(AnchorPane root)
	{
		for(int x = 0; x < dimension; x++)
		{
			for(int y = 0; y < dimension; y++)
			{
			Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); // We want the black outline
			rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
			root.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
	}
     public void loadShipImage(AnchorPane root)
     {
		
		Image shipImage = new Image("ship.png",50,50,true,true);
		shipImageView= new ImageView(shipImage); 
		shipImageView.setX(startPoint.x*scale);
		shipImageView.setY(startPoint.y*scale);
		root.getChildren().add(shipImageView); 
	
		
	}
     
     public void loadIslandsImage(AnchorPane root,Point IsstartPoint)
     {
		
		Image IslandImage = new Image("island.png",50,50,true,true);
		IslandImageView= new ImageView(IslandImage); 
		IslandImageView.setX(IsstartPoint.x*scale);
		IslandImageView.setY(IsstartPoint.y*scale);
		root.getChildren().add(IslandImageView); 
	
		
	}
	/*public boolean[][] getMap(){
		
		return myGrid; // Where hopefully “myGrid” has a more meaningful name.
		 } */
	

}

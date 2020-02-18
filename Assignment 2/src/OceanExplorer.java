import java.awt.Point;
import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class OceanExplorer extends Application
{
	 final int scale = 50;
	  final int dimension=10;
	  int[][] oceanGrid=new int[10][10];
	  AnchorPane root;
	  
	  Image shipImage;
	  ImageView shipImageView;
	  Point startPoint;
	  
	  Image PshipImage;
	  ImageView PshipImageView;
	  ImageView PshipImageView2;
	  Point PstartPoint;
	  

	  Image IslandImage;
	  ImageView IslandImageView;
	  static int[] IslocX = new int[15];
	  static int[] IslocY = new int[15];
	  
	  Image PIslandImage;
	  ImageView PIslandImageView;
	  Point PIsstartPoint;
	
	  
	  OceanMap oceanMap=new OceanMap();
	  Scene scene;
	  Ship ship;
	  PirateShip pship1;
	  PirateShip pship2;
	  
	  
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
		Point PIsstartPoint = null;
	    root = new AnchorPane();
	 /*   

        Button reset = new Button("reset");
        reset.setLayoutX(0);
        reset.setLayoutY(500);
        root.getChildren().add(reset);
        
        
		*/
		
		
		drawMap(root);
		
		startPoint = OceanMap.getShipLocation();
		ship = new Ship(startPoint.x,startPoint.y);
		oceanStage.setScene(scene);
		loadShipImage(root);
		
		for(int i =0 ;i < 2;i++)
		{
        	
		PstartPoint = OceanMap.getPShipLocation();
		if(PstartPoint.x != 0 && PstartPoint.y!=0 )
		{
			if( i== 0)
			{
		pship1 = new PirateShip(PstartPoint.x,PstartPoint.y,i,oceanGrid);
		ship.addObserver(pship1);
		oceanStage.setScene(scene);
		loadPirateShipImage(root);
			}
			else
			{
			pship2 = new PirateShip(PstartPoint.x,PstartPoint.y,i,oceanGrid);
			ship.addObserver(pship2);
			oceanStage.setScene(scene);
			loadPirateShipImage2(root);
			}
		
		}
		else
		{
			i--;
		}
		}
		
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
        for(int i =0 ;i <2 ;i++)
		{
        	
			PIsstartPoint =  OceanMap.getPislandslocation();
			if(PIsstartPoint.x != 0 && PIsstartPoint.y != 0)
			{
				IslocX[count] = PIsstartPoint.x ;
				IslocY[count] = PIsstartPoint.y ;
				loadPIslandsImage(root,PIsstartPoint);
				count++;
			}
			else
			{
				i--;
			}
		}
        
     /*
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    start(oceanStage);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        */
        
        Scene scene = new Scene(root,600,600);
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
        
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
				PshipImageView.setX(pship1.getShipLocation1().x * scale);
				PshipImageView.setY(pship1.getShipLocation1().y * scale);
				PshipImageView2.setX(pship2.getShipLocation2().x * scale);
				PshipImageView2.setY(pship2.getShipLocation2().y * scale);
			}
		});

	}
	
	public int[] islandlocationsX() {
		return IslocX;
	}
	
	public int[] islandlocationsY() {
		return IslocY;
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
     
     
     public void loadPirateShipImage(AnchorPane root)
     {
		
		Image PshipImage = new Image("pirateShip.png",50,50,true,true);
		PshipImageView= new ImageView(PshipImage); 
		PshipImageView.setX(PstartPoint.x*scale);
		PshipImageView.setY(PstartPoint.y*scale);
		root.getChildren().add(PshipImageView); 
	
		
	}
     
     public void loadPirateShipImage2(AnchorPane root)
     {
		
		Image PshipImage = new Image("pirateShip.png",50,50,true,true);
		PshipImageView2= new ImageView(PshipImage); 
		PshipImageView2.setX(PstartPoint.x*scale);
		PshipImageView2.setY(PstartPoint.y*scale);
		root.getChildren().add(PshipImageView2); 
	
		
	}
     
     public void loadIslandsImage(AnchorPane root,Point IsstartPoint)
     {
		
		Image IslandImage = new Image("island.png",50,50,true,true);
		IslandImageView= new ImageView(IslandImage); 
		IslandImageView.setX(IsstartPoint.x*scale);
		IslandImageView.setY(IsstartPoint.y*scale);
		root.getChildren().add(IslandImageView); 
	
		
	}
     public void loadPIslandsImage(AnchorPane root,Point PIsstartPoint)
     {
		
		Image PIslandImage = new Image("pirateIsland.png",50,50,true,true);
		PIslandImageView= new ImageView(PIslandImage); 
		PIslandImageView.setX(PIsstartPoint.x*scale);
		PIslandImageView.setY(PIsstartPoint.y*scale);
		root.getChildren().add(PIslandImageView); 
	
		
	}
	/*public boolean[][] getMap(){
		
		return myGrid; // Where hopefully “myGrid” has a more meaningful name.
		 } */
	

}

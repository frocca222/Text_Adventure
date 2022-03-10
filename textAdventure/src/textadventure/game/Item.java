package textadventure.game;

import java.util.Set;
public class Item{
    private String name;
    private String description;
    private int points;
    public Item(String name, String description,int points) {
        this.name=name;
        this.description = description;
        points =0;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
  public int getPoints() {
	  
	  return points;
		  
	  }
  }
    

 
 


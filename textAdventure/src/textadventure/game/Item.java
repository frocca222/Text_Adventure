package textadventure.game;

import java.util.Set;
public class Item{
    private String name;
    private String description;
    int points;
    public Item(String name, String description) {
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
    
    public void setPoints(int value){
        points+=value;
    }
    
    public int getPlayerPoints(){
        return points;
    }
    

    }
    
 


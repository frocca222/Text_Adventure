package textadventure.game;

import java.util.HashMap;
import java.util.Set;
public class Player{
    private HashMap<String, Item> inventory;
    
    private String name;
    
    public Player() {
        this.name=name;

        inventory = new HashMap<>();
    }
 
     public void setItem(String name, Item item) {
        inventory.put(name,item);
    }
    
    public Item removeItem(String key) {
        return inventory.remove(key);
    }
        
    public Item getItem(String key) {
        return inventory.get(key);
    }

    
        public String getInventoryString(){
        String returnString = "Player Inventory:";
        Set<String> keys = inventory.keySet();
        for(String item: keys){
            returnString += " " + item;
        }
        return returnString;
    }
    public void setPoints() {
    	int playerPoints= 0;
    	
    	
    }
    
}
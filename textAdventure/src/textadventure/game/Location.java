package textadventure.game;

import java.util.HashMap;
import java.util.Set;

public class Location{
    private String name;
    private String shortDescription;
    private String longDescription;
    private String introText;
    
    private HashMap<String, Location> exits;
    private HashMap<String, Item> inventory;
    
    public Location(String name, String shortDescription, String longDescription) {
        this.name=name;
        this.shortDescription= shortDescription;
        this.longDescription= longDescription;
        exits = new HashMap<>();
        inventory = new HashMap<>();
    }
    

    public void setExit(String direction, Location neighbor) {
        exits.put(direction,neighbor);
    }
    
    public String getName(){
        return name;
    }

    public String getShortDescription(){
        return shortDescription;
    }
    
    public String getLongDescription(){
        return longDescription;
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
    
    public Location getExit(String direction){
        return exits.get(direction);
    }
    
    public String getInventoryString(){
        String returnString = "Location Inventory:";
        Set<String> keys = inventory.keySet();
        for(String item: keys){
            returnString += " \"" + item + "\"";
        }
        return returnString;
    }
    
    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit: keys){
            returnString += " \"" + exit + "\"";
        }
        return returnString;
    }
}
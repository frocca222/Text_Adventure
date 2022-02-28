package textadventure.game;

import java.util.Random;
import java.util.Scanner;
public class Game{
    private Parser parser;
    private Location currentLocation;
    private Player player;
    private CLS cls_var;
    private int points;
    private int randomGuess;
    public Game(){
        parser = new Parser();
        player = new Player();
    }
   
    public static void main(String[] args){
        Game game= new Game();
        game.setupGame();
        game.play();
    }


    public void printInformation(){
        System.out.println(currentLocation.getExitString());
        System.out.println(currentLocation.getShortDescription());
        System.out.println(player.getInventoryString());
        System.out.println(currentLocation.getInventoryString());
       
    }
   
    public void setupGame() {
        
        Location startingLocation = new Location ("tree","You are at the base of a tree", "You are standing next to a very tall tree.\nAt the base of it there is a whole.\nThere are four different paths in each direction that you are able to go down.\n");
        Location duckPond = new Location("duck pond","You are at the duck pond" , "You are in a meadow and in the center of it is a pond.\nThere are about 15 ducks swimming at the top.\nThere is sunlight beaming into the meadow, shining onto the flowers and algae on the water.\nThere is a thick forest you can’t enter to east\n");
        Location appleOrchard = new Location ("apple orchard","You are in an apple orchard", "There are rows of trees growing in front of you.\nThe trees has hundreds apples growing on them.\nIn almost every direction, there is dense forest that you can not enter.\nDown one path, you see a large tree.\n");
        Location farmersHouse = new Location ("farmers house","You are at the farmers house" , "You are at the door of a barnhouse that is worn down.\nInside lives the farmer who is eager to trap you.\nThere is thick forest you can’t enter north and west of the house, but there seems to be a clearing to the east.\nIn the clearing there is a single chicken.");
        Location chickenCoop = new Location ("chicken coop","You are at the chicken coop", "You reach a coop filled with chickens and another small enclosed area filled with more chickens.\nThere is a gate to get access to the chickens, but you need a key to open it.\n");
        Location clearingOne = new Location ("clearing one","You are in a trap","You hear the a loud metallic bang.\nYou look around and are now in a cage that the farmer set up to  trap you.\nThere is a way out though.\nThere is a lock and if you guess the right number, you will be free.\nIf not the farmer will catch you.\n");        
        Location clearingTwo = new Location ("clearing two","You are in a trap","You hear the a loud metallic bang.\nYou look around and are now in a cage that the farmer set up to  trap you.\nThere is a way out though.\nThere is a lock and if you guess the right number, you will be free.\nIf not the farmer will catch you.\n");        
        Location clearingThree = new Location ("clearing three","You are in a trap","You hear the a loud metallic bang.\nYou look around and are now in a cage that the farmer set up to  trap you.\nThere is a way out though.\nThere is a lock and if you guess the right number, you will be free.\nIf not the farmer will catch you.\n");        
        Location coop = new Location ("coop","You are in the coop", "You are in the coop and there is enough chickens to feed your family for weeks.");
       
        startingLocation.setExit("duck pond", duckPond);
        startingLocation.setExit("apple orchard", appleOrchard);
        startingLocation.setExit("farmers house", farmersHouse);
        startingLocation.setExit("chicken coop", chickenCoop);
       
        duckPond.setExit("starting location", startingLocation);
        duckPond.setExit("clearing one", clearingOne);
        duckPond.setExit("clearing three", clearingThree);
       
        appleOrchard.setExit("starting location", startingLocation);
        appleOrchard.setExit("clearing two", clearingTwo);
       
        farmersHouse.setExit("starting location", startingLocation);
        farmersHouse.setExit("clearing three", clearingThree);
       
        chickenCoop.setExit("starting location", startingLocation);
        chickenCoop.setExit("clearing one", clearingOne);
        chickenCoop.setExit("clearing two", clearingTwo);
       
        coop.setExit("chicken coop", chickenCoop);

        Item lockPick = new Item("lock pick", "long description");
        Item chicken = new Item("chicken", "The chicken is fat and covered in white feathers");
        Item apple = new Item("apple", "The apple is red and reasonably sized. It is very shiny and will make the perfect snack for your family");
        Item chickenTwo = new Item("chicken", "The chicken is fat and covered in white feathers");
        Item key = new Item("key", "The key is small, gold, ornate piece of metal.");
        Item flock = new Item("flock", "There are countless fat chickens in the flock");
               
        flock.setPoints(12);
        chicken.setPoints(2);
        apple.setPoints(1);
        chickenTwo.setPoints(1);
       

        duckPond.setItem("lock pick", lockPick);
        chickenCoop.setItem("chicken", chicken);
        clearingThree.setItem("chicken", chickenTwo);
        appleOrchard.setItem("apple", apple);
        clearingOne.setItem("key", key);
        coop.setItem("flock", flock);
       
        currentLocation = startingLocation;
        try {
            cls_var.main();
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("You look around and see a quaint farm.\n When you look down you see yourself covered in orange fur.\n The goal of the game is get steal as much food from the farm\n to feed your family without getting caught.\n To grab something, type 'grab' followed by the object you want.\n To move, type 'go' followed by where you want to go.\n");
        printInformation();
        play();

    }
   

   
    public void play() {
       while(true) {            
        Command command = parser.getCommand();
        try {
            cls_var.main();
        }catch(Exception e) {
            System.out.println(e);
        }
        processCommand(command);
        printInformation();  
       }
    }

   
    public void processCommand(Command command){
        String commandWord = command.getCommandWord().toLowerCase();
        switch(commandWord){
            case"speak":
            System.out.println("you wanted me to speak this word, " + command.getSecondWord());
            break;
            case "go":
                goLocation(command);
                break;
            case "grab":
                grab(command);
                break;
            case "drop":
                drop(command);
                break;
            case "inspect":
                inspect(command);
                break;
            case "pick":
                pick(command);
                break;
            case "help":
                help(command);
                break;
           
           
        }
    }
   
    public void pick(Command command){
    	Random random= new Random();
    	int next = random.nextInt(6);
    	
        Scanner keyboard= new Scanner(System.in);
      
        String pick = "";
        Item itemToPick = null;
        if(!command.hasSecondWord()) {
            System.out.println("pick what?");
        }
        if(!command.hasLine()) {
            pick = command.getSecondWord();
        }
        else if(command.hasLine()) {
            pick = command.getSecondWord() + command.getLine();

            System.out.println("pick a number 1-5 to pick the lock. You can pick the lock if you guess the right number");
            int myInt= keyboard.nextInt();
            return next();
        }
        if(itemToPick==null){
            System.out.println("you can't grab that");
        }
    }
   
    public void help(Command command){

        if( !command.hasLine()){
            System.out.println("Help Page:\nTo go somewhere type 'go' followed by where you want to go.\nTo grab something type 'grab' followed by what you want to grab.\nTo pick a lock type 'pick lock'.\nTo drop soemthing type 'drop' followed by what you want to drop.\nTo get a long description of a location or object, type 'inspect' followed by what you want to look at.\n");
        }
    }
   

    public void inspect(Command command){
        String printString= "Looking at ";
        String thingToInspect = null;
        if (!command.hasSecondWord()){
            System.out.println ("inspect what?");
            return;
        }
        if (!command.hasLine()){
            thingToInspect = command.getSecondWord();
        }
        else if (command.hasLine()){
            thingToInspect = command.getSecondWord() + command.getLine();
        }
       
        if (thingToInspect.equals (currentLocation.getName())){
            printString += "the room: " + currentLocation.getName()+ "\n" + currentLocation.getLongDescription();
        }
        else if (currentLocation.getItem(thingToInspect) != null){
            printString+= "the item: " + currentLocation.getItem(thingToInspect).getName()+ "\n" + currentLocation.getItem(thingToInspect).getDescription();
        }
        else if (player.getItem(thingToInspect) != null){
            printString+= "the item: " + player.getItem(thingToInspect).getName()+"\n" + player.getItem(thingToInspect).getDescription();
        }
        else{
            printString+= "\nYou can't look at that";
        }
        System.out.println (printString);
     }


    public void grab(Command command){
        String item = "";
       
        if(!command.hasSecondWord()) {
            System.out.println("grab what?");
        }
        if(!command.hasLine()) {
            item = command.getSecondWord();
        }
        else if(command.hasLine()) {
            item = command.getSecondWord() + command.getLine();
        }
        Item itemToGrab = currentLocation.removeItem(item);
        if(itemToGrab==null){
            System.out.println("you can't grab that");
        }
        else{
            player.setItem(item, itemToGrab);
            printInformation();
        }
    }
    
    public void setPoints() {
    	
    }
   
    public void drop(Command command){
        String item = "";
        if(!command.hasSecondWord()) {
            System.out.println("drop what?");
            return;
        }    
        if(!command.hasLine()) {
            item = command.getSecondWord();
        }
        else if(command.hasLine()) {
            item = command.getSecondWord() + command.getLine();
        }
        Item itemToDrop = player.removeItem(item);
        if(itemToDrop==null){
            System.out.println("you can't drop that");
            return;
        }
        else{
            currentLocation.setItem(item, itemToDrop);
            printInformation();
        }
    }
   
    public void goLocation(Command command) {
        String direction= "";
        if(!command.hasSecondWord()) {
            System.out.println("go where?");
        }
        if(!command.hasLine()) {
            direction = command.getSecondWord();
        }
        else if(command.hasLine()) {
            direction = command.getSecondWord() + command.getLine();
        }
     
        Location nextLocation = currentLocation.getExit(direction);
        if(nextLocation==null){
            System.out.println("you can't go there");
        }
        else{
            currentLocation = nextLocation;
            printInformation();
        }
    }
   
    public void winGame(){
        if (points>=15){
            System.out.println("You found enough food for you family for weeks. You won!");
            System.exit(0);
        }
    }
   
    public void endGame() {
        if (points<15){
            System.out.println("You did not get enough food to feed you family and they starved.\n GAME OVER");
            System.exit(0);
        }
    }
}


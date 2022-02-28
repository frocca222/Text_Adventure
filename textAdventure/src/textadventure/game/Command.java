package textadventure.game;


public class Command
{
    private String commandWord;
    private String secondWord;
    private String line = " You look around and see a quaint farm.\n When you look down, you see yourself \n covered in orange fur; you are a fox. \n The goal of the game is to get as much food to \n feed your fox family. \n To go to different location use the word 'go' followed by the location.\n You can also grab certain objects by using the word 'grab' followed by the item.";

    
    public Command(String commandWord, String secondWord, String line) {
        this.commandWord = commandWord;
        this.secondWord= secondWord;
        this.line = line;
    }
    
    public String getCommandWord(){
        return commandWord;
    }
    
    public String getSecondWord(){
        return secondWord;
    }
    
    public boolean hasSecondWord(){
        return (secondWord!=null);
    }
    
    public String getLine(){
        return line;
    }
    
    public boolean hasLine(){
    return (line != null);
    }
}

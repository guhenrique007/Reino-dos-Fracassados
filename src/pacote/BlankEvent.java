package pacote;


import java.util.Collection;
import pacote.Event;

public class BlankEvent extends Event{
    public BlankEvent(String description, Collection<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {
         String string = "Você é um cara na ilha";
    }
}
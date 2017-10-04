package pacote;


public class BattleChoice extends Choice {
    public BattleChoice(String description, Event event, Enemy enemy) {
        super(description, event);
        
        this.enemy = enemy;
    }

    @Override
    public void executeChoice(Character character) {
        //while(this.enemy.isAlive() == true){  
        character.battle(this.enemy);

    }

    private final Enemy enemy;
   
}
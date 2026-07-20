package Skills;

import cardwars1.Player;

public class Strength extends Skill{
    private static final int ROUND_TRIGGER = 3;
    private static final int ATK_INCREASE = 10;

    private String description = "Strength: Increase attack by "+ATK_INCREASE+"% \n";
    
    public Strength(){}
    
    @Override
    public void activate(Player player, int round)
    {
        if(round % ROUND_TRIGGER == 0)
        {
            player.setAttack(player.getAttack()+player.getAttack()*ATK_INCREASE/100);
            System.out.println(player.getName()+" increases attack to "+player.getAttack());
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
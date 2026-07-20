package Skills;

import cardwars1.Player;

public class Slash implements Skill{
    private static final int ROUND_TRIGGER = 2;
    private static final double ATTACK_PERCENT = 0.35;
    
    private String description = "Slash: Deals "+(int)(ATTACK_PERCENT*100)+"% of your attack as damage\n";
    
    public Slash(){}
    
    @Override
    public void activate(Player player, int round)
    {
        if(round % ROUND_TRIGGER == 0)
        {
            int slash = (int) Math.ceil((player.getAttack() * ATTACK_PERCENT));
            player.getOpponent().setHealth(player.getOpponent().getHealth()-slash);
            System.out.println(player.getName()+" deals "+slash+" slash damage.");
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
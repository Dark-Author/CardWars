package Skills;

import cardwars1.Player;

public class Guard implements Skill{
    private static final int ROUND_TRIGGER = 3;
    private static final int DEFENSE_INCREASE = 15;

    private String description = "Guard: Increase Defense by "+DEFENSE_INCREASE+"% every "+ROUND_TRIGGER+" rounds.\n";
    
    public Guard(){}
    
    @Override
    public void activate(Player player, int round)
    {
        if(round % ROUND_TRIGGER == 0)
        {
            player.setDefense((int) (player.getDefense() *(100.0+ DEFENSE_INCREASE)/100.0));
            
            System.out.println(player.getName()+" increases Defense to "+player.getDefense()+".");
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
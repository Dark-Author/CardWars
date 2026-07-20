package Skills;

import cardwars1.Player;

public class Prec extends Skill{
    private static final int ROUND_TRIGGER = 4;
    private static final int CRIT_CHANCE_INCREASE = 20;
    private static final int CRIT_DAMAGE_INCREASE = 10;

    private String description = "Precision: Increase critical hit rate by "+CRIT_CHANCE_INCREASE+"% and critiical damage by "+CRIT_DAMAGE_INCREASE+"%.\n";
    
    public Prec(){}
    
    @Override
    public void activate(Player player, int round)
    {
        if(round % ROUND_TRIGGER == 0)
        {
            player.setCrit_chance(player.getCrit_chance() + CRIT_CHANCE_INCREASE);
            player.setCrit_damage(player.getCrit_damage() + CRIT_DAMAGE_INCREASE);
            System.out.println(player.getName()+" increases critical hit chance to "+player.getCrit_chance()+"% and critical hit damage to "+player.getCrit_damage()+"%.");
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
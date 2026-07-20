package Skills;

import cardwars1.Player;

public class Heal extends Skill{
    private static final int ROUND_TRIGGER = 3;
    private static final double HEAL_PERCENT = 0.04;
    private static final double HEAL_EFFECT_INCREASE = 0.1;
    
    private String description = "Heal: Heals 4% of your maximum health and increases healing efect by 10%\n";
    
    public Heal(){}
    
    @Override
    public void activate(Player player, int round)
    {
        if(round % ROUND_TRIGGER == 0)
        {
            int heal = (int) Math.ceil((player.getMax_health() * HEAL_PERCENT) * player.getHealing_effect());
            player.setHealing_effect((player.getHealing_effect() + HEAL_EFFECT_INCREASE));
            System.out.println(player.getName()+" heals "+heal+" HP and increaces healing effect by 10%.");
            player.setHealth(player.getHealth()+heal);
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
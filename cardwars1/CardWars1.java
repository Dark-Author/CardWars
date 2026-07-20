package cardwars1;

import Skills.*;
import java.util.ArrayList;
import java.util.Random;

public class CardWars1
{
    private static Skill[] list_of_skills = {new Focus(), new Heal(), new Prec(),new Slash(), new Guard(), new Strength()};
    private static ArrayList<Player> players = new ArrayList<Player>();
    // REMOVED: public static Player active_player;
    private static Random rand = new Random();
        
    public static void main(String[] args) throws InterruptedException
    {
        players.add(new Player("Author",list_of_skills[rand.nextInt(list_of_skills.length)]));
        players.add(new Player("Tris",list_of_skills[rand.nextInt(list_of_skills.length)]));
        displaySkills();
        Thread.sleep(1000);
        displayPlayers(players.get(0),players.get(1));
        Thread.sleep(1000);
        battle(players.get(0),players.get(1));
    }
    
    public static void battle(Player player1, Player player2) throws InterruptedException
    {
        player1.setOpponent(player2); player2.setOpponent(player1);
        
        Player active_player;
        Player opponent_player;

        if(player1.getSpeed() > player2.getSpeed()){
            active_player = player1;
            opponent_player = player2;
        }
        else{
            active_player = player2;
            opponent_player = player1;
        }
        
        int round = 1;
        String damage_message;
        
        while(player1.getHealth() > 0 && player2.getHealth() > 0)
        {
            System.out.println("\nRound "+round);
            for (int i = 0; i < 2; i++) {
                System.out.println(active_player.getName()+" : "+active_player.getHealth()+"\t|\t"+opponent_player.getName()+" : "+opponent_player.getHealth());
                
                // Active player passed to the skill activation method
                active_player.getSkill().activate(active_player, round);
                active_player.setDamage(active_player.calDamage());
                
                
                if(active_player.getCrit_success())
                {
                    active_player.setDamage((int) (active_player.getDamage()*((double) (active_player.getCrit_damage()/100.0))));
                    damage_message = "CRITICAL HITT!!! "+active_player.getName()+" deals "+active_player.getDamage()+" damage.";
                }
                else
                {
                    damage_message = active_player.getName()+" deals "+active_player.getDamage()+" damage.";
                }
                opponent_player.setHealth(opponent_player.getHealth()-active_player.getDamage());
                
                System.out.println(damage_message);
                
                if(opponent_player.getHealth()<=0)
                {
                    System.out.println(active_player.getName()+" wins!");
                    break;
                }
                
                // Swap active and opponent
                Player temp = active_player;
                active_player = opponent_player;
                opponent_player = temp;
                
                Thread.sleep(2000);
            }
            round++;
        }
    }
    public static void displayPlayers(Player player1, Player player2)
    {
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }

    // REMOVED: setActive_player method

    public static void displaySkills(){
        for (Skill skill:list_of_skills) {
            System.out.println(skill.getDescription());
        }
    }
}
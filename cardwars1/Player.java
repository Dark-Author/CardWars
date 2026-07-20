package cardwars1;

import Skills.Skill;
import java.util.Random;

public class Player
{
    int health;
    int max_health;
    int attack;
    int damage;
    int crit_chance;
    int crit_damage;
    int defense;
    double healing_effect;
    int evade;
    int speed;
    String name;
    Player opponent;
    Skill skill;
    Random random = new Random();

    public Player(String name, Skill skill)
    {
        this.max_health = random.nextInt(300)+700;
        this.health = max_health;
        this.attack = random.nextInt(30)+70;
        this.crit_chance = 1;
        this.crit_damage = 180;
        this.defense = random.nextInt(30)+70;
        this.healing_effect = 1;
        this.evade = 1;
        this.speed = random.nextInt(30)+70;
        this.name = name;
        this.skill = skill;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int calDamage() {
        // NEW FORMULA: ATK * (100 / (100 + Opponent DEF)) + Random Factor [1..10]
        double damage_reduction_multiplier = 100.0 / (100.0 + getOpponent().getDefense());
        
        // Base damage is now full ATK * multiplier, plus a random factor (1 to 10).
        int damage = (int) (this.attack * damage_reduction_multiplier + random.nextInt(10) + 1);
        
        return damage;
    }
    
    public boolean getCrit_success() {
        // OPTIMIZED: Simplified to directly return the boolean expression.
        return random.nextInt(100)+1 <= crit_chance;
    }
    
    public int getCrit_chance() {
        return crit_chance;
    }

    public void setCrit_chance(int crit_chance) {
        this.crit_chance = crit_chance;
    }

    public int getCrit_damage() {
        return crit_damage;
    }

    public void setCrit_damage(int crit_damage) {
        this.crit_damage = crit_damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getHealing_effect() {
        return healing_effect;
    }

    public void setHealing_effect(double healing_effect) {
        this.healing_effect = healing_effect;
    }

    public int getEvade() {
        return evade;
    }

    public void setEvade(int evade) {
        this.evade = evade;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return 
                "Name:\t" + name + "\n" +
                "Skill:\t" + skill.getDescription() +
                "HP:\t" + max_health + "\n" +
                "ATK:\t" + attack + "\n" +
                "DEF:\t" + defense + "\n" +
                "SPD:\t" + speed + "\n";
    }
}

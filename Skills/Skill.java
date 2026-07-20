package Skills;

public abstract class Skill
{
    // String description field removed as it was unused.
    public abstract void activate(cardwars1.Player player, int round);
    public abstract String getDescription();
}
package Skills;

public interface Skill
{
    // String description field removed as it was unused.
    public void activate(cardwars1.Player player, int round);
    public String getDescription();
}
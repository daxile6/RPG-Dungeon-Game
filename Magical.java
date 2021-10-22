 /**
    Magical.java - Interface with three magical attacks. to be used by other classes, specifically the warlock which decorates a base enemy. The first magical attack being magic missile, the second being fireball and the last being thunderbolt.
  */
public interface Magical{
  public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
  
  public String magicMissile(Entity e);
  
  public String fireball(Entity e);

  public String thunderclap(Entity e);

}
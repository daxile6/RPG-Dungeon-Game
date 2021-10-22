import java.util.Random;
import java.awt.Point;
/**
 * Hero.java - class with a hero constructor and attack methods,
 * movement methods, level up methods, and other interaction 
 * methods etc.
 * @instance variable level : integer representing the hero's 
 * progression 
 * throughout the dungeon. As the level changes, the dungeon 
 * will choose a certain map and the enemies will become more 
 * powerful.
 * @instance variable gold : integer representing gold that the * hero is able to spend in the store and attain within the 
 * dungeon
 * @instance variable key: integer representing the number of 
 * keys that the
 * hero is in possession of. A key is required to exit the 
 * current floor at the finish of each level
 */

public class Hero extends Entity implements Magical{
  private Point position;
  private int level;
  int gold;
  int key;

  /**
   * Hero constuctor, starting off the hero with a name to be 
   * entered by the user, 25 max hit points,
   * level 1, 100 gold, 0 keys a new map and a position at the 
   * start of map 1.
   */
  public Hero(String n) 
  {
    super(n, 25); 
    level = 1;
    gold = 100;
    gold = 100;
    key = 0;
    position = new Point(Map.getInstance().findStart());
  }
  /** 
   * getGold() retrieves the current amount of gold that the 
   * hero has.
   * @return - the integer value of the hero's current gold
   */
  public int getGold()
  {
    return gold;
  }
  /**
   * collectGold(int g) When gold is found, this method adds to * the hero's current total gold amount.
   */
  public void collectGold(int g)
  {
    gold += g;
  }
  /**
   * spendGold(int g) When gold is spent int the store, this 
   * method reduces the hero's current gold amount.
   */
  public void spendGold(int g)
  {
    gold -= g;
  }
  /**
   * hasKey() - Method that checks if the hero is in possession * of a key when called.
   * @return - a boolean that is set to true if the hero has a 
   * key and false otherwise.
   */
  public boolean hasKey()
  {
    if(key == 1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  /**
   * pickUpKey() When a key is found, this method sets the 
   */
  public void pickUpKey()
  {
    key = 1;
  }
  /**
   * useKey() - Method that checks if the hero is in possession * of a key when called and reduces the key count to 0 if a 
   * key has been used at the appropriate time.
   * @return - a boolean that is set to true if the hero has a 
   * key and is used, also setting the key count to 0 and false * otherwise.
   */
  public boolean useKey()
  {
    if(key == 1)
    {
      key = 0;
      return true;
    }
    else
    {
      return false;
    }
  }
  /**
   * getLoc() retrieves the postion of the hero.
   * @return - hero's current position (a point)
   */
  public Point getLoc()
  {
    return position;
  }
  
  /**
   * getLoc() retrieves the level of the hero.
   * @return - hero's current level
   */
  public int getLevel(){
    return level;
  }

  /**
   * toString() - Method that returns a string containing the 
   * hero's name, current level, and map with revealed rooms 
   * and current position of the Hero Object
   * @return- returns a string containing the 
   * hero's name, current level, gold amount, key amount and 
   * map with revealed rooms 
   * and current position of the Hero Object
   */
  @Override
  public String toString() {
    return super.getName() + "\nHP: " + super.getHP() + "/" + super.getMaxHP() + "\nLevel: " + level + "\nGold: " + gold + "\nKey: "+ key + "\n" + Map.getInstance().mapToString(position);
  }
  /**
   * attack(Entity e) - Regular/physical attack method that 
   * rolls a random 
   * integer damage between one and three, reducing an enemy 
   * object's 
   * current HP by said damage.
   * @param Entity E - Entity e takes certain damage from attack
   * between one and three
   * @return - a string with the name of the hero, the enemy 
   * that they hit
   * and the damage done to said target
   */
  @Override
  public String attack(Entity e){
    int damage = 0;
    damage = (int) (Math.random() * (3) + 1);
    e.takeDamage(damage);
    return getName() + " hits " + e.getName() + " for " + damage + " damage. ";
  }
 /**
  * levelUP() - Increases the hero's level at the finish of 
  * each map, and will loop through the three maps, starting at * the finish of the previous map depending on the remainder 
  * of the level modulo 3.
  */
  public void levelUp(){
    level++;
    if (level%3 ==1){ 
      Map.getInstance().loadMap((1));
      position = Map.getInstance().findStart();
    }
    if (level%3 ==2){ 
      Map.getInstance().loadMap((2));
      position = Map.getInstance().findStart();
    }
    if (level%3 ==0){ 
      Map.getInstance().loadMap((3));
      position = Map.getInstance().findStart();
    }
  }
  /**
   * goNorth() - Removes the character at the location that the * Hero has already visited, replacing it with a null/n value. 
   * Moves the character up one space in the Y direction, and 
   * checks if the Hero moves out of bound, prompting the user 
   * that they can not move that way. If they do go out of 
   * bounds,the movement is reversed, and they are placed where * they were previously. This method also reveals the spot 
   * that the hero moves to. Returns the character at that 
   * location.
   * @return - the character position after moving
   */
  public char goNorth(){
    position.translate(-1, 0); // up 1
    if (position.getX() < 0){ // check if out of map
      System.out.println("You are out of bounds");
      position.translate(1, 0);
    }
    return Map.getInstance().getCharAtLoc(position);
  }
  /**
   * goSouth() - Removes the character at the location that the * Hero has already visited, replacing it with a null/n value. 
   * Moves the character down one space in the Y direction, and * checks if the Hero moves out of bounds, prompting the user * that they can not move that way. If they do go out of 
   * bounds, the movement is reversed, and they are placed where * they were previously. This method also reveals the spot 
   * that the hero moves to. Returns the character at that 
   * location.
   * @return - the character position after moving
   */
  public char goSouth(){
    position.translate(1, 0); // down 1
    if (position.getX() > 4){
      System.out.println("You are out of bounds");
    position.translate(-1, 0);
    }
    return Map.getInstance().getCharAtLoc(position);
  }
  /**
   * goWest() - Removes the character at the location that the 
   * Hero has already visited, replacing it with a null/n value. 
   * Moves the character left one space in the X direction, and * checks if the Hero moves out of bounds, prompting the user * that they can not move that way. If they do go out of 
   * bounds,the movement is reversed, and they are placed where * they were previously. This method also reveals the spot 
   * that the hero moves to. Returns the character at that 
   * location.
   * @return - the character position after moving
   */
  public char goWest(){
    position.translate(0, -1); // left 1
    if (position.getY() < 0){
      System.out.println("You are out of bounds");
      position.translate(0, 1);
    }
    return Map.getInstance().getCharAtLoc(position);
  }
  /**
   * goEast() - Removes the character at the location that the 
   * Hero has already visited, replacing it with a null/n value. 
   * Moves the character right one space in the X direction, and * checks if the Hero moves out of bounds, prompting the user * that they can not move that way. If they do go out of 
   * bounds,the movement is reversed, and they are placed where * they were previously. This method also reveals the spot 
   * that the hero moves to. Returns the character at that 
   * location.
   * @return - the character position after moving
   */
  public char goEast(){
    position.translate(0, 1); // right 1
    if (position.getY() > 4){
      System.out.println("You are out of bounds");
      position.translate(0, -1);
    }
    return Map.getInstance().getCharAtLoc(position);
  }
 
  /**
   * magicMissile(Entity e) - Magical missle attack method that * rolls a random integer damage between one and three, 
   * reducing an enemy object's current HP by said damage.
   * @param param Entity E - Entity e takes certain damage from * attack between one and three
   * @return - a string with the name of the hero, the enemy 
   * that they hit and the damage done to said target, with the * magic missile
   */
  @Override
  public String magicMissile(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(3)+1; 
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with a Magical Missile for " + randomDamage + " damage.";
  }

  /**
   * fireball(Entity e) - Magical fireball attack method that 
   * rolls a random integer damage between one and three, 
   * reducing an enemy object's current HP by said damage.
   * @param Entity E - Entity e takes certain damage from attack
   * between one and three
   * @return - a string with the name of the hero, the enemy 
   * that they hit and the damage done to said target, with the * fireball
   */

  @Override
  public String fireball(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(3)+1;
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with a fireball for " + randomDamage + " damage.";
  }
 /**
  * thunderclap(Entity e) - Thunderclap attack method that 
  * rolls a random integer damage between one and six, reducing * an enemy object's current HP by said damage.
  * @param Entity E - Entity e takes certain damage from attack
  * between one and 6
  * @return - a string with the name of the hero, the enemy 
  * that they hit and the damage done to said target, with the * thunderclap
  */
  @Override
  public String thunderclap(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(6)+1; 
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with thunderclap for " + randomDamage + " damage.";
  }
}

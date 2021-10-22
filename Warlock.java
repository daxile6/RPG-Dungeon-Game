/** 
 * Warlock decoration class extending EnemyDecorator and making use of Magical.  This decorates a base monster, adding Warlock to its 
 * name, increasing its hp by one and granting it the ability to cast magical spells. The magical spells:  magic missile, fireball and 
 * thunderclap will be used at random and each spell also does random damage.
 */
import java.util.*;
public class Warlock extends EnemyDecorator implements Magical{
   /** 
    * Warlock decorator that adds Warlock to the to the enemy's
    * name and grants 1 more hp to the enemy's max hp. 
    * @param - Enemy e being passed in to be decorated
    */
    public Warlock(Enemy e){
      super(e, e.getName() + "Warlock", e.getHP()+1 );
          }
    /** 
     * Warlock's attack method that randomly selects one of the three maigcal spells to attack with.
     * @param  Entity E - Entity e takes certain damage randomly generated abilities between 0-3
     * @return - the randomly selected magical attack based on the randomly generated number. If zero, Magical missile is called and used,
     * if two, fireball is called and used, if two, thunderbolt is called and used.
     */
    @Override 
    public String attack(Entity e){
      Random rand = new Random();
      int num = rand.nextInt(3);
      if(num == 0){
        return magicMissile(e) + "\n" + super.attack(e);
      }
      else if(num == 1){
        return fireball(e) + "\n" + super.attack(e);
      }
      else {
        return thunderclap(e) + "\n" + super.attack(e);
      }
    
  }
    /**
     * Retrieves the name of the base enemy to be decorated
     * @return - a string with the base enemy's name
     */
    public String getName(){
      return super.getName();
    }
    @Override
     /**
      * magicMissile(Entity e) - Magical magic missle attack method that rolls a random  integer damage between one and two,
      * reducing an enemy object's current HP by said damage.
      * @param Entity E - Entity e takes certain damage from attack between 0 and 2
      * @return - a string with the name of the entity (a warlock decorated base enemy), the entity (a hero) that they hit
      * and the damage done to said target, with the magic missile
      */
    public String magicMissile(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(2); 
      e.takeDamage(randomDamage);
      return "hits " + e.getName() + " with a Magical Missle for " + randomDamage + " damage. ";
      // return getName() + "\n" + " hits " + e.getName() + " with a Magical Missle for " + randomDamage + " . ";
    }
   /**
    * Fireball(Entity e) - Magical fireball attack method that rolls a random  integer damage 
    * between zero and three, reducing another entity's current HP by said damage.
    * @param Entity E - Entity e takes certain damage from attack between 0 and 3
    * @return - a string with the name of the entity (a warlock decorated base enemy), the entity (a hero) that they hit
    * and the damage done to said target, with the fireball
    */
    @Override
    public String fireball(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(3); 
      e.takeDamage(randomDamage);
      return "hits " + e.getName() + " with a Fireball for " + randomDamage + " damage. ";
      // return getName() + "\n" + " hits " + e.getName() + " with a fireball for " + randomDamage + " . ";
    }
   /**
    * Thunderclap(Entity e) - Magical thunderbolt attack method that rolls a random  integer damage between one and three, reducing  *another entity's current HP by said damage.
    * @param Entity E - Entity e takes certain damage from attack between 1 and 3
    * @return - a string with the name of the entity (a warlock decorated base enemy), the entity (a hero) that they hit
    * and the damage done to said target, with the thunderbolt
    */
     @Override
    public String thunderclap(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(3)+1; 
      e.takeDamage(randomDamage);
      return "hits " + e.getName() + " with a Thunderclap for " + randomDamage + " damage. ";
      // return getName() + "\n" + " hits " + e.getName() + " with thunderclap for " + randomDamage + " . ";
    }


} 



 
/** 
 * Warrior decoration class extending EnemyDecorator. This decorates a base monster, adding Warrior to its name, increasing its hp by two and 
 * replacing the basic attack by one does random damage between one and three
 */
import java.util.*;
public class Warrior extends EnemyDecorator{
   /** 
    *Warrior decorator that adds Warrior to the to the enemy's name and grants 2 more hp to the enemy's max hp. 
    *@param - Enemy e being passed in to be decorated
    */
    public Warrior(Enemy e){
      super(e, e.getName() + "Warrior" , e.getHP() +2 );
          }
  /** 
   *Warrior's attack method that randomly deals between one and three damage
   *@param Entity E - Entity e takes certain damage from attack between 1 and 3
   *@return -  a string indicating the target that the Warrior decorated enemy hit, and the damage done to that same target.
   */
	@Override
	public String attack(Entity e) {
		 Random rand = new Random();
		 int decoratedDamage = rand.nextInt(3)+1; 
		 e.takeDamage(decoratedDamage);
		 return super.attack(e) + "\n" + "hits " + e.getName() + " for " + decoratedDamage + " damage ";
	}
    /**
     *Retrieves the name of the base enemy to be decorated
     *@return - a string with the base enemy's name
     */
    public String getName(){
      return super.getName();
    }

} 
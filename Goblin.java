/**
* Goblin.java - Base Goblin Class that extends Enemy Class, 
* constructing a Goblin object when called. 
*/
import java.util.Random;

public class Goblin extends Enemy {
 /** 
  * Constructs a Goblin enemy with 4 hp
  */
	public Goblin() {
		super("Goblin", 2);
		
	}
  /** 
   * Goblin's basic attack method that randomly does damage 
   * between one and two. Reduces the target's (entity e) 
   * health by the random damage.
   * @param Entity E - Entity e takes certain damage from 
   * attack
   * @return - a string indicating the target that the Goblin * hit, and the damage done to that same target.
   */
	@Override
	public String attack(Entity e) {
		 Random rand = new Random();
		 int randomDamage = rand.nextInt(2)+1; 
		 e.takeDamage(randomDamage);
    return  "hits " + e.getName() + " for " + randomDamage + " damage ";
	}
}

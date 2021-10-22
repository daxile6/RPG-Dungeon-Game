/**
 * Troll.java - Base Troll Class that extends Enemy Class, constructing a Troll object when called. 
 */
import java.util.Random;

public class Troll extends Enemy{
 /** 
  * Constructs a Troll enemy with 5 hp
  *
  */
	public Troll() {
		super("Troll", 5);
		
	}
  /** 
   * Troll's basic attack method that randomly does damage between zero and five. Reduces the target's (entity e) health by the random *damage.
   * @param Entity E - Entity e takes certain damage from attack between 0 and 5
   * @return - a string indicating the target that the Troll hit, and the damage done to that same target.
   */
	@Override
	public String attack(Entity e) {
		Random rand = new Random();
		int randomDamage = rand.nextInt(5); 
		e.takeDamage(randomDamage);
		return "hits " + e.getName() + " for " + randomDamage + " damage ";
	}

}

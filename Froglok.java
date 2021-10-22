/**
 * Froglok.java - Base Froglok Class that extends Enemy Class, * constructing a Froglok object when called. 
 */
import java.util.Random;

public class Froglok extends Enemy {
  /** 
   * Constructs a Froglok enemy with 3 hp
   */
	public Froglok() {
		super("Froglok" , 3);
		
	}
  /** 
   * Froglok's basic attack method that randomly does damage 
   * between one and three. Reduces the target's (entity e) 
   * health by the random damage.
   * @param Entity E - Entity e takes certain damage from attack
   * @return - a string indicating the target that the Froglok * hit, and the damage done to that same target.
   */
	@Override
	public String attack(Entity e) {
		 Random rand = new Random();
		 int randomDamage = rand.nextInt(3)+1; 
		 e.takeDamage(randomDamage);
		 return  "hits " + e.getName() + " for " + randomDamage + " damage ";
	}

}

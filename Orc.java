/**
 * Orc.java - Base Orc Class that extends Enemy Class, constructing an Orc object when called. 
 */
import java.util.Random;

public class Orc extends Enemy {
  /** 
   * Constructs an orc enemy with 4 hp
   *
   */
	public Orc() {
		super("Orc" , 4);
		
	}
  /** 
   * Orc's basic attack method that randomly does damage between zero & four. Reduces the target's (entity e) health by the random  *damage.
   * @param Entity E - Entity e takes certain damage from attack between 0 and 4
   * @return - a string indicating the target that the orc hit, and the damage done to that same target.
   */
	@Override
	public String attack(Entity e) {
		Random rand = new Random();
		int randomDamage = rand.nextInt(4); 
		e.takeDamage(randomDamage);
		return  "hits " + e.getName() + " for " + randomDamage + " damage ";
	}

}

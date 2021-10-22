/**
 * Entity.java , the abstract class from which subclasses 
 * Hero.java, and
 * enemy.java extend to.
 */
public abstract class Entity{
	  private String name;
	  private int maxHP;
	  private int hp;
   /**
    * Abstract method that Hero and Enemy override for their 
    * respective
    * constructors, each with a name, and current/Maximum Hit 
    * points
    * @param n - name of the relevant class's object
    * @param mHp - Maximum hit points
    */
	  public Entity(String n,int mHp){
	    name = n;
	    hp = mHp;
	    maxHP = mHp;

	  }
    /**
     * Allows the entity to attack
     */
	  public abstract String attack(Entity e);
    /**
     * getName() - returns the name of the Entity
     * @return name returns variable with name in it
     */
	  public String getName(){
	    return name;
	  }
    /**
     * getHP() - returns the current hit points of the Entity
     * @return hp returns the variable hp
     */
	  public int getHP(){
	    return hp;
	  }
    /**
     * getMaxhHP() - returns the current hit points of the 
     * Entity
     * @return maxHP returns the variable MaxHP
     */
	  public int getMaxHP(){
	    return maxHP;
	  }
    /**
     * heal(int h) - increases the current hp of the hero 
     * object by a certain amount, when an item is picked up 
     * (hero location is the same as an item location). The if * statement ensures that the hero's hp will not go
     * over the maximum when healed, setting the current hp to * the MaxHP when this does occur.
     */
	  public void heal(int h){
	    hp+= h;
	    if(hp>maxHP){
        hp = maxHP;
	    }
	  }
    /**
     * takeDamage(int d) - Called when hero attacks an enemy or * vice versa, Reducing the attacked entity's current hp by * d (the random damage generated by the attack method that * is called)
     * The if statement will set the attacked entity's hp to 0, * if damage taken reduces the hp to less than 0, not 
     * allowing the hp to be negative.
     */
	  public void takeDamage(int d){
	    hp-=d;
      if (hp < 0) {
        hp = 0;
      }  
	  }
    /**
     * toString() - returns a string containing the entity's 
     * name, and current hp over max hp
     * @return - string with entity's name , & hp/MaxHP
     */
	  public String toString(){
	    return name + "\n" + "HP: " +  hp + "/" + maxHP;
	  }
	}

/**
 * Enemy.java , subclass extended from Entity, with an enemy 
 * constructor and attack method
 */
public abstract class Enemy extends Entity{
  /**
   * Constructs an enemy object with a name, n and max HP, m HP,
   * referencing the variables by the same name in Entity.java
   * @param n - name of the enemy
   * @param mHp - Maximum hit points
   */
  public Enemy(String n,int mhp){
    super(n,mhp);
  }
  /**
   * Enemy's abstract attack method extending from entity, to 
   * be extended to other classes
   */
  @Override
  public abstract String attack(Entity e);
  
}
  
 

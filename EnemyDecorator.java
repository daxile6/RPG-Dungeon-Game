/** 
 * Abstract enemy Monster Decorator class that grants special 
 * attacks, extra health and an altered name to  an already 
 * existing enemy via decoration classes.
 * @Param Enemy - a constructed enemy to be decorated, made 
 * private to prevent alteration by the user.
 */
public abstract class EnemyDecorator extends Enemy
{
  private Enemy enemy;
  /** 
   * Method that decorates the base/current enemy, 
   * giving it extra hp, special attacks and changing its name * depending on the decoration applied. 
   * @param e - enemy that gets decorated
   */
  public EnemyDecorator(Enemy e, String n, int h){
    super(n, h);
    enemy=e;
  }
  /** 
   * Decorated Enemy's attack method, that decorates the 
   * base/current enemy's attack method, netting it different 
   * attacks with different damage
   * @return - a string of the attack that is decorated
   */
  @Override
  public String attack(Entity e){
    return enemy.attack(e);
  }

} 
 /**
  * EnemyGenerator.java - generates an enemy randomly to be
  * encountered by the hero in MonsterRoom in main. 
  * As the level gets higher, enemies will be decorated and
  * become stronger with more health and different attacks.
  */
import java.util.Random;
public class EnemyGenerator{
	/** 
   * generateEnemy(int level) - generates a random enemy at 
   * level one, at level two and above, will randomly and 
   * repeatedly decorate a random enemy
   * @param the_level - sets this variable equal to the hero's * level
   * @return - the enemy that is generated.
   */
  public Enemy generateEnemy(int level) {
	  int the_level = level;
	  Random rand = new Random();
	  Enemy enemy = new Troll();
	  int randomEnemy = rand.nextInt(4)+1; 
	  if(randomEnemy == 1) {
		   enemy = new Goblin();
	  }
	  else if(randomEnemy ==2) {
		  enemy = new Froglok();
	  }
	  else if(randomEnemy ==3) {
		  enemy = new Orc();
	  }
	  else if (randomEnemy ==4) {
		  enemy = new Troll();
	  }
	  int chosen = rand.nextInt(2)+1;
	  while(the_level>1) {
		  the_level-=1;
		  if(chosen ==1) {
			  enemy = new Warrior(enemy);
		  }
		  else {
			  enemy = new Warlock(enemy);
		  }
	  }
	  return enemy;
  }
}
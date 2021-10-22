import java.util.Random;
 /**
    MagicalEnemy.java - class with a magical enemy constructor, 
    an attack method that randomly chooses which magical attack/method
    will be called/used as well as the magical attack methods themselves
  */
public class MagicalEnemy extends Enemy implements Magical{
 /**
   MagicalEnemy(sting n, int mHP) - constructs a magical enemy
   object with a name from the enemies.txt file ( an enemy along with 
   the word magical) as well a maxHP. Enemies constructed this way 
   are capable of using the magical attack methods.
  */
  public MagicalEnemy(String n, int mHP)
  {
    super(n,mHP);
  }
 /**
   attack(Entity e) - Randomly decides which magical attack that
   the enemy will use.
   @param num - randomly generated integer beteen 0 and 2, and 
   will choose magic missile if 0, fireball if 1 , and thundrclap if 2.
   The result will be the magical attack used by the magical enemy to 
   attack the hero.
  */
  public String attack(Entity e)
  {
    Random rand = new Random();
    int num = rand.nextInt(3);
    if(num == 0)
    {
      return magicMissile(e); 
     

    }
    else if(num == 1)
    {
      return fireball(e);
      
    }
    else 
    {
      return thunderclap(e);
      
    }
    
  }

 /**
    magicMissile(Entity e) - Magical magic missle attack method that rolls a random  integer damage between one and six, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and six
    @return - a string with the name of the entity (a magical enemy), the entity (a hero) that they hit
    and the damage done to said target, with the magic missile
  */
    @Override
    public String magicMissile(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(6)+1; 
      e.takeDamage(randomDamage);
      return super.getName() + " hits " + e.getName() + " with a Magical Missle for " + randomDamage + " . ";
    }
/**
    fireball(Entity e) - Magical fireball attack method that rolls a random 
    integer damage between one and three, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and three
    @return - a string with the name of the entity (a magical enenmy) that used it, the entity (a hero) that they hit and the damage done to said target, with the fireball
  */
    @Override
    public String fireball(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(6)+1; 
      e.takeDamage(randomDamage);
      return super.getName() + " hits " + e.getName() + " with a fireball for " + randomDamage + " . ";
    }
 /**
    thunderclap(Entity e) - Thunderclap attack method that rolls a random 
    integer damage between one and six, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and six
    @return - a string with the name of the entity (a magical enemy), the entity (a hero) that they hit
    and the damage done to said target, with the thunderclap
  */
    @Override
    public String thunderclap(Entity e)
    {
      Random rand = new Random();
      int randomDamage = rand.nextInt(6)+1; 
      e.takeDamage(randomDamage);
      return super.getName() + " hits " + e.getName() + " with thunderclap for " + randomDamage + " . ";
    }

}

/** 
 * Edward Ahn, Steven Nguyen, Donovan Saenz
 * CECS 277
 * Project 2
 * Group #15
 * 5/5/21
 */

/** 
 *Dungeon master game where the user names a hero and can *traverse a dungeon that loops through three different levels, 
 * until the user quits or the hero runs out of hp. The user, 
 * can move north, west, south and east. The hero starts 
 * off with 25 health, 100 gold and no keys. Health potions and * keys
 * can be bought in the store with gold that can be found along
 * the way. To move to the next floor, the hero must find the 
 * exit, but to needs a key to continue once the exit is found. * Monsters can also be encountered by the hero and the user 
 * can decide to fight or flee. After the first level, monsters * will become warlocks or warriors, gaining more health and 
 * special attacks. After the second level, those same monsters * will be decorated repeatedly, incrementally gaining health 
 * and more damage.
 */

	 


import java.util.Scanner;
import java.util.Random;
import java.awt.Point;


class Main {
  public static void main(String[] args){
    int i = 0;
    Map map = Map.getInstance();
    map.loadMap(++i);
    Point position = new Point(map.findStart());
    System.out.print("What is your name, traveler? ");
    String name = CheckInput.getString();
    Hero h1 = new Hero(name);
    System.out.print(h1);
   /**
    * Checks to see if user health is greater than zero
    */
    while (h1.getHP()>0){
      System.out.println("1. Go North");
      System.out.println("2. Go South");
      System.out.println("3. Go East");
      System.out.println("4. Go West");
      System.out.println("5. Quit");
      int choice = CheckInput.getIntRange(1,5);
     /**
      * Checks to see if user input is between 0 and 6
      */
      if (choice>0 && choice<6){
        /**
         * if choice 1, go north, choice 2 is south, choice 3 
         * is  east and choice 4 is west, choice 5 will exit 
         * the game
         * if char at this point is 'i' we heal the hero
         * if it is 'm', we will generate a monster and 
         * transfer into monsterRoom
         * if it is 'f', we found the exit and will finish the 
         * level
         * if it is 'n', there is nothing there
         * if it is 's', we are at the start
         */

        if (choice ==1){
          char north = h1.goNorth();
          if(north == 'i'){
            Map.getInstance().reveal(h1.getLoc());
            Random rand = new Random();
            int randomDirection = rand.nextInt(2)+1;
            if(randomDirection == 1)
            {
              h1.heal(25);
              System.out.print("You found a Health Potion! You drink it to restore your health.");
              System.out.println(" ");
            }
            else if(randomDirection == 2)
            {
              System.out.println("You found a key!");
              h1.pickUpKey();
            }
          }
          else if(north == 'm')
          {
            Map.getInstance().reveal(h1.getLoc());
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy(h1.getLevel());
            monsterRoom(h1, monster);
          }
          else if (north == 'f'){
            Map.getInstance().reveal(h1.getLoc());
            if(h1.hasKey() == true)
            {
              h1.levelUp();
              System.out.println("You found the exit. Proceeding to the next level. ");
              h1.useKey();
              System.out.println(h1);
            }
            else 
            {
              System.out.println("Sorry, you do not have a key");
                
            }
          }
          else if (north == 'n'){
            System.out.println("There's nothing here. ");
            Map.getInstance().reveal(h1.getLoc());
          }
          else if (north == 's'){
            store(h1);
            Map.getInstance().reveal(h1.getLoc());
          }

          System.out.println(h1);
        }
        else if (choice == 2){
          char south = h1.goSouth();
          if(south == 'i'){
            Map.getInstance().reveal(h1.getLoc());
            Random rand = new Random();
            int randomDirection = rand.nextInt(2)+1;
            if(randomDirection == 1)
            {
              h1.heal(25);
              System.out.print("You found a Health Potion! You drink it to restore your health.");
              System.out.println(" ");
            }
            else if(randomDirection == 2)
            {
              System.out.println("You found a key!");
              h1.pickUpKey();
            }
          }
           else if(south == 'm')
           {
             Map.getInstance().reveal(h1.getLoc());
             EnemyGenerator enemy = new EnemyGenerator();
             Enemy monster = enemy.generateEnemy(h1.getLevel()); 
             monsterRoom(h1, monster);
             Map.getInstance().reveal(h1.getLoc());
          }
          else if (south == 'f'){
            if(h1.hasKey() == true)
            {
              h1.levelUp();
              System.out.println("You found the exit. Proceeding to the next level. ");
              h1.useKey();
              System.out.println(h1);
            }
            else{
                Map.getInstance().reveal(h1.getLoc());
                System.out.println("Sorry, you do not have a key");
              }
            
          }
          else if (south == 'n'){
            System.out.println("There's nothing here. ");
            Map.getInstance().reveal(h1.getLoc());
          }
          else if (south == 's'){
            Map.getInstance().reveal(h1.getLoc());
            store(h1);
          }

          System.out.println(h1);
        }
        else if (choice == 3){
          char east = h1.goEast();
          if(east == 'i'){
            Map.getInstance().reveal(h1.getLoc());
            Random rand = new Random();
            int randomDirection = rand.nextInt(2)+1;
            if(randomDirection == 1)
            {
              h1.heal(25);
              System.out.print("You found a Health Potion! You drink it to restore your health.");
              System.out.println(" ");
            }
            else if(randomDirection == 2)
            {
              System.out.println("You found a key!");
              h1.pickUpKey();
            }
          }
          else if(east == 'm')
          {
            Map.getInstance().reveal(h1.getLoc());
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy(h1.getLevel());
            monsterRoom(h1, monster);
          }
          else if (east == 'f'){
            if(h1.hasKey() == true)
            {
              Map.getInstance().reveal(h1.getLoc());
              h1.levelUp();
              System.out.println("You found the exit. Proceeding to the next level. ");
              System.out.println(h1);
              h1.useKey();
            }
            else 
            {
              Map.getInstance().reveal(h1.getLoc());
              System.out.println("Sorry, you do not have a key");
            }
          }
          else if (east == 'n'){
            System.out.println("There's nothing here. ");
            Map.getInstance().reveal(h1.getLoc());
          }
          else if (east == 's'){
            store(h1);
            Map.getInstance().reveal(h1.getLoc());
          }

          System.out.println(h1);
        }
        else if (choice ==4){
          char west = h1.goWest();
          if(west== 'i'){
            Map.getInstance().reveal(h1.getLoc());
            Random rand = new Random();
            int randomDirection = rand.nextInt(2)+1;
            if(randomDirection == 1)
            {
              h1.heal(25);
              System.out.print("You found a Health Potion! You drink it to restore your health.");
              System.out.println(" ");
            }
            else if(randomDirection == 2)
            {
              System.out.println("You found a key!");
              h1.pickUpKey();
            }
          }
          else if(west == 'm')
          {
            Map.getInstance().reveal(h1.getLoc());
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy(h1.getLevel());
            monsterRoom(h1, monster);
          }
          else if (west == 'f'){
            if(h1.hasKey() == true)
            {
              Map.getInstance().reveal(h1.getLoc());
              h1.levelUp();
              System.out.println("You found the exit. Proceeding to the next level. ");
              h1.useKey();
              System.out.println(h1);
            }
            else 
            {
              System.out.println("Sorry, you do not have a key");
              Map.getInstance().reveal(h1.getLoc());  
            }
          }
          else if (west == 'n'){
            System.out.println("There's nothing here. ");
            Map.getInstance().reveal(h1.getLoc());
          }
          else if (west == 's'){
            store(h1);
            Map.getInstance().reveal(h1.getLoc());
          }
          System.out.println(h1);
        }
        else{
          System.out.println("You have quit.");
          break;
        }
        }
      }
    }
    /**
     * store(Hero h) - Upon entering a new level, the user can * decide
     * to buy a health potion, or  a key if they have enough 
     * gold, or nothing & quit. If the user has at least 25 
     * gold, they can 
     * purchase a health potion which will heal them. If the 
     * user has at least 50 gold, they can purchase a key which * is necessary to go the the next level. If the user &
     * doesn't have enough gold for either transaction, they 
     * will be told that they do not have enough gold. 
     * Otherwise, they'll be told that they are successful, and * will be told how much gold they have left.  
     * @param Hero h - takes in the hero
     */
    public static void store(Hero h)
    {
      System.out.println("--Hero Store--");
      System.out.println("1. Health Potion");
      System.out.println("2. Key");
      System.out.println("3. Quit");
      int choice = CheckInput.getIntRange(1,3);
      if(choice == 1)
      {
        if(h.getGold() >= 25)
        {
          h.heal(25);
          h.spendGold(25);
          System.out.println("You purchased a Health Potion! You drink it to restore your health. You now have " + h.getGold() + " gold");
        }
        else{
          System.out.println("Sorry you do not have enough money");
        }
      }
      else if(choice == 2)
      {
        if(h.getGold() >= 50)
        {
          h.pickUpKey();
          h.spendGold(50);
          System.out.println("You purchased a Key! You now have " + h.getGold() + " gold");
        }
        else{
          System.out.println("Sorry you do not have enough money");
        }
      }
      else if(choice ==3)
      {
        System.out.println("You have quit.");
      }
    }

    /**
     * We have entered the monsterRoom which displays what 
     * monster we encountered and gives us an option to either * fight or run away
     * If we choose to fight it takes us to the fight method
     * If we choose to run, there will be a random number 
     * generated which will determine our random position
     * @param Hero h - the hero we created
     * @param Enemy e - the enemy we generated
     * @return static boolean
     */
    public static boolean monsterRoom(Hero h, Enemy e)
   { 
     System.out.println("You have encountered a " +e ) ; 
     System.out.println("Fight, or run away?");
     System.out.println("1. Fight");
     System.out.println("2. Run Away");
    int fightOrFlight = CheckInput.getIntRange(1,2);
      if(fightOrFlight == 1){
        fight(h, e);
        if(h.getHP() <=0){
        return false;}
      }
      else if(fightOrFlight == 2){
        System.out.println("You have chosen to escape");
        Random rand = new Random();
            int randomDirection = rand.nextInt(4)+1;
             if (randomDirection == 1){     
              char north = h.goNorth();
              Map.getInstance().reveal(h.getLoc());
              if(north == 'i'){
                  Map.getInstance().reveal(h.getLoc());
                  Random rand1 = new Random();
                  int randomDirection1 = rand1.nextInt(2)+1;
                  if(randomDirection == 1)
                  {
                    h.heal(25);
                    System.out.print("You found a Health Potion! You drink it to restore your health.");
                    System.out.println(" ");
                  }
                  else if(randomDirection1 == 2)
                  {
                    System.out.println("You found a key!");
                    h.pickUpKey();
                  }
                }
                else if(north == 'm')
                {
                  Map.getInstance().reveal(h.getLoc());
                  EnemyGenerator enemy = new EnemyGenerator();
                  Enemy monster = enemy.generateEnemy(h.getLevel());
                  monsterRoom(h, monster);
                }
                else if (north == 'f'){
                  Map.getInstance().reveal(h.getLoc());
                  if(h.hasKey() == true)
                  {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                    h.useKey();
                    System.out.println(h);
                  }
                  else 
                  {
                    System.out.println("Sorry, you do not have a key");
                  }
                }
                else if (north == 'n'){
                  System.out.println("There's nothing here. ");
                  Map.getInstance().reveal(h.getLoc());
                }
                else if (north == 's'){
                  store(h);
                  Map.getInstance().reveal(h.getLoc());
                }
             }
             else if (randomDirection == 2){    
               char south = h.goSouth();
               Map.getInstance().reveal(h.getLoc());
               if(south == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(south == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (south == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (south == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (south == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
             }        
             else if (randomDirection == 3){     
              char east = h.goEast();
              Map.getInstance().reveal(h.getLoc());
              if(east == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(east == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (east == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (east == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (east == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
             }
             else if (randomDirection == 4){    
              char west = h.goWest();
              Map.getInstance().reveal(h.getLoc());
              if(west == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(west == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (west == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key"); 
                    }
                  }
                  else if (west == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (west == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
             }
      }
      return true;
   }

   /**
	  * the first thing we do when we enter the fight is to check * if hero's hp is greater than zero
	  * There is an option for physical or magical attack(magic 
    * missile, fireball and thunderclap)
	  * If we choose to run, we are put in a random spot again
    * We also check the enemy's health in order to keep 
    * fighting or end
	  * @param Hero h - the hero we created
    * @param Enemy e - the enemy we generated
	  * @return static boolean
	  */
   public static boolean fight(Hero h, Enemy e){ 
     boolean proceed = true;
    do{
       if (h.getHP() > 0)
       {
        System.out.println(h.toString());
        System.out.println(e.toString());
        System.out.println("You have chosen to fight, how will you attack?");
        System.out.println("1. Physical Attack");
        System.out.println("2. Magical Attack");
        int attackChoice = CheckInput.getIntRange(1,2);
   
      if(attackChoice == 1){
         System.out.println(h.attack(e));
      
        if(e.getHP() > 0){
             String fightString = e.attack(h); 
             System.out.println(e.getName());
             System.out.println(fightString );
             System.out.println(h);
             System.out.println(e);
             System.out.println("1. Fight");
             System.out.println("2. Run Away");
             int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
            }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  Map.getInstance().reveal(h.getLoc()); 
                  if(north == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(north == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (north == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (north == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (north == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  Map.getInstance().reveal(h.getLoc()); 
                  if(south == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(south == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (south == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (south == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (south == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 Map.getInstance().reveal(h.getLoc()); 
                 if(east == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(east == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (east == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (east == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (east == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 Map.getInstance().reveal(h.getLoc()); 
                 if(west == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(west == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (west == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (west == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (west == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                proceed = false;
              }
           }          
      }

      else if(attackChoice ==2) {
        System.out.println(Magical.MAGIC_MENU);
        System.out.println("Which attack will you use?");
        int magicChoice = CheckInput.getIntRange(1,3);

        if(magicChoice == 1)
        {
          System.out.println(h.magicMissile(e));
          
          if(e.getHP() > 0)
          {
            String fightString = e.attack(h); 
            System.out.println(e.getName());
            System.out.println(fightString );
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  Map.getInstance().reveal(h.getLoc()); 
                  if(north == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(north == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (north == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (north == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (north == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth();
                  Map.getInstance().reveal(h.getLoc()); 
                  if(south == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(south == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (south == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (south == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (south == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  } 
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 Map.getInstance().reveal(h.getLoc());
                 if(east == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(east == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (east == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (east == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (east == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 Map.getInstance().reveal(h.getLoc()); 
                 if(west == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(west == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (west == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (west == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (west == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                proceed = false;
              }
          }
        }

        if(magicChoice == 2)
        {
          System.out.println(h.fireball(e));
          
          if(e.getHP() > 0)
          {
            String fightString = e.attack(h); 
            System.out.println(e.getName());
            System.out.println(fightString );
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if(north == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(north == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (north == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (north == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (north == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(south == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (south == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                    }
                  }
                  else if (south == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (south == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if(east == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(east == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (east == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");  
                    }
                  }
                  else if (east == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (east == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(west == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (west == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");   
                    }
                  }
                  else if (west == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (west == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                proceed = false;
              }
          }
        }

        if(magicChoice == 3)
        {
          System.out.println(h.thunderclap(e));
          
          if(e.getHP() > 0)
          {
            String fightString = e.attack(h); 
            System.out.println(e.getName());
            System.out.println(fightString );
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if(north == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(north == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (north == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                        
                    }
                  }
                  else if (north == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (north == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(south == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (south == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);
                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                        
                    }
                  }
                  else if (south == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (south == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if(east == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(east == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (east == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);


                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                        
                    }
                  }
                  else if (east == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (east == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                else if (randomDirection == 4){     
                  char west = h.goWest();
                  if(west == 'i'){
                    Map.getInstance().reveal(h.getLoc());
                    Random rand1 = new Random();
                    int randomDirection1 = rand1.nextInt(2)+1;
                    if(randomDirection == 1)
                    {
                      h.heal(25);
                      System.out.print("You found a Health Potion! You drink it to restore your health.");
                      System.out.println(" ");
                    }
                    else if(randomDirection1 == 2)
                    {
                      System.out.println("You found a key!");
                      h.pickUpKey();
                    }
                  }
                  else if(west == 'm')
                  {
                    Map.getInstance().reveal(h.getLoc());
                    EnemyGenerator enemy = new EnemyGenerator();
                    Enemy monster = enemy.generateEnemy(h.getLevel());
                    monsterRoom(h, monster);
                  }
                  else if (west == 'f'){
                    Map.getInstance().reveal(h.getLoc());
                    if(h.hasKey() == true)
                    {
                      h.levelUp();
                      System.out.println("You found the exit. Proceeding to the next level. ");
                      h.useKey();
                      System.out.println(h);


                    }
                    else 
                    {
                      System.out.println("Sorry, you do not have a key");
                        
                    }
                  }
                  else if (west == 'n'){
                    System.out.println("There's nothing here. ");
                    Map.getInstance().reveal(h.getLoc());
                  }
                  else if (west == 's'){
                    store(h);
                    Map.getInstance().reveal(h.getLoc());
                  }
                }
                proceed = false;
              }
          }
        }
      }
       }
       if (h.getHP() == 0) {
         System.out.println("Hero " + h.getName() + " has no more hp. Game Over");
         break;
       }
      
     }
     while(e.getHP() > 0 && h.getHP() > 0 && proceed == true);
     if (e.getHP() == 0) {
       System.out.println("You have slain " + e.getName());
       Random rand = new Random();
       int randomgold = rand.nextInt(10)+3;
       h.collectGold(randomgold);
       Map.getInstance().removeCharAtLoc(h.getLoc());
     }
      return true;
   }
}




